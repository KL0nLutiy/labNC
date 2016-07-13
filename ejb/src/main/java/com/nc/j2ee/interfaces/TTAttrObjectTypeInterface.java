package com.nc.j2ee.interfaces;

import com.nc.j2ee.TTAttrObjectTypes;
import com.nc.j2ee.embeded.AttrObjectType;

import javax.ejb.Local;

/**
 * EJB Local attribute object type interface
 * Created by Vlad on 27.06.2016.
 */

@Local
public interface TTAttrObjectTypeInterface {
    /**
     * Create attribute object type
     * @param attrObjectType - attribute object type object
     */
    void create(TTAttrObjectTypes attrObjectType);

    /**
     * Update attribute object type
     * @param attrObjectType - attribute object type object
     */
    void update(TTAttrObjectTypes attrObjectType);

    /**
     * Delete attribute object type by id
     * @param id - embeded id(AttrObjectType.class)
     */
    void delete(AttrObjectType id);
}
