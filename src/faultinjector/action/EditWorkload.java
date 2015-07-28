package faultinjector.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import faultinjector.entity.Application;
import faultinjector.entity.InjectionRun;
import faultinjector.entity.Workload;
import faultinjector.service.EclipseLinkPersistence;

public class EditWorkload extends ActionSupport implements SessionAware
{
	private static final long serialVersionUID = 4L;

	private Map<String, Object> session;
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

	@Override
	public void setSession(Map<String, Object> session)
	{
		this.session = session;
	}
}
