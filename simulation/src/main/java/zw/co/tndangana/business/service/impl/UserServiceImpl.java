package zw.co.tndangana.business.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zw.co.tndangana.business.domain.User;
import zw.co.tndangana.business.service.UserService;
import zw.co.tndangana.business.repository.UserRepo;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 *
 * @author tonderai ndangana created on 03/04/2016
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;
    @PersistenceContext
    private EntityManager entityManager;

    public User save(User user) {
        return userRepo.save(user);
    }

    public List<User> findAll() {

        return userRepo.findAll();
    }

    public User find(Long id) {
        User user = userRepo.findOne(id);
        return user;
    }

    public void delete(User user) {
        userRepo.delete(user);

    }

    public User get(String username, String password) {
        List<User> users = entityManager.createQuery("SELECT u from User u WHERE u.username=:uname AND u.password=:upass").setParameter("uname", username).setParameter("upass", password).getResultList();
        if (!users.isEmpty()) {
            return users.get(0);
        } else {
            return null;
        }
    }

//    public User edit(User user) {
//        return userRepo.edit(user);
//    }
}
