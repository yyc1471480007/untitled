package cn.kgc.service.impl;

import cn.kgc.dao.UserDao;
import cn.kgc.dao.impl.UserDaoImpl;
import cn.kgc.service.DemoService;

/**
 * @ClassName DemoServiceImpl
 * @Description TODO
 * @Author zhaojing
 * @Date 2019/10/31 8:42
 * @Version 1.0
 */
public class DemoServiceImpl implements DemoService {

    //实例化dao对象
    UserDao userDao = new UserDaoImpl();

    @Override
    public boolean isExists(String userName, String userPwd) throws Exception {
        return userDao.isExists(userName,userPwd)!=null?true:false;
    }
}
