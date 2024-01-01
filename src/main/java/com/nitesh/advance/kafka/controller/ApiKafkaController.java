package com.nitesh.advance.kafka.controller;

import com.nitesh.advance.kafka.service.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author nitesh
 */
@RestController
@RequestMapping("/kafka")
public class ApiKafkaController {

    @Autowired
    KafkaProducer kafkaProducer;

    @GetMapping("/{message}")
    public String publish(@PathVariable String message) {
        return kafkaProducer.publish(message);
    }
}
