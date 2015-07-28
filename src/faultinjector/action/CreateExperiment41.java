package faultinjector.action;

import java.util.Arrays;

import faultinjector.bean.ExperimentBean;

public class CreateExperiment41 extends ApplicationSupport
{
	private static final long serialVersionUID = 4L;

	private ExperimentBean experimentBean;
	private String[] fids;

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

		experimentBean.setFaultloadIds(fids);

		System.out.println("NEW EXPERIMENT 4.1-------------------------------");
		System.out.println("BEAN");
		System.out.println("New experiment NAME = " + experimentBean.getName());
		System.out.println("New experiment DESCRIPTION = " + experimentBean.getDescription());
		System.out.println("New experiment SELECTED TARGET ID = " + experimentBean.getTargetId());
		System.out.println("New experiment SELECTED WORKLOAD ID = " + experimentBean.getWorkloadId());
		System.out.println("New experiment SELECTED FAULTLOAD(S) ID(S) = " + Arrays.toString(experimentBean.getFaultloadIds()));

		return SUCCESS;
	}

	public void setFids(String[] fids)
	{
		this.fids = fids;
	}
}
