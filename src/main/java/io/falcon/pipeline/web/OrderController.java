package io.falcon.pipeline.web;

import io.falcon.pipeline.model.PizzaOrder;
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
    public List<PizzaOrder> getAll() {
        return new ArrayList<PizzaOrder>();
    }

    @RequestMapping(method=RequestMethod.POST)
    public String create(HttpEntity<byte[]> requestEntity) {
        System.out.println("json = " + new String(requestEntity.getBody()));

        template.convertAndSend("json-payload:queue", new String(requestEntity.getBody()));

        return "OK";
    }
}
