package faultinjector.action;

import faultinjector.bean.ExperimentBean;

public class CreateExperiment3 extends ApplicationSupport
{
	private static final long serialVersionUID = 4L;

	private ExperimentBean experimentBean;
	private int wid;

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

		if (wid != 0)
			experimentBean.setWorkloadId(wid);

		System.out.println("NEW EXPERIMENT 3-------------------------------");
		System.out.println("New experiment NAME = " + experimentBean.getName());
		System.out.println("New experiment DESCRIPTION = " + experimentBean.getDescription());
		System.out.println("New experiment SELECTED TARGET ID = " + experimentBean.getTargetId());
		System.out.println("New experiment SELECTED WORKLOAD ID = " + experimentBean.getWorkloadId());

		return SUCCESS;
	}

	public void setWid(int wid)
	{
		this.wid = wid;
	}
}
