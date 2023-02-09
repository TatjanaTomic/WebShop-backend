package org.unibl.etf.ip.shop.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.unibl.etf.ip.shop.exceptions.ConflictException;
import org.unibl.etf.ip.shop.models.entities.PaymentType;
import org.unibl.etf.ip.shop.repositories.PaymentTypeRepository;
import org.unibl.etf.ip.shop.services.IPaymentTypeService;

@Service
@Transactional
public class PaymentTypeService extends CrudJpaService<PaymentType, Integer> implements IPaymentTypeService {

    private final PaymentTypeRepository repository;

    public PaymentTypeService(PaymentTypeRepository repository, ModelMapper modelMapper) {
        super(repository, PaymentType.class, modelMapper);
        this.repository = repository;
    }

    @Override
    public <T, U> T insert(U object, Class<T> resultDtoClass) {
        if (repository.existsByName(getModelMapper().map(object, getEntityClass()).getName()))
            throw new ConflictException();
        return super.insert(object, resultDtoClass);
    }

    @Override
    public <T, U> T update(Integer integer, U object, Class<T> resultDtoClass) {
        if (repository.existsByNameAndIdNot(getModelMapper().map(object, getEntityClass()).getName(), integer))
            throw new ConflictException();
        return super.update(integer, object, resultDtoClass);
    }

}
