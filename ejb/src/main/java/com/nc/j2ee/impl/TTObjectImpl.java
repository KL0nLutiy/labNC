package com.nc.j2ee.impl;

import com.nc.j2ee.DBWorker;
import com.nc.j2ee.TTObject;
import com.nc.j2ee.interfaces.TTObjectInterface;
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
@Stateless(name = "TTObjectLocalSessionEJB")
public class TTObjectImpl implements TTObjectInterface {
    /**
     * Logger for logging info and errors
     */
    private static final Logger log = Logger.getLogger(TTObjectImpl.class);

    /**
     * Entity manager to connect database with parsistance xml
     */
    @PersistenceContext(unitName = "objects")
    private EntityManager manager;

    /**
     * Create object
     * @param object - object object
     * @return object id
     */
    public long create(TTObject object) {
        DBWorker dbWorker = new DBWorker();
        long id = dbWorker.getId();
        object.setObjectId(id);
        object.setObjectClassId(id);
        object.setVersion(1L);
        log.info("Create object"+object.toString());
        manager.persist(object);
        return id;
    }

    /**
     * Update object
     * @param object - object object
     */
    public void update(TTObject object) {
        object.setObjectClassId(object.getObjectId());
        log.info("Update object"+object.toString());
        manager.merge(object);
    }

    /**
     * Delete object by id
     * @param id - object id
     */
    public void delete(long id) {
        TTObject object = manager.find(TTObject.class, id);
        log.info("Delete object"+object.toString());
        manager.remove(object);
    }
}
