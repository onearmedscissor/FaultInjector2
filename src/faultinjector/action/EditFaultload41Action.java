package faultinjector.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import faultinjector.entity.Faultload;
import faultinjector.entity.Register;
import faultinjector.service.ExperimentService;

public class EditFaultload41Action extends ActionSupport implements SessionAware
{
	private static final long serialVersionUID = 4L;

	private Map<String, Object> session;
	private Faultload faultload;
	private String[] rids;
	List<Register> regs;

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

		regs = new ArrayList<Register>();

		for (String s : rids)
		{
			Register r = this.getExperimentService().findRegister(Integer.parseInt(s));

			regs.add(r);
		}

		faultload.setRegisters(regs);

		// System.out.println("ID -> " + id);
		System.out.println("EDIT FAULTLOAD [4.1/5]-------------------------------");
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

	public ExperimentService getExperimentService()
	{
		if (!session.containsKey("experimentService"))
		{
			ExperimentService experimentService = new ExperimentService();

			this.setExperimentService(experimentService);
		}

		return (ExperimentService) session.get("experimentService");
	}

	public void setExperimentService(ExperimentService experimentService)
	{
		this.session.put("experimentService", experimentService);
	}

	public void setRids(String[] rids)
	{
		this.rids = rids;
	}

	@Override
	public void setSession(Map<String, Object> session)
	{
		this.session = session;
	}
}
