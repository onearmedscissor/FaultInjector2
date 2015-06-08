package faultinjector.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import faultinjector.entity.Experiment;
import faultinjector.entity.Faultload;
import faultinjector.entity.Injection_Run;
import faultinjector.service.ExperimentService;

public class ShowExperimentAction extends ActionSupport /*implements SessionAware*/
{
	private static final long serialVersionUID = 4L;

	/*private Map<String, Object> session;*/

	private ExperimentService service;
	private Experiment experiment;
	private List<Faultload> faultloads;
	private List<Injection_Run> injectionRuns;
	
	private int id;
	
	@Override
	public String execute()
    {
		System.out.println("Olá!");
		service = new ExperimentService();
		
		this.experiment=service.findExperiment(id);
	   	
		System.out.println("ID -> "+id);
		System.out.println("SHOW EXPERIMENT-------------------------------");
		System.out.println("Experiment ID = "+experiment.getExp_id());
		System.out.println("Experiment NAME = "+experiment.getName());
		System.out.println("Experiment TARGET NAME = "+experiment.getTarget().getName());
		System.out.println("Experiment CREATION DATE = "+experiment.getCreation_date());
		
		if(experiment.getUser()!=null)
			System.out.println("Experiment CREATOR NAME = "+experiment.getUser().getName());
		
		faultloads = experiment.getFaultloads();
		
		for (Faultload f : faultloads)
		{
			injectionRuns = f.getInjectionRuns();
			
			System.out.println("Experiment FAULTLOAD NAME = "+f.getName());
			
			for(Injection_Run i : injectionRuns)
			{
				System.out.println("Faultload WORKLOAD NAME = "+i.getWorkload().getName());
				System.out.println("Faultload OUTPUT FILENAME = "+i.getOutput_filename());
			}
		}
			
		System.out.println("Experiment DESCRIPTION = "+experiment.getDescription());
		
        return SUCCESS;
	}
	
	/*@Override
	public void setSession(Map<String, Object> session)
	{
		this.session = session;
	}*/

	public ExperimentService getService()
	{
		return service;
	}

	public void setService(ExperimentService service)
	{
		this.service = service;
	}
	
	public Experiment getExperiment()
	{
		return experiment;
	}

	public void setExperiment(Experiment experiment)
	{
		this.experiment=experiment;
	}

	public List<Faultload> getFaultloads()
	{
		return faultloads;
	}

	/*public List<Injection_Run> getInjectionRuns()
	{
		return injectionRuns;
	}*/

	public void setId(int id)
	{
		this.id = id;
	}
}
