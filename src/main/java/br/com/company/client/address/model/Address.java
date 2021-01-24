package br.com.company.client.address.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "tb_address_addr")
@SequenceGenerator(name = "sq_address_addr", initialValue = 1, allocationSize = 1)
public class Address {

	@Id
	@GeneratedValue(generator = "sq_address_addr", strategy = GenerationType.SEQUENCE)
	@Column(name = "id_address", nullable = false)
	private Long id;

	@Column(name = "id_client", nullable = false)
	private Long clientId;
	
	@Column(name = "st_street", nullable = false)
	private String street;
	
	@Column(name = "st_complement")
	private String complement;
	
	@Column(name = "st_neighbordhood", nullable = false)
	private String neighbordhood;
	
	@Column(name = "st_city", nullable = false)
	private String city;
	
	@Column(name = "st_state", nullable = false)
	private String state;
	
	@Column(name = "st_country", nullable = false)
	private String country;
	
	@Column(name = "dt_created_date", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;
	
	@Column(name = "dt_modified_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedDate;
	
}
