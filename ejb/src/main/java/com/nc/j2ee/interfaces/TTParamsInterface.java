package com.nc.j2ee.interfaces;


import com.nc.j2ee.TTParams;
import com.nc.j2ee.embeded.AttrObject;

import javax.ejb.Local;

/**
 * EJB Local parameters interface
 * Created by Vlad on 27.06.2016.
 */
@Local
public interface TTParamsInterface {
    /**
     * Create parameters
     * @param params - params object
     */
    void create(TTParams params);

    /**
     * Update parameters
     * @param params - params object
     */
    void update(TTParams params);

    /**
     * Delete parameters by id
     * @param id - embeded id(AttrObject.class)
     */
    void delete(AttrObject id);
}
