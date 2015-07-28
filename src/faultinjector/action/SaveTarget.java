package faultinjector.action;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import faultinjector.entity.Architecture;
import faultinjector.entity.Target;

public class SaveTarget extends ApplicationSupport
{
	private static final long serialVersionUID = 4L;

	private Target target;
	private EntityManager em;
	private EntityTransaction et;
	private String id;
	private String name;
	private int architectureId, ip1, ip2, ip3, ip4;
	private String ip;
	private String operatingSystem;

	@Override
	public String execute()
	{
		em = this.getExperimentService().getEntityManager();
		et = em.getTransaction();
		et.begin();

		target = this.getExperimentService().findTarget(Integer.parseInt(id));

		target.setName(name);

		Architecture a = this.getExperimentService().findArchitecture(architectureId);
		a.addTarget(target);

		ip = Integer.toString(ip1) + "." + Integer.toString(ip2) + "." + Integer.toString(ip3) + "." + Integer.toString(ip4);
		target.setIp(ip);

		target.setOperatingSystem(operatingSystem);

		et.commit();
		em.close();

		System.out.println("SAVE TARGET-------------------------------");
		System.out.println("Target ID = " + target.getTargetId());
		System.out.println("Target NAME = " + target.getName());
		System.out.println("Target ARCHITECTURE = " + target.getArchitecture().getName());
		System.out.println("Target IP = " + target.getIp());
		System.out.println("Target OPERATING SYSTEM = " + target.getOperatingSystem());

		return SUCCESS;
	}

	public void validate()
	{
		System.out.println("SAVE ID -> " + id);

		if (name == null || name.length() == 0 || name.length() > 50)
			addFieldError("target.name", "Target name is required and can't have more than 50 characters!");

		if (ip1 < 0 || ip1 > 255 || ip2 < 0 || ip2 > 255 || ip3 < 0 || ip3 > 255 || ip4 < 0 || ip4 > 255)
			addFieldError("target.ip", "Target IP address is required and blocks must contain a vlaue between 0 and 255!");

		if (operatingSystem == null || operatingSystem.length() == 0 || operatingSystem.length() > 30)
			addFieldError("target.operating_system", "Target operating system is required and can't have more than 30 characters!");
	}

	public String getId()
	{
		return id;
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

	public Target getTarget()
	{
		return target;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public void setTarget(Target target)
	{
		this.target = target;
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

	public void setIp(String ip)
	{
		this.ip = ip;
	}

	public void setOperatingSystem(String operatingSystem)
	{
		this.operatingSystem = operatingSystem;
	}
}
