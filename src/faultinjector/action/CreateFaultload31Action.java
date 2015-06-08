package faultinjector.action;

import java.util.Arrays;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import faultinjector.bean.FaultloadBean;

public class CreateFaultload31Action extends ActionSupport implements SessionAware
{
	private static final long serialVersionUID = 4L;

	private Map<String, Object> session;
	private FaultloadBean faultloadBean;
	private String[] rids;

	public String execute()
	{
		if (!session.containsKey("faultloadBean"))
		{
			this.faultloadBean = new FaultloadBean();
			session.put("faultloadBean", faultloadBean);
		} else
			faultloadBean = (FaultloadBean) session.get("faultloadBean");

		faultloadBean.setRegisterIds(rids);

		System.out.println("NEW FAULTLOAD 3-------------------------------");
		System.out.println("New faultload NAME = " + faultloadBean.getName());
		System.out.println("New faultload DESCRIPTION = " + faultloadBean.getDescription());
		System.out.println("New faultload TIME INTERVAL = " + faultloadBean.getTimeInterval());

		System.out.println("New faultload HARDWARE FAULT TYPE = " + faultloadBean.getHardwareFaultType());
		System.out.println("New faultload MEMORY FAULT RANGE = " + faultloadBean.getMemoryFaultRangeStart() + " - " + faultloadBean.getMemoryFaultRangeEnd());
		System.out.println("New faultload NUMBER OF FAULTS = " + faultloadBean.getNumberFaults());
		System.out.println("New faultload 1.1 FAULT MODEL____________________________________");
		System.out.println("New faultload FAULT CLASS: IS BIT-FLIP? = " + faultloadBean.getBitFlip());
		System.out.println("New faultload BITS TO CHANGE = " + faultloadBean.getBitsChangeStart() + " - " + faultloadBean.getBitsChangeEnd());
		System.out.println("New faultload SELECTED REGISTER(S) ID(S) = " + Arrays.toString(faultloadBean.getRegisterIds()));

		return SUCCESS;
	}

	public void validate()
	{

	}

	public void setRids(String[] rids)
	{
		this.rids = rids;
	}

	@Override
	public void setSession(Map<String, Object> session)
	{
		this.session = session;
	}
}
