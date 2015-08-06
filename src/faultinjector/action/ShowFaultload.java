package faultinjector.action;

import java.util.List;

import faultinjector.entity.Fault;
import faultinjector.entity.Faultload;
import faultinjector.entity.HardwareFault;
import faultinjector.entity.InjectionRun;
import faultinjector.service.EclipseLinkPersistence;

/**
 * This Action class accesses the database and gets the faultload with the specified ID, making it available to
 * faultload_details.jsp.
 * 
 * @author João Fernandes
 * @see struts.xml
 * @see ApplicationSupport
 * @see Faultload
 * @see Fault
 * @see HardwareFault
 */

public class ShowFaultload extends ApplicationSupport
{
	private static final long serialVersionUID = 4L;

	private EclipseLinkPersistence service;
	private Faultload faultload;
	private List<InjectionRun> injectionRuns;
	private List<Fault> faults;
	private List<HardwareFault> hardwareFaults;

	private int id;

	@Override
	public String execute()
	{
		service = new EclipseLinkPersistence();

		this.faultload = service.findFaultload(id);

		System.out.println("SHOW FAULTLOAD-------------------------------");
		System.out.println("Faultload ID = " + faultload.getFaultloadId());
		System.out.println("Faultload NAME = " + faultload.getName());
		System.out.println("Faultload CREATION DATE = " + faultload.getCreationDate());
		System.out.println("Faultload MEMORY RANGE BEGINNING = " + faultload.getMemoryRangeBeginning());
		System.out.println("Faultload MEMORY RANGE END = " + faultload.getMemoryRangeEnd());
		System.out.println("Faultload NUMBER OF FAULTS = " + faultload.getNumberFaults());
		System.out.println("Faultload MEMORY TIME INTERVAL = " + faultload.getTimeInterval());
		System.out.println("Faultload DESCRIPTION = " + faultload.getDescription());

		if (faultload.getExperiment() != null)
			System.out.println("Faultload EXPERIMENT NAME = " + faultload.getExperiment().getName());

		injectionRuns = faultload.getInjectionRuns();

		for (InjectionRun i : injectionRuns)
		{
			System.out.println("Faultoad WORKLOAD NAME = " + i.getWorkload().getName());
			System.out.println("Faultload OUTPUT FILENAME = " + i.getOutputFilename());
		}

		faults = faultload.getFaults();

		for (Fault f : faults)
		{
			System.out.println("Faultoad FAULT ID = " + f.getFaultId());
			System.out.println("Faultload FAULT TYPE = " + f.getFaultType());
		}

		hardwareFaults = faults.get(0).getHardwareFaults();

		return SUCCESS;
	}

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

	public List<HardwareFault> getHardwareFaults()
	{
		return hardwareFaults;
	}
}
