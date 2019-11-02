package com.xing.xing.service.activity;

import com.xing.xing.response.Result;
import com.xing.xing.entity.user.User;
import com.xing.xing.response.UserInfo;
import com.xing.xing.repository.UserJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "Sign")
public class ActivityService {
    @Autowired
    private UserJpa mJpa;
    Result result = new Result();

    /**
     * 获取用户签到数据
     * @param user
     * @return
     * @throws Exception
     */
    public Result getSign(User user) throws Exception {
        if (user.getCk() == null || user.getCk() == "null" || user.getCk()=="") {
            result = result.getResultData("您未登录用户，请前往登录！", 103, null);
        } else {
            User record = mJpa.findByCk(user.getCk());
            if (record == null) {
                result = result.getResultData("您的登录已过期，请重新登录！", 102, null);
            } else {
                UserInfo u = new UserInfo();
                result = result.getResultData("登录OK！", 100, u.setData(record));
            }
        }

        return result;
    }
}
