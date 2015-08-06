package faultinjector.action;

import java.util.List;

import faultinjector.entity.Application;
import faultinjector.entity.InjectionRun;
import faultinjector.entity.Workload;
import faultinjector.service.EclipseLinkPersistence;

/**
 * This Action class accesses the database and gets the workload with the specified ID, making it available to
 * workload_details.jsp.
 * 
 * @author João Fernandes
 * @see struts.xml
 * @see ApplicationSupport
 * @see Workload
 * @see Application
 */

public class ShowWorkload extends ApplicationSupport
{
	private static final long serialVersionUID = 4L;

	private EclipseLinkPersistence service;
	private Workload workload;
	private List<InjectionRun> injectionRuns;
	private List<Application> applications;

	private int id;

	@Override
	public String execute()
	{
		int n = 1;
		service = new EclipseLinkPersistence();

		this.workload = service.findWorkload(id);

		applications = workload.getApplications();

		System.out.println("SHOW WORKLOAD-------------------------------");
		System.out.println("Workload ID = " + workload.getWorkloadId());
		System.out.println("Workload NAME = " + workload.getName());

		for (Application a : applications)
		{
			System.out.println("Workload APP " + n + " NAME = " + a.getName());

			n++;
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

	public Workload getWorkload()
	{
		return workload;
	}

	public List<Application> getApplications()
	{
		return applications;
	}

	public void setId(int id)
	{
		this.id = id;
	}
}
