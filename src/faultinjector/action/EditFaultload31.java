package faultinjector.action;

import faultinjector.entity.FaultClass;
import faultinjector.entity.Faultload;
import faultinjector.entity.HardwareFaultType;

/**
 * This Action class validates and applies the form data input submitted in edit_faultload_2.jsp (faultload hardware
 * fault type ID, memory fault range, number of faults, fault class ID and bit(s) to change range) to the faultload
 * entity instance being edited, accessible via the session HTTP object (Session).
 * 
 * @author João Fernandes
 * @see struts.xml
 * @see ApplicationSupport
 * @see Faultload
 */

public class EditFaultload31 extends ApplicationSupport
{
	private static final long serialVersionUID = 4L;

	private Faultload faultload;

	private int id, hardwareFaultTypeId, memoryStart, memoryEnd, numberFaults, faultClassId, bitStart, bitEnd;

	public String execute()
	{
		faultload = (Faultload) getSession().get("editFaultload");

		HardwareFaultType hft = this.getExperimentService().findHardwareFaultType(hardwareFaultTypeId);
		hft.addHardwareFault(faultload.getFaults().get(0).getHardwareFaults().get(0));

		faultload.setMemoryRangeBeginning(memoryStart);
		faultload.setMemoryRangeEnd(memoryEnd);
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
		if (memoryStart < 0)
			addFieldError("faultload.memoryRangeBeginning", "Faultload memory fault range start is required and can't be negative!");

		if (memoryEnd < 0)
			addFieldError("faultload.memoryRangeEnd", "Faultload memory fault range end is required and can't be negative!");

		if (numberFaults < 0)
			addFieldError("faultload.numberFaults", "Faultload number of faults field is required and can't be negative!");

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

	public void setMemoryStart(int memoryStart)
	{
		this.memoryStart = memoryStart;
	}

	public void setMemoryEnd(int memoryEnd)
	{
		this.memoryEnd = memoryEnd;
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

	public void setId(int id)
	{
		this.id = id;
	}
}
