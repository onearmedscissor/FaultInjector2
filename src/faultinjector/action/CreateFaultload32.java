package faultinjector.action;

import java.util.ArrayList;
import java.util.List;

import faultinjector.bean.FaultloadBean;
import faultinjector.entity.FaultMode;

public class CreateFaultload32 extends ApplicationSupport
{
	private static final long serialVersionUID = 4L;

	private FaultloadBean faultloadBean;
	private List<String> accessTypes;
	private List<FaultMode> faultModes;
	private int faultModeId;
	private static final String read = "read", write = "write";

	public CreateFaultload32()
	{
		accessTypes = new ArrayList<String>();
		accessTypes.add(read);
		accessTypes.add(write);
	}

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
}
