package org.unibl.etf.ip.shop.models;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class UserAccountSingleDTO extends UserAccountDTO {

    private List<PurchaseDTO> purchases;
}
