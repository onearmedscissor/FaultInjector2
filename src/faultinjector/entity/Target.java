package faultinjector.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the Target database table.
 * 
 */
@Entity
@Table(name = "Target")
@NamedQuery(name = "Target.findAll", query = "SELECT t FROM Target t")
public class Target implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Target_id")
	private int target_id;

	@Column(name = "32_bit_arch")
	private boolean i386Arch;

	@Column(name = "IP")
	private String ip;

	@Column(name = "Name")
	private String name;

	@Column(name = "Operating_system")
	private String operating_system;

	// bi-directional many-to-one association to Experiment
	@OneToMany(mappedBy = "target", cascade = CascadeType.ALL)
	private List<Experiment> experiments;

	// bi-directional many-to-one association to Workload
	@OneToMany(mappedBy = "target", cascade = CascadeType.PERSIST)
	private List<Workload> workloads;

	public Target()
	{
	}

	public int getTarget_id()
	{
		return this.target_id;
	}

	public void setTarget_id(int target_id)
	{
		this.target_id = target_id;
	}

	public boolean getI386Arch()
	{
		return this.i386Arch;
	}

	public void setI386Arch(boolean i386Arch)
	{
		this.i386Arch = i386Arch;
	}

	public String getIp()
	{
		return this.ip;
	}

	public void setIp(String ip)
	{
		this.ip = ip;
	}

	public String getName()
	{
		return this.name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getOperating_system()
	{
		return this.operating_system;
	}

	public void setOperating_system(String operating_system)
	{
		this.operating_system = operating_system;
	}

	public List<Experiment> getExperiments()
	{
		if (this.experiments == null)
			this.experiments = new ArrayList<Experiment>();

		return this.experiments;
	}

	public void setExperiments(List<Experiment> experiments)
	{
		this.experiments = experiments;
	}

	public Experiment addExperiment(Experiment experiment)
	{
		getExperiments().add(experiment);
		experiment.setTarget(this);

		return experiment;
	}

	public Experiment removeExperiment(Experiment experiment)
	{
		getExperiments().remove(experiment);
		experiment.setTarget(null);

		return experiment;
	}

	public List<Workload> getWorkloads()
	{
		if (this.workloads == null)
			this.workloads = new ArrayList<Workload>();

		return this.workloads;
	}

	public void setWorkloads(List<Workload> workloads)
	{
		this.workloads = workloads;
	}

	public Workload addWorkload(Workload workload)
	{
		getWorkloads().add(workload);
		workload.setTarget(this);

		return workload;
	}

	public Workload removeWorkload(Workload workload)
	{
		getWorkloads().remove(workload);
		workload.setTarget(null);

		return workload;
	}

}