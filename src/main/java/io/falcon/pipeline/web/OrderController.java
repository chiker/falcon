package io.falcon.pipeline.web;

import io.falcon.pipeline.domain.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    StringRedisTemplate template;

    @RequestMapping(method= RequestMethod.GET)
    public List<Message> getAll() {
        return new ArrayList<Message>();
    }

    @RequestMapping(method=RequestMethod.POST)
    public String create(HttpEntity<byte[]> requestEntity) {
        String messageContent = new String(requestEntity.getBody());

        System.out.println("json = " + messageContent);

        template.convertAndSend("json-payload:queue", messageContent);

        return "OK";
    }
}
