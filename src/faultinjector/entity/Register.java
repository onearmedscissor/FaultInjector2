package faultinjector.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the Register database table.
 * 
 */
@Entity
@Table(name = "Register")
@NamedQuery(name = "Register.findAll", query = "SELECT r FROM Register r")
public class Register implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Reg_id")
	private int registerId;

	@Column(name = "Name")
	private String name;

	// bi-directional many-to-many association to Faultload
	@ManyToMany(mappedBy = "registers")
	private List<Faultload> faultloads;

	public Register()
	{
	}

	public int getRegisterId()
	{
		return this.registerId;
	}

	public void setRegisterId(int registerId)
	{
		this.registerId = registerId;
	}

	public String getName()
	{
		return this.name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public List<Faultload> getFaultloads()
	{
		return this.faultloads;
	}

	public void setFaultloads(List<Faultload> faultloads)
	{
		this.faultloads = faultloads;
	}

	public Faultload addFaultload(Faultload faultload)
	{
		getFaultloads().add(faultload);
		faultload.addRegister(this);

		return faultload;
	}

}