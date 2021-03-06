package io.falcon.pipeline.web;

import io.falcon.pipeline.dao.RequestRepository;
import io.falcon.pipeline.domain.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    StringRedisTemplate template;

    @Autowired
    private RequestRepository requestRepository;

    @RequestMapping(method= RequestMethod.GET, produces = "application/json")
    public List<Request> getAll() {
        return requestRepository.findAll();
    }

    @RequestMapping(method=RequestMethod.POST, produces = "application/json", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public String create(HttpEntity<byte[]> requestEntity) {
        String messageContent = new String(requestEntity.getBody());

        template.convertAndSend("json-payload:queue", messageContent);

        return "OK";
    }
}
