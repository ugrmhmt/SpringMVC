package com.springmvc.dao.Base;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@SuppressWarnings("unchecked")
@Repository
@Transactional
public abstract class GenericDaoImpl<E, K extends Serializable> 
        implements GenericDAO<E, K> {
    @Autowired
    protected SessionFactory sessionFactory;
    protected Class<? extends E> daoType;
    public GenericDaoImpl() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        daoType = (Class) pt.getActualTypeArguments()[0];
    }
     
    protected Session currentSession() {
        return sessionFactory.getCurrentSession();
    }
     
    @Override
    public void add(E entity) {
        currentSession().save(entity);
    }
     
    @Override
    public void saveOrUpdate(E entity) {
        currentSession().saveOrUpdate(entity);
    }
     
    @Override
    public void update(E entity) {
        currentSession().saveOrUpdate(entity);
    }
     
    @Override
    public void remove(E entity) {
        currentSession().delete(entity);
    }
     
    @Override
    public E find(K key) {
        return (E) currentSession().get(daoType, key);
    }
    
    @Override
    public E find(String query) {
    	return (E) currentSession().createQuery(query);
    }
     
    @Override
    public List<E> getAll() {
        return currentSession().createCriteria(daoType).list();
    }
    
    @Override
    public List<E> getAll(String query, List<String> k, List<Object> v) {
    	Query q = currentSession().createQuery(query);
    	for(int i=0;i<k.size();i++)
    		q.setParameter(k.get(i), v.get(i));
    	List list = ((org.hibernate.query.Query) q).list();
        return list;
        //return currentSession().createQuery(query).list();
    }
    
    @Override
    public List<E> getAll(String query) {
    	Query q = currentSession().createQuery(query);
    	List list = ((org.hibernate.query.Query) q).list();
        return list;
        //return currentSession().createQuery(query).list();
    }
    

}
