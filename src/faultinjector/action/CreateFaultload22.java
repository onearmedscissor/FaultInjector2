package faultinjector.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import faultinjector.entity.Register;
import faultinjector.service.EclipseLinkPersistence;

public class CreateFaultload22 extends ActionSupport implements SessionAware
{
	private static final long serialVersionUID = 4L;

	private Map<String, Object> session;
	private List<Register> registers;

	@Override
	public String execute()
	{
		this.registers = this.getExperimentService().findAllRegisters();

		System.out.println("LOAD REGISTERS-------------------------------");

		for (Register r : this.registers)
		{
			System.out.println("Register ID = " + r.getRegisterId());
			System.out.println("Register NAME = " + r.getName());
			System.out.println();
		}

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

	public List<Register> getRegisters()
	{
		return registers;
	}

	@Override
	public void setSession(Map<String, Object> session)
	{
		this.session = session;
	}
}
