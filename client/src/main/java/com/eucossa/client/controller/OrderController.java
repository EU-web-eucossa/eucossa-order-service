package com.eucossa.client.controller;

import com.eucossa.client.model.dto.OrderDetailsDto;
import com.eucossa.client.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author christopherochiengotieno@gmail.com
 * @version 1.0.0
 * @since Wednesday, 09/11/2022
 */

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/process")
    public ResponseEntity<OrderDetailsDto> processOrder(@RequestBody OrderDetailsDto orderDetailsDto ) {
        OrderDetailsDto response = orderService.processOrder(orderDetailsDto);
        return ResponseEntity.ok(response);
    }
}
