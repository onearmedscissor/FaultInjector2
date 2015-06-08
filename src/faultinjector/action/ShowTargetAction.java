package faultinjector.action;

import com.opensymphony.xwork2.ActionSupport;

import faultinjector.entity.Target;
import faultinjector.service.ExperimentService;

public class ShowTargetAction extends ActionSupport /*implements SessionAware*/
{
	private static final long serialVersionUID = 4L;

	/*private Map<String, Object> session;*/

	private ExperimentService service;
	private Target target;
	
	private int id;
	
	@Override
	public String execute()
    {
		System.out.println("Olá!");
		service = new ExperimentService();
		
		this.target=service.findTarget(id);
	   	
		System.out.println("SHOW TARGET-------------------------------");
		System.out.println("Target ID = "+target.getTarget_id());
		System.out.println("Target NAME = "+target.getName());
		System.out.println("Target 32 BIT ARCHITECTURE? = "+target.getI386Arch());
		System.out.println("Target IP = "+target.getIp());
		System.out.println("Target OPERATING SYSTEM = "+target.getOperating_system());
		
        return SUCCESS;
	}
	
	/*@Override
	public void setSession(Map<String, Object> session)
	{
		this.session = session;
	}*/
	
	public Target getTarget()
	{
		return target;
	}

	public void setId(int id)
	{
		this.id = id;
	}
}
