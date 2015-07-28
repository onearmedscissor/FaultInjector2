package faultinjector.action;

import java.util.ArrayList;
import java.util.List;

import faultinjector.entity.Fault;
import faultinjector.entity.FaultMode;
import faultinjector.entity.Faultload;
import faultinjector.entity.HardwareFault;
import faultinjector.entity.Register;

public class EditFaultload42 extends ApplicationSupport
{
	private static final long serialVersionUID = 4L;

	private Faultload faultload;
	private List<Fault> faults;
	private List<HardwareFault> hardwareFaults;
	private List<String> accessTypes;
	private List<FaultMode> faultModes;
	private static final String read = "read", write = "write";

	public EditFaultload42()
	{
		accessTypes = new ArrayList<String>();
		accessTypes.add(read);
		accessTypes.add(write);
	}

	public String execute()
	{
		faultload = (Faultload) getSession().get("editFaultload");

		faultModes = this.getExperimentService().findAllFaultModes();

		faults = faultload.getFaults();
		hardwareFaults = faults.get(0).getHardwareFaults();

		System.out.println("EDIT FAULTLOAD [4.2/5]-------------------------------");
		System.out.println("Faultload ID = " + faultload.getFaultloadId());
		System.out.println("Faultload NAME = " + faultload.getName());
		System.out.println("Faultload TIME INTERVAL = " + faultload.getTimeInterval());

		System.out.println("Faultload HARDWARE FAULT TYPE = " + faultload.getFaults().get(0).getHardwareFaults().get(0).getHardwareFaultType().getName());
		System.out.println("Faultload MEMORY FAULT RANGE = " + faultload.getMemoryRangeBeginning() + " - " + faultload.getMemoryRangeEnd());
		System.out.println("Faultload NUMBER OF FAULTS = " + faultload.getNumberFaults());
		System.out.println("Faultload 1.1 FAULT MODEL____________________________________");
		System.out.println("Faultload FAULT CLASS: IS BIT-FLIP? = " + faultload.getFaults().get(0).getHardwareFaults().get(0).getFaultClass().getName());
		System.out.println("Faultload BITS TO CHANGE = " + faultload.getFaults().get(0).getHardwareFaults().get(0).getBitStart() + " - " + faultload.getFaults().get(0).getHardwareFaults().get(0).getBitEnd());

		for (Register r : faultload.getRegisters())
			System.out.println("Faultload REGISTER: ID = " + r.getRegisterId() + " | NAME = " + r.getName());

		return SUCCESS;
	}

	public Faultload getFaultload()
	{
		return faultload;
	}

	public List<Fault> getFaults()
	{
		return faults;
	}

	public List<HardwareFault> getHardwareFaults()
	{
		return hardwareFaults;
	}

	public List<String> getAccessTypes()
	{
		return accessTypes;
	}

	public List<FaultMode> getFaultModes()
	{
		return faultModes;
	}

	public int getFaultModeId()
	{
		return getHardwareFaults().get(0).getFaultMode().getFaultModeId();
	}
}
