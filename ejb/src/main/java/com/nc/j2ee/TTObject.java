package com.nc.j2ee;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Class for Entity Beans. Table TT_OBJECTS
 * Created by Vlad on 24.06.2016.
 */

@Entity
@Table(name="TT_OBJECTS")
public class TTObject implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="OBJECT_ID")
    /**Attribute - object id*/
    private Long objectId;
    @Column(name="PARENT_ID")
    /**Attribute - parent id*/
    private Long parentId;
    @Column(name="OBJECT_TYPE_ID")
    /**Attribute - object type id*/
    private Long objectTypeId;
    @Column(name="OBJECT_CLASS_ID")
    /**Attribute - object class id*/
    private Long objectClassId;
    @Column(name="PROJECT_ID")
    /**Attribute - project id*/
    private Long projectId;
    @Column(name="NAME")
    /**Attribute - object name*/
    private String name;
    @Column(name="DESCRIPTION")
    /**Attribute - object description*/
    private String description;
    @Column(name="ORDER_NUMBER")
    /**Attribute - object order number*/
    private Long orderNumber;
    @Column(name="VERSION")
    /**Attribute - object version*/
    private Long version;

    /**
     *
     * @return objectId - object id
     */
    public Long getObjectId() {
        return objectId;
    }

    /**
     *
     * @param objectId - set object id
     */
    public void setObjectId(Long objectId) {
        this.objectId = objectId;
    }

    /**
     *
     * @return parentId - object parent id
     */
    public Long getParentId() {
        return parentId;
    }

    /**
     *
     * @param parentId - set objetc parent id
     */
    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

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
     * @return objectClassid - object class id
     */
    public Long getObjectClassId() {
        return objectClassId;
    }

    /**
     *
     * @param objectClassId - set object class id
     */
    public void setObjectClassId(Long objectClassId) {
        this.objectClassId = objectClassId;
    }

    /**
     *
     * @return projectId - object project id
     */
    public Long getProjectId() {
        return projectId;
    }

    /**
     *
     * @param projectId - set object project id
     */
    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    /**
     *
     * @return name - object name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name - set object name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return description - object description
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description - set object description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     * @return orderNumber - object order number
     */
    public Long getOrderNumber() {
        return orderNumber;
    }

    /**
     *
     * @param orderNumber - set object order number
     */
    public void setOrderNumber(Long orderNumber) {
        this.orderNumber = orderNumber;
    }

    /**
     *
     * @return version - object version
     */
    public Long getVersion() {
        return version;
    }

    /**
     *
     * @param version - set object version
     */
    public void setVersion(Long version) {
        this.version = version;
    }

    /**
     * Overrided method toString(), use for logging.
     * @return all object attributes.
     */
    @Override
    public String toString() {
        return "com.nc.com.nc.j2ee.TTObject{" +
                "objectId=" + objectId +
                ", parentId=" + parentId +
                ", objectTypeId=" + objectTypeId +
                ", objectClassId=" + objectClassId +
                ", projectId=" + projectId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", orderNumber=" + orderNumber +
                ", version=" + version +
                '}';
    }
}
