package faultinjector.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the Application database table.
 * 
 */
@Entity
@Table(name = "Application")
@NamedQuery(name = "Application.findAll", query = "SELECT a FROM Application a")
public class Application implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "App_id")
	private int appId;

	@Column(name = "Name")
	private String name;

	// bi-directional many-to-many association to Faultload
	@ManyToMany(mappedBy = "applications", cascade = CascadeType.PERSIST)
	private List<Workload> workloads;

	public Application()
	{
	}

	public int getAppId()
	{
		return this.appId;
	}

	public void setAppId(int app_id)
	{
		this.appId = app_id;
	}

	public String getName()
	{
		return this.name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public List<Workload> getWorkloads()
	{
		return this.workloads;
	}

	public void setWorkloads(List<Workload> workloads)
	{
		this.workloads = workloads;
	}
}