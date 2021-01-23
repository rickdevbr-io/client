package br.com.company.client.controller.v1;

import java.util.List;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.company.client.facade.ClientFacade;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/client/v1")
public class ClientController {

	private final ClientFacade clientFacade;
	
	@GetMapping("/{id}")
	public ClientDto findClientById(@PathVariable("id") Long id) {
		return clientFacade.findClientById(id);
	}
	
	@GetMapping()
	public List<ClientDto> loadClientList(){
		return clientFacade.loadClientList();
	}
	
	@PostMapping("/save")
	public ClientDto saveClient(@RequestBody(required = false) @Validated ClientDto client) {
		return clientFacade.saveClient(client);
	}
	
	@DeleteMapping("/{id}")
	public void deleteClient(@PathVariable("id") Long id) {
		clientFacade.deleteClientBy(id);
	}
	
}
