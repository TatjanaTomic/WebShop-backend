package org.unibl.etf.ip.shop.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.unibl.etf.ip.shop.models.entities.Image;
import org.unibl.etf.ip.shop.repositories.ImageRepository;
import org.unibl.etf.ip.shop.services.IImageService;

import java.util.List;

@Service
@Transactional
public class ImageService extends CrudJpaService<Image, Integer> implements IImageService {

    private ImageRepository repository;
    public ImageService(ImageRepository repository, ModelMapper mapper) {
        super(repository, Image.class, mapper);
        this.repository = repository;
    }

}
