package com.realtimeproject.kafkarealtimeproject;


import com.realtimeproject.kafkarealtimeproject.entity.WikimediaData;
import com.realtimeproject.kafkarealtimeproject.repository.WikimediaRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaDatabaseConsumer {

    private Logger logger= LoggerFactory.getLogger(KafkaDatabaseConsumer.class);

    private WikimediaRepo wikimediaRepo;

    @Autowired
    public KafkaDatabaseConsumer(WikimediaRepo repo)
    {
        this.wikimediaRepo=repo;
    }


    @KafkaListener(topics="wikimedia",groupId = "myGroup")
    public void consume(String eventMessage)
    {

        logger.info(String.format("message received -> %s",eventMessage));
        WikimediaData wikimediaData=new WikimediaData();
        wikimediaData.setData(eventMessage);
        wikimediaRepo.save(wikimediaData);

    }
}
