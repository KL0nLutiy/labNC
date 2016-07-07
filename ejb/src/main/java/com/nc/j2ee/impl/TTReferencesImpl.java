package com.nc.j2ee.impl;

import com.nc.j2ee.TTReferences;
import com.nc.j2ee.embeded.AttrObjectReference;
import com.nc.j2ee.interfaces.TTReferencesInterface;
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
@Stateless(name = "TTReferencesLocalSessionEJB")
public class TTReferencesImpl implements TTReferencesInterface {
    /**
     * Logger for logging info and errors
     */
    private static final Logger log = Logger.getLogger(TTReferencesImpl.class);

    /**
     * Entity manager to connect database with parsistance xml
     */
    @PersistenceContext(unitName = "objects")
    private EntityManager manager;

    /**
     * Create references
     * @param references - references object
     */
    public void create(TTReferences references) {
        log.info("Create reference "+references.toString());
        manager.persist(references);
    }

    /**
     * Update references
     * @param references - references object
     */
    public void update(TTReferences references) {
        log.info("Update reference "+references.toString());
        manager.merge(references);
    }

    /**
     * Delete references by id
     * @param id - embeded id(AttrObjectReference.class)
     */
    public void delete(AttrObjectReference id) {
        TTReferences references = manager.find(TTReferences.class, id);
        log.info("Delete reference "+references.toString());
        manager.remove(references);
    }
}
