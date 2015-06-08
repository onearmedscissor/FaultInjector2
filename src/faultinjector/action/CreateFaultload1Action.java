package faultinjector.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import faultinjector.bean.FaultloadBean;

public class CreateFaultload1Action extends ActionSupport implements SessionAware
{
	private static final long serialVersionUID = 4L;

	private Map<String, Object> session;
	private FaultloadBean faultloadBean;

	private String name, description;
	private int timeInterval;

	private List<Character> hardwareFaultTypes;
	private List<String> faultClasses;

	private static final String bitFlip = "bit-flip", stuckAt = "stuck at";

	public CreateFaultload1Action()
	{
		hardwareFaultTypes = new ArrayList<Character>();
		hardwareFaultTypes.add('r');
		hardwareFaultTypes.add('m');

		faultClasses = new ArrayList<String>();
		faultClasses.add(bitFlip);
		faultClasses.add(stuckAt);
	}

	public String execute()
	{
		if (!session.containsKey("faultloadBean"))
		{
			this.faultloadBean = new FaultloadBean();
			session.put("faultloadBean", faultloadBean);
		} else
			faultloadBean = (FaultloadBean) session.get("faultloadBean");

		faultloadBean.setName(name);
		faultloadBean.setDescription(description);
		faultloadBean.setTimeInterval(timeInterval);

		System.out.println("NEW FAULTLOAD 1-------------------------------");
		System.out.println("New faultload NAME = " + faultloadBean.getName());
		System.out.println("New faultload DESCRIPTION = " + faultloadBean.getDescription());
		System.out.println("New faultload TIME INTERVAL = " + faultloadBean.getTimeInterval());

		return SUCCESS;
	}

	public void validate()
	{
		if (name == null || name.length() == 0 || name.length() > 50)
			addFieldError("faultloadBean.name", "Faultload name is required and can't have more than 50 characters!");

		if (description == null || description.length() == 0 || description.length() > 300)
			addFieldError("faultloadBean.description", "Faultload description is required and can't have more than 300 characters!");

		if (timeInterval < 0 || timeInterval > 60000)
			addFieldError("faultloadBean.timeInterval", "Faultload time interval is required. It can't be negative nor greater than 60.000 milliseconds!");
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public void setTimeInterval(int timeInterval)
	{
		this.timeInterval = timeInterval;
	}

	public List<String> getFaultClasses()
	{
		return faultClasses;
	}

	public FaultloadBean getFaultloadBean()
	{
		return faultloadBean;
	}

	public String getDefaultFaultClass()
	{
		if (getFaultloadBean().getBitFlip())
			return bitFlip;
		else
			return stuckAt;
	}

	@Override
	public void setSession(Map<String, Object> session)
	{
		this.session = session;
	}
}
