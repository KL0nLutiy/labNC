package com.nc.j2ee.interfaces;

import com.nc.j2ee.OrderInfo;

import javax.ejb.Local;
import java.util.List;
import java.util.Map;

/**
 * Created by Vlad on 13.07.2016.
 */
@Local
public interface DBWorkerInterface {

    /**
     * Get database generated value from sequence
     * @return id from database sequence
     */
    Long getId();

    /**
     * Get attribute access type for attribute id
     * @param attrId - attribute id
     * @return attribute acces type
     */
    Long getAttrAccessType(long attrId);

    /**
     * Get attribute id for value
     * @param value - value
     * @return attribute id
     */
    Long getAttrIdForValue(String value);

    /**
     * Get password(MD5 hash) for username
     * @param username - username
     * @return password(MD5 hash)
     */
    String getPasswordForUsername(String username);

    /**
     * Check if user is admin
     * @param username - username
     * @return true if admin and false if not admin
     */
    boolean isAdmin(String username);

    /**
     * Get all item that has database or specific category
     * @param objectTypeId - object type id (0 - all items, 3 - phones, 4 - headphones, 5 - usb cable, 6 - charger, 7 - battery, 8 - screen/sensor)
     * @return map<object id, map<attribute name, value>
     */
    Map<Long,Map<String, String>> getGoods(long objectTypeId);

    /**
     * Get admin by object id
     * @param objectId - object id
     * @return admin name
     */
    String getAdminById(long objectId);

    /**
     * Get first and last name of the user
     * @param username - username
     * @return first and last name
     */
    String getUsersName(String username);

    /**
     * Get object id for value
     * @param value - value
     * @return object id
     */
    Long getObjectIdForValue(String value);

    /**
     * Get all orders for user
     * @param username - username
     * @return List<order information>
     */
    List<OrderInfo> getOrderInfoForUser(String username);

    /**
     * Get version for object id
     * @param objectId - object id
     * @return version of the object
     */
    Long getVersionForObject(Long objectId);

    /**
     * Get object type id object id
     * @param objectId - object id
     * @return object type id of the object
     */
    Long getObjectTypeIdForObject(Long objectId);

    /**
     * Get attribute id for name
     * @param name - attribute name
     * @return attribute id
     */
    Long getAttrIdForName(String name);

    /**
     * Get attribute for goodsType(category)
     * @param goodsType - item category(0 - all items, 3 - phones, 4 - headphones, 5 - usb cable, 6 - charger, 7 - battery, 8 - screen/sensor)
     * @return List<attribute name>
     */
    List<String> getAttrsForGoods(Long goodsType);
}
