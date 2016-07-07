package com.nc.j2ee;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Class for Entity Beans. Table TT_OBJECT_TYPES
 * Created by Vlad on 24.06.2016.
 */
@Entity
@Table(name="TT_OBJECT_TYPES")
public class TTObjectType implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="OBJECT_TYPE_ID")
    /**Attribute - object type id*/
    private Long objectTypeId;
    @Column(name="PARENT_ID")
    /**Attribute - object type parent id*/
    private Long parentId;
    @Column(name="NAME")
    /**Attribute - object type name*/
    private String name;
    @Column(name="DESCRIPTION")
    /**Attribute -  object type description*/
    private String description;
    @Column(name="ISCLASS")
    /**Attribute - object type is class*/
    private Boolean isClass;
    @Column(name="ISSYSTEM")
    /**Attribute - object type is system*/
    private Boolean isSystem;
    @Column(name="ISSEARCHABLE")
    /**Attribute - object type is searchable*/
    private Boolean isSearchable;
    @Column(name="ALIAS")
    /**Attribute - object type alias*/
    private String alias;
    @Column(name="FLAGS")
    /**Attribute - object type flags*/
    private Long flags;
    @Column(name="PROPERTIES")
    /**Attribute - object type properties*/
    private String properties;
    @Column(name="ISABSTRACT")
    /**Attribute - object type is abstract*/
    private Boolean isAbstract;
    @Column(name="INTERNAL_NAME")
    /**Attribute - object type internal name*/
    private String internalName;

    /**
     *
     * @return objectTypeId - object type id
     */
    public Long getObjectTypeId() {
        return objectTypeId;
    }

    /**
     *
     * @param objectTypeId - set object type id
     */
    public void setObjectTypeId(Long objectTypeId) {
        this.objectTypeId = objectTypeId;
    }

    /**
     *
     * @return parentId - object type parent id
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     *
     * @param parentId - set object type parent id
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    /**
     *
     * @return name - object type name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name - set object type name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return description - object type description
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description - set object type description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     * @return isClass - object type is class
     */
    public Boolean isClass() {
        return isClass;
    }

    /**
     *
     * @param isClass - set object type if is class
     */
    public void setClass(Boolean isClass) {
        this.isClass = isClass;
    }

    /**
     *
     * @return isSystem - object type is system
     */
    public Boolean isSystem() {
        return isSystem;
    }

    /**
     *
     * @param isSystem - set object type if is system
     */
    public void setSystem(Boolean isSystem) {
        this.isSystem = isSystem;
    }

    /**
     *
     * @return isSearchable - object type is searchable
     */
    public Boolean getSearchable() {
        return isSearchable;
    }

    /**
     *
     * @param searchable - set object type if is searchable
     */
    public void setSearchable(Boolean searchable) {
        isSearchable = searchable;
    }

    /**
     *
     * @return alias - object type alias
     */
    public String getAlias() {
        return alias;
    }

    /**
     *
     * @param alias - set object type alias
     */
    public void setAlias(String alias) {
        this.alias = alias;
    }

    /**
     *
     * @return flags - object type flags
     */
    public Long getFlags() {
        return flags;
    }

    /**
     *
     * @param flags - set object type flags
     */
    public void setFlags(Long flags) {
        this.flags = flags;
    }

    /**
     *
     * @return properties - object type properties
     */
    public String getProperties() {
        return properties;
    }

    /**
     *
     * @param properties -set object type properties
     */
    public void setProperties(String properties) {
        this.properties = properties;
    }

    /**
     *
     * @return isAbstract - object type is abstract
     */
    public Boolean IsAbstract() {
        return isAbstract;
    }

    /**
     *
     * @param isAbstract - set object type if is abstract
     */
    public void setAbstract(Boolean isAbstract) {
        this.isAbstract = isAbstract;
    }

    /**
     *
     * @return internalName - object type internalName
     */
    public String getInternalName() {
        return internalName;
    }

    /**
     *
     * @param internalName - set object type internal name
     */
    public void setInternalName(String internalName) {
        this.internalName = internalName;
    }

    /**
     * Overrided method toString(), use for logging.
     * @return all object attributes.
     */
    @Override
    public String toString() {
        return "com.nc.com.nc.j2ee.TTObjectType{" +
                "objectTypeId=" + objectTypeId +
                ", parentId=" + parentId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", isClass=" + isClass +
                ", isSystem=" + isSystem +
                ", isSearchable=" + isSearchable +
                ", alias='" + alias + '\'' +
                ", flags=" + flags +
                ", properties='" + properties + '\'' +
                ", isAbstract=" + isAbstract +
                ", internalName='" + internalName + '\'' +
                '}';
    }
}
