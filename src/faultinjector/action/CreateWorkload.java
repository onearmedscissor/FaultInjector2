package faultinjector.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import faultinjector.bean.ExperimentBean;
import faultinjector.entity.Application;
import faultinjector.entity.Target;
import faultinjector.entity.Workload;
import faultinjector.service.EclipseLinkPersistence;

public class CreateWorkload extends ActionSupport implements SessionAware
{
	private static final long serialVersionUID = 4L;

	private Map<String, Object> session;
	private Workload workload;

	private String name, app1Name, app2Name, app3Name, app4Name, app5Name, app6Name, app7Name, app8Name, app9Name, app10Name;
	private Application app1, app2, app3, app4, app5, app6, app7, app8, app9, app10;
	private List<Application> apps;

	@Override
	public String execute()
	{
		workload = new Workload();
		apps = new ArrayList<Application>();

		workload.setName(name);

		app1 = new Application();
		app1.setName(app1Name);
		apps.add(app1);

		if (app2Name != null && !app2Name.isEmpty())
		{
			app2 = new Application();
			app2.setName(app2Name);
			apps.add(app2);
		}

		if (app3Name != null && !app3Name.isEmpty())
		{
			app3 = new Application();
			app3.setName(app3Name);
			apps.add(app3);
		}

		if (app4Name != null && !app4Name.isEmpty())
		{
			app4 = new Application();
			app4.setName(app4Name);
			apps.add(app4);
		}

		if (app5Name != null && !app5Name.isEmpty())
		{
			app5 = new Application();
			app5.setName(app5Name);
			apps.add(app5);
		}

		if (app6Name != null && !app6Name.isEmpty())
		{
			app6 = new Application();
			app6.setName(app6Name);
			apps.add(app6);
		}

		if (app7Name != null && !app7Name.isEmpty())
		{
			app7 = new Application();
			app7.setName(app7Name);
			apps.add(app7);
		}

		if (app8Name != null && !app8Name.isEmpty())
		{
			app8 = new Application();
			app8.setName(app8Name);
			apps.add(app8);
		}

		if (app9Name != null && !app9Name.isEmpty())
		{
			app9 = new Application();
			app9.setName(app9Name);
			apps.add(app9);
		}

		if (app10Name != null && !app10Name.isEmpty())
		{
			app10 = new Application();
			app10.setName(app10Name);
			apps.add(app10);
		}

		workload.setApplications(apps);

		ExperimentBean eb = (ExperimentBean) session.get("experimentBean");
		System.out.println(eb);
		System.out.println("CREATE WORKLOAD SESSION EXPERIMENT TARGET ID -> " + eb.getTargetId());

		Target t = this.getExperimentService().findTarget(eb.getTargetId());

		t.addWorkload(workload);

		this.getExperimentService().createWorkload(workload);

		System.out.println("NEW WORKLOAD-------------------------------");
		System.out.println("Workload ID = " + workload.getWorkloadId());
		System.out.println("Workload NAME = " + workload.getName());

		for (int n = 0; n < apps.size(); n++)
		{
			System.out.println("Workload APP " + (n + 1) + " NAME = " + workload.getApplications().get(n).getName());
		}

		System.out.println("Workload TARGET NAME = " + workload.getTarget().getName());

		return SUCCESS;
	}

	public void validate()
	{
		if (name == null || name.length() == 0 || name.length() > 30)
			addFieldError("name", "Workload name is required and can't have more than 30 characters!");

		if (app1Name == null || app1Name.length() == 0 || app1Name.length() > 30)
			addFieldError("app1Name", "Workload Application #1 is required and can't have more than 30 characters!");

		if (app2Name != null && app2Name.length() > 30)
			addFieldError("app2Name", "Workload Application #2 can't have more than 30 characters!");

		if (app3Name != null && app3Name.length() > 30)
			addFieldError("workload.app3Name", "Workload Application #3 can't have more than 30 characters!");

		if (app4Name != null && app4Name.length() > 30)
			addFieldError("app4Name", "Workload Application #4 can't have more than 30 characters!");

		if (app5Name != null && app5Name.length() > 30)
			addFieldError("app5Name", "Workload Application #5 can't have more than 30 characters!");

		if (app6Name != null && app6Name.length() > 30)
			addFieldError("app6Name", "Workload Application #6 can't have more than 30 characters!");

		if (app7Name != null && app7Name.length() > 30)
			addFieldError("app7Name", "Workload Application #7 can't have more than 30 characters!");

		if (app8Name != null && app8Name.length() > 30)
			addFieldError("app8Name", "Workload Application #8 can't have more than 30 characters!");

		if (app9Name != null && app9Name.length() > 30)
			addFieldError("app9Name", "Workload Application #9 can't have more than 30 characters!");

		if (app10Name != null && app10Name.length() > 30)
			addFieldError("app10Name", "Workload Application #10 can't have more than 30 characters!");
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

	public void setApp4Name(String app4Name)
	{
		this.app4Name = app4Name;
	}

	public void setApp5Name(String app5Name)
	{
		this.app5Name = app5Name;
	}

	public void setApp6Name(String app6Name)
	{
		this.app6Name = app6Name;
	}

	public void setApp7Name(String app7Name)
	{
		this.app7Name = app7Name;
	}

	public void setApp8Name(String app8Name)
	{
		this.app8Name = app8Name;
	}

	public void setApp9Name(String app9Name)
	{
		this.app9Name = app9Name;
	}

	public void setApp10Name(String app10Name)
	{
		this.app10Name = app10Name;
	}

	public String getName()
	{
		return name;
	}

	public String getApp1Name()
	{
		return app1Name;
	}

	@Override
	public void setSession(Map<String, Object> session)
	{
		this.session = session;
	}
}
