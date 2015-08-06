package faultinjector.action;

import faultinjector.entity.Faultload;
import faultinjector.entity.Register;

/**
 * This Action class accesses the database and gets the faultload with the specified ID, making it available for editing
 * purposes in edit_faultload_1.jsp.
 * 
 * @author João Fernandes
 * @see struts.xml
 * @see ApplicationSupport
 * @see Faultload
 */

public class EditFaultload1 extends ApplicationSupport
{
	private static final long serialVersionUID = 4L;

	private Faultload faultload;
	private int id;

	@Override
	public String execute()
	{
		// if it's the first time we're here
		if (!getSession().containsKey("editFaultload"))
		{
			this.faultload = this.getExperimentService().findFaultload(id);
			this.getSession().put("editFaultload", faultload);
		}
		else
			faultload = (Faultload) getSession().get("editFaultload");

		System.out.println("ID -> " + id);
		System.out.println("EDIT FAULTLOAD [1/5]-------------------------------");
		System.out.println("Faultload ID = " + faultload.getFaultloadId());
		System.out.println("Faultload NAME = " + faultload.getName());
		System.out.println("Faultload TIME INTERVAL = " + faultload.getTimeInterval());

		System.out.println("Faultload HARDWARE FAULT TYPE = " + faultload.getFaults().get(0).getHardwareFaults().get(0).getHardwareFaultType().getName());
		System.out.println("Faultload MEMORY FAULT RANGE = " + faultload.getMemoryRangeBeginning() + " - " + faultload.getMemoryRangeEnd());
		System.out.println("Faultload NUMBER OF FAULTS = " + faultload.getNumberFaults());
		System.out.println("Faultload 1.1 FAULT MODEL____________________________________");
		System.out.println("Faultload FAULT CLASS = " + faultload.getFaults().get(0).getHardwareFaults().get(0).getFaultClass().getName());
		System.out.println("Faultload BITS TO CHANGE = " + faultload.getFaults().get(0).getHardwareFaults().get(0).getBitStart() + " - " + faultload.getFaults().get(0).getHardwareFaults().get(0).getBitEnd());

		for (Register r : faultload.getRegisters())
			System.out.println("Faultload REGISTER: ID = " + r.getRegisterId() + " | NAME = " + r.getName());

		System.out.println("Faultload 2.1 FAULT TRIGGER____________________________________");
		System.out.println("Faultload MODE = " + faultload.getFaults().get(0).getFaultMode().getName());
		System.out.println("Faultload PROCESS ID = " + faultload.getFaults().get(0).getProcessId());
		System.out.println("Faultload 2.2 FAULT TRIGGER TYPE____________________________________");
		System.out.println("Faultload TRIGGER TYPE = " + faultload.getFaults().get(0).getTriggerType());

		switch (faultload.getFaults().get(0).getTriggerType())
		{
			case "tp":
				System.out.println("Faultload TEMPORAL BETWEEN = " + faultload.getFaults().get(0).getTimeStart() + " AND " + faultload.getFaults().get(0).getTimeEnd());
				break;
			case "sc":
				System.out.println("Faultload SPATIAL (CODE SEGMENT) = " + faultload.getFaults().get(0).getReadAddress() + " ON ADDRESS " + faultload.getFaults().get(0).getMemoryAddress());
				break;
			case "sd":
				System.out.println("Faultload SPATIAL (DATA SEGMENT) = " + faultload.getFaults().get(0).getReadAddress() + " ON ADDRESS " + faultload.getFaults().get(0).getMemoryAddress());
				break;
		}

		return SUCCESS;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public Faultload getFaultload()
	{
		return faultload;
	}
}
