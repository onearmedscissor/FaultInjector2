package faultinjector.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import faultinjector.entity.Fault;
import faultinjector.entity.Faultload;
import faultinjector.entity.HardwareFault;
import faultinjector.entity.Register;

public class EditFaultload42Action extends ActionSupport implements SessionAware
{
	private static final long serialVersionUID = 4L;

	private Map<String, Object> session;
	private List<String> accessTypes;
	private Faultload faultload;
	private List<Fault> faults;
	private List<HardwareFault> hardwares;

	public EditFaultload42Action()
	{
		accessTypes = new ArrayList<String>();
		accessTypes.add("read");
		accessTypes.add("write");
	}

	public String execute()
	{
		// if (!session.containsKey("editFaultload"))
		// {
		// this.faultload =
		// this.getExperimentService().findFaultload(Integer.parseInt(id));
		// this.session.put("editFaultload", faultload);
		// }
		// else
		faultload = (Faultload) session.get("editFaultload");

		faults = faultload.getFaults();
		hardwares = faults.get(0).getHardwares();

		System.out.println("EDIT FAULTLOAD [4.2/5]-------------------------------");
		System.out.println("Faultload ID = " + faultload.getFl_id());
		System.out.println("Faultload NAME = " + faultload.getName());
		System.out.println("Faultload TIME INTERVAL = " + faultload.getTime_interval());

		System.out.println("Faultload HARDWARE FAULT TYPE = " + faultload.getFaults().get(0).getHardwares().get(0).getHw_fault_type());
		System.out.println("Faultload MEMORY FAULT RANGE = " + faultload.getMem_range_beg() + " - " + faultload.getMem_range_end());
		System.out.println("Faultload NUMBER OF FAULTS = " + faultload.getN_faults());
		System.out.println("Faultload 1.1 FAULT MODEL____________________________________");
		System.out.println("Faultload FAULT CLASS: IS BIT-FLIP? = " + faultload.getFaults().get(0).getHardwares().get(0).getBit_flip());
		System.out.println("Faultload BITS TO CHANGE = " + faultload.getFaults().get(0).getHardwares().get(0).getBitStart() + " - " + faultload.getFaults().get(0).getHardwares().get(0).getBitEnd());

		for (Register r : faultload.getRegisters())
			System.out.println("Faultload REGISTER: ID = " + r.getReg_id() + " | NAME = " + r.getName());

		return SUCCESS;
	}

	public List<String> getAccessTypes()
	{
		return accessTypes;
	}

	public Faultload getFaultload()
	{
		return faultload;
	}

	public List<Fault> getFaults()
	{
		return faults;
	}

	public List<HardwareFault> getHardwares()
	{
		return hardwares;
	}

	@Override
	public void setSession(Map<String, Object> session)
	{
		this.session = session;
	}
}
