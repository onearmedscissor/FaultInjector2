package faultinjector.action;

import com.opensymphony.xwork2.ActionSupport;

import faultinjector.service.ExperimentService;

public class DeleteExperimentAction extends ActionSupport
{
	private static final long serialVersionUID = 4L;
	
	private ExperimentService service;
	
	private int id;
	
	@Override
	public String execute()
    {	
		service = new ExperimentService();
		
		System.out.println("DELETE EXPERIMENT ID -> "+id);
		service.deleteExperiment(id);
		
        return SUCCESS;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
}
