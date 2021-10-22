package com.kafka.KafkaSampleMicroservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/kafka")
public class KafkaController {
	
	@Autowired
	private KafkaTemplate<String,MyModel> kafkaTemplate;
	
	
	@PostMapping("post")
	public void PostMessage(@RequestBody MyModel myModel) {
		System.out.println("invoked");
	 kafkaTemplate.send("myTopic",myModel);
	}
	
	

}
