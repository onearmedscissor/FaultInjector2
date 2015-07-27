package faultinjector.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the HardwareFault database table.
 * 
 */
@Entity
@Table(name = "Hardware")
@DiscriminatorValue("Hardware")
@NamedQuery(name = "HardwareFault.findAll", query = "SELECT h FROM HardwareFault h")
public class HardwareFault extends Fault implements Serializable
{
	private static final long serialVersionUID = 1L;

	// bi-directional many-to-one association to Fault
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "Fault_id")
	private Fault fault;

	@Column(name = "Bit_start")
	private int bitStart;

	@Column(name = "Bit_end")
	private int bitEnd;

	// bi-directional many-to-one association to Hardware_fault_type
	@ManyToOne
	@JoinColumn(name = "Hardware_fault_type_id")
	private HardwareFaultType hardwareFaultType;

	public HardwareFault()
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

	public int getBitStart()
	{
		return this.bitStart;
	}

	public void setBitStart(int bitStart)
	{
		this.bitStart = bitStart;
	}

	public int getBitEnd()
	{
		return this.bitEnd;
	}

	public void setBitEnd(int bitEnd)
	{
		this.bitEnd = bitEnd;
	}

	public HardwareFaultType getHardwareFaultType()
	{
		return hardwareFaultType;
	}

	public void setHardwareFaultType(HardwareFaultType hardwareFaultType)
	{
		this.hardwareFaultType = hardwareFaultType;
	}
}