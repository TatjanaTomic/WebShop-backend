package org.unibl.etf.ip.shop.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.unibl.etf.ip.shop.models.dtos.MessageDTO;
import org.unibl.etf.ip.shop.models.entities.Message;
import org.unibl.etf.ip.shop.services.IMessageService;

@RestController
@RequestMapping("/api/v1/messages")
@CrossOrigin(origins = "http://localhost:4200/")
public class MessageController extends CrudController<Integer, Message, MessageDTO> {
    public MessageController(IMessageService messageService) {
        super(MessageDTO.class, messageService);
    }
}
