package faultinjector.action;

import java.util.List;

import faultinjector.bean.FaultloadBean;
import faultinjector.entity.FaultClass;
import faultinjector.entity.HardwareFaultType;

public class CreateFaultload12 extends ApplicationSupport
{
	private static final long serialVersionUID = 4L;

	private FaultloadBean faultloadBean;
	private List<HardwareFaultType> hardwareFaultTypes;
	private List<FaultClass> faultClasses;

	public String execute()
	{
		if (!getSession().containsKey("faultloadBean"))
		{
			this.faultloadBean = new FaultloadBean();
			getSession().put("faultloadBean", faultloadBean);
		}
		else
			faultloadBean = (FaultloadBean) getSession().get("faultloadBean");

		hardwareFaultTypes = this.getExperimentService().findAllHardwareFaultTypes();
		faultClasses = this.getExperimentService().findAllFaultClasses();

		return SUCCESS;
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
}
