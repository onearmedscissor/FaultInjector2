package faultinjector.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import faultinjector.entity.Application;
import faultinjector.entity.InjectionRun;
import faultinjector.entity.Workload;
import faultinjector.service.ExperimentService;

public class ShowWorkloadAction extends ActionSupport
{
	private static final long serialVersionUID = 4L;

	private ExperimentService service;
	private Workload workload;
	private List<InjectionRun> injectionRuns;
	private List<Application> applications;

	private int id;

	@Override
	public String execute()
	{
		int n = 1;
		service = new ExperimentService();

		this.workload = service.findWorkload(id);

		applications = workload.getApplications();

		System.out.println("SHOW WORKLOAD-------------------------------");
		System.out.println("Workload ID = "+workload.getWorkloadId());
		System.out.println("Workload NAME = "+workload.getName());

		for (Application a : applications)
		{
			System.out.println("Workload APP "+n+" NAME = "+a.getName());

			n++;
		}

		injectionRuns = workload.getInjectionRuns();

		for (InjectionRun i : injectionRuns)
		{
			System.out.println("Workload FAULTLOAD NAME = "+i.getFaultload().getName());
			System.out.println("Workload OUTPUT FILENAME = "+i.getOutputFilename());
		}

		System.out.println("Workload TARGET NAME = "+workload.getTarget().getName());

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
