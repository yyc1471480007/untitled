package cn.kgc.service;

import cn.kgc.domain.User;

/**
 * @ClassName DemoService
 * @Description TODO
 * @Author zhaojing
 * @Date 2019/10/31 8:42
 * @Version 1.0
 */
public interface DemoService {

    //验证用户名和密码是否正确
    boolean isExists(String userName, String userPwd) throws Exception;
}
