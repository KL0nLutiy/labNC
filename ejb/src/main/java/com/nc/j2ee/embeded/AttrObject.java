package com.nc.j2ee.embeded;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Embaddable class with attrId and objectId. Used in TT_PARAMS
 * Created by Vlad on 27.06.2016.
 */

@Embeddable
@Table(name="TT_PARAMS")
public class AttrObject implements Serializable {
    @Column(name="ATTR_ID")
    /**Attribute - attribute id*/
    private Long atttId;
    @Column(name="OBJECT_ID")
    /**Attribute - object id*/
    private Long objectId;

    /**
     * Empty constructor for AttrObject
     */
    public AttrObject(){

    }

    /**
     * Constructor for AttrObject
     * @param atttId - attribute id
     * @param objectId - object id
     */
    public AttrObject(Long atttId, Long objectId) {
        this.atttId = atttId;
        this.objectId = objectId;
    }

    /**
     *
     * @return attrId - attribute id
     */
    public Long getAtttId() {
        return atttId;
    }

    /**
     *
     * @return objectId - object id
     */
    public Long getObjectId() {
        return objectId;
    }

    /**
     * Overrided method toString(), use for logging.
     * @return all object attributes.
     */
    @Override
    public String toString() {
        return "AttrObject{" +
                "atttId=" + atttId +
                ", objectId=" + objectId +
                '}';
    }
}
