package org.unibl.etf.ip.shop.models.dtos;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.unibl.etf.ip.shop.models.dtos.PurchaseDTO;
import org.unibl.etf.ip.shop.models.dtos.UserAccountDTO;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class UserAccountSingleDTO extends UserAccountDTO {

    private List<PurchaseDTO> purchases;
}
