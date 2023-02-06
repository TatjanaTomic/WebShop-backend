package org.unibl.etf.ip.shop.services;

import org.unibl.etf.ip.shop.models.entities.Attribute;

import java.util.List;

public interface IAttributeService {
    List<Attribute> findAttributesOfCategory(Integer idCategory);
}
