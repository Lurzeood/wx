package com.xpc.demo.wx.controller;

import com.xpc.demo.wx.util.MessageUtil;
import com.xpc.demo.wx.util.SignUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Map;

@Controller
@RequestMapping("/wechat")
public class SecurityController {

    private static Logger logger = LoggerFactory.getLogger(SecurityController.class);

    @RequestMapping(value = "/security", method = RequestMethod.GET)
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response,
                      @RequestParam(value = "signature", required = true) String signature,
                      @RequestParam(value = "timestamp", required = true) String timestamp,
                      @RequestParam(value = "nonce", required = true) String nonce,
                      @RequestParam(value = "echostr", required = true) String echostr){

        logger.info("singature is {},timestamp is {},nonce is {}",signature, timestamp, nonce);

        try{
            if (SignUtil.checkSignature(signature,timestamp,nonce)){
                PrintWriter out = response.getWriter();
                out.print(echostr);
                out.close();
            }else {
                logger.info("这里存在非法请求");
            }
        }catch (Exception e){
            logger.error("exception",e);
        }

    }

    @RequestMapping(value = "/security", method = RequestMethod.POST)
    public void doPost(HttpServletRequest request, HttpServletResponse response){
        logger.info("this is doPost method");

        try {
            Map<String, String> map = MessageUtil.parseXml(request);
            logger.info("get the message : {}",map.get("Content"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
