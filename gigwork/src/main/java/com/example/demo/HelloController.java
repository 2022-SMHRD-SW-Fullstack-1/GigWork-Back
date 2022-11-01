package com.example.demo;

import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

@RestController
public class HelloController {

	
	Gson gson1 = new Gson();
	Gson gson2 = new GsonBuilder().create();
    Gson gson3 = new GsonBuilder().setPrettyPrinting().create();
    
    JsonObject jsonObject = new JsonObject();
    
	
	@GetMapping("/hello")
	public String hello() {
		jsonObject.addProperty("name", "anna");
		jsonObject.addProperty("age", 5);
		String jsonStr = gson1.toJson(jsonObject);
		return jsonStr;
	}
}



