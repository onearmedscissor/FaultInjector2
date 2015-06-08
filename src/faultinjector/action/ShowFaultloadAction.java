package faultinjector.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import faultinjector.entity.Fault;
import faultinjector.entity.Faultload;
import faultinjector.entity.HardwareFault;
import faultinjector.entity.Injection_Run;
import faultinjector.service.ExperimentService;

public class ShowFaultloadAction extends ActionSupport /*
														 * implements
														 * SessionAware
														 */
{
	private static final long serialVersionUID = 4L;

	/* private Map<String, Object> session; */

	private ExperimentService service;
	private Faultload faultload;
	private List<Injection_Run> injectionRuns;
	private List<Fault> faults;
	private List<HardwareFault> hardwares;

	private int id;

	@Override
	public String execute()
	{
		System.out.println("Olá!");
		service = new ExperimentService();

		this.faultload = service.findFaultload(id);

		System.out.println("SHOW FAULTLOAD-------------------------------");
		System.out.println("Faultload ID = " + faultload.getFl_id());
		System.out.println("Faultload NAME = " + faultload.getName());
		System.out.println("Faultload CREATION DATE = " + faultload.getCreation_date());
		System.out.println("Faultload MEMORY RANGE BEGINNING = " + faultload.getMem_range_beg());
		System.out.println("Faultload MEMORY RANGE END = " + faultload.getMem_range_end());
		System.out.println("Faultload NUMBER OF FAULTS = " + faultload.getN_faults());
		System.out.println("Faultload MEMORY TIME INTERVAL = " + faultload.getTime_interval());
		System.out.println("Faultload DESCRIPTION = " + faultload.getDescription());

		System.out.println("Faultload EXPERIMENT NAME = " + faultload.getExperiment().getName());

		injectionRuns = faultload.getInjectionRuns();

		for (Injection_Run i : injectionRuns)
		{
			System.out.println("Faultoad WORKLOAD NAME = " + i.getWorkload().getName());
			System.out.println("Faultload OUTPUT FILENAME = " + i.getOutput_filename());
		}

		faults = faultload.getFaults();

		for (Fault f : faults)
		{
			System.out.println("Faultoad FAULT ID = " + f.getFault_id());
			System.out.println("Faultload FAULT TYPE = " + f.getFault_type());
		}

		hardwares = faults.get(0).getHardwares();

		return SUCCESS;
	}

	/*
	 * @Override public void setSession(Map<String, Object> session) {
	 * this.session = session; }
	 */

	public void setId(int id)
	{
		this.id = id;
	}

	public Faultload getFaultload()
	{
		return faultload;
	}

	public List<Fault> getFaults()
	{
		return faults;
	}

	public List<HardwareFault> getHardwares()
	{
		return hardwares;
	}
}
