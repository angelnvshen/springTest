package spring.model;

/**
 * Created by bf50 on 2015/10/29.
 */
public class Cat {
    private String name;
    private String desc;

    private Cat(){

    }

    private Cat(String name, String desc){
        this.name = name;
        this.desc = desc;
    }

    public static Cat getCatInstancc(String name, String desc){
        return new Cat(name, desc);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
