package com.nc.j2ee;

import com.nc.j2ee.embeded.AttrObject;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.sql.Date;

/**
 * Class for Entity Beans. Table TT_PARAMS
 * Created by Vlad on 24.06.2016.
 */

@Entity
@Table(name="TT_PARAMS")
public class TTParams {

    @EmbeddedId
    /**Attribute - embeded id. Include attrId and objectId*/
    private AttrObject attrObject;
    @Column(name="ATTR_ACCESS_TYPE")
    /**Attribute - attribute access type*/
    private Long attrAccessType;
    @Column(name="VALUE")
    /**Attribute - value*/
    private String value;
    @Column(name="DATA")
    /**Attribute - data*/
    private String data;
    @Column(name="SHOW_ORDER")
    /**Attribute - order*/
    private Long showOrder;
    @Column(name="DATE_VALUE")
    /**Attribute - date value*/
    private Date dateValue;
    @Column(name="PRIORITY")
    /**Attribute - priority*/
    private Long priority;

    /**Empty constructor for object TParams*/
    public TTParams(){

    }

    /**
     * Constructor for object TTParams
     * @param attrObject - embeded id. Include attrId and objectId
     * @param attrAccessType - attribute access type
     * @param value - value
     */
    public TTParams(AttrObject attrObject, Long attrAccessType, String value) {
        this.attrObject = attrObject;
        this.attrAccessType = attrAccessType;
        this.value = value;
    }

    /**
     * Constructor for object TTParams
     * @param attrObject - embeded id. Include attrId and objectId
     * @param attrAccessType - attribute access type
     * @param dateValue - date value
     */
    public TTParams(AttrObject attrObject, Long attrAccessType, Date dateValue) {
        this.attrObject = attrObject;
        this.attrAccessType = attrAccessType;
        this.dateValue = dateValue;
    }

    /**
     *
     * @return attrObject - attribute object ids
     */
    public AttrObject getAttrObject() {
        return attrObject;
    }

    /**
     *
     * @param attrObject - set attribute object ids
     */
    public void setAttrObject(AttrObject attrObject) {
        this.attrObject = attrObject;
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
     *
     * @return value - value
     */
    public String getValue() {
        return value;
    }

    /**
     *
     * @param value - value
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     *
     * @return data - stored big data
     */
    public String getData() {
        return data;
    }

    /**
     *
     * @param data - set big data
     */
    public void setData(String data) {
        this.data = data;
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
     * @return dateValue - date value
     */
    public Date getDateValue() {
        return dateValue;
    }

    /**
     *
     * @param dateValue - set date value
     */
    public void setDateValue(Date dateValue) {
        this.dateValue = dateValue;
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
     * Overrided method toString(), use for logging.
     * @return all object attributes.
     */
    @Override
    public String toString() {
        return "com.nc.com.nc.j2ee.TTParams{" +
                "attrObject=" + attrObject +
                ", attrAccessType=" + attrAccessType +
                ", value='" + value + '\'' +
                ", data='" + data + '\'' +
                ", showOrder=" + showOrder +
                ", dateValue=" + dateValue +
                ", priority=" + priority +
                '}';
    }
}
