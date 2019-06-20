package com.wds.rabbit.receiver;

import com.wds.rabbit.StreamApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;


/**
 * @author : TenYun
 * @date : 2019-06-20 20:47
 * @description :
 **/

@EnableBinding(Sink.class)
public class SinkReceiver {

    private static Logger logger = LoggerFactory.getLogger(StreamApplication.class);

    @StreamListener(Sink.INPUT)
    public void receive(Object payload) {
        logger.info("Receiver: " + payload);
    }
}
