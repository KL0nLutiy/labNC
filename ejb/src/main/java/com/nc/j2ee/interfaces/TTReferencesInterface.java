package com.nc.j2ee.interfaces;


import com.nc.j2ee.TTReferences;
import com.nc.j2ee.embeded.AttrObjectReference;

import javax.ejb.Local;

/**
 * EJB Local references interface
 * Created by Vlad on 27.06.2016.
 */
@Local
public interface TTReferencesInterface {
    /**
     * Create references
     * @param references - references object
     */
    void create(TTReferences references);

    /**
     * Update references
     * @param references - references object
     */
    void update(TTReferences references);

    /**
     * Delete references by id
     * @param id - embeded id(AttrObjectReference.class)
     */
    void delete(AttrObjectReference id);
}
