package faultinjector.action;

import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import faultinjector.entity.Faultload;
import faultinjector.service.EclipseLinkPersistence;

public class EditFaultload21 extends ActionSupport implements SessionAware
{
	private static final long serialVersionUID = 4L;

	private Map<String, Object> session;
	private Faultload faultload;
	private EntityManager em;
	private EntityTransaction et;
	private String name, description;
	private int id, timeInterval;

	@Override
	public String execute()
	{
		// if it's the first time we're here
		if (!session.containsKey("et") || !session.containsKey("em"))
		{
			em = this.getExperimentService().getEntityManager();
			et = em.getTransaction();
			et.begin();

			this.session.put("em", em);
			this.session.put("et", et);
		}

		faultload = (Faultload) session.get("editFaultload");

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
			addFieldError("faultload.time_interval", "Faultload time interval is required. It can't be negative nor greater than 60.000 milliseconds!");
	}

	public EclipseLinkPersistence getExperimentService()
	{
		if (!session.containsKey("experimentService"))
		{
			EclipseLinkPersistence experimentService = new EclipseLinkPersistence();

			this.setExperimentService(experimentService);
		}

		return (EclipseLinkPersistence) session.get("experimentService");
	}

	public void setExperimentService(EclipseLinkPersistence experimentService)
	{
		this.session.put("experimentService", experimentService);
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

	@Override
	public void setSession(Map<String, Object> session)
	{
		this.session = session;
	}
}
