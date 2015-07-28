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
 * The persistent class for the Hardware_fault_type database table.
 * 
 */
@Entity
@Table(name = "Hardware_fault_type")
@NamedQuery(name = "Hardware_fault_type.findAll", query = "SELECT hft FROM HardwareFaultType hft")
public class HardwareFaultType implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Hardware_fault_type_id")
	private int hardwareFaultTypeId;

	@Column(name = "Name")
	private String name;

	// bi-directional many-to-one association to Hardware
	@OneToMany(mappedBy = "hardwareFaultType")
	private List<HardwareFault> hardwareFaults;

	public int getHardwareFaultTypeId()
	{
		return hardwareFaultTypeId;
	}

	public void setHardwareFaultTypeId(int hardwareFaultTypeId)
	{
		this.hardwareFaultTypeId = hardwareFaultTypeId;
	}

	public String getName()
	{
		return this.name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public List<HardwareFault> getHardwareFaults()
	{
		if (this.hardwareFaults == null)
			this.hardwareFaults = new ArrayList<HardwareFault>();

		return this.hardwareFaults;
	}

	public void setHardwareFaults(List<HardwareFault> hardwareFaults)
	{
		this.hardwareFaults = hardwareFaults;
	}

	public Fault addHardwareFault(HardwareFault hardwareFault)
	{
		getHardwareFaults().add(hardwareFault);
		hardwareFault.setHardwareFaultType(this);

		return hardwareFault;
	}

	public HardwareFault removeHardwareFault(HardwareFault hardwareFault)
	{
		getHardwareFaults().remove(hardwareFault);
		hardwareFault.setHardwareFaultType(null);

		return hardwareFault;
	}
}