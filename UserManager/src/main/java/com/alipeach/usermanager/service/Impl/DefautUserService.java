package com.alipeach.usermanager.service.Impl;

import com.alipeach.core.GenericDao;
import com.alipeach.core.service.GenericServiceImpl;
import com.alipeach.security.IrreversibleEncryptor;
import com.alipeach.security.Md5Encryptor;
import com.alipeach.usermanager.dao.UserDao;
import com.alipeach.usermanager.model.User;
import com.alipeach.usermanager.service.UserService;

import java.util.List;

/**
 * @author Chen Haoming
 */
public class DefautUserService extends GenericServiceImpl<User, String> implements UserService {

    public static final int SUCCESSFUL = 0;
    public static final int USER_EXISTS = 1;
    private UserDao dao;
    private IrreversibleEncryptor encryptor;

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

    @Override
    public User save (User user) {
        if (null != encryptor) {
            user.setPassword (encryptor.encrypt (user.getPassword ()));
        }
        return super.save (user);
    }

    @Override
    public List<User> save (List<User> list) {
        throw new UnsupportedOperationException ();
        //To change body of overridden methods use File | Settings | File Templates.
    }

    public void setEncryptor (IrreversibleEncryptor encryptor) {
        this.encryptor = encryptor;
    }
}
