package com.xing.xing.controller.activity;

import com.xing.xing.response.Result;
import com.xing.xing.entity.user.User;
import com.xing.xing.service.activity.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@CrossOrigin(value = "*")
@RequestMapping(value = "/activity")
public class ActivityController {
    @Autowired
    private ActivityService activityService;


    @RequestMapping(value = "/signIn/getSignInInfo",method = RequestMethod.POST)
    @ResponseBody
    public Result getSignInInfo(User user) throws Exception {

        return activityService.getSign(user);
    }
}
