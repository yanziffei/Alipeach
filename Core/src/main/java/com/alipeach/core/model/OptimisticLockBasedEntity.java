package com.alipeach.core.model;

/**
 * @author Chen Haoming
 */
public interface OptimisticLockBasedEntity {

    void setVersion(int version);

    int getVersion();
}
