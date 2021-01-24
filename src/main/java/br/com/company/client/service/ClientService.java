package br.com.company.client.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.com.company.client.exceptions.NotFoundException;
import br.com.company.client.model.Client;
import br.com.company.client.model.ClientRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ClientService {

	private final ClientRepository clientRepository;
	
	public List<Client> loadClientList(){
		return clientRepository.findAll();
	}
	
	public Client findClientById(Long id) {
		
		return clientRepository.findById(id)
				.orElseThrow(() -> new NotFoundException("Client not found"));			
	}
	
	@Transactional
	public Client save (Client client) {
		return clientRepository.save(client);
	}
	
	@Transactional
	public void deleteById (Long id) {
		clientRepository.deleteById(id);
	}
}
