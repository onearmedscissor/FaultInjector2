package faultinjector.bean;

public class FaultloadBean
{
	private String name, description, triggerType;
	private int timeInterval, hardwareFaultTypeId, memoryFaultRangeStart, memoryFaultRangeEnd, numberFaults, bitsChangeStart, bitsChangeEnd, faultClassId, faultModeId, processId, temporalTriggerStart, temporalTriggerEnd, memoryAddress;
	private boolean readAddress;
	private String[] registerIds;

	public FaultloadBean()
	{
		faultClassId = 0;
		faultModeId = 0;
		hardwareFaultTypeId = 0;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public int getTimeInterval()
	{
		return timeInterval;
	}

	public void setTimeInterval(int timeInterval)
	{
		this.timeInterval = timeInterval;
	}

	public int getMemoryFaultRangeStart()
	{
		return memoryFaultRangeStart;
	}

	public void setMemoryFaultRangeStart(int memoryFaultRangeStart)
	{
		this.memoryFaultRangeStart = memoryFaultRangeStart;
	}

	public int getMemoryFaultRangeEnd()
	{
		return memoryFaultRangeEnd;
	}

	public void setMemoryFaultRangeEnd(int memoryFaultRangeEnd)
	{
		this.memoryFaultRangeEnd = memoryFaultRangeEnd;
	}

	public int getNumberFaults()
	{
		return numberFaults;
	}

	public void setNumberFaults(int numberFaults)
	{
		this.numberFaults = numberFaults;
	}

	public int getBitsChangeStart()
	{
		return bitsChangeStart;
	}

	public void setBitsChangeStart(int bitsChangeStart)
	{
		this.bitsChangeStart = bitsChangeStart;
	}

	public int getBitsChangeEnd()
	{
		return bitsChangeEnd;
	}

	public void setBitsChangeEnd(int bitsChangeEnd)
	{
		this.bitsChangeEnd = bitsChangeEnd;
	}

	public int getHardwareFaultTypeId()
	{
		return hardwareFaultTypeId;
	}

	public void setHardwareFaultTypeId(int hardwareFaultTypeId)
	{
		this.hardwareFaultTypeId = hardwareFaultTypeId;
	}

	public int getFaultClassId()
	{
		return faultClassId;
	}

	public void setFaultClassId(int faultClassId)
	{
		this.faultClassId = faultClassId;
	}

	public int getFaultModeId()
	{
		return faultModeId;
	}

	public void setFaultModeId(int faultModeId)
	{
		this.faultModeId = faultModeId;
	}

	public String[] getRegisterIds()
	{
		return registerIds;
	}

	public void setRegisterIds(String[] registerIds)
	{
		this.registerIds = registerIds;
	}

	public String getTriggerType()
	{
		return triggerType;
	}

	public void setTriggerType(String triggerType)
	{
		this.triggerType = triggerType;
	}

	public int getProcessId()
	{
		return processId;
	}

	public void setProcessId(int processId)
	{
		this.processId = processId;
	}

	public int getTemporalTriggerStart()
	{
		return temporalTriggerStart;
	}

	public void setTemporalTriggerStart(int temporalTriggerStart)
	{
		this.temporalTriggerStart = temporalTriggerStart;
	}

	public int getTemporalTriggerEnd()
	{
		return temporalTriggerEnd;
	}

	public void setTemporalTriggerEnd(int temporalTriggerEnd)
	{
		this.temporalTriggerEnd = temporalTriggerEnd;
	}

	public int getMemoryAddress()
	{
		return memoryAddress;
	}

	public void setMemoryAddress(int memoryAddress)
	{
		this.memoryAddress = memoryAddress;
	}

	public void setReadAddress(boolean readAddress)
	{
		this.readAddress = readAddress;
	}

	public boolean containsRegisterId(String id)
	{
		for (String s : registerIds)
		{
			if (s.equals(id))
				return true;
		}
		return false;
	}
}
