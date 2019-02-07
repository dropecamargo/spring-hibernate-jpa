/**
 * 
 */
package com.koi.reservation.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.koi.reservation.model.Client;
import com.koi.reservation.repository.ClientRepository;

/**
 * Client service
 * 
 * @author @dropecamargo
 *
 */

@Service
@Transactional(readOnly = true)
public class ClientService {
	private final ClientRepository clientRepository;

	public ClientService(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}

	/**
	 * Save client
	 * 
	 * @param client
	 * @return
	 */
	@Transactional
	public Client create(Client client) {
		return this.clientRepository.save(client);
	}

	/**
	 * Update client
	 * 
	 * @param client
	 * @return
	 */
	@Transactional
	public Client update(Client client) {
		return this.clientRepository.save(client);
	}

	/**
	 * Delete client
	 * 
	 * @param client
	 */
	@Transactional
	public void delete(Client client) {
		this.clientRepository.delete(client);
	}

	/**
	 * Find client by identification
	 * 
	 * @param identificationClient
	 * @return
	 */
	public Client findByIdentification(String identificationClient) {
		return this.clientRepository.findByIdentification(identificationClient);
	}
	
	/**
	 * Find all clients
	 * @return
	 */
	public List<Client> findAll(){
		return this.clientRepository.findAll();
	}
}
