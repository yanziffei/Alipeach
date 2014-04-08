package com.alipeach.core.model;

import org.apache.commons.lang.StringUtils;

import java.util.UUID;

/**
 * @author Chen Haoming
 */
public abstract class BaseEntity implements UUIDBasedEntity, OptimisticLockBasedEntity {

    public BaseEntity () {
        setUUID (UUID.randomUUID ().toString ().replaceAll ("-", ""));
    }

    @Override
    public int hashCode () {
        String uuid = getUUID ();
        return (null == uuid) ? 0 : uuid.hashCode ();
    }

    @Override
    public boolean equals (Object obj) {
        if (obj == null || ! (obj instanceof BaseEntity)) {
            return false;
        }

        if(this == obj) {
            return true;
        }

        BaseEntity entity = (BaseEntity) obj;
        return StringUtils.equals (entity.getUUID (), this.getUUID ()) && doEquals(entity);
    }

    protected abstract boolean doEquals (BaseEntity entity);
}
