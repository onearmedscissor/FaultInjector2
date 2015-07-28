package faultinjector.action;

import faultinjector.bean.FaultloadBean;

public class CreateFaultload21 extends ApplicationSupport
{
	private static final long serialVersionUID = 4L;

	private FaultloadBean faultloadBean;

	private int hardwareFaultTypeId, memStart, memEnd, numberFaults, faultClassId, bitStart, bitEnd;

	public String execute()
	{
		if (!getSession().containsKey("faultloadBean"))
		{
			this.faultloadBean = new FaultloadBean();
			getSession().put("faultloadBean", faultloadBean);
		}
		else
			faultloadBean = (FaultloadBean) getSession().get("faultloadBean");

		faultloadBean.setHardwareFaultTypeId(hardwareFaultTypeId);
		faultloadBean.setMemoryFaultRangeStart(memStart);
		faultloadBean.setMemoryFaultRangeEnd(memEnd);
		faultloadBean.setNumberFaults(numberFaults);
		faultloadBean.setFaultClassId(faultClassId);
		faultloadBean.setBitsChangeStart(bitStart);
		faultloadBean.setBitsChangeEnd(bitEnd);

		System.out.println("NEW FAULTLOAD 2-------------------------------");
		System.out.println("New faultload NAME = " + faultloadBean.getName());
		System.out.println("New faultload DESCRIPTION = " + faultloadBean.getDescription());
		System.out.println("New faultload TIME INTERVAL = " + faultloadBean.getTimeInterval());

		System.out.println("New faultload HARDWARE FAULT TYPE ID = " + faultloadBean.getHardwareFaultTypeId());
		System.out.println("New faultload MEMORY FAULT RANGE = " + faultloadBean.getMemoryFaultRangeStart() + " - " + faultloadBean.getMemoryFaultRangeEnd());
		System.out.println("New faultload NUMBER OF FAULTS = " + faultloadBean.getNumberFaults());
		System.out.println("New faultload 1.1 FAULT MODEL____________________________________");
		System.out.println("New faultload FAULT CLASS ID = " + faultloadBean.getFaultClassId());
		System.out.println("New faultload BITS TO CHANGE = " + faultloadBean.getBitsChangeStart() + " - " + faultloadBean.getBitsChangeEnd());

		return SUCCESS;
	}

	public void validate()
	{
		if (memStart < 0)
			addFieldError("faultloadBean.memoryFaultRangeStart", "Faultload memory fault range start is required and can't be negative!");

		if (memEnd < 0)
			addFieldError("faultloadBean.memoryFaultRangeEnd", "Faultload memory fault range end is required and can't be negative!");

		if (numberFaults < 0)
			addFieldError("faultloadBean.numberFaults", "Faultload number of faults field is required and can't be negative!");

		if (bitStart < 0 || bitStart > 31)
			addFieldError("faultloadBean.bitsChangeStart", "Faultload bit(s) to change range is required and must be set between 0 and 31!");

		if (bitStart < 0 || bitStart > 31)
			addFieldError("faultloadBean.bitsChangeEnd", "Faultload bit(s) to change range is required and must be set between 0 and 31!");
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

	public FaultloadBean getFaultloadBean()
	{
		return faultloadBean;
	}
}
