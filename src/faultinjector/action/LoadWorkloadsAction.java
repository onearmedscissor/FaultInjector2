package faultinjector.action;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

import org.apache.struts2.interceptor.SessionAware;

import faultinjector.entity.Injection_Run;
import faultinjector.entity.Workload;
import faultinjector.service.ExperimentService;

public class LoadWorkloadsAction extends ActionSupport implements SessionAware
{
	private static final long serialVersionUID = 4L;
		
	private Map<String, Object> session;
	private List <Workload> workloads;
	private List<Injection_Run> injectionRuns;

	@Override
	public String execute()
    {	
		this.workloads=this.getExperimentService().findAllWorkloads();
		
		for (Workload w : this.workloads)
		{
			System.out.println("LOAD WORKLOADS-------------------------------");
			System.out.println("Workload ID = "+w.getWl_id());
			System.out.println("Workload NAME = "+w.getName());
			System.out.println("Workload APP 1 NAME = "+w.getApp_1_name());
			System.out.println("Workload APP 2 NAME = "+w.getApp_2_name());
			System.out.println("Workload APP 3 NAME = "+w.getApp_3_name());
			
			injectionRuns = w.getInjectionRuns();
			
			for (Injection_Run i : injectionRuns)
			{
				if(i.getFaultload()!=null)
					System.out.println("Workload FAULTLOAD NAME = "+i.getFaultload().getName());
				
				System.out.println("Workload OUTPUT FILENAME = "+i.getOutput_filename());
			}
			
			System.out.println("Workload TARGET NAME = "+w.getTarget().getName());
		}
		
        return SUCCESS;
	}
	
	public ExperimentService getExperimentService()
	{
		if(!session.containsKey("experimentService"))
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
	
	public List<Workload> getWorkloads()
	{
		return workloads;
	}

	@Override
	public void setSession(Map<String, Object> session)
	{
		this.session=session;
	}
}
