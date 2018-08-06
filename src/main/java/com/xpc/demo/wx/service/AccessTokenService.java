package com.xpc.demo.wx.service;

import com.xpc.demo.wx.dao.AccessTokenMapper;
import com.xpc.demo.wx.entity.TokenBean;
import com.xpc.demo.wx.util.HttpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class AccessTokenService {

    Logger logger = LoggerFactory.getLogger(AccessTokenService.class);

    @Autowired
    private AccessTokenMapper tokenDao;

    public String getAccessToken(){
        logger.info("get token from mysql");
        return tokenDao.getToken();
    }

}
