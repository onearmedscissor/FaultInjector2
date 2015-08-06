package faultinjector.action;

import java.util.List;

import faultinjector.bean.FaultloadBean;
import faultinjector.entity.FaultClass;
import faultinjector.entity.HardwareFaultType;

/**
 * This Action class accesses the database and provides the necessary data to populate the <s: radio> tags present in
 * new_faultload_2.jsp (hardware fault types and fault classes).
 * 
 * @author João Fernandes
 * @see struts.xml
 * @see ApplicationSupport
 * @see FaultloadBean
 * @see HardwareFaultType
 * @see FaultClass
 */

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

	/**
	 * If no fault class has been selected yet in new_faultload_2.jsp, this method returns the first fault class option
	 * ID. Otherwise, it returns the previously selected fault class ID, present in a temporary faultload JavaBean.
	 * 
	 * @author João Fernandes
	 * @see FaultloadBEan
	 * @see FaultClass
	 */
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

	/**
	 * If no hardware fault type has been selected yet in new_faultload_2.jsp, this method returns the first hardware
	 * fault type option ID. Otherwise, it returns the previously selected hardware fault type ID, present in a
	 * temporary faultload JavaBean.
	 * 
	 * @author João Fernandes
	 * @see FaultloadBEan
	 * @see HardwareFaultType
	 */
	public int getDefaultHardwareFaultTypeId()
	{
		if (getFaultloadBean().getHardwareFaultTypeId() == 0)
			return hardwareFaultTypes.get(0).getHardwareFaultTypeId();
		else
			return getFaultloadBean().getHardwareFaultTypeId();
	}
}
