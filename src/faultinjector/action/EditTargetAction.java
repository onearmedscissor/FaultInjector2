package faultinjector.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import faultinjector.entity.Target;
import faultinjector.service.ExperimentService;

public class EditTargetAction extends ActionSupport implements SessionAware
{
	private static final long serialVersionUID = 4L;

	private Map<String, Object> session;
	private Target target;
	private int id;
	private String ip, ip1, ip2, ip3, ip4;
	private String[] ips;
	private List<String> architectures;

	private static final String X86 = "Intel 32 Bit", X64 = "Intel 64 Bit";

	public EditTargetAction()
	{
		architectures = new ArrayList<String>();
		architectures.add(X86);
		architectures.add(X64);
	}

	@Override
	public String execute()
	{
		// et = this.getExperimentService().getEntityManager().getTransaction();
		//
		// if(!et.isActive())
		// et.begin();

		target = this.getExperimentService().findTarget(id);

		// if(!session.containsKey("target "+id))
		// {
		// this.target = this.getExperimentService().findTarget(id);
		// session.put("target "+id, target);
		// }
		// else
		// target = (Target) session.get("target "+id);

		ip = target.getIp();
		ips = ip.split("\\.");
		System.out.println("IP -> " + ip);
		ip1 = ips[0];
		System.out.println("IP1 -> " + ip1);
		ip2 = ips[1];
		System.out.println("IP2 -> " + ip2);
		ip3 = ips[2];
		System.out.println("IP3 -> " + ip3);
		ip4 = ips[3];
		System.out.println("IP4 -> " + ip4);

		System.out.println("ID -> " + id);
		System.out.println("EDIT TARGET-------------------------------");
		System.out.println("Target ID = " + target.getTarget_id());
		System.out.println("Target NAME = " + target.getName());
		System.out.println("Target 32 BIT ARCHITECTURE? = " + target.getI386Arch());
		System.out.println("Target IP = " + target.getIp());
		System.out.println("Target OPERATING SYSTEM = " + target.getOperating_system());

		return SUCCESS;
	}

	public ExperimentService getExperimentService()
	{
		if (!session.containsKey("experimentService"))
		{
			ExperimentService experimentService = new ExperimentService();

			this.setExperimentService(experimentService);
		}

		return (ExperimentService) session.get("experimentService");
	}

	public void setExperimentService(ExperimentService experimentService)
	{
		this.session.put("experimentService", experimentService);
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

	public List<String> getArchitectures()
	{
		return architectures;
	}

	public Target getTarget()
	{
		return target;
	}

	public String getDefaultArchitectureValue()
	{
		if (getTarget().getI386Arch())
			return X86;
		else
			return X64;
	}

	@Override
	public void setSession(Map<String, Object> session)
	{
		this.session = session;
	}
}
