package com.demo.controllers;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import com.demo.engine.Producer;

@RestController
@RequestMapping(value = "/kafka")
public final class KafkaController {
    private final Producer producer;

    @Autowired
    KafkaController(Producer producer) {
        this.producer = producer;
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    @ResponseBody
    public String getFoosBySimplePath() {
        return "Get some Foos";
    }


    @PostMapping(value = "/publish")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
        this.producer.sendMessage(message);
    }
}
