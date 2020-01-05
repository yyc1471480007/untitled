package cn.kgc.dao.impl;

import cn.kgc.dao.UserDao;
import cn.kgc.domain.User;
import cn.kgc.utils.C3P0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

/**
 * @ClassName UserDaoImpl
 * @Description TODO
 * @Author zhaojing
 * @Date 2019/10/31 8:38
 * @Version 1.0
 */
public class UserDaoImpl implements UserDao {

    QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());

    @Override
    public User isExists(String userName, String userPwd) throws Exception {
        String sql = " select * from users where uname=? and upwd=? ";
        User user = qr.query(sql, new BeanHandler<User>(User.class), userName, userPwd);
        return user;
    }
}
