package faultinjector.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the Faultload database table.
 * 
 */
@Entity
@Table(name = "Faultload")
@NamedQuery(name = "Faultload.findAll", query = "SELECT f FROM Faultload f")
public class Faultload implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Fl_id")
	private int fl_id;

	@Column(name = "Creation_date")
	private Timestamp creation_date;

	@Column(name = "Description")
	private String description;

	@Column(name = "Mem_range_beg")
	private int mem_range_beg;

	@Column(name = "Mem_range_end")
	private int mem_range_end;

	@Column(name = "N_faults")
	private int n_faults;

	@Column(name = "Name")
	private String name;

	@Column(name = "Time_interval")
	private int time_interval;

	// bi-directional many-to-many association to Register
	@ManyToMany
	@JoinTable(name = "Rel_faultload_register", joinColumns = { @JoinColumn(name = "Fl_id") }, inverseJoinColumns = { @JoinColumn(name = "Reg_id") })
	private List<Register> registers;

	// bi-directional many-to-one association to Fault
	@OneToMany(mappedBy = "faultload", cascade = CascadeType.PERSIST)
	private List<Fault> faults;

	// bi-directional many-to-one association to Experiment
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "Exp_id")
	private Experiment experiment;

	// bi-directional many-to-one association to Injection_Run
	@OneToMany(mappedBy = "faultload", cascade = CascadeType.PERSIST)
	private List<Injection_Run> injectionRuns;

	public Faultload()
	{
	}

	public int getFl_id()
	{
		return this.fl_id;
	}

	public void setFl_id(int fl_id)
	{
		this.fl_id = fl_id;
	}

	public Timestamp getCreation_date()
	{
		return this.creation_date;
	}

	public void setCreation_date(Timestamp creation_date)
	{
		this.creation_date = creation_date;
	}

	public String getDescription()
	{
		return this.description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public int getMem_range_beg()
	{
		return this.mem_range_beg;
	}

	public void setMem_range_beg(int mem_range_beg)
	{
		this.mem_range_beg = mem_range_beg;
	}

	public int getMem_range_end()
	{
		return this.mem_range_end;
	}

	public void setMem_range_end(int mem_range_end)
	{
		this.mem_range_end = mem_range_end;
	}

	public int getN_faults()
	{
		return this.n_faults;
	}

	public void setN_faults(int n_faults)
	{
		this.n_faults = n_faults;
	}

	public String getName()
	{
		return this.name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getTime_interval()
	{
		return this.time_interval;
	}

	public void setTime_interval(int time_interval)
	{
		this.time_interval = time_interval;
	}

	public List<Register> getRegisters()
	{
		if (this.registers == null)
			this.registers = new ArrayList<Register>();

		return this.registers;
	}

	public void setRegisters(List<Register> registers)
	{
		this.registers = registers;
	}

	public Register addRegister(Register register)
	{
		getRegisters().add(register);
		register.addFaultload(this);

		return register;
	}

	public boolean containsRegisterId(int id)
	{
		for (Register r : registers)
		{
			if (r.getReg_id() == id)
				return true;
		}
		return false;
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
		fault.setFaultload(this);

		return fault;
	}

	public Fault removeFault(Fault fault)
	{
		getFaults().remove(fault);
		fault.setFaultload(null);

		return fault;
	}

	public Experiment getExperiment()
	{
		return this.experiment;
	}

	public void setExperiment(Experiment experiment)
	{
		this.experiment = experiment;
	}

	public List<Injection_Run> getInjectionRuns()
	{
		if (this.injectionRuns == null)
			this.injectionRuns = new ArrayList<Injection_Run>();

		return this.injectionRuns;
	}

	public void setInjectionRuns(List<Injection_Run> injectionRuns)
	{
		this.injectionRuns = injectionRuns;
	}

	public Injection_Run addInjectionRun(Injection_Run injectionRun)
	{
		getInjectionRuns().add(injectionRun);
		injectionRun.setFaultload(this);

		return injectionRun;
	}

	public Injection_Run removeInjectionRun(Injection_Run injectionRun)
	{
		getInjectionRuns().remove(injectionRun);
		injectionRun.setFaultload(null);

		return injectionRun;
	}
}