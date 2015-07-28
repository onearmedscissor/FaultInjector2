package faultinjector.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import faultinjector.entity.Fault;
import faultinjector.entity.FaultClass;
import faultinjector.entity.Faultload;
import faultinjector.entity.HardwareFault;
import faultinjector.entity.HardwareFaultType;
import faultinjector.service.EclipseLinkPersistence;

public class EditFaultload22 extends ActionSupport implements SessionAware
{
	private static final long serialVersionUID = 4L;

	private Map<String, Object> session;
	private Faultload faultload;
	private List<Fault> faults;
	private List<HardwareFault> hardwareFaults;

	private String id;

	private List<HardwareFaultType> hardwareFaultTypes;
	private List<FaultClass> faultClasses;

	@Override
	public String execute()
	{
		faultload = (Faultload) session.get("editFaultload");

		hardwareFaultTypes = this.getExperimentService().findAllHardwareFaultTypes();
		faultClasses = this.getExperimentService().findAllFaultClasses();

		faults = faultload.getFaults();
		hardwareFaults = faults.get(0).getHardwareFaults();

		System.out.println("ID -> " + id);
		System.out.println("EDIT FAULTLOAD [2.2/4]-------------------------------");
		System.out.println("Faultload ID = " + faultload.getFaultloadId());
		System.out.println("Faultload NAME = " + faultload.getName());
		System.out.println("Faultload TIME INTERVAL = " + faultload.getTimeInterval());

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

	public List<HardwareFault> getHardwareFaults()
	{
		return hardwareFaults;
	}

	public List<FaultClass> getFaultClasses()
	{
		return faultClasses;
	}

	public int getFaultClassId()
	{
		return getHardwareFaults().get(0).getFaultClass().getFaultClassId();
	}

	public List<HardwareFaultType> getHardwareFaultTypes()
	{
		return hardwareFaultTypes;
	}

	public int getHardwareFaultTypeId()
	{
		return getHardwareFaults().get(0).getHardwareFaultType().getHardwareFaultTypeId();
	}

	@Override
	public void setSession(Map<String, Object> session)
	{
		this.session = session;
	}
}
