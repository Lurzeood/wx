package com.xpc.demo.wx.dao;


import com.xpc.demo.wx.entity.TokenBean;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AccessTokenMapper {

    @Insert("insert into access_token(access_token, expires_in) values(#{tokenBean.access_token},#{tokenBean.expires_in})")
    public void saveToken(@Param("tokenBean") TokenBean tokenBean);


    @Select("select access_token from access_token order by id desc limit 1")
    public String getToken();

}
