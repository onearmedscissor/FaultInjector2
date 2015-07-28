package faultinjector.action;

import java.util.Arrays;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import faultinjector.bean.ExperimentBean;

public class CreateExperiment41 extends ActionSupport implements SessionAware
{
	private static final long serialVersionUID = 4L;

	private Map<String, Object> session;
	private ExperimentBean experimentBean;
	private String[] fids;

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

		experimentBean.setFaultloadIds(fids);

		System.out.println("NEW EXPERIMENT 4.1-------------------------------");
		System.out.println("BEAN");
		System.out.println("New experiment NAME = " + experimentBean.getName());
		System.out.println("New experiment DESCRIPTION = " + experimentBean.getDescription());
		System.out.println("New experiment SELECTED TARGET ID = " + experimentBean.getTargetId());
		System.out.println("New experiment SELECTED WORKLOAD ID = " + experimentBean.getWorkloadId());
		System.out.println("New experiment SELECTED FAULTLOAD(S) ID(S) = " + Arrays.toString(experimentBean.getFaultloadIds()));

		return SUCCESS;
	}

	public void setFids(String[] fids)
	{
		this.fids = fids;
	}

	@Override
	public void setSession(Map<String, Object> session)
	{
		this.session = session;
	}
}
