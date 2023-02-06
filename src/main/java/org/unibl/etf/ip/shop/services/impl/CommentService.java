package org.unibl.etf.ip.shop.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.unibl.etf.ip.shop.models.dtos.CommentDTO;
import org.unibl.etf.ip.shop.models.dtos.OfferDTO;
import org.unibl.etf.ip.shop.models.entities.Comment;
import org.unibl.etf.ip.shop.repositories.CommentRepository;
import org.unibl.etf.ip.shop.services.ICommentService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CommentService extends CrudJpaService<Comment, Integer> implements ICommentService {
    private CommentRepository repository;
    private ModelMapper modelMapper;
    public CommentService(CommentRepository repository, ModelMapper modelMapper) {
        super(repository, Comment.class, modelMapper);
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<CommentDTO> findByOfferId(Integer id) {
        return repository.searchByOfferId(id).stream().map(e -> modelMapper.map(e, CommentDTO.class)).collect(Collectors.toList());
    }
}
