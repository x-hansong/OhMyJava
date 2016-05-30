package mapper;

import model.User;

/**
 * Created by xhans on 2016/5/30 0030.
 */
public interface UserMapper {
    int add(User user);

    User get(int uid);

    int update(User user);

    int delete(int uid);
}
