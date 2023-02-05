package org.unibl.etf.ip.shop.services.impl;

import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.unibl.etf.ip.shop.models.entities.Message;
import org.unibl.etf.ip.shop.repositories.MessageRepository;
import org.unibl.etf.ip.shop.services.IMessageService;

@Service
@Transactional
public class MessageService extends CrudJpaService<Message, Integer> implements IMessageService {
    public MessageService(MessageRepository repository, ModelMapper modelMapper) {
        super(repository, Message.class, modelMapper);
    }
}
