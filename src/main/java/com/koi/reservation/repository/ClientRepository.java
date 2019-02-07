/**
 * 
 */
package com.koi.reservation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.koi.reservation.model.Client;

/**
 * Client Repository
 * @author @dropecamargo
 *
 */
public interface ClientRepository extends JpaRepository<Client, String> {
	
	/**
	 * Find user by email
	 * @param emailClient
	 * @return
	 */
	public Client findByEmailClient(String emailClient);
	
	/**
	 * Find users by name
	 * @param nameClient
	 * @return
	 */
	public List<Client> findByNameClient(String nameClient);
	
	/**
	 * Find user by identificacion 
	 * @param identificationClient
	 * @return
	 */
	public Client findByIdentification(String identificationClient);
}
