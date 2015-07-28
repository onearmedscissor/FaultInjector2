package faultinjector.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import faultinjector.entity.Architecture;
import faultinjector.entity.Target;
import faultinjector.service.EclipseLinkPersistence;

public class EditTarget extends ActionSupport implements SessionAware
{
	private static final long serialVersionUID = 4L;

	private Map<String, Object> session;
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

	public EclipseLinkPersistence getExperimentService()
	{
		if (!session.containsKey("experimentService"))
		{
			EclipseLinkPersistence experimentService = new EclipseLinkPersistence();

			this.setExperimentService(experimentService);
		}

		return (EclipseLinkPersistence) session.get("experimentService");
	}

	public void setExperimentService(EclipseLinkPersistence experimentService)
	{
		this.session.put("experimentService", experimentService);
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

	@Override
	public void setSession(Map<String, Object> session)
	{
		this.session = session;
	}
}
