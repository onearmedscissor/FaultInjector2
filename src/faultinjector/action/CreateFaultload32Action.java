package faultinjector.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;

import faultinjector.entity.Faultload;

public class CreateFaultload32Action extends ActionSupport
{
	private static final long serialVersionUID = 4L;

	private Map<String, Object> session;
	private Faultload faultload;

	private List<String> accessTypes;

	public CreateFaultload32Action()
	{
		accessTypes = new ArrayList<String>();
		accessTypes.add("read");
		accessTypes.add("write");
	}

	public String execute()
	{
		return SUCCESS;
	}

	public List<String> getAccessTypes()
	{
		return accessTypes;
	}
}
