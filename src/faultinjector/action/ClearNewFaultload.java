package faultinjector.action;

import faultinjector.bean.FaultloadBean;

/**
 * This Action class resets a temporary faultload JavaBean (faultloadBean).
 * 
 * @author João Fernandes
 * @see struts.xml
 * @see ApplicationSupport
 * @see FaultloadBean
 */

public class ClearNewFaultload extends ApplicationSupport
{
	private static final long serialVersionUID = 4L;

	private FaultloadBean faultloadBean;

	@Override
	public String execute()
	{
		if (getSession().containsKey("faultloadBean"))
		{
			faultloadBean = (FaultloadBean) getSession().get("faultloadBean");

			System.out.println("FAULTLOAD BEAN RESET-------------------------------");
			System.out.println("New faultload NAME = " + faultloadBean.getName());
			System.out.println("New experiment DESCRIPTION = " + faultloadBean.getDescription());

			faultloadBean = new FaultloadBean();
			getSession().put("faultloadBean", faultloadBean);
		}

		return SUCCESS;
	}
}
