package faultinjector.action;

import java.util.List;

import faultinjector.entity.Application;
import faultinjector.entity.InjectionRun;
import faultinjector.entity.Workload;

/**
 * This Action class accesses the database and gets the workload with the specified ID, for editing purposes in
 * edit_workload.jsp.
 * 
 * @author João Fernandes
 * @see struts.xml
 * @see ApplicationSupport
 * @see Workload
 * @see InjectionRun
 * @see Application
 */

public class EditWorkload extends ApplicationSupport
{
	private static final long serialVersionUID = 4L;

	private Workload workload;
	private int id;
	private List<InjectionRun> injectionRuns;
	private List<Application> applications;

	@Override
	public String execute()
	{
		workload = this.getExperimentService().findWorkload(id);

		applications = workload.getApplications();

		System.out.println("EDIT WORKLOAD-------------------------------");
		System.out.println("Workload ID = " + workload.getWorkloadId());
		System.out.println("Workload NAME = " + workload.getName());

		for (int n = 0; n < applications.size(); n++)
		{
			System.out.println("Workload APP " + (n + 1) + " NAME = " + applications.get(n).getName());
		}

		injectionRuns = workload.getInjectionRuns();

		for (InjectionRun i : injectionRuns)
		{
			System.out.println("Workload FAULTLOAD NAME = " + i.getFaultload().getName());
			System.out.println("Workload OUTPUT FILENAME = " + i.getOutputFilename());
		}

		System.out.println("Workload TARGET NAME = " + workload.getTarget().getName());

		return SUCCESS;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public Workload getWorkload()
	{
		return workload;
	}

	public List<Application> getApplications()
	{
		return applications;
	}
}
