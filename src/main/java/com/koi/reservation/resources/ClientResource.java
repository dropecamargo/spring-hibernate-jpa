/**
 * 
 */
package com.koi.reservation.resources;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.koi.reservation.model.Client;
import com.koi.reservation.resources.vo.ClientVO;
import com.koi.reservation.services.ClientService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Service web Client
 * 
 * @author @dropecamargo
 *
 */
@RestController
@RequestMapping("/api/client")
@Api(tags = "client")
public class ClientResource {

	private final ClientService clientService;

	public ClientResource(ClientService clientService) {
		this.clientService = clientService;
	}

	@PostMapping
	@ApiOperation(value = "Crear cliente", notes = "Servicio para crear un nuevo cliente")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Cliente creado correctamente"),
			@ApiResponse(code = 400, message = "Solicitud invalida") })
	public ResponseEntity<Client> createClient(@RequestBody ClientVO clientVo) {
		Client client = new Client();
		client.setNameClient(clientVo.getNameClient());
		client.setLastnameClient(clientVo.getLastnameClient());
		client.setEmailClient(clientVo.getEmailClient());
		client.setMovilClient(clientVo.getMovilClient());
		client.setIdentificationClient(clientVo.getIdentificationClient());

		return new ResponseEntity<>(this.clientService.create(client), HttpStatus.CREATED);
	}

	@PutMapping("/{identification}")
	@ApiOperation(value = "Actualizar cliente", notes = "Servicio para actualizar un cliente")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Cliente actualizado correctamente"),
			@ApiResponse(code = 404, message = "Cliente no encontrado") })
	public ResponseEntity<Client> updateClient(@PathVariable("identification") String identificationClient,
			@RequestBody ClientVO clientVo) {
		Client client = this.clientService.findByIdentification(identificationClient);
		if (client == null) {
			return new ResponseEntity<Client>(HttpStatus.NOT_FOUND);
		}

		client.setNameClient(clientVo.getNameClient());
		client.setLastnameClient(clientVo.getLastnameClient());
		client.setEmailClient(clientVo.getEmailClient());
		client.setMovilClient(clientVo.getMovilClient());
		client.setIdentificationClient(clientVo.getIdentificationClient());

		return new ResponseEntity<>(this.clientService.update(client), HttpStatus.OK);
	}

	@DeleteMapping("/{identification}")
	@ApiOperation(value = "Eliminar cliente", notes = "Servicio para eliminar un cliente")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Cliente eliminado correctamente"),
			@ApiResponse(code = 404, message = "Cliente no encontrado") })
	public void removeClient(@PathVariable("identification") String identificationClient) {
		Client client = this.clientService.findByIdentification(identificationClient);
		if (client != null) {
			this.clientService.delete(client);
		}
	}

	@GetMapping
	@ApiOperation(value = "Listar clientes", notes = "Servicio para listar todos los clientes")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Clientes encontrados"),
			@ApiResponse(code = 404, message = "Cliente no encontrados") })
	public ResponseEntity<List<Client>> findAll() {
		return ResponseEntity.ok(this.clientService.findAll());
	}
}
