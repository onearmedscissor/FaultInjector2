package faultinjector.action;

import java.util.Arrays;

import faultinjector.bean.FaultloadBean;

/**
 * This Action class assigns the registers selected in new_faultload_3.jsp to a temporary faultload JavaBean.
 * 
 * @author João Fernandes
 * @see struts.xml
 * @see ApplicationSupport
 * @see FaultloadBean
 */

public class CreateFaultload31 extends ApplicationSupport
{
	private static final long serialVersionUID = 4L;

	private FaultloadBean faultloadBean;
	private String[] rids;

	public String execute()
	{
		if (!getSession().containsKey("faultloadBean"))
		{
			this.faultloadBean = new FaultloadBean();
			getSession().put("faultloadBean", faultloadBean);
		}
		else
			faultloadBean = (FaultloadBean) getSession().get("faultloadBean");

		faultloadBean.setRegisterIds(rids);

		System.out.println("NEW FAULTLOAD 3-------------------------------");
		System.out.println("New faultload NAME = " + faultloadBean.getName());
		System.out.println("New faultload DESCRIPTION = " + faultloadBean.getDescription());
		System.out.println("New faultload TIME INTERVAL = " + faultloadBean.getTimeInterval());

		System.out.println("New faultload HARDWARE FAULT TYPE ID = " + faultloadBean.getHardwareFaultTypeId());
		System.out.println("New faultload MEMORY FAULT RANGE = " + faultloadBean.getMemoryFaultRangeStart() + " - " + faultloadBean.getMemoryFaultRangeEnd());
		System.out.println("New faultload NUMBER OF FAULTS = " + faultloadBean.getNumberFaults());
		System.out.println("New faultload 1.1 FAULT MODEL____________________________________");
		System.out.println("New faultload FAULT CLASS ID = " + faultloadBean.getFaultClassId());
		System.out.println("New faultload BITS TO CHANGE = " + faultloadBean.getBitsChangeStart() + " - " + faultloadBean.getBitsChangeEnd());
		System.out.println("New faultload SELECTED REGISTER(S) ID(S) = " + Arrays.toString(faultloadBean.getRegisterIds()));

		return SUCCESS;
	}

	public void setRids(String[] rids)
	{
		this.rids = rids;
	}
}
