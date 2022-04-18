package cinema.app.service.impl;

import cinema.app.dao.UserDao;
import cinema.app.lib.Inject;
import cinema.app.lib.Service;
import cinema.app.model.User;
import cinema.app.service.UserService;
import cinema.app.util.HashUtil;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Inject
    private UserDao userDao;

    @Override
    public User add(User user) {
        user.setSalt(HashUtil.getSalt());
        user.setPassword(HashUtil.hashPassword(user.getPassword(), user.getSalt()));
        return userDao.add(user);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userDao.findByEmail(email);
    }
}
