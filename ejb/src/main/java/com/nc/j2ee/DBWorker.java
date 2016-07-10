package com.nc.j2ee;

import org.apache.log4j.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.util.*;

/**
 * Class for select statement implementation
 * Created by Vlad on 04.07.2016.
 */

public class DBWorker {
    /**
     * Entity manager to connect database with parsistance xml
     */
    public EntityManager em = Persistence.createEntityManagerFactory("objects").createEntityManager();

    /**
     * Logger for logging info and errors
     */
    private static final Logger log = Logger.getLogger(DBWorker.class);

    /**
     * Get database generated value from sequence
     * @return id from database sequence
     */
    public Long getId() {
        try {
            String sequenceId = "SELECT id_seq.nextval FROM DUAL";
            Query query = em.createNativeQuery(sequenceId);
            return ((BigDecimal) query.getSingleResult()).longValue();
        } catch(NoResultException e) {
            return null;
        } catch (Exception e) {
            log.error("DataBase driver problem: "+e.getMessage());
            return null;
        }
    }

    /**
     * Get attribute access type for attribute id
     * @param attrId - attribute id
     * @return attribute acces type
     */
    public Long getAttrAccessType(long attrId) {
        try {
        String attrAccessTypeSelect = "SELECT ATTR_ACCESS_TYPE FROM TT_ATTRIBUTES WHERE ATTR_ID = ?";
        Query query = em.createNativeQuery(attrAccessTypeSelect);
        query.setParameter(1,attrId);
        return  ((BigDecimal) query.getSingleResult()).longValue();
        } catch(NoResultException e) {
            return null;
        } catch (Exception e) {
            log.error("DataBase driver problem: "+e.getMessage());
            return null;
        }
    }

    /**
     * Get attribute id for value
     * @param value - value
     * @return attribute id
     */
    public Long getAttrIdForValue(String value){
        try {
        String attrIdSelect = "SELECT ATTR_ID FROM TT_PARAMS WHERE VALUE = ?";
        Query query = em.createNativeQuery(attrIdSelect);
        query.setParameter(1,value);
        return  ((BigDecimal) query.getSingleResult()).longValue();
        } catch(NoResultException e) {
            return null;
        } catch (Exception e) {
            log.error("DataBase driver problem: "+e.getMessage());
            return null;
        }
    }

    /**
     * Get password(MD5 hash) for username
     * @param username - username
     * @return password(MD5 hash)
     */
    public String getPasswordForUsername(String username){
        try {
        String passwordSelect = "SELECT VALUE FROM TT_PARAMS WHERE OBJECT_ID = (SELECT OBJECT_ID FROM TT_PARAMS WHERE VALUE = ?) AND ATTR_ID = 3";
        Query query = em.createNativeQuery(passwordSelect);
        query.setParameter(1, username);
        return  query.getSingleResult().toString();
        } catch(NoResultException e) {
            return null;
        } catch (Exception e) {
            log.error("DataBase driver problem: "+e.getMessage());
            return null;
        }
    }

    /**
     * Check if user is admin
     * @param username - username
     * @return true if admin and false if not admin
     */
    public boolean isAdmin(String username) {
        try {
        String adminSelect = "SELECT OBJECT_TYPE_ID FROM TT_OBJECTS INNER JOIN TT_PARAMS ON TT_OBJECTS.OBJECT_ID = TT_PARAMS.OBJECT_ID WHERE VALUE = ?";
        Query query = em.createNativeQuery(adminSelect);
        query.setParameter(1,username);
        return  ((BigDecimal) query.getSingleResult()).longValue() == 1L;
        } catch(NoResultException e) {
            return false;
        } catch (Exception e) {
            log.error("DataBase driver problem: "+e.getMessage());
            return false;
        }
    }

