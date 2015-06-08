package faultinjector.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import faultinjector.bean.ExperimentBean;
import faultinjector.entity.Target;
import faultinjector.entity.Workload;
import faultinjector.service.ExperimentService;

public class CreateWorkloadAction extends ActionSupport implements SessionAware
{
	private static final long serialVersionUID = 4L;

	private Map<String, Object> session;
	private Workload workload;

	private String name;
	private String app1Name;
	private String app2Name;
	private String app3Name;

	@Override
	public String execute()
	{
		workload = new Workload();

		workload.setName(name);
		workload.setApp_1_name(app1Name);

		// if(workload.getApp_2_name()!=null)
		workload.setApp_2_name(app2Name);

		// if(workload.getApp_3_name()!=null)
		workload.setApp_3_name(app3Name);

		ExperimentBean eb = (ExperimentBean) session.get("experimentBean");

		System.out.println("CREATE WORKLOAD SESSION EXPERIMENT TARGET ID -> " + eb.getTargetId());

		Target t = this.getExperimentService().findTarget(eb.getTargetId());

		// workload.setTarget(t);

		t.addWorkload(workload);

		this.getExperimentService().createWorkload(workload);

		System.out.println("NEW WORKLOAD-------------------------------");
		System.out.println("Workload ID = " + workload.getWl_id());
		System.out.println("Workload NAME = " + workload.getName());
		System.out.println("Workload APP 1 NAME = " + workload.getApp_1_name());
		System.out.println("Workload APP 2 NAME = " + workload.getApp_2_name());
		System.out.println("Workload APP 3 NAME = " + workload.getApp_3_name());
		System.out.println("Workload TARGET NAME = " + workload.getTarget().getName());

		return SUCCESS;
	}

	public void validate()
	{
		if (name == null || name.length() == 0 || name.length() > 30)
			addFieldError("workload.name", "Workload name is required and can't have more than 30 characters!");

		if (app1Name == null || app1Name.length() == 0 || app1Name.length() > 30)
			addFieldError("workload.app1Name", "Workload Application #1 is required and can't have more than 30 characters!");

		if (app2Name.length() > 30)
			addFieldError("workload.app2Name", "Workload Application #2 can't have more than 30 characters!");

		if (app3Name.length() > 30)
			addFieldError("workload.app3Name", "Workload Application #3 can't have more than 30 characters!");
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

	public void setName(String name)
	{
		this.name = name;
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

	public String getName()
	{
		return name;
	}

	public String getApp1Name()
	{
		return app1Name;
	}

	public String getApp2Name()
	{
		return app2Name;
	}

	public String getApp3Name()
	{
		return app3Name;
	}

	@Override
	public void setSession(Map<String, Object> session)
	{
		this.session = session;
	}
}
