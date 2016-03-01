package com.iyihua.itimes.component.message;

import java.util.Map;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;

public class RedisMessageListener implements MessageListener {

	MessageSerializer serializer = new MessageSerializer();
	
	@Override
    public void onMessage( final Message message, final byte[] pattern ) {
		RedisMessage obj = (RedisMessage) serializer.deserialize(message.getBody());
//		RedisMessage obj = (RedisMessage) message;
		Map<String, String> map = (Map<String, String>) obj.getData();
		
        System.out.println( "Message received: " + map.toString() + map.get("text"));
    }
	
}
