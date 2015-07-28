package faultinjector.action;

import faultinjector.entity.FaultClass;
import faultinjector.entity.Faultload;
import faultinjector.entity.HardwareFaultType;

public class EditFaultload31 extends ApplicationSupport
{
	private static final long serialVersionUID = 4L;

	private Faultload faultload;

	private String id;
	private int hardwareFaultTypeId, memStart, memEnd, numberFaults, faultClassId, bitStart, bitEnd;

	public String execute()
	{
		faultload = (Faultload) getSession().get("editFaultload");

		HardwareFaultType hft = this.getExperimentService().findHardwareFaultType(hardwareFaultTypeId);
		hft.addHardwareFault(faultload.getFaults().get(0).getHardwareFaults().get(0));

		faultload.setMemoryRangeBeginning(memStart);
		faultload.setMemoryRangeEnd(memEnd);
		faultload.setNumberFaults(numberFaults);

		FaultClass fc = this.getExperimentService().findFaultClass(faultClassId);
		fc.addFault(faultload.getFaults().get(0).getHardwareFaults().get(0));

		faultload.getFaults().get(0).getHardwareFaults().get(0).setBitStart(bitStart);
		faultload.getFaults().get(0).getHardwareFaults().get(0).setBitEnd(bitEnd);

		System.out.println("ID -> " + id);
		System.out.println("EDIT FAULTLOAD [3.1/4]-------------------------------");
		System.out.println("Faultload ID = " + faultload.getFaultloadId());
		System.out.println("Faultload NAME = " + faultload.getName());
		System.out.println("Faultload TIME INTERVAL = " + faultload.getTimeInterval());

		System.out.println("Faultload HARDWARE FAULT TYPE = " + faultload.getFaults().get(0).getHardwareFaults().get(0).getHardwareFaultType().getName());
		System.out.println("Faultload MEMORY FAULT RANGE = " + faultload.getMemoryRangeBeginning() + " - " + faultload.getMemoryRangeEnd());
		System.out.println("Faultload NUMBER OF FAULTS = " + faultload.getNumberFaults());
		System.out.println("Faultload 1.1 FAULT MODEL____________________________________");
		System.out.println("Faultload FAULT CLASS = " + faultload.getFaults().get(0).getHardwareFaults().get(0).getFaultClass().getName());
		System.out.println("Faultload BITS TO CHANGE = " + faultload.getFaults().get(0).getHardwareFaults().get(0).getBitStart() + " - " + faultload.getFaults().get(0).getHardwareFaults().get(0).getBitEnd());

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

	public void setHardwareFaultTypeId(int hardwareFaultTypeId)
	{
		this.hardwareFaultTypeId = hardwareFaultTypeId;
	}

	public void setFaultClassId(int faultClassId)
	{
		this.faultClassId = faultClassId;
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
}
