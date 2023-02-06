package org.unibl.etf.ip.shop.models.entities;

import lombok.Data;

@Data
public class AttributeValue {
    private Attribute attribute;
    private Value value;
}
