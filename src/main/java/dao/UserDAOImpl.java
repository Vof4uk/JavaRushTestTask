package main.java.dao;

import main.java.entities.User;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Configuration
@ComponentScan(basePackages ="main.java.connection")
public class UserDAOImpl implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session session;

    private Session getSession()
    {
        if(session == null || !session.isOpen())
            session = sessionFactory.openSession();
        return session;
    }

    @Transactional
    public void createUser(User user) {
        Session session = getSession();
        session.save(user);
        session.flush();
    }

    @Transactional
    public void updateUser(User freshUser) {
        Session session = getSession();
        User oldUser = session.get(User.class, freshUser.getUserID());
        oldUser.setAge(freshUser.getAge());
        oldUser.setUsername(freshUser.getUsername());
        oldUser.setAdmin(oldUser.isAdmin());
        session.save(oldUser);
        session.flush();
    }

    @Transactional
    @SuppressWarnings("unchecked")
    public List<User> selectAllUsers(int pageNumber, PagingProps props) {
        Criteria criteria = getSession().createCriteria(User.class).addOrder(props.getHQLOrder());
        criteria.setFirstResult((pageNumber - 1) * props.getPageSize());
        criteria.setMaxResults(props.getPageSize());
        return criteria.list();
    }

    @Transactional
    public void deleteUser(User user) {
        Session session = getSession();
        session.delete(user);
        session.flush();
    }

    @Transactional
    public User getUserByID(Long id) {
        Session session = getSession();
        return session.get(User.class, id);
    }

    @Transactional
    @SuppressWarnings("unchecked")
    public List<User> searchUserNameLike(String spittle, int pageNum, PagingProps props) {
        Criteria criteria = getSession().createCriteria(User.class).addOrder(props.getHQLOrder());
        criteria.setFirstResult((pageNum - 1) * props.getPageSize());
        criteria.setMaxResults(props.getPageSize());
        criteria.add(Restrictions.like("username", "%" + spittle + "%"));
        return criteria.list();
    }

}
