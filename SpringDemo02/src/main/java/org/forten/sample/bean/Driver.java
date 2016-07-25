package org.forten.sample.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2016/7/25.
 */
@Component("lb")
// @Scope("prototype")可以设置这个bean以非单例模式实例化，每次使用会得到一个新实例
public class Driver {
    @Value("吕布")
    private String name;
    @Resource(name="qq")
    private Car car;

    public Driver() {
    }

    public Driver(String name, Car car) {
        this.name = name;
        this.car = car;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "name='" + name + '\'' +
                ", car=" + car +
                '}';
    }
}
