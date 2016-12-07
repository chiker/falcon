package io.falcon.pipeline.service;

import io.falcon.pipeline.domain.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageRepository msgRepository;

    @Override
    public Iterable<Message> findAll() {
        return msgRepository.findAll();
    }

    @Override
    public void saveMessage(Message msg) {
        msgRepository.save(msg);
    }

    @Override
    public Message findOne(long id) {
        return msgRepository.findOne(id);
    }
}
