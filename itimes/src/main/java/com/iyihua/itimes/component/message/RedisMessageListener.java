package com.iyihua.itimes.component.message;

import java.util.Map;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;

import com.iyihua.model.component.message.EmailMessage;

public class RedisMessageListener implements MessageListener {

	MessageSerializer serializer = new MessageSerializer();
	
	@SuppressWarnings("unchecked")
	@Override
    public void onMessage( final Message message, final byte[] pattern ) {
		RedisMessage obj = (RedisMessage) serializer.deserialize(message.getBody());
//		RedisMessage obj = (RedisMessage) message;
		EmailMessage map = (EmailMessage) obj.getData();
		
        System.out.println( "Message received: " + map.toString());
    }
	
}
