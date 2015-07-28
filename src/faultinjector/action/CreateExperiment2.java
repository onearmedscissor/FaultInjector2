package faultinjector.action;

import faultinjector.bean.ExperimentBean;

public class CreateExperiment2 extends ApplicationSupport
{
	private static final long serialVersionUID = 4L;

	private ExperimentBean experimentBean;
	private int tid;

	@Override
	public String execute()
	{
		if (!getSession().containsKey("experimentBean"))
		{
			this.experimentBean = new ExperimentBean();
			getSession().put("experimentBean", experimentBean);
		}
		else
			experimentBean = (ExperimentBean) getSession().get("experimentBean");

		if (tid != 0)
			experimentBean.setTargetId(tid);

		System.out.println("NEW EXPERIMENT 2-------------------------------");
		System.out.println("New experiment NAME = " + experimentBean.getName());
		System.out.println("New experiment DESCRIPTION = " + experimentBean.getDescription());
		System.out.println("New experiment SELECTED TARGET ID = " + experimentBean.getTargetId());

		return SUCCESS;
	}

	public void setTid(int tid)
	{
		this.tid = tid;
	}
}
