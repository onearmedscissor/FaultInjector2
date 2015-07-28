package faultinjector.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import faultinjector.entity.Target;
import faultinjector.service.EclipseLinkPersistence;

public class LoadTargets extends ActionSupport implements SessionAware
{
	private static final long serialVersionUID = 4L;

	private Map<String, Object> session;
	private List<Target> targets;

	@Override
	public String execute()
	{
		this.targets = this.getExperimentService().findAllTargets();

		System.out.println("LOAD TARGETS-------------------------------");

		for (Target t : this.targets)
		{
			System.out.println();
			System.out.println("Target ID = " + t.getTargetId());
			System.out.println("Target NAME = " + t.getName());
			System.out.println("Target ARCHITECTURE = " + t.getArchitecture().getName());
			System.out.println("Target IP = " + t.getIp());
			System.out.println("Target OPERATING SYSTEM = " + t.getOperatingSystem());
		}

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

	public List<Target> getTargets()
	{
		return targets;
	}

	@Override
	public void setSession(Map<String, Object> session)
	{
		this.session = session;
	}
}
