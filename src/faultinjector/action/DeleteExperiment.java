package faultinjector.action;

import faultinjector.service.EclipseLinkPersistence;

/**
 * This Action class removes the Experiment entity instance with the specified ID from the database.
 * 
 * @author João Fernandes
 * @see struts.xml
 * @see ApplicationSupport
 * @see EclipseLinkPersistence
 */

public class DeleteExperiment extends ApplicationSupport
{
	private static final long serialVersionUID = 4L;

	private EclipseLinkPersistence service;

	private int id;

	@Override
	public String execute()
	{
		service = new EclipseLinkPersistence();

		System.out.println("DELETE EXPERIMENT ID -> " + id);
		service.deleteExperiment(id);

		return SUCCESS;
	}

	public void setId(int id)
	{
		this.id = id;
	}
}
