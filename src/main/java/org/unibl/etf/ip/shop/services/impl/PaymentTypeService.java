package org.unibl.etf.ip.shop.services.impl;

import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.unibl.etf.ip.shop.exceptions.ConflictException;
import org.unibl.etf.ip.shop.exceptions.NotFoundException;
import org.unibl.etf.ip.shop.models.dtos.PaymentTypeDTO;
import org.unibl.etf.ip.shop.models.entities.PaymentType;
import org.unibl.etf.ip.shop.repositories.PaymentTypeRepository;
import org.unibl.etf.ip.shop.services.CrudJpaService;
import org.unibl.etf.ip.shop.services.IPaymentTypeService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class PaymentTypeService extends CrudJpaService<PaymentType, Integer> implements IPaymentTypeService {

    private PaymentTypeRepository repository;

    public PaymentTypeService(PaymentTypeRepository repository, ModelMapper modelMapper) {
        super(repository, PaymentType.class, modelMapper);
        this.repository = repository;
    }

    @Override
    public <T, U> T insert(U object, Class<T> resultDtoClass) {
        if(repository.existsByName(getModelMapper().map(object, getEntityClass()).getName()))
            throw new ConflictException();
        return super.insert(object, resultDtoClass);
    }

    @Override
    public <T, U> T update(Integer integer, U object, Class<T> resultDtoClass) {
        if(repository.existsByNameAndIdNot(getModelMapper().map(object, getEntityClass()).getName(), integer))
            throw new ConflictException();
        return super.update(integer, object, resultDtoClass);
    }

}
