package faultinjector.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import faultinjector.entity.Experiment;
import faultinjector.entity.Faultload;
import faultinjector.entity.Injection_Run;
import faultinjector.service.ExperimentService;

public class EditExperimentAction extends ActionSupport implements SessionAware
{
	private static final long serialVersionUID = 4L;

	private Map<String, Object> session;
	private Experiment experiment;

	private int id;
	private List<Faultload> faultloads;
	private List<Injection_Run> injectionRuns;

	@Override
	public String execute()
	{
		experiment = this.getExperimentService().findExperiment(id);

		System.out.println("ID -> " + id);
		System.out.println("EDIT EXPERIMENT-------------------------------");
		System.out.println("Experiment ID = " + experiment.getExp_id());
		System.out.println("Experiment NAME = " + experiment.getName());

		if (experiment.getTarget() != null)
			System.out.println("Experiment TARGET NAME = " + experiment.getTarget().getName());

		System.out.println("Experiment CREATION DATE = " + experiment.getCreation_date());

		if (experiment.getUser() != null)
			System.out.println("Experiment CREATOR NAME = " + experiment.getUser().getName());

		faultloads = experiment.getFaultloads();
		faultloads.size();

		for (Faultload f : faultloads)
		{
			injectionRuns = f.getInjectionRuns();

			System.out.println("Experiment FAULTLOAD NAME = " + f.getName());

			for (Injection_Run i : injectionRuns)
			{
				System.out.println("Faultload WORKLOAD NAME = " + i.getWorkload().getName());
				System.out.println("Faultload OUTPUT FILENAME = " + i.getOutput_filename());
			}
		}

		System.out.println("Experiment DESCRIPTION = " + experiment.getDescription());

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

	public List<Injection_Run> getInjectionRuns()
	{
		return injectionRuns;
	}

	@Override
	public void setSession(Map<String, Object> session)
	{
		this.session = session;
	}
}
