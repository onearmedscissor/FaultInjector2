package faultinjector.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import faultinjector.entity.Architecture;
import faultinjector.service.EclipseLinkPersistence;

public class LoadArchitectures extends ActionSupport implements SessionAware
{
	private static final long serialVersionUID = 4L;

	private Map<String, Object> session;
	private List<Architecture> architectures;

	public String execute()
	{
		architectures = this.getExperimentService().findAllArchitectures();

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

	public List<Architecture> getArchitectures()
	{
		return architectures;
	}

	public int getDefaultArchitectureId()
	{
		return architectures.get(0).getArchitectureId();
	}

	@Override
	public void setSession(Map<String, Object> session)
	{
		this.session = session;
	}
}
