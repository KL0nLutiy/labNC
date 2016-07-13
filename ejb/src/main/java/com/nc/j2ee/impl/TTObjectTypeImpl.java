package com.nc.j2ee.impl;

import com.nc.j2ee.TTObjectType;
import com.nc.j2ee.interfaces.TTObjectTypeInterface;
import org.apache.log4j.Logger;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * EJB LocalBean with interface implements
 * Created by Vlad on 24.06.2016.
 */
@LocalBean
@Stateless(name = "TTObjectTypeLocalSessionEJB")
public class TTObjectTypeImpl implements TTObjectTypeInterface {
    /**
     * Logger for logging info and errors
     */
    private static final Logger log = Logger.getLogger(TTObjectTypeImpl.class);

    /**
     * Entity manager to connect database with parsistance xml
     */
    @PersistenceContext(unitName = "objects")
    private EntityManager manager;

    /**
     * Create object type
     * @param objectType - object type object
     * @return - object type id
     */
    public long create(TTObjectType objectType) {
        DBWorkerImpl dbWorker = new DBWorkerImpl();
        long id = dbWorker.getId();
        objectType.setObjectTypeId(id);
        log.info("Create object type "+objectType.toString());
        manager.persist(objectType);
        return id;
    }

    /**
     * Update object type
     * @param objectType - object type object
     */
    public void update(TTObjectType objectType) {
        log.info("Update object type "+objectType.toString());
        manager.merge(objectType);
    }

    /**
     * Delete object type by id
     * @param id - object id
     */
    public void delete(long id) {
        TTObjectType objectType = manager.find(TTObjectType.class, id);
        log.info("Remove object type "+objectType.toString());
        manager.remove(objectType);
    }
}
