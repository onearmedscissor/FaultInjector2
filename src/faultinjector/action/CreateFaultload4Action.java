package faultinjector.action;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import faultinjector.bean.ExperimentBean;
import faultinjector.bean.FaultloadBean;
import faultinjector.entity.FaultClass;
import faultinjector.entity.FaultMode;
import faultinjector.entity.Faultload;
import faultinjector.entity.HardwareFault;
import faultinjector.entity.HardwareFaultType;
import faultinjector.entity.InjectionRun;
import faultinjector.entity.Register;
import faultinjector.entity.Workload;
import faultinjector.service.ExperimentService;

public class CreateFaultload4Action extends ActionSupport implements SessionAware
{
	private static final long serialVersionUID = 4L;

	private Map<String, Object> session;
	private ExperimentBean experimentBean;
	private FaultloadBean faultloadBean;
	private int faultModeId, processId, timeStart, timeEnd, codeAddress, dataAddress;
	private String triggerType, accessCode, accessData;
	private List<String> accessTypes;
	private int id;

	public String execute()
	{
		if (!session.containsKey("experimentBean"))
		{
			this.experimentBean = new ExperimentBean();
			session.put("experimentBean", experimentBean);
		}
		else
			experimentBean = (ExperimentBean) session.get("experimentBean");

		if (!session.containsKey("faultloadBean"))
		{
			this.faultloadBean = new FaultloadBean();
			session.put("faultloadBean", faultloadBean);
		}
		else
			faultloadBean = (FaultloadBean) session.get("faultloadBean");

		faultloadBean.setFaultModeId(faultModeId);
		faultloadBean.setProcessId(processId);
		faultloadBean.setTriggerType(triggerType);

		switch (faultloadBean.getTriggerType())
		{
			case "tp":
			{
				faultloadBean.setTemporalTriggerStart(timeStart);
				faultloadBean.setTemporalTriggerEnd(timeEnd);
			}
				break;
			case "sc":
			{
				if (accessCode.equals("write"))
					faultloadBean.setReadAddress(false);
				else
					faultloadBean.setReadAddress(true);

				faultloadBean.setMemoryAddress(codeAddress);
			}
				break;
			case "sd":
			{
				if (accessData.equals("write"))
					faultloadBean.setReadAddress(false);
				else
					faultloadBean.setReadAddress(true);

				faultloadBean.setMemoryAddress(dataAddress);
			}
				break;
		}

		Faultload faultload = new Faultload();

		faultload.setName(faultloadBean.getName());
		faultload.setDescription(faultloadBean.getDescription());
		faultload.setTimeInterval(faultloadBean.getTimeInterval());

		if (faultloadBean.getHardwareFaultTypeId() != 0)
		{
			faultload.setMemoryRangeBeginning(faultloadBean.getMemoryFaultRangeStart());
			faultload.setMemoryRangeEnd(faultloadBean.getMemoryFaultRangeEnd());
		}

		faultload.setNumberFaults(faultloadBean.getNumberFaults());

		String[] registers = faultloadBean.getRegisterIds();
		List<Register> regs = new ArrayList<Register>();

		for (String s : registers)
		{
			Register r = this.getExperimentService().findRegister(Integer.parseInt(s));

			regs.add(r);
		}

		faultload.setRegisters(regs);

		HardwareFault hardwareFault = new HardwareFault();

		HardwareFaultType hft = this.getExperimentService().findHardwareFaultType(faultloadBean.getHardwareFaultTypeId());
		hft.addHardwareFault(hardwareFault);

		FaultClass fc = this.getExperimentService().findFaultClass(faultloadBean.getFaultClassId());
		fc.addFault(hardwareFault);

		hardwareFault.setBitStart(faultloadBean.getBitsChangeStart());
		hardwareFault.setBitEnd(faultloadBean.getBitsChangeEnd());

		FaultMode fm = this.getExperimentService().findFaultMode(faultloadBean.getFaultModeId());
		fm.addFault(hardwareFault);

		hardwareFault.setPid(processId);
		hardwareFault.setTriggerType(triggerType);

		switch (hardwareFault.getTriggerType())
		{
			case "tp":
			{
				hardwareFault.setTimeStart(timeStart);
				hardwareFault.setTimeEnd(timeEnd);
			}
				break;
			case "sc":
			{
				if (accessCode.equals("write"))
					hardwareFault.setReadAddress(false);
				else
					hardwareFault.setReadAddress(true);

				hardwareFault.setMemAddress(codeAddress);
			}
				break;
			case "sd":
			{
				if (accessData.equals("write"))
					hardwareFault.setReadAddress(false);
				else
					hardwareFault.setReadAddress(true);

				hardwareFault.setMemAddress(dataAddress);
			}
				break;
		}

		hardwareFault.setCreationDate(getCurrentTimestamp());
		faultload.addFault(hardwareFault);

		/* */

		InjectionRun injection_Run = new InjectionRun();
		// injection_Run.setOutput_filename("experiment_3_2.csv");

		Workload workload = this.getExperimentService().findWorkload(experimentBean.getWorkloadId());
		workload.addInjectionRun(injection_Run);

		faultload.addInjectionRun(injection_Run);

		hardwareFault.addInjectionRun(injection_Run);

		/* */

		id = this.getExperimentService().createFaultload(faultload);

		System.out.println("ID NOVA FAULTLOAD 3 -> " + id);

		String[] fids = { Integer.toString(id) };
		experimentBean.setFaultloadIds(fids);

		System.out.println("NEW EXPERIMENT 4 [BEAN]-------------------------------");
		System.out.println("New experiment NAME = " + experimentBean.getName());
		System.out.println("New experiment DESCRIPTION = " + experimentBean.getDescription());
		System.out.println("New experiment SELECTED TARGET ID = " + experimentBean.getTargetId());
		System.out.println("New experiment SELECTED WORKLOAD ID = " + experimentBean.getWorkloadId());
		System.out.println("New experiment SELECTED FAULTLOAD(S) ID(S) = " + Arrays.toString(experimentBean.getFaultloadIds()));

		System.out.println("NEW FAULTLOAD 4-------------------------------");
		System.out.println("New faultload NAME = " + faultload.getName());
		System.out.println("New faultload DESCRIPTION = " + faultload.getDescription());
		System.out.println("New faultload TIME INTERVAL = " + faultload.getTimeInterval());

		System.out.println("New faultload HARDWARE FAULT TYPE = " + hardwareFault.getHardwareFaultType().getName());
		System.out.println("New faultload MEMORY FAULT RANGE = " + faultload.getMemoryRangeBeginning() + " - " + faultload.getMemoryRangeEnd());
		System.out.println("New faultload NUMBER OF FAULTS = " + faultload.getNumberFaults());
		System.out.println("New faultload 1.1 FAULT MODEL____________________________________");
		System.out.println("New faultload FAULT CLASS = " + hardwareFault.getFaultClass().getName());
		System.out.println("New faultload BITS TO CHANGE = " + hardwareFault.getBitStart() + " - " + hardwareFault.getBitEnd());
		System.out.println("New faultload SELECTED REGISTER(S) ID(S) = " + faultload.getRegisters());

		System.out.println("New faultload 2.1 FAULT TRIGGER____________________________________");
		System.out.println("New faultload FAULT MODE = " + hardwareFault.getFaultMode());
		System.out.println("New faultload PROCESS ID = " + hardwareFault.getPid());
		System.out.println("New faultload 2.2 FAULT TRIGGER TYPE____________________________________");
		System.out.println("New faultload TRIGGER TYPE = " + hardwareFault.getTriggerType());

		switch (hardwareFault.getTriggerType())
		{
			case "tp":
				System.out.println("New faultload TEMPORAL BETWEEN = " + hardwareFault.getTimeStart() + " AND " + hardwareFault.getTimeEnd());
				break;
			case "sc":
				System.out.println("New faultload SPATIAL (CODE SEGMENT) = " + hardwareFault.getReadAddress() + " ON ADDRESS " + hardwareFault.getMemAddress());
				break;
			case "sd":
				System.out.println("New faultload SPATIAL (DATA SEGMENT) = " + hardwareFault.getReadAddress() + " ON ADDRESS " + hardwareFault.getMemAddress());
				break;
		}

		return SUCCESS;
	}

