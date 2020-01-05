package cn.kgc.domain;

/**
 * @ClassName User
 * @Description TODO
 * @Author zhaojing
 * @Date 2019/10/31 8:36
 * @Version 1.0
 */
public class User {

    private Integer uid;
    private String userName;
    private String userPwd;

    public User() {
    }

    public User(Integer uid, String userName, String userPwd) {
        this.uid = uid;
        this.userName = userName;
        this.userPwd = userPwd;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", userName='" + userName + '\'' +
                ", userPwd='" + userPwd + '\'' +
                '}';
    }
}
