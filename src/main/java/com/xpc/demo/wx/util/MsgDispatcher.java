package com.xpc.demo.wx.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class MsgDispatcher {

    public static Logger logger = LoggerFactory.getLogger(MsgDispatcher.class);

    public static String processMessage(Map<String, String> map){
        if (map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)){
            logger.info("this is text message");
        }

        if (map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)){
            logger.info("this is image message");
        }

        if (map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)){
            logger.info("this is link message");
        }

        if (map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)){
            logger.info("this is location message");
        }

        if (map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)){
            logger.info("this is voice message");
        }

        if (map.get("MsgType").equals(MessageUtil.REQ_MESSAGE_TYPE_VIDEO)){
            logger.info("this is video message");
        }

        return null;
    }

}
