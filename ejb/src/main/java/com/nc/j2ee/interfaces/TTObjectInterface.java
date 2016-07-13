package com.nc.j2ee.interfaces;


import com.nc.j2ee.TTObject;

import javax.ejb.Local;

/**
 * EJB Local object interface
 * Created by Vlad on 24.06.2016.
 */
@Local
public interface TTObjectInterface {
    /**
     * Create object
     * @param object - object object
     * @return object id
     */
    long create(TTObject object);

    /**
     * Update object
     * @param object - object object
     */
    void update(TTObject object);

    /**
     * Delete object by id
     * @param id - object id
     */
    void delete(long id);
}
