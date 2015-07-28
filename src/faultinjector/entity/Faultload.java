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
	private int faultloadId;

	@Column(name = "Creation_date")
	private Timestamp creationDate;

	@Column(name = "Description")
	private String description;

	@Column(name = "Mem_range_beg")
	private int memoryRangeBeginning;

	@Column(name = "Mem_range_end")
	private int memoryRangeEnd;

	@Column(name = "N_faults")
	private int numberFaults;

	@Column(name = "Name")
	private String name;

	@Column(name = "Time_interval")
	private int timeInterval;

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

	// bi-directional many-to-one association to InjectionRun
	@OneToMany(mappedBy = "faultload", cascade = CascadeType.PERSIST)
	private List<InjectionRun> injectionRuns;

	public Faultload()
	{
	}

	public int getFaultloadId()
	{
		return this.faultloadId;
	}

	public void setFaultloadId(int faultloadId)
	{
		this.faultloadId = faultloadId;
	}

	public Timestamp getCreationDate()
	{
		return this.creationDate;
	}

	public void setCreationDate(Timestamp creationDate)
	{
		this.creationDate = creationDate;
	}

	public String getDescription()
	{
		return this.description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public int getMemoryRangeBeginning()
	{
		return this.memoryRangeBeginning;
	}

	public void setMemoryRangeBeginning(int memoryRangeBeginning)
	{
		this.memoryRangeBeginning = memoryRangeBeginning;
	}

	public int getMemoryRangeEnd()
	{
		return this.memoryRangeEnd;
	}

	public void setMemoryRangeEnd(int memoryRangeEnd)
	{
		this.memoryRangeEnd = memoryRangeEnd;
	}

	public int getNumberFaults()
	{
		return this.numberFaults;
	}

	public void setNumberFaults(int numberFaults)
	{
		this.numberFaults = numberFaults;
	}

	public String getName()
	{
		return this.name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public int getTimeInterval()
	{
		return this.timeInterval;
	}

	public void setTimeInterval(int timeInterval)
	{
		this.timeInterval = timeInterval;
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
			if (r.getRegisterId() == id)
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

	public List<InjectionRun> getInjectionRuns()
	{
		if (this.injectionRuns == null)
			this.injectionRuns = new ArrayList<InjectionRun>();

		return this.injectionRuns;
	}

	public void setInjectionRuns(List<InjectionRun> injectionRuns)
	{
		this.injectionRuns = injectionRuns;
	}

	public InjectionRun addInjectionRun(InjectionRun injectionRun)
	{
		getInjectionRuns().add(injectionRun);
		injectionRun.setFaultload(this);

		return injectionRun;
	}

	public InjectionRun removeInjectionRun(InjectionRun injectionRun)
	{
		getInjectionRuns().remove(injectionRun);
		injectionRun.setFaultload(null);

		return injectionRun;
	}
}