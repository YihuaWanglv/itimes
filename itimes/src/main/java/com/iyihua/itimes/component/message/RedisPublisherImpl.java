package com.iyihua.itimes.component.message;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;

public class RedisPublisherImpl implements IRedisPublisher {

	private final RedisTemplate< String, Object > template;
    private final ChannelTopic topic; 
    private final AtomicLong counter = new AtomicLong( 0 );
    MessageSerializer serializer = new MessageSerializer();

    public RedisPublisherImpl( final RedisTemplate< String, Object > template, 
            final ChannelTopic topic ) {
        this.template = template;
        this.topic = topic;
    }
    
	@Override
	public void publish() {
		// TODO Auto-generated method stub
		Map<String, String> map = new HashMap<String, String>();
		map.put("title", "iyihua");
		map.put("text", "伊华");
		RedisMessage me = new RedisMessage(1, "ee", map);
		template.convertAndSend( topic.getTopic(), me);
		
	}

}
