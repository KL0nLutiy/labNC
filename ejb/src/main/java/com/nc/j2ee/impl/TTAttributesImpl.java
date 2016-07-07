package com.nc.j2ee.impl;

import com.nc.j2ee.DBWorker;
import com.nc.j2ee.TTAttributes;
import com.nc.j2ee.interfaces.TTAttributeInterface;
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
@Stateless(name = "TTAttributesLocalSessionEJB")
public class TTAttributesImpl implements TTAttributeInterface {
    /**
     * Logger for logging info and errors
     */
    private static final Logger log = Logger.getLogger(TTAttributesImpl.class);

    /**
     * Entity manager to connect database with parsistance xml
     */
    @PersistenceContext(unitName = "objects")
    private EntityManager manager;

    /**
     * Create attribute
     * @param attributes - attribute object
     * @return attribute id
     */
    public long create(TTAttributes attributes) {
        DBWorker dbWorker = new DBWorker();
        long id = dbWorker.getId();
        attributes.setAttrId(id);
        log.info("Create attribute "+attributes.toString());
        manager.persist(attributes);
        return id;
    }

    /**
     * Update attribute
     * @param attributes - attribute object
     */
    public void update(TTAttributes attributes) {
        log.info("Update attribute "+attributes.toString());
        manager.merge(attributes);
    }

    /**
     * Delete attribute by id
     * @param id - attribute id
     */
    public void delete(long id) {
        TTAttributes attributes = manager.find(TTAttributes.class, id);
        log.info("Delete attribute "+attributes.toString());
        manager.remove(attributes);
    }
}
