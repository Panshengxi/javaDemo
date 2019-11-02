package com.xing.xing.service.role;

import com.xing.xing.entity.Role;
import com.xing.xing.repository.RoleJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl {

    @Autowired
    private RoleJpa mJpa;
    public List<Role> findAll(){
        return mJpa.findAll();
    }
    public void findOne(Long i){
       System.out.println(mJpa.findById(i)+" -==============查询ID");
    }
}

