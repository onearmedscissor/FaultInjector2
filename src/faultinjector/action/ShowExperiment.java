package faultinjector.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import faultinjector.entity.Experiment;
import faultinjector.entity.Faultload;
import faultinjector.entity.InjectionRun;
import faultinjector.service.EclipseLinkPersistence;

public class ShowExperiment extends ActionSupport
{
	private static final long serialVersionUID = 4L;

	private EclipseLinkPersistence service;
	private Experiment experiment;
	private List<Faultload> faultloads;
	private List<InjectionRun> injectionRuns;

	private int id;

	@Override
	public String execute()
	{
		service = new EclipseLinkPersistence();

		this.experiment = service.findExperiment(id);

		System.out.println("ID -> " + id);
		System.out.println("SHOW EXPERIMENT-------------------------------");
		System.out.println("Experiment ID = " + experiment.getExpId());
		System.out.println("Experiment NAME = " + experiment.getName());
		System.out.println("Experiment TARGET NAME = " + experiment.getTarget().getName());
		System.out.println("Experiment CREATION DATE = " + experiment.getCreationDate());

		if (experiment.getUser() != null)
			System.out.println("Experiment CREATOR NAME = " + experiment.getUser().getName());

		faultloads = experiment.getFaultloads();

		for (Faultload f : faultloads)
		{
			injectionRuns = f.getInjectionRuns();

			System.out.println("Experiment FAULTLOAD NAME = " + f.getName());

			for (InjectionRun i : injectionRuns)
			{
				System.out.println("Faultload WORKLOAD NAME = " + i.getWorkload().getName());
				System.out.println("Faultload OUTPUT FILENAME = " + i.getOutputFilename());
			}
		}

		System.out.println("Experiment DESCRIPTION = " + experiment.getDescription());

		return SUCCESS;
	}

	public EclipseLinkPersistence getService()
	{
		return service;
	}

	public void setService(EclipseLinkPersistence service)
	{
		this.service = service;
	}

	public Experiment getExperiment()
	{
		return experiment;
	}

	public void setExperiment(Experiment experiment)
	{
		this.experiment = experiment;
	}

	public List<Faultload> getFaultloads()
	{
		return faultloads;
	}

	public void setId(int id)
	{
		this.id = id;
	}
}
