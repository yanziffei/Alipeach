package com.alipeach.core.model;

import org.apache.commons.lang.StringUtils;

import java.util.UUID;

/**
 * @author Chen Haoming
 */
public abstract class UUIDBasedEntity {

    public UUIDBasedEntity () {
        setUUID (UUID.randomUUID ().toString ());
    }

    public abstract void setUUID (String uuid);

    public abstract String getUUID ();

    @Override
    public int hashCode () {
        String uuid = getUUID ();
        return (null == uuid) ? 0 : uuid.hashCode ();
    }

    @Override
    public boolean equals (Object obj) {
        if (obj == null || ! (obj instanceof UUIDBasedEntity)) {
            return false;
        }

        if(this == obj) {
            return true;
        }

        UUIDBasedEntity entity = (UUIDBasedEntity) obj;
        return StringUtils.equals (entity.getUUID (), this.getUUID ()) && doEquals(entity);
    }

    protected abstract boolean doEquals (UUIDBasedEntity entity);
}
