package faultinjector.entity;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the Injection_Run database table.
 * 
 */
@Entity
@Table(name="Injection_Run")
@NamedQuery(name="Injection_Run.findAll", query="SELECT i FROM Injection_Run i")
public class Injection_Run implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="Injection_id")
	private int injection_id;

	@Column(name="Output_filename")
	private String output_filename;

	//bi-directional many-to-one association to Faultload
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="Fl_id")
	private Faultload faultload;

	//bi-directional many-to-one association to Workload
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="Wl_id")
	private Workload workload;

	//bi-directional many-to-one association to Fault
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="Fault_id")
	private Fault fault;

	public Injection_Run() {
	}

	public int getInjection_id() {
		return this.injection_id;
	}

	public void setInjection_id(int injection_id) {
		this.injection_id = injection_id;
	}

	public String getOutput_filename() {
		return this.output_filename;
	}

	public void setOutput_filename(String output_filename) {
		this.output_filename = output_filename;
	}

	public Faultload getFaultload() {
		return this.faultload;
	}

	public void setFaultload(Faultload faultload) {
		this.faultload = faultload;
	}

	public Workload getWorkload() {
		return this.workload;
	}

	public void setWorkload(Workload workload) {
		this.workload = workload;
	}

	public Fault getFault() {
		return this.fault;
	}

	public void setFault(Fault fault) {
		this.fault = fault;
	}

}