package com.alipeach.usermanager.model;

import com.alipeach.core.model.BaseEntity;
import com.sun.org.glassfish.external.statistics.Stats;

import java.util.UUID;

/**
 * @author wjy
 */
public class User extends BaseEntity {

    private String uuid = UUID.randomUUID ().toString ();

    private int version = 0;

    private String nickName;

    private String password;

    private Status status;

    public String getNickName () {
        return nickName;
    }

    public void setNickName (String nickName) {
        this.nickName = nickName;
    }

    public String getPassword () {
        return password;
    }

    public void setPassword (String password) {
        this.password = password;
    }

    public int getStatus () {
        return status.getCode ();
    }

    public void setStatus (int code) {
        this.status = Status.getStatus (code);
    }

    @Override
    protected boolean doEquals (BaseEntity entity) {
        throw new UnsupportedOperationException ();
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void setVersion (int version) {
        this.version = version;
    }

    @Override
    public int getVersion () {
        return version;
    }

    @Override
    public void setUUID (String uuid) {
        this.uuid = uuid;
    }

    @Override
    public String getUUID () {
        return uuid;
    }
}
