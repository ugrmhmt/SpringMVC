package com.springmvc.dao;

import org.springframework.stereotype.Repository;

import com.springmvc.dao.Base.GenericDaoImpl;
import com.springmvc.entity.Kullanici;

@Repository
public class KullaniciDAOImp extends GenericDaoImpl<Kullanici, Integer> implements KullaniciDAO {

}
