package com.eucossa.client.service;

import com.eucossa.client.model.dto.OrderDetailsDto;

/**
 * @author christopherochiengotieno@gmail.com
 * @version 1.0.0
 * @since Wednesday, 09/11/2022
 */
public interface OrderService {
    OrderDetailsDto processOrder(OrderDetailsDto orderDetailsDto);
}
