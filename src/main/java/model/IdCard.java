package model;

import java.io.Serializable;

/**
 * Created by bf50 on 2015/10/19.
 */
public class IdCard implements Serializable{
    private String id;
    private String number;
    private String desc;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "IdCard{" +
                "id='" + id + '\'' +
                ", number='" + number + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
