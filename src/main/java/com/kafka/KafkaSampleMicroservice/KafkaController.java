package com.kafka.KafkaSampleMicroservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

@RestController
@RequestMapping("/api/kafka")
public class KafkaController {
	
	@Autowired
	private Gson gsonConverter;
	
	@Autowired
	private KafkaTemplate<String,String> kafkaTemplate;
	
	
	@PostMapping("post")
	public void PostMessage(@RequestBody MyModel myModel) {
		System.out.println("invoked");
	 kafkaTemplate.send("myTopic",gsonConverter.toJson(myModel));
	}
	
	
	@KafkaListener(topics="myTopic", groupId = "test-consumer-group")
	public void kafkaGet(String myModel) {
		System.out.println(myModel.toString());
	}
	
	

}
