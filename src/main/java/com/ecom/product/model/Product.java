package com.ecom.product.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="product")
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "Product_id")
	private long productId;
	
	@Column(name="Model_Name",length=50)
	private String modelname;
	@Column(name="OS",length=50)
	private String os;
	@Column(name="RAM",length=50)
	private String ram;
	@Column(name="Hard_Drive_Size",length=50)
	private String harddrivesize;
	@Column(name="Stock_Available",length=50)
	private String stockavailable;
	
	public Product() {
		
	}
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "Vendor_id",nullable = false)
	@JsonIgnoreProperties("products")
	private Vendor vendor;
	
	public Vendor getVendor() {
		return vendor;
	}
	
	public void setVendor(Vendor vendor)
	{
		this.vendor=vendor;
	}
	


	public long getId() {
		return productId;
	}


	public void setId(long productId) {
		this.productId = productId;
	}


	public String getModelname() {
		return modelname;
	}


	public void setModelname(String modelname) {
		this.modelname = modelname;
	}


	public String getOs() {
		return os;
	}


	public void setOs(String os) {
		this.os = os;
	}


	public String getRam() {
		return ram;
	}


	public void setRam(String ram) {
		this.ram = ram;
	}


	public String getHarddrivesize() {
		return harddrivesize;
	}


	public void setHarddrivesize(String harddrivesize) {
		this.harddrivesize = harddrivesize;
	}


	public String getStockavailable() {
		return stockavailable;
	}


	public void setStockavailable(String stockavailable) {
		this.stockavailable = stockavailable;
	}
	
	
}

