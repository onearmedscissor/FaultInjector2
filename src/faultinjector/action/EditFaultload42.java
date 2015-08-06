package faultinjector.action;

import java.util.List;

import faultinjector.entity.Fault;
import faultinjector.entity.FaultMode;
import faultinjector.entity.Faultload;
import faultinjector.entity.HardwareFault;
import faultinjector.entity.Register;

/**
 * This Action class accesses the database and provides the necessary data to populate the <s: radio> tag present in
 * edit_faultload_4.jsp with the available fault modes. It also accesses the session HTTP object (Session) and gets the
 * faultload entity instance being edited in edit_faultload_4.jsp.
 * 
 * @author João Fernandes
 * @see struts.xml
 * @see ApplicationSupport
 * @see Faultload
 * @see HardwareFault
 * @see Fault
 * @see FaultMode
 */

public class EditFaultload42 extends ApplicationSupport
{
	private static final long serialVersionUID = 4L;

	private Faultload faultload;
	private List<Fault> faults;
	private List<HardwareFault> hardwareFaults;
	private List<FaultMode> faultModes;

	public String execute()
	{
		faultModes = this.getExperimentService().findAllFaultModes();

		faultload = (Faultload) getSession().get("editFaultload");

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

	public List<FaultMode> getFaultModes()
	{
		return faultModes;
	}

	public int getFaultModeId()
	{
		return getHardwareFaults().get(0).getFaultMode().getFaultModeId();
	}
}
