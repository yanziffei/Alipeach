package com.alipeach.usermanager.model;

import com.alipeach.core.model.BaseEntity;
import com.sun.org.glassfish.external.statistics.Stats;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

/**
 * @author wjy
 */
@Entity (name = "t_user")
public class User extends BaseEntity {

    @Id
    @Column (name = "uuid", length = 36)
    private String uuid = UUID.randomUUID ().toString ();

    @Column (name = "version", nullable = false)
    private int version = 0;

    @Column (name = "nickname", unique = true, length = 60, nullable = false)
    private String nickName;

    @Column (name = "password", length = 32, nullable = false)
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

    @Column (name = "status", nullable = false)
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
