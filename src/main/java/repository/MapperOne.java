package repository;

import model.User;

import java.util.HashMap;
import java.util.List;

/**
 * Created by bf50 on 2015/10/16.
 */
public interface MapperOne {
    List<User> getUsers(User user);
    List<User> getUsers_2(User user);
    List<User> getUsers_3(User user);
    List<User> selectUsers(HashMap params);
}
