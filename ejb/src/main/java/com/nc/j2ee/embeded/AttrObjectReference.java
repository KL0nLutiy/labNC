package com.nc.j2ee.embeded;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Embaddable class with attrId, objectId and references(objectid). Used in TT_REFERENCES
 * Created by Vlad on 27.06.2016.
 */
@Embeddable
@Table(name="TT_REFERENCES")
public class AttrObjectReference implements Serializable {

    @Column(name="ATTR_ID")
    /**Attribute - attribute id*/
    private Long atttId;
    @Column(name="OBJECT_ID")
    /**Attribute - object id*/
    private Long objectId;
    @Column(name="REFERENCE")
    /**Attribute - references(object id)*/
    private Long references;

    /**
     * Empty constructor for AttrObjectReference
     */
    public AttrObjectReference(){

    }

    /**
     * Constructor for AttrObjectReference
     * @param atttId - attribute id
     * @param objectId - object id
     * @param references - references - object id
     */
    public AttrObjectReference(Long atttId, Long objectId, Long references) {
        this.atttId = atttId;
        this.objectId = objectId;
        this.references = references;
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
     *
     * @return references - references(objectId)
     */
    public Long getReferences() {
        return references;
    }

    /**
     * Overrided method toString(), use for logging.
     * @return all object attributes.
     */
    @Override
    public String toString() {
        return "AttrObjectReference{" +
                "atttId=" + atttId +
                ", objectId=" + objectId +
                ", references=" + references +
                '}';
    }
}
