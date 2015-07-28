package faultinjector.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import faultinjector.entity.Experiment;
import faultinjector.entity.Faultload;
import faultinjector.entity.InjectionRun;
import faultinjector.service.EclipseLinkPersistence;

public class EditExperiment extends ActionSupport implements SessionAware
{
	private static final long serialVersionUID = 4L;

	private Map<String, Object> session;
	private Experiment experiment;

	private int id;
	private List<Faultload> faultloads;
	private List<InjectionRun> injectionRuns;

	@Override
	public String execute()
	{
		experiment = this.getExperimentService().findExperiment(id);

		System.out.println("ID -> " + id);
		System.out.println("EDIT EXPERIMENT-------------------------------");
		System.out.println("Experiment ID = " + experiment.getExpId());
		System.out.println("Experiment NAME = " + experiment.getName());

		if (experiment.getTarget() != null)
			System.out.println("Experiment TARGET NAME = " + experiment.getTarget().getName());

		System.out.println("Experiment CREATION DATE = " + experiment.getCreationDate());

		if (experiment.getUser() != null)
			System.out.println("Experiment CREATOR NAME = " + experiment.getUser().getName());

		faultloads = experiment.getFaultloads();
		faultloads.size();

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

	public List<InjectionRun> getInjectionRuns()
	{
		return injectionRuns;
	}

	@Override
	public void setSession(Map<String, Object> session)
	{
		this.session = session;
	}
}