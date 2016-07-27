package org.forten.sample.bo;

import org.forten.sample.model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by Administrator on 2016/7/26.
 */
public class UserBoTest {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath*:/spring/app-*.xml");
        UserBo bo = ctx.getBean("userBo",UserBo.class);
//        bo.doSave(new User("Tom2","abc","tom2@tom.com"));
        List<User> list = bo.queryAll();
        for(User u: list){
            System.out.println(u);
        }
        System.out.println("===========================");
        list = bo.queryByName("o");
        for(User u: list){
            System.out.println(u);
        }
    }
}
