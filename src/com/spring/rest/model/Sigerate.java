package com.spring.rest.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;


@Entity
public class Sigerate {
	
	
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int sigerateId;
	
	@Column
	private String sigerateBrand;
	
	public int getSigerateId() {
		return sigerateId;
	}
	public void setSigerateId(int sigerateId) {
		this.sigerateId = sigerateId;
	}
	
	public String getSigerateBrand() {
		return sigerateBrand;
	}
	public void setSigerateBrand(String sigerateBrand) {
		this.sigerateBrand = sigerateBrand;
	}
	
}
