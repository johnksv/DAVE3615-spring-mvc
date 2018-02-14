package com.s305089.software.service;

import com.s305089.software.dao.UserDao;
import com.s305089.software.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao dao;

//    @Autowired
//    private PasswordEncoder passwordEncoder;

    @Override
    public User findById(int id) {
        return dao.findById(id);
    }

    @Override
    public User findBySSO(String sso) {
        return dao.findBySSO(sso);
    }

    @Override
    public void saveUser(User user) {
    //    user.setPassword(passwordEncoder.encode(user.getPassword()));
        dao.save(user);
    }

    @Override
    public void updateUser(User user) {
        User entity = dao.findById(user.getId());
        if (entity != null) {
            entity.setSsoId(user.getSsoId());
            if (!user.getPassword().equals(entity.getPassword())) {
                //entity.setPassword(passwordEncoder.encode(user.getPassword()));
                entity.setPassword(user.getPassword());
            }
            entity.setFirstName(user.getFirstName());
            entity.setLastName(user.getLastName());
            entity.setEmail(user.getEmail());
        }
    }

    @Override
    public void deleteUserBySSO(String sso) {
        dao.deleteBySSO(sso);
    }

    @Override
    public List<User> findAllUsers() {
        return dao.findAllUsers();
    }

    @Override
    public boolean isUserSSOUnique(Integer id, String sso) {
        User user = findBySSO(sso);
        return (user == null || ((id != null) && (user.getId().equals(id))));
    }
}
