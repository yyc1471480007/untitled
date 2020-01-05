package cn.kgc.utils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Hander
 * @Description TODO 内省机制的工具类(框架)=设置封装属性的值
 * @Author zhaojing
 * @Date 2019/10/27 10:27
 * @Version 1.0
 *
 * Hander<T>:表示该类存放的是什么数据类型(对象类型，包装类型...)
 */
public class Hander<T> {

    public List<T> BeanListHander(ResultSet rs,Class<?> aClass) throws Exception{
        List<T> list = new ArrayList<>();

        while (rs.next()){
            //获取beaninfo对象
            BeanInfo beanInfo = Introspector.getBeanInfo(aClass, Object.class);
            //获取传入类型的实例化对象
            T t = (T)aClass.newInstance();
            //根据beaninfo对象获取属性的描述器
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor pc : propertyDescriptors) {
                //获取设置属性方法
                Method writeMethod = pc.getWriteMethod();
                //执行方法
                //pc.getName()：获取属性的名字
                writeMethod.invoke(t,rs.getObject(pc.getName()));
            }
            //把实体放到集合中
            list.add(t);
        }
        return list;
    }
}
