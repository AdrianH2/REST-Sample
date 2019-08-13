package com.examen.config;

import java.net.UnknownHostException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;

import com.mongodb.MongoClientURI;

@Configuration
public class MongoConfig {
	
	public MongoClientURI mongoUri() {
		//Configurar tu sevidor local de mongo
		return new MongoClientURI("mongodb://usuario:pass@TUIP:27021/Base");
	}
	
	@Primary
	@Bean
	public MongoTemplate plantillaMongo() throws UnknownHostException {
		SimpleMongoDbFactory simpleMongoDbFactory = new SimpleMongoDbFactory(mongoUri());
		MongoTemplate mongoTemplate = new MongoTemplate(simpleMongoDbFactory);
		((MappingMongoConverter) mongoTemplate.getConverter()).setTypeMapper(new DefaultMongoTypeMapper(null));
		return mongoTemplate;
	}

}
