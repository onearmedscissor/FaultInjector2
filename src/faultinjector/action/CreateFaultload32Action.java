package faultinjector.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import faultinjector.bean.FaultloadBean;
import faultinjector.entity.FaultMode;
import faultinjector.service.ExperimentService;

public class CreateFaultload32Action extends ActionSupport implements SessionAware
{
	private static final long serialVersionUID = 4L;

	private Map<String, Object> session;
	private FaultloadBean faultloadBean;
	private List<String> accessTypes;
	private List<FaultMode> faultModes;
	private int faultModeId;
	private static final String read = "read", write = "write";

	public CreateFaultload32Action()
	{
		accessTypes = new ArrayList<String>();
		accessTypes.add(read);
		accessTypes.add(write);
	}

	public String execute()
	{
		if (!session.containsKey("faultloadBean"))
		{
			this.faultloadBean = new FaultloadBean();
			session.put("faultloadBean", faultloadBean);
		}
		else
			faultloadBean = (FaultloadBean) session.get("faultloadBean");

		faultModes = this.getExperimentService().findAllFaultModes();

		return SUCCESS;
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

	public FaultloadBean getFaultloadBean()
	{
		return faultloadBean;
	}

	public void setFaultModeId(int faultModeId)
	{
		this.faultModeId = faultModeId;
	}

	public List<String> getAccessTypes()
	{
		return accessTypes;
	}

	public List<FaultMode> getFaultModes()
	{
		return faultModes;
	}

	public int getDefaultFaultModeId()
	{
		if (getFaultloadBean().getFaultModeId() == 0)
			return faultModes.get(0).getFaultModeId();
		else
			return getFaultloadBean().getFaultModeId();
	}

	@Override
	public void setSession(Map<String, Object> session)
	{
		this.session = session;
	}
}
