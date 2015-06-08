package faultinjector.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import faultinjector.bean.FaultloadBean;

public class ClearNewFaultloadAction extends ActionSupport implements SessionAware
{
	private static final long serialVersionUID = 4L;

	private Map<String, Object> session;
	private FaultloadBean faultloadBean;

	@Override
	public String execute()
	{
		if (session.containsKey("faultloadBean"))
		{
			faultloadBean = (FaultloadBean) session.get("faultloadBean");

			System.out.println("FAULTLOAD BEAN RESET-------------------------------");
			System.out.println("New faultload NAME = " + faultloadBean.getName());
			// System.out.println("New experiment DESCRIPTION = " +
			// faultloadBean.getDescription());
			// System.out.println("New experiment SELECTED TARGET ID = " +
			// experimentBean.getTargetId());
			// System.out.println("New experiment SELECTED WORKLOAD ID = " +
			// experimentBean.getWorkloadId());
			// System.out.println("New experiment SELECTED FAULTLOADS = " +
			// Arrays.toString(experimentBean.getFaultloadIds()));

			faultloadBean = new FaultloadBean();
			session.put("faultloadBean", faultloadBean);
		}

		return SUCCESS;
	}

	@Override
	public void setSession(Map<String, Object> session)
	{
		this.session = session;
	}
}
