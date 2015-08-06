package faultinjector.action;

import faultinjector.entity.Faultload;

/**
 * This Action class replaces a Faultload object stored in the session HTTP object (Session).
 * 
 * @author João Fernandes
 * @see struts.xml
 * @see ApplicationSupport
 * @see Faultload
 */

public class ReplaceEditFaultload extends ApplicationSupport
{
	private static final long serialVersionUID = 4L;

	private Faultload faultload;

	private int id;

	@Override
	public String execute()
	{
		this.faultload = this.getExperimentService().findFaultload(id);
		this.getSession().put("editFaultload", faultload);

		System.out.println("CLEAR EDIT FAULTLOAD-------------------------------");
		System.out.println("ID -> " + id);
		System.out.println("Faultload ID = " + faultload.getFaultloadId());
		System.out.println("Faultload NAME = " + faultload.getName());
		System.out.println("Faultload TIME INTERVAL = " + faultload.getTimeInterval());

		return SUCCESS;
	}

	public void setId(int id)
	{
		this.id = id;
	}
}
