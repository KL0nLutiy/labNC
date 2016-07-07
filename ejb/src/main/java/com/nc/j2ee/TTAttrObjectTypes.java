package com.nc.j2ee;

import com.nc.j2ee.embeded.AttrObjectType;

import javax.persistence.*;

/**
 * Class for Entity Beans. Table TT_ATTR_OBJECT_TYPES
 * Created by Vlad on 24.06.2016.
 */

@Entity
@Table(name="TT_ATTR_OBJECT_TYPES")
public class TTAttrObjectTypes {

    @EmbeddedId
    /**Attribute - embeded id. Include attrId and objectTypeId*/
    private AttrObjectType attrObjectType;
    @Column(name="ISDISPLAYED")
    /**Attribute - is displayed*/
    private Boolean isDisplayed;
    @Column(name="REQUIRED")
    /**Attribute - is required*/
    private Boolean isRequired;
    @Column(name="OPTIONS")
    /**Attribute - options*/
    private Long options;
    @Column(name="DEFAULT_VALUE")
    /**Attribute - default value*/
    private String defaultValue;
    @Column(name="FLAGS")
    /**Attribute - flags*/
    private Long flags;

    /**
     *
     * @return attrObjectType - attribute object type
     */
    public AttrObjectType getAttrObjectType() {
        return attrObjectType;
    }

    /**
     *
     * @param attrObjectType - set attribute object type
     */
    public void setAttrObjectEmbedded(AttrObjectType attrObjectType) {
        this.attrObjectType = attrObjectType;
    }

    /**
     *
     * @return isDisplayed - displayed
     */
    public Boolean getDisplayed() {
        return isDisplayed;
    }

    /**
     *
     * @param displayed - set displayed
     */
    public void setDisplayed(Boolean displayed) {
        isDisplayed = displayed;
    }

    /**
     *
     * @return isRequired - required
     */
    public Boolean getRequired() {
        return isRequired;
    }

    /**
     *
     * @param required - set required
     */
    public void setRequired(Boolean required) {
        isRequired = required;
    }

    /**
     *
     * @return options - options
     */
    public Long getOptions() {
        return options;
    }

    /**
     *
     * @param options - set options
     */
    public void setOptions(Long options) {
        this.options = options;
    }

    /**
     *
     * @return defaultValue - default value
     */
    public String getDefaultValue() {
        return defaultValue;
    }

    /**
     *
     * @param defaultValue - set default value
     */
    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    /**
     *
     * @return flags - flags
     */
    public Long getFlags() {
        return flags;
    }

    /**
     *
     * @param flags - set flags
     */
    public void setFlags(Long flags) {
        this.flags = flags;
    }

    /**
     * Overrided method toString(), use for logging.
     * @return all object attributes.
     */
    @Override
    public String toString() {
        return "com.nc.com.nc.j2ee.TTAttrObjectTypes{" +
                "attrObjectType=" + attrObjectType +
                ", isDisplayed=" + isDisplayed +
                ", isRequired=" + isRequired +
                ", options=" + options +
                ", defaultValue='" + defaultValue + '\'' +
                ", flags=" + flags +
                '}';
    }
}
