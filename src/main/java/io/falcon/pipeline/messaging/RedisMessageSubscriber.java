package io.falcon.pipeline.messaging;

import io.falcon.pipeline.dao.RequestRepository;
import io.falcon.pipeline.domain.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class RedisMessageSubscriber implements MessageListener {

    @Autowired
    private RequestRepository requestRepository;

    public void onMessage(final Message message, final byte[] pattern) {

        System.out.println("Message received: " + message.toString());

        Request request = new Request(message.toString());
        requestRepository.save(request);

    }
}
