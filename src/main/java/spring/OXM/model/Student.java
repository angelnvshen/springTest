package spring.OXM.model;

import javax.xml.bind.annotation.*;

/**
 * Created by bf50 on 2015/12/16.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="student")
public class Student {
    @XmlElement(required = true)
    private String name;
    @XmlAttribute
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
