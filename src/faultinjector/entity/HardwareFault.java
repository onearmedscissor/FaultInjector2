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

	@Column(name = "Bit_flip")
	private boolean bit_flip;

	@Column(name = "Bit_start")
	private int bitStart;

	@Column(name = "Bit_end")
	private int bitEnd;

	@Column(name = "Hw_fault_type")
	private char hw_fault_type;

	// bi-directional many-to-one association to Fault
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "Fault_id")
	private Fault fault;

	public HardwareFault()
	{
	}

	public boolean getBit_flip()
	{
		return this.bit_flip;
	}

	public void setBit_flip(boolean bit_flip)
	{
		this.bit_flip = bit_flip;
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

	public char getHw_fault_type()
	{
		return hw_fault_type;
	}

	public void setHw_fault_type(char hw_fault_type)
	{
		this.hw_fault_type = hw_fault_type;
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