package faultinjector.entity;

import java.io.Serializable;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the Workload database table.
 * 
 */
@Entity
@Table(name="Workload")
@NamedQuery(name="Workload.findAll", query="SELECT w FROM Workload w")
public class Workload implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Wl_id")
	private int wl_id;

	@Column(name="App_1_name")
	private String app_1_name;

	@Column(name="App_2_name")
	private String app_2_name;

	@Column(name="App_3_name")
	private String app_3_name;

	@Column(name="Name")
	private String name;

	//bi-directional many-to-one association to Injection_Run
	@OneToMany(mappedBy="workload", cascade = CascadeType.PERSIST)
	private List<Injection_Run> injectionRuns;

	//bi-directional many-to-one association to Target
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="Target_id")
	private Target target;

	public Workload() {
	}

	public int getWl_id() {
		return this.wl_id;
	}

	public void setWl_id(int wl_id) {
		this.wl_id = wl_id;
	}

	public String getApp_1_name() {
		return this.app_1_name;
	}

	public void setApp_1_name(String app_1_name) {
		this.app_1_name = app_1_name;
	}

	public String getApp_2_name() {
		return this.app_2_name;
	}

	public void setApp_2_name(String app_2_name) {
		this.app_2_name = app_2_name;
	}

	public String getApp_3_name() {
		return this.app_3_name;
	}

	public void setApp_3_name(String app_3_name) {
		this.app_3_name = app_3_name;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Injection_Run> getInjectionRuns()
	{
		if(this.injectionRuns==null)
			this.injectionRuns = new ArrayList<Injection_Run>();
		
		return this.injectionRuns;
	}

	public void setInjectionRuns(List<Injection_Run> injectionRuns) {
		this.injectionRuns = injectionRuns;
	}

	public Injection_Run addInjectionRun(Injection_Run injectionRun) {
		getInjectionRuns().add(injectionRun);
		injectionRun.setWorkload(this);

		return injectionRun;
	}

	public Injection_Run removeInjectionRun(Injection_Run injectionRun) {
		getInjectionRuns().remove(injectionRun);
		injectionRun.setWorkload(null);

		return injectionRun;
	}

	public Target getTarget() {
		return this.target;
	}

	public void setTarget(Target target) {
		this.target = target;
	}

}