package cn.kgc.dao;

import cn.kgc.domain.User;

/**
 * @ClassName UserDao
 * @Description TODO
 * @Author zhaojing
 * @Date 2019/10/31 8:37
 * @Version 1.0
 */
public interface UserDao {

    //验证用户名和密码是否正确
    User isExists(String userName, String userPwd) throws Exception;
}
