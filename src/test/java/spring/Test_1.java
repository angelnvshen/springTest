package spring;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.model.Cat;
import spring.model.Car;
import spring.model.Dog;
import spring.model.inherit.Child;
import spring.model.inherit.Child2;
import spring.model.inherit.Parent;

/**
 * Created by bf50 on 2015/10/27.
 */
public class Test_1 {

    private ApplicationContext context;

    @Before
    public void beforeTest(){
        context = new ClassPathXmlApplicationContext(new String[]{"spring/Bean_test.xml"});
    }

    @Test
    public void testUsingContainer(){

        Dog dog = context.getBean("dog", Dog.class);
        System.out.println(dog);
        Dog dog2 = context.getBean("dog_same", Dog.class);
        System.out.println(dog2);

        Dog dog3 = context.getBean("dog_2", Dog.class);
        System.out.println(dog3);
    }

    @Test
    public void testStaticFactoryMethod(){
        Cat cat = context.getBean("cat", Cat.class);
        System.out.println(cat);
    }

    @Test
    public void testInitializationAndDestructionCallbacks(){
        Car car = context.getBean("car", Car.class);
        System.out.println(car);
    }

    @Test
    public void inheritedTest(){
        Parent parent = context.getBean("inheritedTestParent", Parent.class);
        System.out.println(parent);
        Child child = context.getBean("inheritedTestChild", Child.class);
        System.out.println(child);
        Child2 child2 = context.getBean("inheritedTestChild2", Child2.class);
        System.out.println(child2);
    }
}
