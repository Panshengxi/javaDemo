package com.xing.xing.controller.user;

import com.xing.xing.entity.user.User;
import com.xing.xing.response.Result;
import com.xing.xing.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@CrossOrigin(value = "*")
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public Result login(@RequestBody User user) throws Exception {
        return userService.login(user);
    }

    @RequestMapping(value = "/getUserInfo", method = RequestMethod.POST)
    @ResponseBody
    public Result getUserInfo(HttpServletRequest request, @RequestBody User user) throws Exception {
        String auth = request.getHeader("Authorization");
        user.setCk(auth);
        return userService.authLoginState(user);
    }

    @RequestMapping(value = "/checkUser", method = RequestMethod.POST)
    @ResponseBody
    public Result checkUser(@RequestBody User user) throws Exception {
        return userService.checkUser(user);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ResponseBody
    public Result register(@RequestBody User user) throws Exception {
        return userService.register(user);
    }
}
