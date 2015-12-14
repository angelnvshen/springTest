package spring.model;

/**
 * Created by bf50 on 2015/10/27.
 */
public class Dog {
    private String id;
    private String name;
    private String desc;

    public Dog (){

    }

    public Dog(String name){
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
}
