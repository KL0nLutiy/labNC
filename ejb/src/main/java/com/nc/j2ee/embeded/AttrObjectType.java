package com.nc.j2ee.embeded;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Embaddable class with attrId and objectTypeId. Used in TT_ATTR_OBJECT_TYPES
 * Created by Vlad on 27.06.2016.
 */

@Embeddable
@Table(name="TT_ATTR_OBJECT_TYPES")
public class AttrObjectType implements Serializable {
    @Column(name="ATTR_ID")
    /**Attribute - attribute id*/
    private Long atttId;
    @Column(name="OBJECT_TYPE_ID")
    /**Attribute - object type id*/
    private Long objectTypeId;

    /**
     * Empty constructor for object AttrObjectType
     */
    public AttrObjectType(){
    }

    /**
     * Constructor for object AttrObjectType
     * @param atttId - attribute id
     * @param objectTypeId - object type id
     */
    public AttrObjectType(Long atttId, Long objectTypeId) {
        this.atttId = atttId;
        this.objectTypeId = objectTypeId;
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
     * @return objectTypeId - object type id
     */
    public Long getObjectTypeId() {
        return objectTypeId;
    }

    /**
     * Overrided method toString(), use for logging.
     * @return all object attributes.
     */
    @Override
    public String toString() {
        return "AttrObjectType{" +
                "atttId=" + atttId +
                ", objectTypeId=" + objectTypeId +
                '}';
    }
}
