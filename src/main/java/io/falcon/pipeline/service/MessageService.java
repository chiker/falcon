package io.falcon.pipeline.service;

import io.falcon.pipeline.domain.Message;

public interface MessageService {
    public Iterable<Message> findAll();
    public void saveMessage(Message msg);
    public Message findOne(long id);
}
