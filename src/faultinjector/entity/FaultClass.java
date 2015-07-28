package faultinjector.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the Fault_class database table.
 * 
 */
@Entity
@Table(name = "Fault_class")
@NamedQuery(name = "FaultClass.findAll", query = "SELECT fc FROM FaultClass fc")
public class FaultClass implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Fault_class_id")
	private int faultClassId;

	@Column(name = "Name")
	private String name;

	// bi-directional many-to-one association to Fault
	@OneToMany(mappedBy = "faultClass")
	private List<Fault> faults;

	public int getFaultClassId()
	{
		return faultClassId;
	}

	public void setFaultClassId(int faultClassId)
	{
		this.faultClassId = faultClassId;
	}

	public String getName()
	{
		return this.name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public List<Fault> getFaults()
	{
		if (this.faults == null)
			this.faults = new ArrayList<Fault>();

		return this.faults;
	}

	public void setFaults(List<Fault> faults)
	{
		this.faults = faults;
	}

	public Fault addFault(Fault fault)
	{
		getFaults().add(fault);
		fault.setFaultClass(this);

		return fault;
	}

	public Fault removeFault(Fault fault)
	{
		getFaults().remove(fault);
		fault.setFaultClass(null);

		return fault;
	}
}