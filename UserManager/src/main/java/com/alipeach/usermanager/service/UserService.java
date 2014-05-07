package com.alipeach.usermanager.service;

import com.alipeach.core.service.GenericService;
import com.alipeach.usermanager.model.User;

/**
 * @author Chen Haoming
 */
public interface UserService extends GenericService<User, String> {

    int signUp (User user);

    int signIn (User user);

    int signOut (User user);

    int authenticate (User user);

}
