package faultinjector.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import faultinjector.entity.Fault;
import faultinjector.entity.Faultload;
import faultinjector.entity.Injection_Run;
import faultinjector.service.ExperimentService;

public class LoadFaultloadsAction extends ActionSupport implements SessionAware
{
	private static final long serialVersionUID = 4L;

	private Map<String, Object> session;
	private List<Faultload> faultloads;
	private List<Injection_Run> injectionRuns;
	private List<Fault> faults;

	@Override
	public String execute()
	{
		this.faultloads = this.getExperimentService().findAllFaultloads();

		System.out.println("LOAD FAULTLOADS-------------------------------");

		for (Faultload fl : this.faultloads)
		{
			System.out.println("Faultload ID = "+fl.getFl_id());
			System.out.println("Faultload NAME = "+fl.getName());
			System.out.println("Faultload CREATION DATE = "+fl.getCreation_date());
			System.out.println("Faultload DESCRIPTION = "+fl.getDescription());
			System.out.println("Faultload MEMORY RANGE BEGINNING = "+fl.getMem_range_beg());
			System.out.println("Faultload MEMORY RANGE END = "+fl.getMem_range_end());
			System.out.println("Faultload NUMBER OF FAULTS = "+fl.getN_faults());
			System.out.println("Faultload TIME INTERVAL = "+fl.getTime_interval());

			injectionRuns = fl.getInjectionRuns();

			for (Injection_Run i : injectionRuns)
				System.out.println("Faultload OUTPUT FILENAME = "+i.getOutput_filename());

			faults = fl.getFaults();

			for (Fault f : faults)
				System.out.println("Faultload FAULT ID = "+f.getFault_id());

			if (fl.getExperiment()!=null)
				System.out.println("Faultload EXPERIMENT NAME = "+fl.getExperiment().getName());

			System.out.println();
		}

		return SUCCESS;
	}

	public ExperimentService getExperimentService()
	{
		if (!session.containsKey("experimentService"))
		{
			ExperimentService experimentService = new ExperimentService();

			this.setExperimentService(experimentService);
		}

		return (ExperimentService) session.get("experimentService");
	}

	public void setExperimentService(ExperimentService experimentService)
	{
		this.session.put("experimentService", experimentService);
	}

	public List<Faultload> getFaultloads()
	{
		return faultloads;
	}

	@Override
	public void setSession(Map<String, Object> session)
	{
		this.session = session;
	}
}
