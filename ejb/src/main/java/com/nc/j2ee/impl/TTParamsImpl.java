package com.nc.j2ee.impl;

import com.nc.j2ee.TTParams;
import com.nc.j2ee.embeded.AttrObject;
import com.nc.j2ee.interfaces.TTParamsInterface;
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
@Stateless(name = "TTParamsLocalSessionEJB")
public class TTParamsImpl implements TTParamsInterface {
    /**
     * Logger for logging info and errors
     */
    private static final Logger log = Logger.getLogger(TTParamsImpl.class);

    /**
     * Entity manager to connect database with parsistance xml
     */
    @PersistenceContext(unitName = "objects")
    private EntityManager manager;

    /**
     * Create parameters
     * @param params - params object
     */
    public void create(TTParams params) {
        log.info("Create param "+params.toString());
        manager.persist(params);
    }

    /**
     * Update parameters
     * @param params - params object
     */
    public void update(TTParams params) {
        log.info("Update param "+params.toString());
        manager.merge(params);
    }

    /**
     * Delete parameters by id
     * @param id - embeded id(AttrObject.class)
     */
    public void delete(AttrObject id) {
        TTParams params = manager.find(TTParams.class, id);
        log.info("Delete param "+params.toString());
        manager.remove(params);
    }
}
