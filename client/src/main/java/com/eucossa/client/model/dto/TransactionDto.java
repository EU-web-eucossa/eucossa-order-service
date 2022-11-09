package com.eucossa.client.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author christopherochiengotieno@gmail.com
 * @version 1.0.0
 * @since Wednesday, 09/11/2022
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDto {

    private AmountDto amount;
    private PayeeDto payee;
    private String description;
    private ItemListDto itemList;
    private RelatedResourcesDto relatedResources;
}
