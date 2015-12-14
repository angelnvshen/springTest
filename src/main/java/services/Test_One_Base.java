package services;

import model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import repository.MapperOne;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by bf50 on 2015/10/16.
 */
public class Test_One_Base {
    public static SqlSessionFactory getSqlSessionFactory() {
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            System.out.println(Resources.getResourceURL(""));
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        return sessionFactory;
    }

    @Test
    public void testSqlSession(){
        SqlSession session = getSqlSessionFactory().openSession();
        User u = new User();
        u.setLoginName("s01277");
        List<User> user = session.selectList("repository.MapperOne.getUsers", null);
//        User user = session.selectOne("org.mybatis.example.MapperOne.getUsers", u);
        System.out.println(user);
        session.close();
    }

    /**
     * cache
     *      1. 一级缓存: 基于PerpetualCache 的 HashMap本地缓存，其存储作用域为 Session，当 Session flush 或 close 之后，该Session中的所有 Cache 就将清空。
            2. 二级缓存与一级缓存其机制相同，默认也是采用 PerpetualCache，HashMap存储，不同在于其存储作用域为 Mapper(Namespace)，并且可自定义存储源，如 Ehcache。
            3. 对于缓存数据更新机制，当某一个作用域(一级缓存Session/二级缓存Namespaces)的进行了 C/U/D 操作后，默认该作用域下所有 select 中的缓存将被clear。

     */

    @Test
    public void testSqlSession_new (){
        SqlSession session = getSqlSessionFactory().openSession();
        User u = new User();
        u.setLoginName("s01277");
        MapperOne mapper = session.getMapper(MapperOne.class);
        List<User> user = mapper.getUsers(u);
        System.out.println(user);
        session.clearCache();
        List<User> users = mapper.getUsers(u);
        System.out.println(users);

        session.close();
    }

    @Test
    public void testSecondCache(){
        SqlSessionFactory sessionFactory = getSqlSessionFactory();
        SqlSession session1 =  sessionFactory.openSession();
        SqlSession session2 =  sessionFactory.openSession();
        MapperOne mapper1 = session1.getMapper(MapperOne.class);
        MapperOne mapper2 = session2.getMapper(MapperOne.class);
        User u = new User();
        u.setLoginName("s01277");
        List<User> users1 = mapper1.getUsers(u);
        System.out.println(users1);

        session1.commit();

        List<User> users2 = mapper2.getUsers(u);
        System.out.println(users2);

        session1.close();
        session2.close();
    }
    @Test
    public void testNestedSelectForAssociation (){
        SqlSession session = getSqlSessionFactory().openSession();
        User u = new User();
        u.setLoginName("DGCS12");
        MapperOne mapper = session.getMapper(MapperOne.class);
        List<User> user = mapper.getUsers(u);
        System.out.println(user);
        session.close();
    }

    @Test
    public void testNestedResultsForAssociation (){
        SqlSession session = getSqlSessionFactory().openSession();
        User u = new User();
        u.setLoginName("DGCS12");
        MapperOne mapper = session.getMapper(MapperOne.class);
        List<User> user = mapper.getUsers_2(u);
        System.out.println(user);
        session.close();
    }

    @Test
    public void testMultipleResultSetsForAssociation (){
        SqlSession session = getSqlSessionFactory().openSession();
        HashMap params = new HashMap();
        params.put("loginName", "DGCS12");
        params.put("idx", "1");
        MapperOne mapper = session.getMapper(MapperOne.class);
        List<User> user = mapper.selectUsers(params);
        System.out.println(user);
        session.close();
    }

    @Test
    public void testNestedSelectForCollection(){
        SqlSession session = getSqlSessionFactory().openSession();
        User u = new User();
        u.setLoginName("DGCS08");
        MapperOne mapper = session.getMapper(MapperOne.class);
        List<User> user = mapper.getUsers(u);
        System.out.println(user);
        session.close();
    }

    @Test
    public void testNestedResultsForCollection(){
        SqlSession session = getSqlSessionFactory().openSession();
        User u = new User();
        u.setLoginName("DGCS08");
        MapperOne mapper = session.getMapper(MapperOne.class);
        List<User> user = mapper.getUsers_3(u);
        System.out.println(user);
        session.close();
    }

}
