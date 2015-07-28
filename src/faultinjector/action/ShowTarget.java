package faultinjector.action;

import com.opensymphony.xwork2.ActionSupport;

import faultinjector.entity.Target;
import faultinjector.service.EclipseLinkPersistence;

public class ShowTarget extends ActionSupport
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
		System.out.println("Target ID = " + target.getTargetId());
		System.out.println("Target NAME = " + target.getName());
		System.out.println("Target ARCHITECTURE = " + target.getArchitecture().getName());
		System.out.println("Target IP = " + target.getIp());
		System.out.println("Target OPERATING SYSTEM = " + target.getOperatingSystem());

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
