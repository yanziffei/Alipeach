package com.alipeach.usermanager.service.Impl;

import com.alipeach.core.GenericDao;
import com.alipeach.core.service.GenericServiceImpl;
import com.alipeach.usermanager.dao.UserDao;
import com.alipeach.usermanager.model.User;
import com.alipeach.usermanager.service.UserService;

/**
 * @author Chen Haoming
 */
public class DefautUserService extends GenericServiceImpl<User, String> implements UserService {

    public static final int SUCCESSFUL = 0;
    public static final int USER_EXISTS = 1;
    private UserDao dao;

    public DefautUserService (UserDao dao) {
        super (dao);
        this.dao = dao;
    }

    @Override
    public int signUp (User user) {
        User foundUser = dao.findByNickName (user.getNickName ());

        if (foundUser == null) {
            dao.save (user);
            return SUCCESSFUL;
        }

        return USER_EXISTS;
    }

    @Override
    public int signIn (User user) {
        throw new UnsupportedOperationException ();
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int signOut (User user) {
        throw new UnsupportedOperationException ();
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public int authenticate (User user) {
        throw new UnsupportedOperationException ();
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
