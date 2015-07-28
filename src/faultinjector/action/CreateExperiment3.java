package faultinjector.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import faultinjector.bean.ExperimentBean;
import faultinjector.service.EclipseLinkPersistence;

public class CreateExperiment3 extends ActionSupport implements SessionAware
{
	private static final long serialVersionUID = 4L;

	private Map<String, Object> session;
	private ExperimentBean experimentBean;

	private int wid;

	@Override
	public String execute()
	{
		if (!session.containsKey("experimentBean"))
		{
			this.experimentBean = new ExperimentBean();
			session.put("experimentBean", experimentBean);
		}
		else
			experimentBean = (ExperimentBean) session.get("experimentBean");

		System.out.println("WID -> " + wid);

		if (wid != 0)
			experimentBean.setWorkloadId(wid);

		System.out.println("NEW EXPERIMENT 3-------------------------------");
		System.out.println("New experiment NAME = " + experimentBean.getName());
		System.out.println("New experiment DESCRIPTION = " + experimentBean.getDescription());
		System.out.println("New experiment SELECTED TARGET ID = " + experimentBean.getTargetId());
		System.out.println("New experiment SELECTED WORKLOAD ID = " + experimentBean.getWorkloadId());

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

	public void setWid(int wid)
	{
		this.wid = wid;
	}

	@Override
	public void setSession(Map<String, Object> session)
	{
		this.session = session;
	}
}
