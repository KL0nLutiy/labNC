package com.nc.j2ee;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Class for Entity Beans. Table TT_ATTRIBUTES
 * Created by Vlad on 24.06.2016.
 */
@Entity
@Table(name="TT_ATTRIBUTES")
public class TTAttributes implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="ATTR_ID")
    /**Attribute - attribute id */
    private Long attrId;
    @Column(name="NAME")
    /**Attribute - attribute name */
    private String name;
    @Column(name="ATTR_ACCESS_TYPE")
    /**Attribute - attribute access type */
    private Long attrAccessType;
    @Column(name="ISMULTIPLE")
    /**Attribute - is attribute multiple */
    private Boolean isMultiple;
    @Column(name="ISEXTGENERATED")
    /**Attribute - is attribute external generated */
    private Boolean isExtGenerated;
    @Column(name="ISEXTSTORED")
    /**Attribute - is attribute  external stored */
    private Boolean isExtStored;
    @Column(name="ADAPTERNAME")
    /**Attribute - attribute adapter name */
    private String adapterName;
    @Column(name="PARAMS")
    /**Attribute - attribute  parameter*/
    private String params;
    @Column(name="UNIQUE_LEVEL")
    /**Attribute - attribute unique level */
    private Integer uniqueLevel;
    @Column(name="SHOW_ORDER")
    /**Attribute - attribute order */
    private Long showOrder;
    @Column(name="SHOW_HISTORY")
    /**Attribute - attribute history*/
    private Integer showHistory;
    @Column(name="ISSEARCHABLE")
    /**Attribute - is attribute searchable*/
    private Boolean isSearchable;
    @Column(name="MASK")
    /**Attribute - attribute mask */
    private String mask;
    @Column(name="DEF_VALUE")
    /**Attribute - attribute default value */
    private String defValue;
    @Column(name="FLAGS")
    /**Attribute - attribute flags */
    private Long flags;
    @Column(name="DESCRIPTION")
    /**Attribute - attribute description */
    private String description;
    @Column(name="PROPERTIES")
    /**Attribute - attribute properties */
    private String properties;
    @Column(name="RULES")
    /**Attribute - attribute rules */
    private Long rules;
    @Column(name="TOOLTIP")
    /**Attribute - attribute tooltip */
    private String tooltip;
    @Column(name="AV_ADAPTER_NAME")
    /**Attribute - attribute adapter name */
    private String avAdapterName;
    @Column(name="AV_ADAPTER_PROPERTIES")
    /**Attribute - attribute adapter properties */
    private String avAdapterProperties;
    @Column(name="INTERNAL_NAME")
    /**Attribute - attribute internal name */
    private String internalName;

    /**
     * Empty constructor for TTAttributes object.
     */
    public TTAttributes() {
    }

    /**
     * Constructor for TTAttributes object.
     * @param name - attribute name
     * @param attrAccessType - attribute access type(0 - text, 1 - number, 2 - date)
     */
    public TTAttributes(String name, Long attrAccessType) {
        this.name = name;
        this.attrAccessType = attrAccessType;
    }

    /**
     *
     * @return attrId - attribute id
     */
    public Long getAttrId() {
        return attrId;
    }

    /**
     *
     * @param attrId - set attribute id
     */
    public void setAttrId(Long attrId) {
        this.attrId = attrId;
    }

    /**
     *
     * @return name - attribute name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name - set attribute name
     */
    public void setName(String name) {
        this.name = name;
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
     * @param attrAccessType - set attribute access type (0 - text, 1 - number, 2 - date)
     */
    public void setAttrAccessType(Long attrAccessType) {
        this.attrAccessType = attrAccessType;
    }


    /**
     *
     * @return isMultiple - is attribute multiple
     */
    public Boolean getMultiple() {
        return isMultiple;
    }

    /**
     *
     * @param multiple set if atrribute is multiple
     */
    public void setMultiple(Boolean multiple) {
        isMultiple = multiple;
    }

    /**
     *
     * @return isExtGenerated -  is attribute external generated
     */
    public Boolean getExtGenerated() {
        return isExtGenerated;
    }

    /**
     *
     * @param extGenerated set if attribute eternal generated
     */
    public void setExtGenerated(Boolean extGenerated) {
        isExtGenerated = extGenerated;
    }

    /**
     *
     * @return isExtStored - is attribute external stored
     */
    public Boolean getExtStored() {
        return isExtStored;
    }

    /**
     *
     * @param extStored set if attribute external stored
     */
    public void setExtStored(Boolean extStored) {
        isExtStored = extStored;
    }

    /**
     *
     * @return adapterName - attribute adapter name
     */
    public String getAdapterName() {
        return adapterName;
    }

    /**
     *
     * @param adapterName set attribute adapter name
     */
    public void setAdapterName(String adapterName) {
        this.adapterName = adapterName;
    }

    /**
     *
     * @return params - attribute parameters
     */
    public String getParams() {
        return params;
    }

    /**
     *
     * @param params set attribute parameters
     */
    public void setParams(String params) {
        this.params = params;
    }

    /**
     *
     * @return uniqueLevel - attribute unique level
     */
    public Integer getUniqueLevel() {
        return uniqueLevel;
    }

    /**
     *
     * @param uniqueLevel set attribute unique level
     */
    public void setUniqueLevel(Integer uniqueLevel) {
        this.uniqueLevel = uniqueLevel;
    }

    /**
     *
     * @return showOrder - attribute order
     */
    public Long getShowOrder() {
        return showOrder;
    }

    /**
     *
     * @param showOrder set attribute order
     */
    public void setShowOrder(Long showOrder) {
        this.showOrder = showOrder;
    }

    /**
     *
     * @return showHistory - attribute history
     */
    public Integer getShowHistory() {
        return showHistory;
    }

    /**
     *
     * @param showHistory set attribute history
     */
    public void setShowHistory(Integer showHistory) {
        this.showHistory = showHistory;
    }

    /**
     *
     * @return isSearchable - attribute is searchable
     */
    public Boolean getSearchable() {
        return isSearchable;
    }

    /**
     *
     * @param searchable - set if attribute searchable
     */
    public void setSearchable(Boolean searchable) {
        isSearchable = searchable;
    }

    /**
     *
     * @return mask - attribute mask
     */
    public String getMask() {
        return mask;
    }

    /**
     *
     * @param mask - set attribute mask
     */
    public void setMask(String mask) {
        this.mask = mask;
    }

    /**
     *
     * @return defValue - attribute default value
     */
    public String getDefValue() {
        return defValue;
    }

    /**
     *
     * @param defValue set attribute default value
     */
    public void setDefValue(String defValue) {
        this.defValue = defValue;
    }

    /**
     *
     * @return flags - attribute flags
     */
    public Long getFlags() {
        return flags;
    }

    /**
     *
     * @param flags - set attribute flags
     */
    public void setFlags(Long flags) {
        this.flags = flags;
    }

    /**
     *
     * @return description - attribute description
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description - set attribute description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     * @return properties - attribute properties
     */
    public String getProperties() {
        return properties;
    }

    /**
     *
     * @param properties - set attribute properties
     */
    public void setProperties(String properties) {
        this.properties = properties;
    }

    /**
     *
     * @return rules - attribute rules
     */
    public Long getRules() {
        return rules;
    }

    /**
     *
     * @param rules - set attribute rules
     */
    public void setRules(Long rules) {
        this.rules = rules;
    }

    /**
     *
     * @return tooltip - attribute tooltip
     */
    public String getTooltip() {
        return tooltip;
    }

    /**
     *
     * @param tooltip - set attribute tooltip
     */
    public void setTooltip(String tooltip) {
        this.tooltip = tooltip;
    }

    /**
     *
     * @return avAdapterName - attribute adapter name
     */
    public String getAvAdapterName() {
        return avAdapterName;
    }

    /**
     *
     * @param avAdapterName - set attribute adapter name
     */
    public void setAvAdapterName(String avAdapterName) {
        this.avAdapterName = avAdapterName;
    }

    /**
     *
     * @return avAdapterProperties - attribute adapter properties
     */
    public String getAvAdapterProperties() {
        return avAdapterProperties;
    }

    /**
     *
     * @param avAdapterProperties set attribute adapter properties
     */
    public void setAvAdapterProperties(String avAdapterProperties) {
        this.avAdapterProperties = avAdapterProperties;
    }

    /**
     *
     * @return internalName - attribute internal name
     */
    public String getInternalName() {
        return internalName;
    }

    /**
     *
     * @param internalName - set attribute internal name
     */
    public void setInternalName(String internalName) {
        this.internalName = internalName;
    }

    /**
     * Overrided method toString(), use for logging.
     * @return all object attributes
     */
    @Override
    public String toString() {
        return "com.nc.com.nc.j2ee.TTAttributes{" +
                "attrId=" + attrId +
                ", name='" + name + '\'' +
                ", attrAccessType=" + attrAccessType +
                ", isMultiple=" + isMultiple +
                ", isExtGenerated=" + isExtGenerated +
                ", isExtStored=" + isExtStored +
                ", adapterName='" + adapterName + '\'' +
                ", params='" + params + '\'' +
                ", uniqueLevel=" + uniqueLevel +
                ", showOrder=" + showOrder +
                ", showHistory=" + showHistory +
                ", isSearchable=" + isSearchable +
                ", mask='" + mask + '\'' +
                ", defValue='" + defValue + '\'' +
                ", flags=" + flags +
                ", description='" + description + '\'' +
                ", properties='" + properties + '\'' +
                ", rules=" + rules +
                ", tooltip='" + tooltip + '\'' +
                ", avAdapterName='" + avAdapterName + '\'' +
                ", avAdapterProperties='" + avAdapterProperties + '\'' +
                ", internalName='" + internalName + '\'' +
                '}';
    }
}
