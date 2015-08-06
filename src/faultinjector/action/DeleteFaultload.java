package faultinjector.action;

import faultinjector.service.EclipseLinkPersistence;

/**
 * This Action class removes the Faultload entity instance with the specified ID from the database.
 * 
 * @author João Fernandes
 * @see struts.xml
 * @see ApplicationSupport
 * @see EclipseLinkPersistence
 */

public class DeleteFaultload extends ApplicationSupport
{
	private static final long serialVersionUID = 4L;

	private EclipseLinkPersistence service;

	private int id;

	@Override
	public String execute()
	{
		service = new EclipseLinkPersistence();

		System.out.println("DELETE FAULTLOAD ID -> " + id);
		service.deleteFaultload(id);

		return SUCCESS;
	}

	public void setId(int id)
	{
		this.id = id;
	}
}
