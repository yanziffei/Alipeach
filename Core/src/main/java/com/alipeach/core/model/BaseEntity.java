package com.alipeach.core.model;

import org.apache.commons.lang.StringUtils;

import java.io.Serializable;
import java.util.UUID;

/**
 * @author Chen Haoming
 */
public abstract class BaseEntity implements UUIDBasedEntity, OptimisticLockBasedEntity, Serializable {

    private String uuid = UUID.randomUUID ().toString ();

    private int version = 0;

    @Override
    public int hashCode () {
        String uuid = getUuid ();
        return (null == uuid) ? 0 : uuid.hashCode ();
    }

    @Override
    public boolean equals (Object obj) {
        if (obj == null || ! (obj instanceof BaseEntity)) {
            return false;
        }

        if (this == obj) {
            return true;
        }

        BaseEntity entity = (BaseEntity) obj;
        return StringUtils.equals (entity.getUuid (), this.getUuid ()) && this.getVersion () == entity.getVersion () && doEquals (entity);
    }

    protected abstract boolean doEquals (BaseEntity entity);

    @Override
    public String getUuid () {
        return uuid;
    }

    @Override
    public void setUuid (String uuid) {
        this.uuid = uuid;
    }

    @Override
    public int getVersion () {
        return version;
    }

    @Override
    public void setVersion (int version) {
        this.version = version;
    }
}
