package spring.model;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Created by bf50 on 2015/11/5.
 */
public class Car implements InitializingBean,DisposableBean {
    private String brand;
    private String type;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    public void init(){
        System.out.println("init ....  ");
    }
    public void destoryed(){
        System.out.println("destoryed ....  ");
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("PostConstruct ... ");
    }

    @PreDestroy
    public void preDestory() {
        System.out.println("preDestory ... ");
    }


    public void destroy() throws Exception {
        System.out.println("destroy ... ");
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet ... ");
    }
}
