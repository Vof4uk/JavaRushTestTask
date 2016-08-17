package main.java.dao;

import main.java.entities.User;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


/**
 * Created by Микитенко on 12.08.2016.
 */
public interface UserDAO {
    void createUser(User user);
    void updateUser(User user);
    List<User> selectAllUsers(int PageNum, PagingProps props);
    void deleteUser(User user);
    User getUserByID (Long id);
    List<User> searchUserNameLike(String piece, int PageNum, PagingProps props);
}
