package com.eucossa.client.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author christopherochiengotieno@gmail.com
 * @version 1.0.0
 * @since Wednesday, 09/11/2022
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDto {
    private String intent;
    private String state;
    private String cart;
    private PayerDto payer;
    private TransactionDto transactions;
    private Integer httpStatusCode;
    private String createTime;
    private String updateTime;
    private List<LinkDto> links;
}
