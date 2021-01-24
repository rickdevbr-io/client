package br.com.company.client.controller.v1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.company.client.help.HelperClientBuilder;
import br.com.company.client.help.HelperClientDtoBuilder;
import br.com.company.client.model.Client;

@RunWith(SpringRunner.class)
public class TestClientMapper {
	
	@Test
	public void mustEntityToClientDto_Success() {
		
		ClientDto clientDto = HelperClientDtoBuilder.mockToClientDto();
		ClientDto clientDtoReturn = ClientMapper.entityToClientDto(HelperClientBuilder.mockDtoToClient());
		
        assertEquals(clientDto.getId(), clientDtoReturn.getId());
        assertEquals(clientDto.getIdentification(), clientDtoReturn.getIdentification());
        assertEquals(clientDto.getName(), clientDtoReturn.getName());
        assertNotNull(clientDtoReturn.getCreatedDate());
        assertNotNull(clientDtoReturn.getModifiedDate());
     
	}
	
	@Test
	public void mustEntityToClientDto_ifNull() {
		
		assertEquals(new ClientDto(), ClientMapper.entityToClientDto(null));
		
	}
	
	@Test
	public void mustDtotoClient_Success() {
		Client client = HelperClientBuilder.mockDtoToClient();
		Client clientReturn = ClientMapper.dtoToClient(HelperClientDtoBuilder.mockToClientDto());
		
        assertEquals(client.getId(), clientReturn.getId());
        assertEquals(client.getIdentification(), clientReturn.getIdentification());
        assertEquals(client.getName(), clientReturn.getName());
        assertNotNull(clientReturn.getCreatedDate());
        assertNotNull(clientReturn.getModifiedDate());		
	}
	
	@Test
	public void mustDtotoClient_ifNull() {
		
		assertEquals(new Client(), ClientMapper.dtoToClient(null));
		
	}

}
