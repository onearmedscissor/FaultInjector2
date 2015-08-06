package faultinjector.action;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import faultinjector.entity.Faultload;

/**
 * This Action class validates and applies the form data input submitted in edit_faultload_1.jsp (faultload name,
 * description and time interval) to the faultload entity instance being edited, accessible via the session HTTP object
 * (Session), after starting a new database entity transaction.
 * 
 * @author João Fernandes
 * @see struts.xml
 * @see ApplicationSupport
 * @see Faultload
 */

public class EditFaultload21 extends ApplicationSupport
{
	private static final long serialVersionUID = 4L;

	private Faultload faultload;
	private EntityManager em;
	private EntityTransaction et;
	private String name, description;
	private int id, timeInterval;

	@Override
	public String execute()
	{
		// if it's the first time we're here
		if (!getSession().containsKey("et") || !getSession().containsKey("em"))
		{
			em = this.getExperimentService().getEntityManager();
			et = em.getTransaction();
			et.begin();

			this.getSession().put("em", em);
			this.getSession().put("et", et);
		}

		faultload = (Faultload) getSession().get("editFaultload");

		faultload.setName(name);
		faultload.setDescription(description);
		faultload.setTimeInterval(timeInterval);

		System.out.println("ID -> " + id);
		System.out.println("EDIT FAULTLOAD [2.1/4]-------------------------------");
		System.out.println("Faultload ID = " + faultload.getFaultloadId());
		System.out.println("Faultload NAME = " + faultload.getName());
		System.out.println("Faultload TIME INTERVAL = " + faultload.getTimeInterval());

		return SUCCESS;
	}

	public void validate()
	{
		if (name == null || name.length() == 0 || name.length() > 50)
			addFieldError("faultload.name", "Faultload name is required and can't have more than 50 characters!");

		if (description == null || description.length() == 0 || description.length() > 300)
			addFieldError("faultload.description", "Faultload description is required and can't have more than 300 characters!");

		if (timeInterval < 0 || timeInterval > 60000)
			addFieldError("faultload.timeInterval", "Faultload time interval is required. It can't be negative nor greater than 60.000 milliseconds!");
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public int getId()
	{
		return id;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public void setTimeInterval(int timeInterval)
	{
		this.timeInterval = timeInterval;
	}

	public Faultload getFaultload()
	{
		return faultload;
	}
}
