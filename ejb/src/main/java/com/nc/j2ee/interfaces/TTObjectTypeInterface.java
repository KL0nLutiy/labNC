package com.nc.j2ee.interfaces;

import com.nc.j2ee.TTObjectType;

import javax.ejb.Local;

/**
 * EJB Local object type interface
 * Created by Vlad on 24.06.2016.
 */

@Local
public interface TTObjectTypeInterface {
    /**
     * Create object type
     * @param objectType - object type object
     * @return - object type id
     */
    long create(TTObjectType objectType);

    /**
     * Update object type
     * @param objectType - object type object
     */
    void update(TTObjectType objectType);

    /**
     * Delete object type by id
     * @param id - object id
     */
    void delete(long id);
}
