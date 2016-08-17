package main.java.service;

import main.java.dao.PagingProps;
import main.java.dao.UserDAO;
import main.java.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * Created by Микитенко on 12.08.2016.
 */
@Configuration
@ComponentScan(basePackages = "main.java.dao")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    private void validateUser(User user) throws Exception{
        if(user.getAge() != null && (user.getAge()<0 || user.getAge()>150))
            throw new BadAgeException();
        if(user.getUsername() == null || user.getUsername().length() < 4 || user.getUsername().length() > 25)
            throw new BadUsernameException();
    }

    public void createUser(User user) throws Exception{
        validateUser(user);
        userDAO.createUser(user);
    }

    public void updateUser(User user) throws Exception{
        validateUser(user);
        userDAO.updateUser(user);
    }

    public List<User> selectAllUsers(int pageNum, PagingProps props) {
        return userDAO.selectAllUsers(pageNum, props);
    }

    public void deleteUser(Long id) {
        User user = userDAO.getUserByID(id);
        userDAO.deleteUser(user);
    }

    public User getUserByID(Long id) {
        return userDAO.getUserByID(id);
    }

    public List<User> searchUserNameLike(User user, int pageNum, PagingProps props){
        List<User> userList = userDAO.searchUserNameLike(user.getUsername(), pageNum, props);
        return userList;
    }
}
