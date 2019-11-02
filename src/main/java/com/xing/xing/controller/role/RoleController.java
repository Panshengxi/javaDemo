package com.xing.xing.controller.role;

import com.xing.xing.entity.Role;
import com.xing.xing.service.role.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "role")
public class RoleController {

    @Autowired
    private RoleServiceImpl mServiceImpl;

    @GetMapping(value = "/findAll")
    @ResponseBody
    public List<Role> findAll(){
        return mServiceImpl.findAll();
    }

}
