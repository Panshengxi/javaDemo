package com.xing.xing.controller.home;

import com.xing.xing.response.Result;
import com.xing.xing.service.home.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
@CrossOrigin(value = "*")
public class HomeController {
    @Autowired
    private HomeService homeService;
    Result r = new Result();
    @RequestMapping(value = "/home/getInfo", method = RequestMethod.POST)
    @ResponseBody
    public Result getInfo(HttpServletRequest request) throws Exception {
        return homeService.getInfo(request.getHeader("Custom-Params"));
    }


}
