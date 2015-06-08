package faultinjector.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the SoftwareFault database table.
 * 
 */
@Entity
@Table(name = "Software")
@DiscriminatorValue("Software")
@NamedQuery(name = "SoftwareFault.findAll", query = "SELECT s FROM SoftwareFault s")
public class SoftwareFault extends Fault implements Serializable
{
	private static final long serialVersionUID = 1L;

	// bi-directional many-to-one association to Fault
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "Fault_id")
	private Fault fault;

	public SoftwareFault()
	{
	}

	public Fault getFault()
	{
		return this.fault;
	}

	public void setFault(Fault fault)
	{
		this.fault = fault;
	}

}