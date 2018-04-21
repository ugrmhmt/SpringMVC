package com.springmvc.dao.Base;

import java.util.List;



public interface GenericDAO <E,K> {
    void add(E entity) ;
    void saveOrUpdate(E entity) ;
    void update(E entity) ;
    void remove(E entity);
    E find(K key);
    List<E> getAll() ;
	E find(String query);
	List<E> getAll(String query, List<String> k, List<Object> v);
	List<E> getAll(String query);
}
