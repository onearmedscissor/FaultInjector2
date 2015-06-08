package faultinjector.action;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import faultinjector.entity.Fault;
import faultinjector.entity.Faultload;
import faultinjector.entity.Register;
import faultinjector.service.ExperimentService;

public class EditFaultload5Action extends ActionSupport implements SessionAware
{
	private static final long serialVersionUID = 4L;

	private Map<String, Object> session;
	private Faultload faultload;
	private EntityManager em;
	private EntityTransaction et;
	private List<Fault> faults;
	private boolean faultMode;
	private int processId, timeStart, timeEnd, codeAddress, dataAddress;
	private String triggerType, accessCode, accessData;
	private List<String> accessTypes;

	public String execute()
	{
		faultload = (Faultload) session.get("editFaultload");

		em = (EntityManager) session.get("em");
		et = (EntityTransaction) session.get("et");

//		em = this.getExperimentService().getEntityManager();
//		et = em.getTransaction();
//		et.begin();

		faults = faultload.getFaults();

		faultload.getFaults().get(0).setKernel_mode(faultMode);
		faultload.getFaults().get(0).setPid(processId);
		faultload.getFaults().get(0).setTrigger_type(triggerType);

		switch (triggerType)
		{
			case "tp":
			{
				faultload.getFaults().get(0).setTime_start(timeStart);
				faultload.getFaults().get(0).setTime_end(timeEnd);
			}
				break;
			case "sc":
			{
				if (accessCode.equals("write"))
					faultload.getFaults().get(0).setRead_address(false);
				else
					faultload.getFaults().get(0).setRead_address(true);

				faultload.getFaults().get(0).setMem_address(codeAddress);
			}
				break;
			case "sd":
			{
				if (accessData.equals("write"))
					faultload.getFaults().get(0).setRead_address(false);
				else
					faultload.getFaults().get(0).setRead_address(true);

				faultload.getFaults().get(0).setMem_address(dataAddress);
			}
				break;
		}

		et.commit();
		em.close();

		System.out.println("EDIT FAULTLOAD [5/5]-------------------------------");
		System.out.println("Faultload ID = " + faultload.getFl_id());
		System.out.println("Faultload NAME = " + faultload.getName());
		System.out.println("Faultload TIME INTERVAL = " + faultload.getTime_interval());

		System.out.println("Faultload HARDWARE FAULT TYPE = " + faultload.getFaults().get(0).getHardwares().get(0).getHw_fault_type());
		System.out.println("Faultload MEMORY FAULT RANGE = " + faultload.getMem_range_beg() + " - " + faultload.getMem_range_end());
		System.out.println("Faultload NUMBER OF FAULTS = " + faultload.getN_faults());
		System.out.println("Faultload 1.1 FAULT MODEL____________________________________");
		System.out.println("Faultload FAULT CLASS: IS BIT-FLIP? = " + faultload.getFaults().get(0).getHardwares().get(0).getBit_flip());
		System.out.println("Faultload BITS TO CHANGE = " + faultload.getFaults().get(0).getHardwares().get(0).getBitStart() + " - " + faultload.getFaults().get(0).getHardwares().get(0).getBitEnd());

		for (Register r : faultload.getRegisters())
			System.out.println("Faultload REGISTER: ID = " + r.getReg_id() + " | NAME = " + r.getName());

		System.out.println("Faultload 2.1 FAULT TRIGGER____________________________________");
		System.out.println("Faultload MODE: KERNEL? = " + faultload.getFaults().get(0).getKernel_mode());
		System.out.println("Faultload PROCESS ID = " + faultload.getFaults().get(0).getPid());
		System.out.println("Faultload 2.2 FAULT TRIGGER TYPE____________________________________");
		System.out.println("Faultload TRIGGER TYPE = " + faultload.getFaults().get(0).getTrigger_type());

		switch (faultload.getFaults().get(0).getTrigger_type())
		{
			case "tp":
				System.out.println("Faultload TEMPORAL BETWEEN = " + faultload.getFaults().get(0).getTime_start() + " AND " + faultload.getFaults().get(0).getTime_end());
				break;
			case "sc":
				System.out.println("Faultload SPATIAL (CODE SEGMENT) = " + faultload.getFaults().get(0).getRead_address() + " ON ADDRESS " + faultload.getFaults().get(0).getMem_address());
				break;
			case "sd":
				System.out.println("Faultload SPATIAL (DATA SEGMENT) = " + faultload.getFaults().get(0).getRead_address() + " ON ADDRESS " + faultload.getFaults().get(0).getMem_address());
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

	public void setFaultMode(boolean faultMode)
	{
		this.faultMode = faultMode;
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
