package br.com.company.client.controller.v1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.company.client.address.model.Address;
import br.com.company.client.address.model.AddressRepository;
import br.com.company.client.address.service.AddressService;
import br.com.company.client.facade.ClientFacade;
import br.com.company.client.help.HelperClientBuilder;
import br.com.company.client.model.Client;
import br.com.company.client.model.ClientRepository;
import br.com.company.client.service.ClientService;

@RunWith(SpringRunner.class)
public class TestClientController {
	
	@Mock
	private ClientRepository mockClientRepository = Mockito.mock(ClientRepository.class);
	
	@Mock
	private AddressRepository mockAddressRepository = Mockito.mock(AddressRepository.class);
	
	private ClientService clientService = new ClientService(mockClientRepository);
	
	private AddressService addressService = new AddressService(mockAddressRepository);
	
	private ClientFacade clientFacade = new ClientFacade(clientService,addressService);
	
	private ClientController clientController = new ClientController(clientFacade);
	
	@Test
	public void mustSaveClient_Success() {
		Client mockClient = HelperClientBuilder.mockDtoToClient();
		ClientDto clientDto = new ClientDto();
		
		when(mockClientRepository.findById(anyLong())).thenReturn(Optional.of(mockClient));
		
		ClientDto saveClientReturn = clientController.saveClient(clientDto);
		
        assertEquals(clientDto.getId(), saveClientReturn.getId());
        assertEquals(clientDto.getName(), saveClientReturn.getName());
        assertEquals(clientDto.getIdentification(), saveClientReturn.getIdentification());
        assertNotNull(saveClientReturn.getCreatedDate().getTime());
        assertNotNull(saveClientReturn.getModifiedDate().getTime());
	}
	
	@Test
	public void mustDeleteClient_Success() {
		clientFacade.deleteClientBy(1L);
		mockClientRepository.delete(new Client());
		Mockito.verify(mockClientRepository, Mockito.times(1)).delete(any(Client.class));
		
		mockAddressRepository.delete(new Address());
		Mockito.verify(mockAddressRepository, Mockito.times(1)).delete(any(Address.class));
		
	}
}
