import mapper.UserMapper;
import model.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * Created by xhans on 2016/5/30 0030.
 */
public class MybatisTest {
    public static void main(String[] args){
        String resource = "mybatis.xml";

        InputStream is = MybatisTest.class.getClassLoader().getResourceAsStream(resource);

        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);

        SqlSession session = sessionFactory.openSession();

        UserMapper userMapper = session.getMapper(UserMapper.class);

        //test addUser
        User user = new User();
        user.setName("test1");
        user.setPassword("12345");
        userMapper.add(user);

        System.out.println("add new user id = " + user.getId());
        //test getUser
        System.out.println(userMapper.get(user.getId()));

        //test updateUser
        user.setName("test2");
        userMapper.update(user);
        System.out.println(userMapper.get(user.getId()));

        //test deleteUser
        userMapper.delete(user.getId());
        System.out.println(userMapper.get(user.getId()));
    }
}
