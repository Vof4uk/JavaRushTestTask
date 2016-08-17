package main.java.service;

import main.java.dao.PagingProps;
import main.java.entities.User;

import java.util.List;

/**
 * Created by Микитенко on 12.08.2016.
 */
public interface UserService {
        void createUser(User user) throws Exception;
        void updateUser(User user) throws Exception;
        List<User> selectAllUsers(int pageNum, PagingProps props);
        void deleteUser(Long id);
        User getUserByID(Long id);
        List<User> searchUserNameLike(User user, int pageNum, PagingProps props);
}