    /**
     * Get all item that has database or specific category
     * @param objectTypeId - object type id (0 - all items, 3 - phones, 4 - headphones, 5 - usb cable, 6 - charger, 7 - battery, 8 - screen/sensor)
     * @return map<object id, map<attribute name, value>
     */
    public Map<Long,Map<String, String>> getGoods(long objectTypeId){
        try {
        String goodsSelect;

        if(objectTypeId==0) {
            goodsSelect =  "SELECT o.OBJECT_ID, a.NAME, CASE WHEN p.VALUE IS NULL THEN TO_CHAR(p.DATE_VALUE) ELSE p.VALUE END, o.NAME " +
                    "FROM TT_OBJECTS o, TT_ATTRIBUTES a, TT_PARAMS p " +
                    "WHERE p.OBJECT_ID = o.OBJECT_ID AND a.ATTR_ID = ANY " +
                    "(SELECT ATTR_ID FROM TT_ATTR_OBJECT_TYPES WHERE OBJECT_TYPE_ID = o.OBJECT_TYPE_ID AND OBJECT_TYPE_ID <> 1 AND OBJECT_TYPE_ID <> 2 AND OBJECT_TYPE_ID <> 9) " +
                    "AND p.ATTR_ID = a.ATTR_ID ORDER BY o.OBJECT_ID";
        } else {
            goodsSelect = "SELECT o.OBJECT_ID, a.NAME, CASE WHEN p.VALUE IS NULL THEN TO_CHAR(p.DATE_VALUE) ELSE p.VALUE END, o.NAME FROM TT_OBJECTS o, TT_ATTRIBUTES a, TT_PARAMS p WHERE o.OBJECT_TYPE_ID = ? " +
                    "AND p.OBJECT_ID = o.OBJECT_ID AND a.ATTR_ID = ANY (SELECT ATTR_ID FROM TT_ATTR_OBJECT_TYPES WHERE OBJECT_TYPE_ID = ?) AND p.ATTR_ID = a.ATTR_ID ORDER BY o.OBJECT_ID";
        }

        Query query = em.createNativeQuery(goodsSelect);

        if(objectTypeId!=0) {
            query.setParameter(1,objectTypeId);
            query.setParameter(2,objectTypeId);
        }

        List<Object[]> results = query.getResultList();

        Map<Long,Map<String, String>> map = new TreeMap<>();
        results.stream().forEach((record) -> {
            Long objectId = ((BigDecimal) record[0]).longValue();

            if(!map.containsKey(objectId)) {
                map.put(objectId,new HashMap<String,String>());
            }

            if(!map.get(objectId).containsKey("name")) {
                map.get(objectId).put("name",(String) record[3]);
            }

            map.get(objectId).put((String) record[1],(String) record[2]);
        });

        return map;
        } catch(NoResultException e) {
            return null;
        } catch (Exception e) {
            log.error("DataBase driver problem: "+e.getMessage());
            return null;
        }
    }

    /**
     * Get admin by object id
     * @param objectId - object id
     * @return admin name
     */
    public String getAdminById(long objectId){
        try {
        String adminSelect = "SELECT NAME FROM TT_OBJECTS WHERE OBJECT_ID = ?";
        Query query = em.createNativeQuery(adminSelect);
        query.setParameter(1, objectId);
        return  query.getSingleResult().toString();
        } catch(NoResultException e) {
            return null;
        } catch (Exception e) {
            log.error("DataBase driver problem: "+e.getMessage());
            return null;
        }
    }

    /**
     * Get first and last name of the user
     * @param username - username
     * @return first and last name
     */
    public String getUsersName(String username){
        try {
        String nameSelect = "SELECT VALUE FROM TT_PARAMS WHERE OBJECT_ID = (SELECT OBJECT_ID FROM TT_PARAMS WHERE VALUE = ?) AND ATTR_ID = ANY(4,5)";
        Query query = em.createNativeQuery(nameSelect);
        query.setParameter(1, username);
        List<String> firstLast = query.getResultList();
        return firstLast.get(0)+" "+firstLast.get(1);
        } catch(NoResultException e) {
            return null;
        } catch (Exception e) {
            log.error("DataBase driver problem: "+e.getMessage());
            return null;
        }
    }

    /**
     * Get object id for value
     * @param value - value
     * @return object id
     */
    public Long getObjectIdForValue(String value) {
        try {
        String objectIdSelect = "SELECT OBJECT_ID FROM TT_PARAMS WHERE VALUE = ?";
        Query query = em.createNativeQuery(objectIdSelect);
        query.setParameter(1, value);
        return  ((BigDecimal) query.getSingleResult()).longValue();
        } catch(NoResultException e) {
            return null;
        } catch (Exception e) {
            log.error("DataBase driver problem: "+e.getMessage());
            return null;
        }
    }

