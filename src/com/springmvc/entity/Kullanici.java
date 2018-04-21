package com.springmvc.entity;
//import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Kullanici {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="kullanici_id")
	private int id;
	@NotEmpty(message="İsim alanı boş geçilemez.")
	@Size(min=2, max=50, message="İsim alanı 2-50 karakter arasında olmak zorundadır.")
	@Column(name = "adi")
	private String ad;
	@NotEmpty(message="Soyad boş geçilemez.")
	@Size(min=2, max=50, message="Soyad alanı 2-50 karakter arasında olmak zorundadır.")
	@Column(name = "soyadi")
	private String soyad;
	@NotEmpty(message="Email boş geçilemez.")
	@Size(min=4, max=50, message="Email alanı 4-50 karakter arasında olmak zorundadır.")
	@Column(name = "email")
	private String email;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAd() {
		return ad;
	}
	public void setAd(String ad) {
		this.ad = ad;
	}
	public String getSoyad() {
		return soyad;
	}
	public void setSoyad(String soyad) {
		this.soyad = soyad;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
