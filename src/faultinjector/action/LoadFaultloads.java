package faultinjector.action;

import java.util.List;

import faultinjector.entity.Fault;
import faultinjector.entity.Faultload;
import faultinjector.entity.InjectionRun;

/**
 * This Action class accesses the database and provides the necessary data to display a list of the available faultloads
 * in new_experiment_4.jsp.
 * 
 * @author João Fernandes
 * @see struts.xml
 * @see ApplicationSupport
 * @see Faultload
 * @see InjectionRun
 * @see Fault
 */

public class LoadFaultloads extends ApplicationSupport
{
	private static final long serialVersionUID = 4L;

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

	public List<Faultload> getFaultloads()
	{
		return faultloads;
	}
}
