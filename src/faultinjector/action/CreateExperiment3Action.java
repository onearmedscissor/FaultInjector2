package faultinjector.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

import org.apache.struts2.interceptor.SessionAware;

import faultinjector.bean.ExperimentBean;
import faultinjector.service.ExperimentService;

public class CreateExperiment3Action extends ActionSupport implements SessionAware
{
	private static final long serialVersionUID = 4L;
		
	private Map<String, Object> session;
	private ExperimentBean experimentBean;
	
	private String wid;

	@Override
	public String execute()
    {
		if(!session.containsKey("experimentBean"))
		{
			this.experimentBean = new ExperimentBean();
			session.put("experimentBean", experimentBean);
		}
		else
			experimentBean = (ExperimentBean) session.get("experimentBean");
		
		System.out.println("WID -> "+wid);
		
		experimentBean.setWorkloadId(Integer.parseInt(wid));
		
		System.out.println("NEW EXPERIMENT 3-------------------------------");
		System.out.println("New experiment NAME = "+experimentBean.getName());
		System.out.println("New experiment DESCRIPTION = "+experimentBean.getDescription());
		System.out.println("New experiment SELECTED TARGET ID = "+experimentBean.getTargetId());
		System.out.println("New experiment SELECTED WORKLOAD ID = "+experimentBean.getWorkloadId());
		
        return SUCCESS;
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

	public void setWid(String wid)
	{
		this.wid = wid;
	}
	
	@Override
	public void setSession(Map<String, Object> session)
	{
		this.session=session;
	}
}
