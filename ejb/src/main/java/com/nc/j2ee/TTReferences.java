package com.nc.j2ee;

import com.nc.j2ee.embeded.AttrObjectReference;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Class for Entity Beans. Table TT_REFERENCES
 * Created by Vlad on 24.06.2016.
 */

@Entity
@Table(name="TT_REFERENCES")
public class TTReferences {

    @EmbeddedId
    /**Attribute - embeded id. Include attrId, objectId, references(objectId)*/
    private AttrObjectReference attrObjectReference;
    @Column(name="SHOW_ORDER")
    /**Attribute - order*/
    private Long showOrder;
    @Column(name="PRIORITY")
    /**Attribute - priority*/
    private Long priority;
    @Column(name="ATTR_ACCESS_TYPE")
    /**Attribute - attribute access type*/
    private Long attrAccessType;

    /**Empty constructor for object TTReferences*/
    public TTReferences() {

    }

    /**
     * Constructor for object TTReferences
     * @param attrObjectReference - embeded id. Include attrId, objectId, references(objectId)
     * @param attrAccessType - attribute aceess type
     */
    public TTReferences(AttrObjectReference attrObjectReference, Long attrAccessType) {
        this.attrObjectReference = attrObjectReference;
        this.attrAccessType = attrAccessType;
    }

    /**
     *
     * @return attrObjectReference - attribute object reference
     */
    public AttrObjectReference getAttrObjectReference() {
        return attrObjectReference;
    }

    /**
     *
     * @return showOrder - order
     */
    public Long getShowOrder() {
        return showOrder;
    }

    /**
     *
     * @param showOrder - set order
     */
    public void setShowOrder(Long showOrder) {
        this.showOrder = showOrder;
    }

    /**
     *
     * @return priority - priority
     */
    public Long getPriority() {
        return priority;
    }

    /**
     *
     * @param priority - set priority
     */
    public void setPriority(Long priority) {
        this.priority = priority;
    }

    /**
     *
     * @return attrAccessType - attribute access type
     */
    public Long getAttrAccessType() {
        return attrAccessType;
    }

    /**
     *
     * @param attrAccessType - set attribute access type
     */
    public void setAttrAccessType(Long attrAccessType) {
        this.attrAccessType = attrAccessType;
    }

    /**
     * Overrided method toString(), use for logging.
     * @return all object attributes.
     */
    @Override
    public String toString() {
        return "com.nc.com.nc.j2ee.TTReferences{" +
                "attrObjectReference=" + attrObjectReference +
                ", showOrder=" + showOrder +
                ", priority=" + priority +
                ", attrAccessType=" + attrAccessType +
                '}';
    }
}
