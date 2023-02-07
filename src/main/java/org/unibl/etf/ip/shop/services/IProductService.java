package org.unibl.etf.ip.shop.services;

import org.unibl.etf.ip.shop.models.entities.AttributeValue;

import java.util.List;

public interface IProductService extends CrudService<Integer> {
    List<AttributeValue> getAttributesAndValues(Integer id);
}
