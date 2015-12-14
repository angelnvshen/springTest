package spring.model.inherit;

/**
 * Created by bf50 on 2015/11/6.
 */
public class Child2 extends Parent {
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return super.toString() + "Child2{" +
                "type='" + type + '\'' +
                '}';
    }
}
