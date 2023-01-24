package org.unibl.etf.ip.shop.controllers;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.unibl.etf.ip.shop.exceptions.NotFoundException;
import org.unibl.etf.ip.shop.services.CrudService;

import java.util.List;
import java.io.Serializable;

@Getter
public abstract class CrudController<ID extends Serializable, REQ, RESP> {

    private final Class<RESP> respClass;
    private final CrudService<ID> crudService;


    protected CrudController(Class<RESP> respClass, CrudService<ID> crudService) {
        this.respClass = respClass;
        this.crudService = crudService;
    }

    @GetMapping
    List<RESP> findAll() {
    return crudService.findAll(respClass);
    }

    @GetMapping("/{id}")
    public RESP findById(@PathVariable ID id) throws NotFoundException {
        return crudService.findById(id, respClass);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RESP insert(@RequestBody REQ object) throws NotFoundException {
        return crudService.insert(object, respClass);
    }

    @PutMapping("/{id}")
    public RESP update(@PathVariable ID id, @RequestBody REQ object) throws NotFoundException {
        return crudService.update(id, object, respClass);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable ID id) throws NotFoundException {
        crudService.delete(id);
    }
}
