package com.nc.j2ee.interfaces;



import com.nc.j2ee.TTAttributes;

import javax.ejb.Local;

/**
 * EJB Local attribute interface
 * Created by Vlad on 24.06.2016.
 */

@Local
public interface TTAttributeInterface {
    /**
     * Create attribute
     * @param attributes - attribute object
     * @return attribute id
     */
    long create(TTAttributes attributes);

    /**
     * Update attribute
     * @param attributes - attribute object
     */
    void update(TTAttributes attributes);

    /**
     * Delete attribute by id
     * @param id - attribute id
     */
    void delete(long id);
}
