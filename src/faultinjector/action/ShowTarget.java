package faultinjector.action;

import faultinjector.entity.Target;
import faultinjector.service.EclipseLinkPersistence;

/**
 * This Action class accesses the database and gets the target with the specified ID, making it available to
 * target_details.jsp.
 * 
 * @author João Fernandes
 * @see struts.xml
 * @see ApplicationSupport
 * @see Target
 */

public class ShowTarget extends ApplicationSupport
{
	private static final long serialVersionUID = 4L;

	private EclipseLinkPersistence service;
	private Target target;

	private int id;

	@Override
	public String execute()
	{
		service = new EclipseLinkPersistence();

		this.target = service.findTarget(id);

		System.out.println("SHOW TARGET-------------------------------");

		if (target != null)
		{
			System.out.println("Target ID = " + target.getTargetId());
			System.out.println("Target NAME = " + target.getName());
			System.out.println("Target ARCHITECTURE = " + target.getArchitecture().getName());
			System.out.println("Target IP = " + target.getIp());
			System.out.println("Target OPERATING SYSTEM = " + target.getOperatingSystem());
		}

		return SUCCESS;
	}

	public Target getTarget()
	{
		return target;
	}

	public void setId(int id)
	{
		this.id = id;
	}
}
