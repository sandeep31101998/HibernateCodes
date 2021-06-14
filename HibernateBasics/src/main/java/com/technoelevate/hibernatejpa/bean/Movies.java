package com.technoelevate.hibernatejpa.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
public class Movies implements Serializable {
	
	@Id
	@Column
	private int id;
	
	@Column
	private String name;

	@Column
	private String hero;

	@Column
	private double rating;

}
