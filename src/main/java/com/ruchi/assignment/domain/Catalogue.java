package com.ruchi.assignment.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Catalogue {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer SKU_id;
	private String SKU_name;
	private String SKU_dis;
	private String brand_name;
	private String brand_dis;
	private Integer sup_id;

	public Catalogue() {

	}

	public Catalogue(Integer sKU_id, String sKU_name, String sKU_dis, String brand_name, String brand_dis,
			Integer sup_id) {
		SKU_id = sKU_id;
		SKU_name = sKU_name;
		SKU_dis = sKU_dis;
		this.brand_name = brand_name;
		this.brand_dis = brand_dis;
		this.sup_id = sup_id;
	}

	public Integer getSKU_id() {
		return SKU_id;
	}

	public void setSKU_id(Integer sKU_id) {
		SKU_id = sKU_id;
	}

	public String getSKU_name() {
		return SKU_name;
	}

	public void setSKU_name(String sKU_name) {
		SKU_name = sKU_name;
	}

	public String getSKU_dis() {
		return SKU_dis;
	}

	public void setSKU_dis(String sKU_dis) {
		SKU_dis = sKU_dis;
	}

	public String getBrand_name() {
		return brand_name;
	}

	public void setBrand_name(String brand_name) {
		this.brand_name = brand_name;
	}

	public String getBrand_dis() {
		return brand_dis;
	}

	public void setBrand_dis(String brand_dis) {
		this.brand_dis = brand_dis;
	}

	public Integer getSup_id() {
		return sup_id;
	}

	public void setSup_id(Integer sup_id) {
		this.sup_id = sup_id;
	}

}
