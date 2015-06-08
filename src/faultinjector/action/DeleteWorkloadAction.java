package faultinjector.action;

import com.opensymphony.xwork2.ActionSupport;

import faultinjector.service.ExperimentService;

public class DeleteWorkloadAction extends ActionSupport
{
	private static final long serialVersionUID = 4L;
	
	private ExperimentService service;
	
	private int id;
	
	@Override
	public String execute()
    {	
		service = new ExperimentService();
		
		System.out.println("DELETE WORKLOAD ID -> "+id);
		service.deleteWorkload(id);
		
        return SUCCESS;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
}
