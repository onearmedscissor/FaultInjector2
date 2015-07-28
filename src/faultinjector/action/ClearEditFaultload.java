package faultinjector.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import faultinjector.entity.Faultload;
import faultinjector.service.EclipseLinkPersistence;

public class ClearEditFaultload extends ActionSupport implements SessionAware
{
	private static final long serialVersionUID = 4L;

	private Map<String, Object> session;
	private Faultload faultload;

	private int id;

	@Override
	public String execute()
	{
		this.faultload = this.getExperimentService().findFaultload(id);
		this.session.put("editFaultload", faultload);

		System.out.println("CLEAR EDIT FAULTLOAD-------------------------------");
		System.out.println("ID -> " + id);
		System.out.println("Faultload ID = " + faultload.getFaultloadId());
		System.out.println("Faultload NAME = " + faultload.getName());
		System.out.println("Faultload TIME INTERVAL = " + faultload.getTimeInterval());

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

	public void setId(int id)
	{
		this.id = id;
	}

	@Override
	public void setSession(Map<String, Object> session)
	{
		this.session = session;
	}
}
