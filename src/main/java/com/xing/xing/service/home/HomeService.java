package com.xing.xing.service.home;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xing.xing.entity.HomeInfo;
import com.xing.xing.response.Result;

import com.xing.xing.request.customParams.CustomParams;
import com.xing.xing.repository.HomeJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("HomeService")
public class HomeService {
    @Autowired
    private HomeJpa mJpa;
    Result result = new Result();

    public Result getInfo(String str) throws Exception {
        /**
         * json字符串转化为json对象
         */
        JSONObject jsonObject = JSON.parseObject(str);
        /**
         * json对象转化为Java对象
         */
        CustomParams customParams = (CustomParams) JSONObject.toJavaObject(jsonObject, CustomParams.class);
        HomeInfo homeInfo = mJpa.findByPlatform(customParams.getPlatform());
        return result.getResultData("获取首页数据信息！", 100, homeInfo);
    }
}
