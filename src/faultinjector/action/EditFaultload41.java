package faultinjector.action;

import java.util.ArrayList;
import java.util.List;

import faultinjector.entity.Faultload;
import faultinjector.entity.Register;

public class EditFaultload41 extends ApplicationSupport
{
	private static final long serialVersionUID = 4L;

	private Faultload faultload;
	private String[] rids;
	List<Register> regs;

	public String execute()
	{
		faultload = (Faultload) getSession().get("editFaultload");

		regs = new ArrayList<Register>();

		for (String s : rids)
		{
			Register r = this.getExperimentService().findRegister(Integer.parseInt(s));

			regs.add(r);
		}

		faultload.setRegisters(regs);

		System.out.println("EDIT FAULTLOAD [4.1/5]-------------------------------");
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

		return SUCCESS;
	}

	public void setRids(String[] rids)
	{
		this.rids = rids;
	}
}
