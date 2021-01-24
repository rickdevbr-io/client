package br.com.company.client.controller.v1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.company.client.help.HelperClientDtoBuilder;

@RunWith(SpringRunner.class)
public class TestClientDto {
	

	@Test
	public void mustToString() {
		ClientDto clientDto = HelperClientDtoBuilder.mockToClientDto();
		assertEquals("Client(id=1, name=Name, identification=identification, createdDate=Sun Jun 10 23:00:00 BRT 1990, modifiedDate=Thu Dec 10 14:00:00 BRT 2020)",clientDto.toString());
	}		
	

}
