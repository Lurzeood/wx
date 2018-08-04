package com.xpc.demo.wx.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class EventDispatcher {

    public static Logger logger = LoggerFactory.getLogger(EventDispatcher.class);

    public static String processEvent(Map<String, String> map){
        if (map.get("Event").equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)){
            logger.info("this is subscribe event");
        }

        if (map.get("Event").equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)){
            logger.info("this is unsubscribe event");
        }

        if (map.get("Event").equals(MessageUtil.EVENT_TYPE_CLICK)){
            logger.info("this is click event");
        }
        return null;
    }

}
