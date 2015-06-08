package faultinjector.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import faultinjector.entity.Fault;
import faultinjector.entity.Faultload;
import faultinjector.entity.HardwareFault;
import faultinjector.service.ExperimentService;

public class EditFaultload22Action extends ActionSupport implements SessionAware
{
	private static final long serialVersionUID = 4L;

	private Map<String, Object> session;
	private Faultload faultload;
	private List<Fault> faults;
	private List<HardwareFault> hardwares;

	private String id;

	@Override
	public String execute()
	{
		if (!session.containsKey("editFaultload"))
		{
			this.faultload = this.getExperimentService().findFaultload(Integer.parseInt(id));
			this.session.put("editFaultload", faultload);
		}
		else
			faultload = (Faultload) session.get("editFaultload");

		faults = faultload.getFaults();
		hardwares = faults.get(0).getHardwares();

		System.out.println("ID -> " + id);
		System.out.println("EDIT FAULTLOAD [2.2/4]-------------------------------");
		System.out.println("Faultload ID = " + faultload.getFl_id());
		System.out.println("Faultload NAME = " + faultload.getName());
		System.out.println("Faultload TIME INTERVAL = " + faultload.getTime_interval());

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

	public void setId(String id)
	{
		this.id = id;
	}

	public Faultload getFaultload()
	{
		return faultload;
	}

	public List<Fault> getFaults()
	{
		return faults;
	}

	public List<HardwareFault> getHardwares()
	{
		return hardwares;
	}

	@Override
	public void setSession(Map<String, Object> session)
	{
		this.session = session;
	}
}
