package com.jumia.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "customer")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer implements Serializable {
	
	private static final long serialVersionUID = 6112682825386155246L;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private  Integer id;
	@Column(name = "name" , length = 50)
	private String name;
	@Column(name = "phone" , length = 50)
	private String phone;
//	@Transient
//	private String country;

}
