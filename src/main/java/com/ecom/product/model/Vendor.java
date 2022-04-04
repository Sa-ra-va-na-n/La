package com.ecom.product.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="employees")
public class Vendor {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "Vendor_id")
	private long id;
	
	@Column(name="Vendor_Name",length=50)
	private String vendorname;
	@Column(name="Vendor_Rating",length=50)
	private float Rating;
	@Column(name="Vendor_Address",length=50)
	private String address;
	@Column(name="Vendor_ContactNo",length=50)
	private long contact;
	
	
	public Vendor() {
		
	}
	
	@OneToMany(fetch = FetchType.EAGER,mappedBy = "vendor", cascade = CascadeType.ALL,orphanRemoval = true)
    @JsonIgnoreProperties("vendor")
	private Set<Product> products=new HashSet<Product>();
	
	
	public Set<Product>getProducts()
	{
		return products;
	}
	
	public void setProducts(Set<Product> products)
	{
		this.products=products;
	}

	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getVendorname() {
		return vendorname;
	}


	public void setVendorname(String vendorname) {
		this.vendorname = vendorname;
	}


	public float getRating() {
		return Rating;
	}


	public void setRating(float rating) {
		Rating = rating;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public long getContact() {
		return contact;
	}


	public void setContact(long contact) {
		this.contact = contact;
	}
}
