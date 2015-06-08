package faultinjector.action;

import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

import org.apache.struts2.interceptor.SessionAware;

import faultinjector.entity.Target;
import faultinjector.service.ExperimentService;

public class LoadTargetsAction extends ActionSupport implements SessionAware
{
	private static final long serialVersionUID = 4L;
		
	private Map<String, Object> session;
	private List <Target> targets;
	
	@Override
	public String execute()
    {
		this.targets=this.getExperimentService().findAllTargets();
		
		for (Target t : this.targets)
		{
			System.out.println("LOAD TARGETS-------------------------------");
			System.out.println("Target ID = "+t.getTarget_id());
			System.out.println("Target NAME = "+t.getName());
			System.out.println("Target 32 BIT ARCHITECTURE? = "+t.getI386Arch());
			System.out.println("Target IP = "+t.getIp());
			System.out.println("Target OPERATING SYSTEM = "+t.getOperating_system());
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
	
	public List<Target> getTargets()
	{
		return targets;
	}

	@Override
	public void setSession(Map<String, Object> session)
	{
		this.session=session;
	}
}
