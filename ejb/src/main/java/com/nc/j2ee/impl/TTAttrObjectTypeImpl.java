package com.nc.j2ee.impl;
import com.nc.j2ee.TTAttrObjectTypes;
import com.nc.j2ee.embeded.AttrObjectType;
import com.nc.j2ee.interfaces.TTAttrObjectTypeInterface;
import org.apache.log4j.Logger;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * EJB LocalBean with interface implements
 * Created by Vlad on 27.06.2016.
 */
@LocalBean
@Stateless(name = "TTAttrObjectTypesLocalSessionEJB")
public class TTAttrObjectTypeImpl implements TTAttrObjectTypeInterface {
    /**
     * Logger for logging info and errors
     */
    private static final Logger log = Logger.getLogger(TTAttrObjectTypeImpl.class);

    /**
     * Entity manager to connect database with parsistance xml
     */
    @PersistenceContext(unitName = "objects")
    private EntityManager manager;

    /**
     * Create attribute object type
     * @param attrObjectType - attribute object type object
     */
    public void create(TTAttrObjectTypes attrObjectType)
    {
        log.info("Create attr object type "+attrObjectType.toString());
        manager.persist(attrObjectType);
    }

    /**
     * Update attribute object type
     * @param attrObjectType - attribute object type object
     */
    public void update(TTAttrObjectTypes attrObjectType) {
        log.info("Update attr object type "+attrObjectType.toString());
        manager.merge(attrObjectType);
    }

    /**
     * Delete attribute object type by id
     * @param id - embeded id(AttrObjectType.class)
     */
    public void delete(AttrObjectType id) {
        TTAttrObjectTypes attrObjectType = manager.find(TTAttrObjectTypes.class, id);
        log.info("Delete attr object type "+attrObjectType.toString());
        manager.remove(attrObjectType);
    }
}
