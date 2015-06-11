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
import faultinjector.entity.Faultload;
import faultinjector.entity.HardwareFault;
import faultinjector.entity.Register;
import faultinjector.service.ExperimentService;

public class CreateFaultload4Action extends ActionSupport implements SessionAware
{
	private static final long serialVersionUID = 4L;

	private Map<String, Object> session;
	private ExperimentBean experimentBean;
	private FaultloadBean faultloadBean;
	private boolean faultMode;
	private int processId, timeStart, timeEnd, codeAddress, dataAddress;
	private String triggerType, accessCode, accessData;
	private List<String> accessTypes;
	private int id;

	// public CreateFaultload4Action()
	// {
	// accessTypes = new ArrayList<String>();
	// accessTypes.add("read");
	// accessTypes.add("write");
	// }

	public String execute()
	{
		/* 1. First, finish creating a new experiment */

		if (!session.containsKey("experimentBean"))
		{
			this.experimentBean = new ExperimentBean();
			session.put("experimentBean", experimentBean);
		}
		else
			experimentBean = (ExperimentBean) session.get("experimentBean");

		// experimentBean.setFaultloadIds(fids);



		// for (int n = 0; n < fids.length; n++)
		// {
		// Faultload f =
		// this.getExperimentService().findFaultload(Integer.parseInt(fids[n]));
		//
		// experiment.addFaultload(f);
		// }

		/*
		 * 2. Then, assign the newly created experiment to the new faultload being created, and then finish creating it
		 */

		if (!session.containsKey("faultloadBean"))
		{
			this.faultloadBean = new FaultloadBean();
			session.put("faultloadBean", faultloadBean);
		}
		else
			faultloadBean = (FaultloadBean) session.get("faultloadBean");

		// faultloadBean.setKernelMode(faultMode);
		// faultloadBean.setProcessId(processId);
		// faultloadBean.setTriggerType(triggerType);
		//
		// switch (triggerType)
		// {
		// case "tp":
		// {
		// faultloadBean.setTemporalTriggerStart(timeStart);
		// faultloadBean.setTemporalTriggerEnd(timeEnd);
		// }
		// break;
		// case "sc":
		// {
		// if (accessCode.equals("write"))
		// faultloadBean.setReadAddress(false);
		// else
		// faultloadBean.setReadAddress(true);
		//
		// faultloadBean.setMemoryAddress(codeAddress);
		// }
		// break;
		// case "sd":
		// {
		// if (accessData.equals("write"))
		// faultloadBean.setReadAddress(false);
		// else
		// faultloadBean.setReadAddress(true);
		//
		// faultloadBean.setMemoryAddress(dataAddress);
		// }
		// break;
		// }

		Faultload faultload = new Faultload();

		faultload.setName(faultloadBean.getName());
		faultload.setDescription(faultloadBean.getDescription());
		faultload.setTime_interval(faultloadBean.getTimeInterval());

		if (faultloadBean.getHardwareFaultType() == 'm')
		{
			faultload.setMem_range_beg(faultloadBean.getMemoryFaultRangeStart());
			faultload.setMem_range_end(faultloadBean.getMemoryFaultRangeEnd());
		}

		faultload.setN_faults(faultloadBean.getNumberFaults());

		String[] registers = faultloadBean.getRegisterIds();
		List<Register> regs = new ArrayList<Register>();

		for (String s : registers)
		{
			Register r = this.getExperimentService().findRegister(Integer.parseInt(s));

			// faultload.addRegister(r);

			regs.add(r);
		}

		faultload.setRegisters(regs);

		HardwareFault hardwareFault = new HardwareFault();
		hardwareFault.setHw_fault_type(faultloadBean.getHardwareFaultType());
		hardwareFault.setBit_flip(faultloadBean.getBitFlip());
		hardwareFault.setBitStart(faultloadBean.getBitsChangeStart());
		hardwareFault.setBitEnd(faultloadBean.getBitsChangeEnd());
		hardwareFault.setKernel_mode(faultMode);
		hardwareFault.setPid(processId);
		hardwareFault.setTrigger_type(triggerType);

		switch (hardwareFault.getTrigger_type())
		{
			case "tp":
			{
				hardwareFault.setTime_start(timeStart);
				hardwareFault.setTime_end(timeEnd);
			}
				break;
			case "sc":
			{
				if (accessCode.equals("write"))
					hardwareFault.setRead_address(false);
				else
					hardwareFault.setRead_address(true);

				hardwareFault.setMem_address(codeAddress);
			}
				break;
			case "sd":
			{
				if (accessData.equals("write"))
					hardwareFault.setRead_address(false);
				else
					hardwareFault.setRead_address(true);

				hardwareFault.setMem_address(dataAddress);
			}
				break;
		}

		hardwareFault.setCreation_date(getCurrentTimestamp());
		faultload.addFault(hardwareFault);

		// this.getExperimentService().createExperiment(experiment);

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
		System.out.println("New faultload TIME INTERVAL = " + faultload.getTime_interval());

		System.out.println("New faultload HARDWARE FAULT TYPE = " + hardwareFault.getHw_fault_type());
		System.out.println("New faultload MEMORY FAULT RANGE = " + faultload.getMem_range_beg() + " - " + faultload.getMem_range_end());
		System.out.println("New faultload NUMBER OF FAULTS = " + faultload.getN_faults());
		System.out.println("New faultload 1.1 FAULT MODEL____________________________________");
		System.out.println("New faultload FAULT CLASS: IS BIT-FLIP? = " + hardwareFault.getBit_flip());
		System.out.println("New faultload BITS TO CHANGE = " + hardwareFault.getBitStart() + " - " + hardwareFault.getBitEnd());
		System.out.println("New faultload SELECTED REGISTER(S) ID(S) = " + faultload.getRegisters());

		System.out.println("New faultload 2.1 FAULT TRIGGER____________________________________");
		System.out.println("New faultload MODE: KERNEL? = " + hardwareFault.getKernel_mode());
		System.out.println("New faultload PROCESS ID = " + hardwareFault.getPid());
		System.out.println("New faultload 2.2 FAULT TRIGGER TYPE____________________________________");
		System.out.println("New faultload TRIGGER TYPE = " + hardwareFault.getTrigger_type());

		switch (hardwareFault.getTrigger_type())
		{
			case "tp":
				System.out.println("New faultload TEMPORAL BETWEEN = " + hardwareFault.getTime_start() + " AND " + hardwareFault.getTime_end());
				break;
			case "sc":
				System.out.println("New faultload SPATIAL (CODE SEGMENT) = " + hardwareFault.getRead_address() + " ON ADDRESS " + hardwareFault.getMem_address());
				break;
			case "sd":
				System.out.println("New faultload SPATIAL (DATA SEGMENT) = " + hardwareFault.getRead_address() + " ON ADDRESS " + hardwareFault.getMem_address());
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