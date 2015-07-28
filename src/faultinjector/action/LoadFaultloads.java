package faultinjector.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import faultinjector.entity.Fault;
import faultinjector.entity.Faultload;
import faultinjector.entity.InjectionRun;
import faultinjector.service.EclipseLinkPersistence;

public class LoadFaultloads extends ActionSupport implements SessionAware
{
	private static final long serialVersionUID = 4L;

	private Map<String, Object> session;
	private List<Faultload> faultloads;
	private List<InjectionRun> injectionRuns;
	private List<Fault> faults;

	@Override
	public String execute()
	{
		this.faultloads = this.getExperimentService().findAllFaultloads();

		System.out.println("LOAD FAULTLOADS-------------------------------");

		for (Faultload fl : this.faultloads)
		{
			System.out.println();
			System.out.println("Faultload ID = " + fl.getFaultloadId());
			System.out.println("Faultload NAME = " + fl.getName());
			System.out.println("Faultload CREATION DATE = " + fl.getCreationDate());
			System.out.println("Faultload DESCRIPTION = " + fl.getDescription());
			System.out.println("Faultload MEMORY RANGE BEGINNING = " + fl.getMemoryRangeBeginning());
			System.out.println("Faultload MEMORY RANGE END = " + fl.getMemoryRangeEnd());
			System.out.println("Faultload NUMBER OF FAULTS = " + fl.getNumberFaults());
			System.out.println("Faultload TIME INTERVAL = " + fl.getTimeInterval());

			injectionRuns = fl.getInjectionRuns();

			for (InjectionRun i : injectionRuns)
				System.out.println("Faultload OUTPUT FILENAME = " + i.getOutputFilename());

			faults = fl.getFaults();

			for (Fault f : faults)
				System.out.println("Faultload FAULT ID = " + f.getFaultId());

			if (fl.getExperiment() != null)
				System.out.println("Faultload EXPERIMENT NAME = " + fl.getExperiment().getName());

			System.out.println();
		}

		return SUCCESS;
	}

	public EclipseLinkPersistence getExperimentService()
	{
		if (!session.containsKey("experimentService"))
		{
			EclipseLinkPersistence experimentService = new EclipseLinkPersistence();

			this.setExperimentService(experimentService);
		}

		return (EclipseLinkPersistence) session.get("experimentService");
	}

	public void setExperimentService(EclipseLinkPersistence experimentService)
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
