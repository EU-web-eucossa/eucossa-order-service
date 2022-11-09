package com.eucossa.client.service.impl;

import com.eucossa.client.model.dto.*;
import com.eucossa.client.service.OrderService;
import com.eucossa.grpc.shipment.Payer;
import com.eucossa.grpc.shipment.PayerInfo;
import com.eucossa.grpc.shipment.Payment;
import com.eucossa.grpc.shipment.ShipmentServiceGrpc;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author christopherochiengotieno@gmail.com
 * @version 1.0.0
 * @since Wednesday, 09/11/2022
 */

@Service
public class OrderServiceImpl implements OrderService {

    @GrpcClient("grpc-eucossa-shipment-service")
    ShipmentServiceGrpc.ShipmentServiceBlockingStub synchronousShipmentClient;

    @Override
    public OrderDetailsDto processOrder(OrderDetailsDto orderDetailsDto) {

        List<com.eucossa.grpc.shipment.Product> products = new ArrayList<>();
        orderDetailsDto.getProducts().forEach(productDto -> products.add(com.eucossa.grpc.shipment.Product.newBuilder()
                .setName(productDto.getName())
                        .setPrice(productDto.getPrice())
                        .setQty(productDto.getQuantity())
                        .setUrl(productDto.getUrl())
                .build()));

        PaymentDto paymentInfoDto = orderDetailsDto.getPaymentInfo();
        PayerDto payerDto = paymentInfoDto.getPayer();
        PayerInfoDto payerInfoDto = payerDto.getPayerInfo();
        ShippingAddressDto shippingAddressDto = payerInfoDto.getShippingAddress();

        com.eucossa.grpc.shipment.ShippingAddress shippingAddress = com.eucossa.grpc.shipment.ShippingAddress.newBuilder()
                .setRecipientName(shippingAddressDto.getRecipientName())
                .setLine1(shippingAddressDto.getLine1())
                .setCity(shippingAddressDto.getCity())
                .setState(shippingAddressDto.getState())
                .setPostalCode(shippingAddressDto.getPostalCode())
                .setCountyCode(shippingAddressDto.getCountyCode())
                .build();
        PayerInfo payerInfo = com.eucossa.grpc.shipment.PayerInfo.newBuilder()
                .setEmail(payerInfoDto.getEmail())
                .setFirstName(payerInfoDto.getFirstName())
                .setLastName(payerInfoDto.getLastName())
                .setPayerId(payerInfoDto.getPayerId())
                .setShippingAddress(shippingAddress)
                .setCountryCode(payerInfoDto.getCountryCode())
                .build();
        Payer payer = com.eucossa.grpc.shipment.Payer.newBuilder()
                .setPaymentMethod(payerDto.getPaymentMethod())
                .setStatus(payerDto.getStatus())
                .setPayerInfo(payerInfo)
                .build();
        Payment payment = com.eucossa.grpc.shipment.Payment.newBuilder()
                .setIntent(paymentInfoDto.getIntent())
                .setState(paymentInfoDto.getState())
                .setCart(paymentInfoDto.getCart())
                .setPayer(payer)
                .build();

        com.eucossa.grpc.shipment.OrderPayload request = com.eucossa.grpc.shipment.OrderPayload.newBuilder()
                .addAllProducts(products)
                .setPaymentInfo(payment)
                .setOrderId(orderDetailsDto.getOrderId())
                .build();
        com.eucossa.grpc.shipment.ShipmentResponse shipmentResponse = synchronousShipmentClient.processShipment(request);
        return orderDetailsDto;
    }
}