    /**
     * Get all orders for user
     * @param username - username
     * @return List<order information>
     */
    public List<OrderInfo> getOrderInfoForUser(String username){
        try {
        String orderInfoSelect = "SELECT i.VALUE, ii.NAME, iii.VALUE, o.VALUE, TO_CHAR(oo.DATE_VALUE)\n" +
                "\tFROM TT_OBJECTS ob\n" +
                "\tJOIN TT_REFERENCES ref ON ob.OBJECT_ID = ref.OBJECT_ID\n" +
                "  JOIN TT_REFERENCES ref2 ON ref.REFERENCE = ref2.REFERENCE\n" +
                "\tJOIN TT_PARAMS i ON ref2.OBJECT_ID = i.OBJECT_ID\n" +
                "\tJOIN TT_OBJECTS ii ON ref2.OBJECT_ID = ii.OBJECT_ID\n" +
                "\tJOIN TT_PARAMS iii ON ref2.OBJECT_ID = iii.OBJECT_ID\n" +
                "\tJOIN TT_PARAMS o ON ref.REFERENCE = o.OBJECT_ID\n" +
                "\tJOIN TT_PARAMS oo ON ref.REFERENCE = oo.OBJECT_ID\n" +
                "\tJOIN TT_ATTRIBUTES attr1 ON i.ATTR_ID = attr1.ATTR_ID\n" +
                "\tJOIN TT_ATTRIBUTES attr2 ON iii.ATTR_ID = attr2.ATTR_ID\n" +
                "\tJOIN TT_ATTRIBUTES attr3 ON o.ATTR_ID = attr3.ATTR_ID\n" +
                "\tJOIN TT_ATTRIBUTES attr4 ON oo.ATTR_ID = attr4.ATTR_ID\n" +
                "\tWHERE ob.OBJECT_ID = (SELECT OBJECT_ID FROM TT_OBJECTS WHERE NAME = ?) AND\n" +
                "\t(attr1.NAME = 'phone_id' OR attr1.NAME = 'accsesories_id' OR attr1.NAME = 'component_id') AND attr2.NAME = 'price' AND attr3.NAME = 'order_id' AND attr4.NAME = 'create_date'";
        Query query = em.createNativeQuery(orderInfoSelect);
        query.setParameter(1,username);

        List<Object[]> result = query.getResultList();

        List<OrderInfo> orderList = new ArrayList<>();

        result.stream().forEach((record) -> {
            orderList.add(new OrderInfo((String) record[0], (String)record[1],(String) record[2], (String)record[3], (String)record[4]));
        });

        return orderList;
        } catch(NoResultException e) {
            return null;
        } catch (Exception e) {
            log.error("DataBase driver problem: "+e.getMessage());
            return null;
        }
    }

    /**
     * Get version for object id
     * @param objectId - object id
     * @return version of the object
     */
    public Long getVersionForObject(Long objectId){
        try {
        String versionSelect = "SELECT VERSION FROM TT_OBJECTS WHERE OBJECT_ID = ?";
        Query query = em.createNativeQuery(versionSelect);
        query.setParameter(1,objectId);
        return  ((BigDecimal) query.getSingleResult()).longValue();
        } catch(NoResultException e) {
            return null;
        } catch (Exception e) {
            log.error("DataBase driver problem: "+e.getMessage());
            return null;
        }
    }

    /**
     * Get object type id object id
     * @param objectId - object id
     * @return object type id of the object
     */
    public Long getObjectTypeIdForObject(Long objectId){
        try {
        String objectTypeIdSelect = "SELECT OBJECT_TYPE_ID FROM TT_OBJECTS WHERE OBJECT_ID = ?";
        Query query = em.createNativeQuery(objectTypeIdSelect);
        query.setParameter(1,objectId);
        return  ((BigDecimal) query.getSingleResult()).longValue();
        } catch(NoResultException e) {
            return null;
        } catch (Exception e) {
            log.error("DataBase driver problem: "+e.getMessage());
            return null;
        }
    }

    /**
     * Get attribute id for name
     * @param name - attribute name
     * @return attribute id
     */
    public Long getAttrIdForName(String name){
        try {
        String attrIdSelect = "SELECT ATTR_ID FROM TT_ATTRIBUTES WHERE NAME = ?";
        Query query = em.createNativeQuery(attrIdSelect);
        query.setParameter(1,name);
        return  ((BigDecimal) query.getSingleResult()).longValue();
        } catch(NoResultException e) {
            return null;
        } catch (Exception e) {
            log.error("DataBase driver problem: "+e.getMessage());
            return null;
        }
    }

    /**
     * Get attribute for goodsType(category)
     * @param goodsType - item category(0 - all items, 3 - phones, 4 - headphones, 5 - usb cable, 6 - charger, 7 - battery, 8 - screen/sensor)
     * @return List<attribute name>
     */
    public List<String> getAttrsForGoods(Long goodsType){
        try {
        String selectAttr = "SELECT a.NAME FROM TT_ATTRIBUTES a JOIN TT_ATTR_OBJECT_TYPES aot ON a.ATTR_ID = aot.ATTR_ID WHERE aot.OBJECT_TYPE_ID = ?";
        Query query = em.createNativeQuery(selectAttr);
        query.setParameter(1,goodsType);
        List<Object> list = query.getResultList();
        List<String> stringList = new ArrayList<>();
            list.stream().forEach((record) -> {
                stringList.add((String)record);
            });
        return stringList;
        } catch(NoResultException e) {
            return null;
        } catch (Exception e) {
            log.error("DataBase driver problem: "+e.getMessage());
            return null;
        }
    }
}
