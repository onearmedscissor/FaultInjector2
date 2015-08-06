package faultinjector.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 * The persistent class for the Injection_Run database table.
 * 
 */
@Entity
@Table(name = "Injection_Run")
@NamedQuery(name = "InjectionRun.findAll", query = "SELECT i FROM InjectionRun i")
public class InjectionRun implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Injection_id")
	private int injectionId;

	@Column(name = "Output_filename")
	private String outputFilename;

	// bi-directional many-to-one association to Faultload
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "Fl_id")
	private Faultload faultload;

	// bi-directional many-to-one association to Workload
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "Wl_id")
	private Workload workload;

	// bi-directional many-to-one association to Fault
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "Fault_id")
	private Fault fault;

	public InjectionRun()
	{
	}

	public int getInjectionId()
	{
		return this.injectionId;
	}

	public void setInjectionId(int injectionId)
	{
		this.injectionId = injectionId;
	}

	public String getOutputFilename()
	{
		return this.outputFilename;
	}

	public void setOutputFilename(String outputFilename)
	{
		this.outputFilename = outputFilename;
	}

	public Faultload getFaultload()
	{
		return this.faultload;
	}

	public void setFaultload(Faultload faultload)
	{
		this.faultload = faultload;
	}

	public Workload getWorkload()
	{
		return this.workload;
	}

	public void setWorkload(Workload workload)
	{
		this.workload = workload;
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