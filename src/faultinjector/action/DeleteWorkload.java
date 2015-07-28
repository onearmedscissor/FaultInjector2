package faultinjector.action;

import com.opensymphony.xwork2.ActionSupport;

import faultinjector.service.EclipseLinkPersistence;

public class DeleteWorkload extends ActionSupport
{
	private static final long serialVersionUID = 4L;
	
	private EclipseLinkPersistence service;
	
	private int id;
	
	@Override
	public String execute()
    {	
		service = new EclipseLinkPersistence();
		
		System.out.println("DELETE WORKLOAD ID -> "+id);
		service.deleteWorkload(id);
		
        return SUCCESS;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
}
