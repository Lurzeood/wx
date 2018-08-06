package com.xpc.demo.wx.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xpc.demo.wx.dao.AccessTokenMapper;
import com.xpc.demo.wx.sendentity.ClickButton;
import com.xpc.demo.wx.util.HttpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;


@Service
public class MenuService {

    Logger logger = LoggerFactory.getLogger(MenuService.class);

    private ClickButton clickButton1 = new ClickButton();
    private ClickButton clickButton2 = new ClickButton();
    private ClickButton clickButton3 = new ClickButton();

    @Autowired
    private AccessTokenService tokenService;

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    public void addMenu(){

        clickButton1.setKey("button1");
        clickButton2.setKey("button2");
        clickButton3.setKey("button3");

        clickButton1.setName("笨蛋");
        clickButton2.setName("丹丹");
        clickButton3.setName("嘿嘿");

        clickButton1.setType("click");
        clickButton2.setType("click");
        clickButton3.setType("click");

        JSONArray button=new JSONArray();

        button.add(clickButton1);
        button.add(clickButton2);
        button.add(clickButton3);

        JSONObject menu = new JSONObject();
        menu.put("button",button);

        HttpUtil.createMenu(restTemplateBuilder, menu.toString(), tokenService.getAccessToken());

        logger.info("JSON :{}", menu.toString());
    }

}
