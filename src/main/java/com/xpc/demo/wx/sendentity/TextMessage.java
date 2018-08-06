package com.xpc.demo.wx.sendentity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TextMessage extends BaseMessage {

    private String Content;

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}
