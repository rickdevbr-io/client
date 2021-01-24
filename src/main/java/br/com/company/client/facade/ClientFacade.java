package br.com.company.client.facade;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.company.client.address.service.AddressService;
import br.com.company.client.controller.v1.AddressDto;
import br.com.company.client.controller.v1.AddressMapper;
import br.com.company.client.controller.v1.ClientDto;
import br.com.company.client.controller.v1.ClientMapper;
import br.com.company.client.service.ClientService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ClientFacade {

	private final ClientService clientService;
	private final AddressService addressService;
	
	public ClientDto findClientById(Long id) {
		if(Objects.isNull(id))
			this.loadClientList();
		
		ClientDto clientResult = ClientMapper.entityToClientDto(clientService.findClientById(id));
		clientResult.setAddresss(loadClientAddresList(id));
		return clientResult;
		
	}
	
	public List<ClientDto> loadClientList(){
		List<ClientDto> clientResult = clientService.loadClientList()
				.stream()
				.map(ClientMapper :: entityToClientDto)
				.collect(Collectors.toList());
		
		clientResult.forEach(
				client -> client.setAddresss(
						loadClientAddresList(client.getId())
						)
				);
		
		return clientResult;
	}
	
	public ClientDto saveClient(ClientDto client) {
		ClientDto clientResult = new ClientDto();
		
		if(Objects.isNull(client.getCreatedDate()))
			client.setCreatedDate(new Date());
		
		if(!Objects.isNull(client.getId()) && Objects.isNull(client.getModifiedDate()))
			client.setModifiedDate(new Date());
		
		clientResult =ClientMapper.entityToClientDto(
				clientService.save(
						ClientMapper.dtoToClient(client)
						)
				);
		
		if(!Objects.isNull(client.getAddresss())) {
			if(client.getAddresss().size() > 0) {
				List<AddressDto> addressList = new ArrayList<AddressDto>();
				client.getAddresss().forEach(
						address -> {
							address.setClientId(client.getId());
							addressList.add(saveClientAddress(address));
						}
						);
				
				clientResult.setAddresss(addressList);
			}
		}
		
		return clientResult;
	}
	
	public void deleteClientBy(Long id) {
		addressService.deleteByClientId(id);
		clientService.deleteById(id);
	}
	
	private List<AddressDto> loadClientAddresList(Long clientId){
		return addressService.loadAddressList(clientId)
				.stream()
				.map(AddressMapper :: entityToAddressDto)
				.collect(Collectors.toList());
	}
	
	private AddressDto saveClientAddress(AddressDto address) {
		if(Objects.isNull(address.getCreatedDate()))
			address.setCreatedDate(new Date());
		
		if(!Objects.isNull(address.getId()) && Objects.isNull(address.getModifiedDate()))
			address.setModifiedDate(new Date());
	
		return AddressMapper.entityToAddressDto(
				addressService.save(
						AddressMapper.dtoToAddress(address)
						)
				);
	}
	
}
