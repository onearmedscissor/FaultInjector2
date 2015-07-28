package faultinjector.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import faultinjector.bean.FaultloadBean;
import faultinjector.entity.FaultClass;
import faultinjector.entity.HardwareFaultType;
import faultinjector.service.EclipseLinkPersistence;

public class CreateFaultload12 extends ActionSupport implements SessionAware
{
	private static final long serialVersionUID = 4L;

	private Map<String, Object> session;
	private FaultloadBean faultloadBean;
	private List<HardwareFaultType> hardwareFaultTypes;
	private List<FaultClass> faultClasses;

	public String execute()
	{
		if (!session.containsKey("faultloadBean"))
		{
			this.faultloadBean = new FaultloadBean();
			session.put("faultloadBean", faultloadBean);
		}
		else
			faultloadBean = (FaultloadBean) session.get("faultloadBean");

		hardwareFaultTypes = this.getExperimentService().findAllHardwareFaultTypes();
		faultClasses = this.getExperimentService().findAllFaultClasses();

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

	public FaultloadBean getFaultloadBean()
	{
		return faultloadBean;
	}

	public List<FaultClass> getFaultClasses()
	{
		return faultClasses;
	}

	public int getDefaultFaultClassId()
	{
		if (getFaultloadBean().getFaultClassId() == 0)
			return faultClasses.get(0).getFaultClassId();
		else
			return getFaultloadBean().getFaultClassId();
	}

	public List<HardwareFaultType> getHardwareFaultTypes()
	{
		return hardwareFaultTypes;
	}

	public int getDefaultHardwareFaultTypeId()
	{
		if (getFaultloadBean().getHardwareFaultTypeId() == 0)
			return hardwareFaultTypes.get(0).getHardwareFaultTypeId();
		else
			return getFaultloadBean().getHardwareFaultTypeId();
	}

	@Override
	public void setSession(Map<String, Object> session)
	{
		this.session = session;
	}
}
