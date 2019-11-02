package com.xing.xing.controller.register;

import com.xing.xing.response.Result;
import com.xing.xing.entity.user.User;
import com.xing.xing.service.register.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin(value = "*")
public class RegisterController {
    @Autowired
    private RegisterService registerService;
    @RequestMapping(value = "/register" ,method = RequestMethod.POST)
    @ResponseBody
    public Result register(@RequestBody User user) throws Exception{

        return  registerService.register(user);
    }

    @RequestMapping(value = "/testRegister" ,method = RequestMethod.POST)
    @ResponseBody
    public Result testRegister(@RequestBody User user) throws Exception{
        return  registerService.verifyUserName(user);
    }
}
