package br.com.company.client.facade;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.company.client.controller.v1.ClientDto;
import br.com.company.client.controller.v1.ClientMapper;
import br.com.company.client.service.ClientService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ClientFacade {

	private final ClientService clientService;
	
	public ClientDto findClientById(Long id) {
		if(Objects.isNull(id))
			this.loadClientList();
		
		return ClientMapper.entityToClientDto(
				clientService.findClientById(id)
				);
	}
	
	public List<ClientDto> loadClientList(){
		return clientService.loadClientList()
				.stream()
				.map(ClientMapper :: entityToClientDto)
				.collect(Collectors.toList());
	}
	
	public ClientDto saveClient(ClientDto client) {
		if(Objects.isNull(client.getCreatedDate()))
				client.setCreatedDate(new Date());
		
		if(!Objects.isNull(client.getId()) && Objects.isNull(client.getModifiedDate()))
			client.setModifiedDate(new Date());
		
		return ClientMapper.entityToClientDto(
				clientService.save(
						ClientMapper.dtoToClient(client)
						)
				);
	}
	
	public void deleteClientBy(Long id) {
		clientService.deleteById(id);
	}
}
