package com.s305089.software.service;

import com.s305089.software.dao.UserDao;
import com.s305089.software.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService, UserDetailsService {
    private static final Logger log = LogManager.getRootLogger();


    @Autowired
    private UserDao dao;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User findById(int id) {
        return dao.findById(id);
    }

    @Override
    public User findBySeries(String series) {
        return dao.findBySeries(series);
    }

    @Override
    public User findBySSO(String sso) {
        return dao.findBySSO(sso);
    }

    @Override
    public User findByUsername(String username) {
        return dao.findByUsername(username);
    }

    @Override
    public void saveUser(User user) {
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
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


    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String sso) throws UsernameNotFoundException {
        User user = findBySSO(sso);
        log.info("User : {}", user);
        if (user == null) {
            log.info("User not found");
            throw new UsernameNotFoundException("Username not found");
        }
        return new org.springframework.security.core.userdetails.User(user.getSsoId(), user.getPassword(),
                true, true, true, true, getGrantedAuthorities(user));
    }

    private List<GrantedAuthority> getGrantedAuthorities(User user) {
        List<GrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
        log.info("authorities : {}", authorities);
        return authorities;
    }

}
