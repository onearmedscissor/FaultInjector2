package faultinjector.action;

import java.util.List;

import faultinjector.bean.FaultloadBean;
import faultinjector.entity.Fault;
import faultinjector.entity.FaultClass;
import faultinjector.entity.Faultload;
import faultinjector.entity.HardwareFault;
import faultinjector.entity.HardwareFaultType;

/**
 * This Action class accesses the database and provides the necessary data to populate the <s: radio> tags present in
 * edit_faultload_2.jsp (hardware fault types and fault classes). It also accesses the session HTTP object (Session) and
 * gets the faultload entity instance being edited in edit_faultload_2.jsp.
 * 
 * @author João Fernandes
 * @see struts.xml
 * @see ApplicationSupport
 * @see FaultloadBean
 * @see HardwareFaultType
 * @see FaultClass
 */

public class EditFaultload22 extends ApplicationSupport
{
	private static final long serialVersionUID = 4L;

	private Faultload faultload;
	private List<Fault> faults;
	private List<HardwareFault> hardwareFaults;

	private String id;

	private List<HardwareFaultType> hardwareFaultTypes;
	private List<FaultClass> faultClasses;

	@Override
	public String execute()
	{
		faultload = (Faultload) getSession().get("editFaultload");

		hardwareFaultTypes = this.getExperimentService().findAllHardwareFaultTypes();
		faultClasses = this.getExperimentService().findAllFaultClasses();

		faults = faultload.getFaults();
		hardwareFaults = faults.get(0).getHardwareFaults();

		System.out.println("ID -> " + id);
		System.out.println("EDIT FAULTLOAD [2.2/4]-------------------------------");
		System.out.println("Faultload ID = " + faultload.getFaultloadId());
		System.out.println("Faultload NAME = " + faultload.getName());
		System.out.println("Faultload TIME INTERVAL = " + faultload.getTimeInterval());

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

	public List<Fault> getFaults()
	{
		return faults;
	}

	public List<HardwareFault> getHardwareFaults()
	{
		return hardwareFaults;
	}

	public List<FaultClass> getFaultClasses()
	{
		return faultClasses;
	}

	public int getFaultClassId()
	{
		return getHardwareFaults().get(0).getFaultClass().getFaultClassId();
	}

	public List<HardwareFaultType> getHardwareFaultTypes()
	{
		return hardwareFaultTypes;
	}

	public int getHardwareFaultTypeId()
	{
		return getHardwareFaults().get(0).getHardwareFaultType().getHardwareFaultTypeId();
	}
}
