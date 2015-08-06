package faultinjector.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the Fault database table.
 * 
 */
@Entity
@Table(name = "Fault")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "Fault_type")
@NamedQuery(name = "Fault.findAll", query = "SELECT f FROM Fault f")
public class Fault implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Fault_id")
	private int faultId;

	// bi-directional many-to-one association to Fault_mode
	@ManyToOne
	@JoinColumn(name = "Fault_mode_id")
	private FaultMode faultMode;

	// bi-directional many-to-one association to Fault_class
	@ManyToOne
	@JoinColumn(name = "Fault_class_id")
	private FaultClass faultClass;

	@Column(name = "Creation_date")
	private Timestamp creationDate;

	@Column(name = "Fault_type")
	private String faultType;

	@Column(name = "Injected")
	private boolean injected;

	@Column(name = "Injection_date")
	private Timestamp injectionDate;

	@Column(name = "Pid")
	private int processId;

	@Column(name = "Read_address")
	private boolean readAddress;

	@Column(name = "Trigger_type")
	private String triggerType;

	@Column(name = "Time_start")
	private int timeStart;

	@Column(name = "Time_end")
	private int timeEnd;

	@Column(name = "Mem_address")
	private int memoryAddress;

	// bi-directional many-to-one association to Faultload
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "Fl_id")
	private Faultload faultload;

	// bi-directional many-to-one association to HardwareFault
	@OneToMany(mappedBy = "fault", cascade = CascadeType.PERSIST)
	private List<HardwareFault> hardwareFaults;

	// bi-directional many-to-one association to Injection_Run
	@OneToMany(mappedBy = "fault", cascade = CascadeType.PERSIST)
	private List<InjectionRun> injectionRuns;

	// bi-directional many-to-one association to SoftwareFault
	@OneToMany(mappedBy = "fault", cascade = CascadeType.PERSIST)
	private List<SoftwareFault> softwareFaults;

	public Fault()
	{
	}

	public int getFaultId()
	{
		return this.faultId;
	}

	public void setFaultId(int faultId)
	{
		this.faultId = faultId;
	}

	public FaultMode getFaultMode()
	{
		return faultMode;
	}

	public void setFaultMode(FaultMode faultMode)
	{
		this.faultMode = faultMode;
	}

	public FaultClass getFaultClass()
	{
		return faultClass;
	}

	public void setFaultClass(FaultClass faultClass)
	{
		this.faultClass = faultClass;
	}

	public Timestamp getCreationDate()
	{
		return this.creationDate;
	}

	public void setCreationDate(Timestamp creationDate)
	{
		this.creationDate = creationDate;
	}

	public String getFaultType()
	{
		return faultType;
	}

	public void setFaultType(String faultType)
	{
		this.faultType = faultType;
	}

	public boolean getInjected()
	{
		return this.injected;
	}

	public void setInjected(boolean injected)
	{
		this.injected = injected;
	}

	public Timestamp getInjectionDate()
	{
		return this.injectionDate;
	}

	public void setInjectionDate(Timestamp injectionDate)
	{
		this.injectionDate = injectionDate;
	}

	public int getProcessId()
	{
		return this.processId;
	}

	public void setProcessId(int processId)
	{
		this.processId = processId;
	}

	public boolean getReadAddress()
	{
		return this.readAddress;
	}

	public void setReadAddress(boolean readAddress)
	{
		this.readAddress = readAddress;
	}

	public String getTriggerType()
	{
		return this.triggerType;
	}

	public void setTriggerType(String triggerType)
	{
		this.triggerType = triggerType;
	}

	public int getTimeStart()
	{
		return timeStart;
	}

	public void setTimeStart(int timeStart)
	{
		this.timeStart = timeStart;
	}

	public int getTimeEnd()
	{
		return timeEnd;
	}

	public void setTimeEnd(int timeEnd)
	{
		this.timeEnd = timeEnd;
	}

	public int getMemoryAddress()
	{
		return this.memoryAddress;
	}

	public void setMemoryAddress(int memoryAddress)
	{
		this.memoryAddress = memoryAddress;
	}

	public Faultload getFaultload()
	{
		return this.faultload;
	}

	public void setFaultload(Faultload faultload)
	{
		this.faultload = faultload;
	}

	public List<HardwareFault> getHardwareFaults()
	{
		return this.hardwareFaults;
	}

	public void setHardwareFaults(List<HardwareFault> hardwareFaults)
	{
		this.hardwareFaults = hardwareFaults;
	}

	public HardwareFault addHardware(HardwareFault hardware)
	{
		getHardwareFaults().add(hardware);
		hardware.setFault(this);

		return hardware;
	}

	public HardwareFault removeHardware(HardwareFault hardware)
	{
		getHardwareFaults().remove(hardware);
		hardware.setFault(null);

		return hardware;
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
		injectionRun.setFault(this);

		return injectionRun;
	}

	public InjectionRun removeInjectionRun(InjectionRun injectionRun)
	{
		getInjectionRuns().remove(injectionRun);
		injectionRun.setFault(null);

		return injectionRun;
	}

	public List<SoftwareFault> getSoftwareFaults()
	{
		return this.softwareFaults;
	}

	public void setSoftwareFaults(List<SoftwareFault> softwares)
	{
		this.softwareFaults = softwares;
	}

	public SoftwareFault addSoftware(SoftwareFault software)
	{
		getSoftwareFaults().add(software);
		software.setFault(this);

		return software;
	}

	public SoftwareFault removeSoftware(SoftwareFault software)
	{
		getSoftwareFaults().remove(software);
		software.setFault(null);

		return software;
	}
}