	public void validate()
	{
		if (processId <= 0)
			addFieldError("faultloadBean.processId", "Faultload process ID is required and must be positive!");

		switch (triggerType)
		{
			case "tp":
			{
				if (timeStart < 0 || timeEnd < timeStart)
					addFieldError("faultloadBean.temporalTriggerStart", "Faultload temporal trigger time start is required and must be positive! Also, time start must be greater than time end!");

				if (timeEnd < 0 || timeEnd < timeStart)
					addFieldError("faultloadBean.temporalTriggerEnd", "Faultload temporal trigger time end is required and must be positive! Also, time start must be greater than time end!");

				break;
			}
			case "sc":
			{
				if (codeAddress <= 0)
					addFieldError("faultloadBean.memoryAddress", "Faultload memory address is required and must be positive!");

				break;
			}
			case "sd":
			{
				if (dataAddress <= 0)
					addFieldError("faultloadBean.memoryAddress", "Faultload memory address is required and must be positive!");

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

	private Timestamp getCurrentTimestamp()
	{
		Timestamp currentTimestamp = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());

		return currentTimestamp;
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

	public void setAccessTypes(List<String> accessTypes)
	{
		this.accessTypes = accessTypes;
	}

	public void setAccessCode(String accessCode)
	{
		this.accessCode = accessCode;
	}

	public void setAccessData(String accessData)
	{
		this.accessData = accessData;
	}

	@Override
	public void setSession(Map<String, Object> session)
	{
		this.session = session;
	}
}