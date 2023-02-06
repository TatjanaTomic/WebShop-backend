package org.unibl.etf.ip.shop.services;

import org.unibl.etf.ip.shop.models.dtos.CommentDTO;

import java.util.List;

public interface ICommentService extends CrudService<Integer> {
    List<CommentDTO> findByOfferId(Integer id);
}
