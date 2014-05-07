package com.alipeach.usermanager.dao;

import com.alipeach.core.GenericDao;
import com.alipeach.usermanager.model.User;

/**
 * @author Chen Haoming
 */
public interface UserDao extends GenericDao<User, String> {

    User findByNickName (String nickname);

}
