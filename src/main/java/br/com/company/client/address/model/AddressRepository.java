package br.com.company.client.address.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends CrudRepository<Address, Long>, JpaSpecificationExecutor<Address>{

	public List<Address> findAllByClientId(Long clientId);
	
	@Modifying
	@Query("delete from Address addr where addr.clientId =?1")
	void deleteByClientId(Long id);
}
