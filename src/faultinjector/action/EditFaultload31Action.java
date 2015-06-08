package faultinjector.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import faultinjector.entity.Faultload;
import faultinjector.service.ExperimentService;

public class EditFaultload31Action extends ActionSupport implements SessionAware
{
	private static final long serialVersionUID = 4L;

	private Map<String, Object> session;
	private Faultload faultload;

	private String id;
	private char hardwareFaultType;
	private boolean faultClass;
	private int memStart, memEnd, numberFaults, bitStart, bitEnd;

	public String execute()
	{
		if (!session.containsKey("editFaultload"))
		{
			this.faultload = this.getExperimentService().findFaultload(Integer.parseInt(id));
			this.session.put("editFaultload", faultload);
		}
		else
			faultload = (Faultload) session.get("editFaultload");

		faultload.getFaults().get(0).getHardwares().get(0).setHw_fault_type(hardwareFaultType);
		faultload.setMem_range_beg(memStart);
		faultload.setMem_range_end(memEnd);
		faultload.setN_faults(numberFaults);
		faultload.getFaults().get(0).getHardwares().get(0).setBit_flip(faultClass);
		faultload.getFaults().get(0).getHardwares().get(0).setBitStart(bitStart);
		faultload.getFaults().get(0).getHardwares().get(0).setBitEnd(bitEnd);

		// faultload.setHardwareFaultType(hardwareFaultType);
		// faultload.setMemoryFaultRangeStart(memStart);
		// faultload.setMemoryFaultRangeEnd(memEnd);
		// faultload.setNumberFaults(numberFaults);
		// faultload.setBitFlip(faultClass);
		// faultload.setBitsChangeStart(bitStart);
		// faultload.setBitsChangeEnd(bitEnd);

		System.out.println("ID -> " + id);
		System.out.println("EDIT FAULTLOAD [3.1/4]-------------------------------");
		System.out.println("Faultload ID = " + faultload.getFl_id());
		System.out.println("Faultload NAME = " + faultload.getName());
		System.out.println("Faultload TIME INTERVAL = " + faultload.getTime_interval());

		System.out.println("Faultload HARDWARE FAULT TYPE = " + faultload.getFaults().get(0).getHardwares().get(0).getHw_fault_type());
		System.out.println("Faultload MEMORY FAULT RANGE = " + faultload.getMem_range_beg() + " - " + faultload.getMem_range_end());
		System.out.println("Faultload NUMBER OF FAULTS = " + faultload.getN_faults());
		System.out.println("Faultload 1.1 FAULT MODEL____________________________________");
		System.out.println("Faultload FAULT CLASS: IS BIT-FLIP? = " + faultload.getFaults().get(0).getHardwares().get(0).getBit_flip());
		System.out.println("Faultload BITS TO CHANGE = " + faultload.getFaults().get(0).getHardwares().get(0).getBitStart() + " - " + faultload.getFaults().get(0).getHardwares().get(0).getBitEnd());

		return SUCCESS;
	}

	public void validate()
	{
		if (memStart < 0)
			addFieldError("faultload.mem_range_beg", "Faultload memory fault range start is required and can't be negative!");

		if (memEnd < 0)
			addFieldError("faultload.mem_range_end", "Faultload memory fault range end is required and can't be negative!");

		if (numberFaults < 0)
			addFieldError("faultload.n_faults", "Faultload number of faults field is required and can't be negative!");

		if (bitStart < 0 || bitStart > 31)
			addFieldError("hardwareFault.bitStart", "Faultload bit(s) to change range is required and must be set between 0 and 31!");

		if (bitStart < 0 || bitStart > 31)
			addFieldError("hardwareFault.bitEnd", "Faultload bit(s) to change range is required and must be set between 0 and 31!");
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

	public void setHardwareFaultType(char hardwareFaultType)
	{
		this.hardwareFaultType = hardwareFaultType;
	}

	public void setFaultClass(boolean faultClass)
	{
		this.faultClass = faultClass;
	}

	public void setMemStart(int memStart)
	{
		this.memStart = memStart;
	}

	public void setMemEnd(int memEnd)
	{
		this.memEnd = memEnd;
	}

	public void setNumberFaults(int numberFaults)
	{
		this.numberFaults = numberFaults;
	}

	public void setBitStart(int bitStart)
	{
		this.bitStart = bitStart;
	}

	public void setBitEnd(int bitEnd)
	{
		this.bitEnd = bitEnd;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	@Override
	public void setSession(Map<String, Object> session)
	{
		this.session = session;
	}
}
