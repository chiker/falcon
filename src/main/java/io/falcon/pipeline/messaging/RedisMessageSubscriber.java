package io.falcon.pipeline.messaging;


import io.falcon.pipeline.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Service;

@Service
public class RedisMessageSubscriber implements MessageListener {

    @Autowired
    private MessageService msgService;

    public void onMessage(final Message message, final byte[] pattern) {

        System.out.println("Message received: " + message.toString());


        io.falcon.pipeline.domain.Message msg = new io.falcon.pipeline.domain.Message(message.toString());

        msgService.saveMessage(msg);
    }
}
