package faultinjector.action;

import java.util.List;

import faultinjector.entity.Architecture;
import faultinjector.entity.Target;

/**
 * This Action class accesses the database and provides the necessary data to populate the <s: radio> tag present in
 * edit_target.jsp, with the available architectures. It also gets the target with the specified ID from the database,
 * for editing purposes.
 * 
 * @author João Fernandes
 * @see struts.xml
 * @see ApplicationSupport
 * @see Target
 * @see Architecture
 */

public class EditTarget extends ApplicationSupport
{
	private static final long serialVersionUID = 4L;

	private Target target;
	private List<Architecture> architectures;
	private Architecture architecture;
	private int id;
	private String ip, ip1, ip2, ip3, ip4;
	private String[] ips;

	@Override
	public String execute()
	{
		architectures = this.getExperimentService().findAllArchitectures();

		target = this.getExperimentService().findTarget(id);
		architecture = target.getArchitecture();

		ip = target.getIp();
		ips = ip.split("\\.");

		ip1 = ips[0];
		ip2 = ips[1];
		ip3 = ips[2];
		ip4 = ips[3];

		System.out.println("EDIT TARGET-------------------------------");
		System.out.println("Target ID = " + target.getTargetId());
		System.out.println("Target NAME = " + target.getName());
		System.out.println("Target ARCHITECTURE = " + target.getArchitecture().getName());
		System.out.println("Target IP = " + target.getIp());
		System.out.println("Target OPERATING SYSTEM = " + target.getOperatingSystem());

		return SUCCESS;
	}

	public List<Architecture> getArchitectures()
	{
		return architectures;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getIp1()
	{
		return ip1;
	}

	public String getIp2()
	{
		return ip2;
	}

	public String getIp3()
	{
		return ip3;
	}

	public String getIp4()
	{
		return ip4;
	}

	public Target getTarget()
	{
		return target;
	}

	public int getArchitectureId()
	{
		return architecture.getArchitectureId();
	}
}
