package org.forten.sample.bean;

/**
 * Created by Administrator on 2016/7/25.
 */
public class Driver {
    private String name;
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
