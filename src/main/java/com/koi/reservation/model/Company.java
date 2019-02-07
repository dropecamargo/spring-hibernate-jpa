/**
 * 
 */
package com.koi.reservation.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

/**
 * Model company
 * @author @dropecamargo
 *
 */

@Entity
@Table(name="company")
@Data
public class Company {
	@Id
	private String idCompany;
	private String nameCompany;
	private String addressCompany;
	@Temporal(TemporalType.DATE)
	private Date dateCompany;
	private Integer ageCompany;
	
	@OneToMany(mappedBy="company")
	private List<Reservation> reservations;
}
