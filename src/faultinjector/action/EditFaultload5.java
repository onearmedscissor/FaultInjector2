package faultinjector.action;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import faultinjector.entity.Fault;
import faultinjector.entity.FaultMode;
import faultinjector.entity.Faultload;
import faultinjector.entity.Register;
import faultinjector.service.EclipseLinkPersistence;

public class EditFaultload5 extends ActionSupport implements SessionAware
{
	private static final long serialVersionUID = 4L;

	private Map<String, Object> session;
	private Faultload faultload;
	private EntityManager em;
	private EntityTransaction et;
	private List<Fault> faults;
	private int faultModeId, processId, timeStart, timeEnd, codeAddress, dataAddress;
	private String triggerType, accessCode, accessData;
	private List<String> accessTypes;

	public String execute()
	{
		em = (EntityManager) session.get("em");
		et = (EntityTransaction) session.get("et");

		faultload = (Faultload) session.get("editFaultload");

		faults = faultload.getFaults();

		FaultMode fm = this.getExperimentService().findFaultMode(faultModeId);
		fm.addFault(faults.get(0));

		faults.get(0).setPid(processId);
		faults.get(0).setTriggerType(triggerType);

		switch (triggerType)
		{
			case "tp":
			{
				faults.get(0).setTimeStart(timeStart);
				faults.get(0).setTimeEnd(timeEnd);
			}
				break;
			case "sc":
			{
				if (accessCode.equals("write"))
					faults.get(0).setReadAddress(false);
				else
					faults.get(0).setReadAddress(true);

				faults.get(0).setMemAddress(codeAddress);
			}
				break;
			case "sd":
			{
				if (accessData.equals("write"))
					faults.get(0).setReadAddress(false);
				else
					faults.get(0).setReadAddress(true);

				faults.get(0).setMemAddress(dataAddress);
			}
				break;
		}

		et.commit();
		em.close();

		System.out.println("EDIT FAULTLOAD [5/5]-------------------------------");
		System.out.println("Faultload ID = " + faultload.getFaultloadId());
		System.out.println("Faultload NAME = " + faultload.getName());
		System.out.println("Faultload TIME INTERVAL = " + faultload.getTimeInterval());

		System.out.println("Faultload HARDWARE FAULT TYPE = " + faults.get(0).getHardwareFaults().get(0).getHardwareFaultType().getName());
		System.out.println("Faultload MEMORY FAULT RANGE = " + faultload.getMemoryRangeBeginning() + " - " + faultload.getMemoryRangeEnd());
		System.out.println("Faultload NUMBER OF FAULTS = " + faultload.getNumberFaults());
		System.out.println("Faultload 1.1 FAULT MODEL____________________________________");
		System.out.println("Faultload FAULT CLASS = " + faults.get(0).getHardwareFaults().get(0).getFaultClass().getName());
		System.out.println("Faultload BITS TO CHANGE = " + faults.get(0).getHardwareFaults().get(0).getBitStart() + " - " + faults.get(0).getHardwareFaults().get(0).getBitEnd());

		for (Register r : faultload.getRegisters())
			System.out.println("Faultload REGISTER: ID = " + r.getRegisterId() + " | NAME = " + r.getName());

		System.out.println("Faultload 2.1 FAULT TRIGGER____________________________________");
		System.out.println("Faultload MODE = " + faults.get(0).getFaultMode().getName());
		System.out.println("Faultload PROCESS ID = " + faults.get(0).getPid());
		System.out.println("Faultload 2.2 FAULT TRIGGER TYPE____________________________________");
		System.out.println("Faultload TRIGGER TYPE = " + faults.get(0).getTriggerType());

		switch (faults.get(0).getTriggerType())
		{
			case "tp":
				System.out.println("Faultload TEMPORAL BETWEEN = " + faults.get(0).getTimeStart() + " AND " + faults.get(0).getTimeEnd());
				break;
			case "sc":
				System.out.println("Faultload SPATIAL (CODE SEGMENT) = " + faults.get(0).getReadAddress() + " ON ADDRESS " + faults.get(0).getMemAddress());
				break;
			case "sd":
				System.out.println("Faultload SPATIAL (DATA SEGMENT) = " + faults.get(0).getReadAddress() + " ON ADDRESS " + faults.get(0).getMemAddress());
				break;
		}

		return SUCCESS;
	}

	public void validate()
	{
		if (processId <= 0)
			addFieldError("fault.pid", "Faultload process ID is required and must be positive!");

		switch (triggerType)
		{
			case "tp":
			{
				if (timeStart < 0 || timeEnd <= timeStart)
					addFieldError("faultload.mem_range_beg", "Faultload temporal trigger time start is required and must be positive! Also, time end must be greater than time start!");

				if (timeEnd < 0 || timeEnd <= timeStart)
					addFieldError("faultload.mem_range_end", "Faultload temporal trigger time end is required and must be positive! Also, time end must be greater than time start!");

				break;
			}
			case "sc":
			{
				if (codeAddress <= 0)
					addFieldError("fault.mem_address", "Faultload memory address is required and must be positive!");

				break;
			}
			case "sd":
			{
				if (dataAddress <= 0)
					addFieldError("fault.mem_address", "Faultload memory address is required and must be positive!");

				break;
			}
		}
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

	public void setFaultModeId(int faultModeId)
	{
		this.faultModeId = faultModeId;
	}

	public void setProcessId(int processId)
	{
		this.processId = processId;
	}

	public void setTimeStart(int timeStart)
	{
		this.timeStart = timeStart;
	}

	public void setTimeEnd(int timeEnd)
	{
		this.timeEnd = timeEnd;
	}

	public void setCodeAddress(int codeAddress)
	{
		this.codeAddress = codeAddress;
	}

	public void setDataAddress(int dataAddress)
	{
		this.dataAddress = dataAddress;
	}

	public void setTriggerType(String triggerType)
	{
		this.triggerType = triggerType;
	}

	public void setAccessCode(String accessCode)
	{
		this.accessCode = accessCode;
	}

	public void setAccessData(String accessData)
	{
		this.accessData = accessData;
	}

	public void setAccessTypes(List<String> accessTypes)
	{
		this.accessTypes = accessTypes;
	}

	@Override
	public void setSession(Map<String, Object> session)
	{
		this.session = session;
	}
}
