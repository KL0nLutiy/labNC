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
    public long create(TTObjectType objectType);

    /**
     * Update object type
     * @param objectType - object type object
     */
    public void update(TTObjectType objectType);

    /**
     * Delete object type by id
     * @param id - object id
     */
    public void delete(long id);
}
