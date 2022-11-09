package com.eucossa.client.service;

import com.eucossa.grpc.inventory.ProductsList;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

/**
 * @author christopherochiengotieno@gmail.com
 * @version 1.0.0
 * @since Wednesday, 09/11/2022
 */

@Service
public class ProductService {

    @GrpcClient("grpc-eucossa-inventory-service")
    com.eucossa.grpc.inventory.ProductsServiceGrpc.ProductsServiceBlockingStub synchronousInventoryClient;

}
