/**
 * 
 */
package com.koi.reservation.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

/**
 * Client Class
 * @author @dropecamargo
 *
 */

@Entity
@Table(name="client")
@Data
@NamedQuery(name="Client.findByIdentification", query="Select c from Client c where c.identificationClient = ?1")
public class Client {
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy="uuid2")
	private String idClient;
	private String identificationClient;
	private String nameClient;
	private String lastnameClient;
	private String movilClient;
	private String emailClient;
	
	@OneToMany(mappedBy="client")
	private Set<Reservation> reservations;
}
