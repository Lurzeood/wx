package com.xpc.demo.wx.util;

import com.alibaba.fastjson.JSONObject;
import com.xpc.demo.wx.Constant.RequestConstant;
import com.xpc.demo.wx.entity.MenuBean;
import com.xpc.demo.wx.entity.TokenBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class HttpUtil {

    public static TokenBean getAccessToken(RestTemplateBuilder restTemplateBuilder){
        String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid={appid}&secret={secret}";
        RestTemplate restTemplate = restTemplateBuilder.build();
        Map<String,String> map = new HashMap<>();
        map.put("appid","wx9438e72e8d94720c");
        map.put("secret","9942744aaf57e85a89aa396d6b3eb91a");
        TokenBean tokenBean = restTemplate.getForObject(url,TokenBean.class,map);
        return tokenBean;
    }

    public static void createMenu(RestTemplateBuilder restTemplateBuilder, String json, String token){

        String url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token="+token;
        RestTemplate restTemplate = restTemplateBuilder.build();
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        headers.setContentType(type);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());
        HttpEntity<String> formEntity = new HttpEntity<String>(json, headers);
        MenuBean result = restTemplate.postForObject(url, formEntity, MenuBean.class);
    }



}
