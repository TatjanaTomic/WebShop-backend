package org.unibl.etf.ip.shop.services;

import org.unibl.etf.ip.shop.models.entities.Value;

public interface IValueService {
    Value getByIdProductAndIdAttribute(Integer idProduct, Integer idAttribute);

    Value add(Value value);
}
