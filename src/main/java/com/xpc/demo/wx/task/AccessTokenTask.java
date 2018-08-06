package com.xpc.demo.wx.task;

import com.xpc.demo.wx.dao.AccessTokenMapper;
import com.xpc.demo.wx.entity.TokenBean;
import com.xpc.demo.wx.service.AccessTokenService;
import com.xpc.demo.wx.service.MenuService;
import com.xpc.demo.wx.util.HttpUtil;
import org.apache.ibatis.annotations.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class AccessTokenTask {

    Logger logger = LoggerFactory.getLogger(AccessTokenTask.class);

    @Autowired
    AccessTokenMapper tokenDao;

    @Autowired
    public RestTemplateBuilder restTemplateBuilder;

    @Autowired
    private MenuService menuService;

    @Scheduled(fixedRate = 7000000)
    @Async
    public void getAccessToken(){
        logger.info("start get accesstoken from wx");
        TokenBean tokenBean = HttpUtil.getAccessToken(restTemplateBuilder);
        logger.info("get the token :{},time :{}",tokenBean.getAccess_token(),tokenBean.getExpires_in());
        tokenDao.saveToken(tokenBean);
        logger.info("save token successful");
    }

    @Scheduled(fixedRate = 7000000)
    @Async
    public void creatMenu(){
        menuService.addMenu();
    }

}
