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
public class SaleDto {

    private String id;
    private String state;
    private AmountDto amount;
    private String paymentMode;
    private String protectionEligibility;
    private String protectionEligibilityType;
    private TransactionFeeDto transactionFee;
    private String parentPayment;
    private String create_time;
    private String update_time ;
    private List<LinkDto> links;
}
