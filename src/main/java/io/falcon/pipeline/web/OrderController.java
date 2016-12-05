package io.falcon.pipeline.web;

import io.falcon.pipeline.domain.PizzaOrder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @RequestMapping(method= RequestMethod.GET)
    public List<PizzaOrder> getAll() {
        return new ArrayList<PizzaOrder>();
    }

    @RequestMapping(method=RequestMethod.POST)
    public String create(@RequestBody String raw) {
        System.out.println("json = " + raw);
        return "OK";
    }
}
