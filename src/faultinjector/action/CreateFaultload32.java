package faultinjector.action;

import java.util.List;

import faultinjector.bean.FaultloadBean;
import faultinjector.entity.FaultMode;

/**
 * This Action class accesses the database and provides the necessary data to populate the <s: radio> tag present in
 * new_faultload_4.jsp with the available fault modes.
 * 
 * @author João Fernandes
 * @see struts.xml
 * @see ApplicationSupport
 * @see FaultloadBean
 * @see FaultMode
 */

public class CreateFaultload32 extends ApplicationSupport
{
	private static final long serialVersionUID = 4L;

	private FaultloadBean faultloadBean;
	private List<FaultMode> faultModes;
	private int faultModeId;

	public String execute()
	{
		if (!getSession().containsKey("faultloadBean"))
		{
			this.faultloadBean = new FaultloadBean();
			getSession().put("faultloadBean", faultloadBean);
		}
		else
			faultloadBean = (FaultloadBean) getSession().get("faultloadBean");

		faultModes = this.getExperimentService().findAllFaultModes();

		return SUCCESS;
	}

	public FaultloadBean getFaultloadBean()
	{
		return faultloadBean;
	}

	public void setFaultModeId(int faultModeId)
	{
		this.faultModeId = faultModeId;
	}

	public List<FaultMode> getFaultModes()
	{
		return faultModes;
	}

	/**
	 * If no fault mode has been selected yet in new_faultload_4.jsp, this method returns the first fault mode option
	 * ID. Otherwise, it returns the previously selected fault mode ID, present in a temporary faultload JavaBean.
	 * 
	 * @author João Fernandes
	 * @see FaultloadBEan
	 * @see FaultMode
	 */
	public int getDefaultFaultModeId()
	{
		if (getFaultloadBean().getFaultModeId() == 0)
			return faultModes.get(0).getFaultModeId();
		else
			return getFaultloadBean().getFaultModeId();
	}
}
