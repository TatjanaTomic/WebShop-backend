package org.unibl.etf.ip.shop.controllers;

import org.springframework.web.bind.annotation.*;
import org.unibl.etf.ip.shop.models.dtos.CommentDTO;
import org.unibl.etf.ip.shop.models.entities.Comment;
import org.unibl.etf.ip.shop.services.ICommentService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/comments")
@CrossOrigin(origins = "http://localhost:4200/")
public class CommentController extends CrudController<Integer, Comment, CommentDTO> {

    private final ICommentService service;

    protected CommentController(ICommentService service) {
        super(CommentDTO.class, service);
        this.service = service;
    }

    @GetMapping("/idOffer/{id}")
    public List<CommentDTO> findByIdOffer(@PathVariable Integer id) {
        return service.findByOfferId(id);
    }
}
