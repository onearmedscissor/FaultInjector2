package faultinjector.action;

import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.opensymphony.xwork2.ActionSupport;

import org.apache.struts2.interceptor.SessionAware;

import faultinjector.entity.Workload;
import faultinjector.service.ExperimentService;

public class SaveWorkloadAction extends ActionSupport implements SessionAware
{
	private static final long serialVersionUID = 4L;
	
	private Map<String, Object> session;
	private Workload workload;
	private EntityManager em;
	private EntityTransaction et;
	
	private String id;
	private String name;
	private String app1Name;
	private String app2Name;
	private String app3Name;

	@Override
	public String execute()
    {	
		em = this.getExperimentService().getEntityManager();
		et = em.getTransaction();
		et.begin();
		
		//workload = (Workload) session.get("workload "+id);
		
		workload = this.getExperimentService().findWorkload(Integer.parseInt(id));
		
		workload.setName(name);

		workload.setApp_1_name(app1Name);

		workload.setApp_2_name(app2Name);
		
		workload.setApp_3_name(app3Name);
		
		et.commit();
		em.close();

		System.out.println("SAVE WORKLOAD-------------------------------");
		System.out.println("Workload ID = "+workload.getWl_id());
		System.out.println("Workload NAME = "+workload.getName());
		System.out.println("Workload APP 1 NAME = "+workload.getApp_1_name());
		System.out.println("Workload APP 2 NAME = "+workload.getApp_2_name());
		System.out.println("Workload APP 3 NAME = "+workload.getApp_3_name());
		
        return SUCCESS;
	}
	
	public void validate()
	{	
		System.out.println ("SAVE ID -> "+id);
		
		if (name==null || name.length()==0 || name.length()>30)
			addFieldError("workload.name", "Workload name is required and can't have more than 30 characters!");
		
		if(app1Name==null || app1Name.length()==0 || app1Name.length()>30)
			addFieldError("workload.app1Name", "Workload Application #1 is required and can't have more than 30 characters!");
		
		if(app2Name.length()>30)
			addFieldError("workload.app2Name", "Workload Application #2 can't have more than 30 characters!");
		
		if(app3Name.length()>30)
			addFieldError("workload.app3Name", "Workload Application #3 can't have more than 30 characters!");
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

//	public Map<String, Object> getSession()
//	{
//		return session;
//	}

//	public Workload getWorkload()
//	{
//		return workload;
//	}
	
	public void setId(String id)
	{
		this.id=id;
	}

	public String getId()
	{
		return id;
	}
	
//	public void setWorkload(Workload workload)
//	{
//		this.workload = workload;
//	}

	public void setName(String name)
	{
		this.name=name;
	}
	
	public void setApp1Name(String app1Name)
	{
		this.app1Name = app1Name;
	}

	public void setApp2Name(String app2Name)
	{
		this.app2Name = app2Name;
	}
	
	public void setApp3Name(String app3Name)
	{
		this.app3Name = app3Name;
	}

	@Override
	public void setSession(Map<String, Object> session)
	{
		this.session=session;
	}
}
