package faultinjector.action;

import java.util.List;

import faultinjector.entity.Faultload;
import faultinjector.entity.Register;

/**
 * This Action class accesses the database and provides the necessary data to display a list of the available registers
 * in edit_faultload_3.jsp. It also accesses the session HTTP object (Session) and gets the faultload entity instance
 * being edited in edit_faultload_3.jsp.
 * 
 * @author João Fernandes
 * @see struts.xml
 * @see ApplicationSupport
 * @see Faultload
 * @see Register
 */

public class EditFaultload32 extends ApplicationSupport
{
	private static final long serialVersionUID = 4L;

	private Faultload faultload;
	private List<Register> registers;

	private String id;

	public String execute()
	{
		this.registers = this.getExperimentService().findAllRegisters();

		faultload = (Faultload) getSession().get("editFaultload");

		System.out.println("ID -> " + id);
		System.out.println("EDIT FAULTLOAD [3.2/4]-------------------------------");
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

	public void setId(String id)
	{
		this.id = id;
	}

	public Faultload getFaultload()
	{
		return faultload;
	}

	public List<Register> getRegisters()
	{
		return registers;
	}
}
