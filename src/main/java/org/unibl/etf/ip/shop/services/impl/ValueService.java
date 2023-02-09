package org.unibl.etf.ip.shop.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.unibl.etf.ip.shop.models.entities.Value;
import org.unibl.etf.ip.shop.repositories.ValueRepository;
import org.unibl.etf.ip.shop.services.IValueService;

@Service
@Transactional
public class ValueService implements IValueService {

    private final ValueRepository repository;

    public ValueService(ValueRepository repository) {
        this.repository = repository;
    }

    @Override
    public Value getByIdProductAndIdAttribute(Integer idProduct, Integer idAttribute) {
        return repository.findByIdProductAndIdAttribute(idProduct, idAttribute);
    }

    @Override
    public Value add(Value value) {
        return repository.saveAndFlush(value);
    }
}
