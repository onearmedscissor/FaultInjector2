package faultinjector.action;

import java.util.Arrays;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import faultinjector.bean.ExperimentBean;

public class ClearNewExperiment extends ActionSupport implements SessionAware
{
	private static final long serialVersionUID = 4L;
	
	private Map<String, Object> session;
	private ExperimentBean experimentBean;
	
	@Override
	public String execute()
    {
		if(session.containsKey("experimentBean"))
		{
			experimentBean = (ExperimentBean) session.get("experimentBean");
			
			System.out.println("EXPERIMENT BEAN RESET-------------------------------");
			System.out.println("New experiment NAME = "+experimentBean.getName());
			System.out.println("New experiment DESCRIPTION = "+experimentBean.getDescription());
			System.out.println("New experiment SELECTED TARGET ID = "+experimentBean.getTargetId());
			System.out.println("New experiment SELECTED WORKLOAD ID = "+experimentBean.getWorkloadId());
			System.out.println("New experiment SELECTED FAULTLOADS = "+Arrays.toString(experimentBean.getFaultloadIds()));
			
			experimentBean = new ExperimentBean();
			session.put("experimentBean", experimentBean);
		}
		
        return SUCCESS;
	}

	@Override
	public void setSession(Map<String, Object> session)
	{
		this.session=session;
	}
}
