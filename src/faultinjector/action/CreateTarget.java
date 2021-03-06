package faultinjector.action;

import faultinjector.entity.Architecture;
import faultinjector.entity.Target;

/**
 * This Action class validates the form data input submitted in new_target.jsp (target name, architecture, IP address
 * and operating system). Upon validation, it creates and persists a new Target entity instance into the database, with
 * the submitted data.
 * 
 * @author João Fernandes
 * @see struts.xml
 * @see ApplicationSupport
 * @see Target
 * @see Architecture
 */

public class CreateTarget extends ApplicationSupport
{
	private static final long serialVersionUID = 4L;

	private Target target;
	private String name, ip, operatingSystem;
	private int architectureId, ip1, ip2, ip3, ip4;

	@Override
	public String execute()
	{
		System.out.println("Target ARCHITECTURE = " + architectureId);

		target = new Target();

		target.setName(name);

		Architecture a = this.getExperimentService().findArchitecture(architectureId);
		a.addTarget(target);

		ip = Integer.toString(ip1) + "." + Integer.toString(ip2) + "." + Integer.toString(ip3) + "." + Integer.toString(ip4);
		target.setIp(ip);
		target.setOperatingSystem(operatingSystem);

		this.getExperimentService().createTarget(target);

		System.out.println("NEW TARGET-------------------------------");
		System.out.println("Target ID = " + target.getTargetId());
		System.out.println("Target NAME = " + target.getName());
		System.out.println("Target ARCHITECTURE = " + target.getArchitecture().getName());
		System.out.println("Target IP ADDRESS = " + target.getIp());
		System.out.println("Target OPERATING SYSTEM= " + target.getOperatingSystem());

		return SUCCESS;
	}

	public void validate()
	{
		if (name == null || name.length() == 0 || name.length() > 50)
			addFieldError("target.name", "Target name is required and can't have more than 50 characters!");

		if (ip1 < 0 || ip1 > 255 || ip2 < 0 || ip2 > 255 || ip3 < 0 || ip3 > 255 || ip4 < 0 || ip4 > 255)
			addFieldError("target.ip", "Target IP address is required and blocks must contain a value between 0 and 255!");

		if (operatingSystem == null || operatingSystem.length() == 0 || operatingSystem.length() > 30)
			addFieldError("target.operatingSystem", "Target operating system is required and can't have more than 30 characters!");
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public void setArchitectureId(int architectureId)
	{
		this.architectureId = architectureId;
	}

	public void setIp1(int ip1)
	{
		this.ip1 = ip1;
	}

	public void setIp2(int ip2)
	{
		this.ip2 = ip2;
	}

	public void setIp3(int ip3)
	{
		this.ip3 = ip3;
	}

	public void setIp4(int ip4)
	{
		this.ip4 = ip4;
	}

	public int getIp1()
	{
		return ip1;
	}

	public int getIp2()
	{
		return ip2;
	}

	public int getIp3()
	{
		return ip3;
	}

	public int getIp4()
	{
		return ip4;
	}

	public void setIp(String ip)
	{
		this.ip = ip;
	}

	public void setOperatingSystem(String operatingSystem)
	{
		this.operatingSystem = operatingSystem;
	}

	public String getName()
	{
		return name;
	}

	public String getIp()
	{
		return ip;
	}

	public String getOperatingSystem()
	{
		return operatingSystem;
	}
}
