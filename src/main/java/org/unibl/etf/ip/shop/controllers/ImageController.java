package org.unibl.etf.ip.shop.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.unibl.etf.ip.shop.models.dtos.ImageDTO;
import org.unibl.etf.ip.shop.models.entities.Image;
import org.unibl.etf.ip.shop.services.IImageService;

@RestController
@RequestMapping("/api/v1/images")
@CrossOrigin(origins="http://localhost:4200/")
public class ImageController extends CrudController<Integer, Image, ImageDTO> {

    private IImageService service;
    public ImageController(IImageService service) {
        super(ImageDTO.class, service);
        this.service = service;
    }
}
