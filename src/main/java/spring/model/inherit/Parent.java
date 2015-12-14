package spring.model.inherit;

/**
 * Created by bf50 on 2015/11/6.
 */
public class Parent {
    private String name;
    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Parent{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
