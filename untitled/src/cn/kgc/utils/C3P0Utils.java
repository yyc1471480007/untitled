package cn.kgc.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @ClassName utils
 * @Description TODO 连接池连接数据库工具类
 * @Author zhaojing
 * @Date 2019/10/27 8:37
 * @Version 1.0
 */
public class C3P0Utils {

    //创建连接池对象
    private static ComboPooledDataSource dataSource = new ComboPooledDataSource();

    //获取dataSource对象，给DBUtils的QueryRunner使用
    public static DataSource getDataSource(){
        return dataSource;
    }

    //获取数据库连接
    public static Connection getConn(){
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("连接池连接数据库失败！");
        }
    }

    //把数据库连接放回到连接池中
    public static void closeAll(Connection conn, Statement stat, ResultSet rs){
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(stat!=null){
            try {
                stat.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Connection conn = C3P0Utils.getConn();
        System.out.println(conn);
    }
}
