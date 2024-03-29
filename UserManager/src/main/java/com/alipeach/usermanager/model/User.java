package com.alipeach.usermanager.model;

import com.alipeach.core.model.BaseEntity;
import org.apache.commons.lang.StringUtils;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Version;

/**
 * @author wjy
 */
@Entity (name = "t_user")
public class User extends BaseEntity {

    @Column (name = "nickname", unique = true, length = 60, nullable = false)
    private String nickName;

    @Column (name = "password", length = 32, nullable = false)
    private String password;

    private Status status = Status.NORMAL;

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
        if (! (entity instanceof User)) {
            return false;
        }

        User user = (User) entity;
        return StringUtils.equals (this.getNickName (), user.getNickName ()) && StringUtils.equals (this.getPassword (), user.getPassword ()) && this.status == user.status;
    }

    @Column (name = "version", nullable = false)
    @Version
    @Override
    public void setVersion (int version) {
        super.setVersion (version);
    }

    @Override
    public int getVersion () {
        return super.getVersion ();
    }

    @Id
    @Column (name = "uuid", length = 36)
    @Override
    public void setUuid (String uuid) {
        super.setUuid (uuid);
    }

    @Override
    public String getUuid () {
        return super.getUuid ();
    }
}
