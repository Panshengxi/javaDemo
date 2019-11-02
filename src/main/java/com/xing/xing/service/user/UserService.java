package com.xing.xing.service.user;

import com.xing.xing.entity.Token;
import com.xing.xing.entity.user.User;
import com.xing.xing.response.Result;
import com.xing.xing.response.UserInfo;
import com.xing.xing.repository.UserJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserJpa mJpa;
    Result result = new Result();

    /**
     * 登录态标识
     */
    public static String getCK() {
        String ck = UUID.randomUUID().toString();
        ck = ck.replace("-", "");
        return ck;
    }

    /**
     * 给用户存登录态token
     *
     * @param name
     * @param token
     */
    public void updateByUsername(String name, Token token) {
        User record = mJpa.findByUserName(name);
        // 直接修改这个record的内容
        record.setCk(token.getCk());
        mJpa.save(record);
    }

    /**
     * 登录
     *
     * @param user
     * @return
     * @throws Exception
     */
    public Result login(User user) throws Exception {

        User record = mJpa.findByMobileAndPassword(user.getMobile(), user.getPassword());
        if (record == null) {
            result = result.getResultData("用户或密码错误！", 102, null);
        } else {
            String str = this.getCK();
            Token token = new Token();
            token.setCk(str);
            token.setUserName(record.getUserName());
            updateByUsername(record.getUserName(), token);
            result = result.getResultData("登录成功！", 100, token);

        }
        return result;
    }

    /**
     * 验证登录态
     *
     * @param user
     * @return
     * @throws Exception
     */
    public Result authLoginState(User user) throws Exception {

        if (user.getCk() == null || user.getCk() == "null" || user.getCk() == "") {
            result = result.getResultData("用户未登录，请登录！", 103, null);
        } else {
            User record = mJpa.findByCk(user.getCk());
            if (record == null) {
                result = result.getResultData("您的登录已过期，", 102, null);
            } else {
                UserInfo userInfo = new UserInfo();
                result = result.getResultData("登录ok！", 100, userInfo.setData(record));
            }
        }
        return result;
    }

    /**
     * 检验是否有该用户
     *
     * @param user
     * @return
     * @throws Exception
     */
    public Result checkUser(User user) throws Exception {
        User r = mJpa.findByMobile(user.getMobile());
        if (r == null) {
            result = result.getResultData("您未注册此账号，请前往注册！", 102, null);
        } else {
            result = result.getResultData("此账号OK！", 100, r);
        }
        return result;
    }

    /**
     * 注册用户
     *
     * @param user
     * @return
     * @throws Exception
     */
    public Result register(User user) throws Exception {
        user.setUserName(user.getMobile());
        User record = mJpa.save(user);
        if (record.toString() == "Optional.empty") {
            result = result.getResultData("注册失败！", 102, null);
        } else {
            String str = this.getCK();
            Token token = new Token();
            token.setCk(str);
            token.setUserName(user.getUserName());
            result = result.getResultData("注册成功！", 100, token);
            updateByUsername(user.getUserName(), token);
        }
        return result;
    }
}
