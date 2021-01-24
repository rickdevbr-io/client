package br.com.company.client.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.company.client.help.HelperClientBuilder;

@RunWith(SpringRunner.class)
public class TestClient {

	@Test
	public void mustToString() {
		Client client = HelperClientBuilder.mockDtoToClient();
		assertEquals("Client(id=1, name=Name, identification=identification, createdDate=Sun Jun 10 23:00:00 BRT 1990, modifiedDate=Thu Dec 10 14:00:00 BRT 2020)", client.toString());
	}
}
