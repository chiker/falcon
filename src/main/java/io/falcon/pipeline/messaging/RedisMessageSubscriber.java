package io.falcon.pipeline.messaging;

import io.falcon.pipeline.dao.RequestRepository;
import io.falcon.pipeline.domain.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class RedisMessageSubscriber implements MessageListener {

    @Autowired
    private RequestRepository requestRepository;

    @Autowired
    private SimpMessagingTemplate webSocketTemplate;

    public void onMessage(final Message message, final byte[] pattern) {

        Request request = new Request(message.toString());
        requestRepository.save(request);

        webSocketTemplate.convertAndSend("/pipeline/requests", message.toString());
    }
}
