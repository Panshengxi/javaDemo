package com.xing.xing.service.register;

import com.xing.xing.entity.user.User;
import com.xing.xing.response.Result;
import com.xing.xing.repository.UserJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RegisterService {
    @Autowired
    private UserJpa mJpa;
    Result result = new Result();

    /***
     * 校验用户名是否注册过
     * @param user
     * @return
     * @throws Exception
     */
    public Result verifyUserName(User user) throws Exception{
        Example<User> regExample = Example.of(user);
        Optional<User> exampleResult = mJpa.findOne(regExample);
        if(exampleResult.toString()=="Optional.empty"){
            result = result.getResultData("用户名可用！",100,null);
        }else {
            result = result.getResultData("用户已存在！", 100,null);
        }
        return result;
    }

    /***
     * 注册
     * @param user
     * @return
     * @throws Exception
     */
    public Result register(User user) throws Exception {
        if (mJpa.save(user).toString()=="Optional.empty"){
            result = result.getResultData("注册失败！",102,null);
        }else {
            result = result.getResultData("注册成功！",100,null);
        }
        return result;
    }
}
