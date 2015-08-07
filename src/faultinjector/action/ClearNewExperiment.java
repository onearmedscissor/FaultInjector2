package faultinjector.action;

import java.util.Arrays;

import faultinjector.bean.ExperimentBean;

/**
 * This Action class resets a temporary experiment JavaBean (experimentBean).
 * 
 * @author João Fernandes
 * @see struts.xml
 * @see ApplicationSupport
 * @see ExperimentBean
 */

public class ClearNewExperiment extends ApplicationSupport
{
	private static final long serialVersionUID = 4L;

	private ExperimentBean experimentBean;

	@Override
	public String execute()
	{
		if (getSession().containsKey("experimentBean"))
		{
			experimentBean = (ExperimentBean) getSession().get("experimentBean");

			System.out.println("EXPERIMENT BEAN BEFORE RESET-------------------------------");
			System.out.println("New experiment NAME = " + experimentBean.getName());
			System.out.println("New experiment DESCRIPTION = " + experimentBean.getDescription());
			System.out.println("New experiment SELECTED TARGET ID = " + experimentBean.getTargetId());
			System.out.println("New experiment SELECTED WORKLOAD ID = " + experimentBean.getWorkloadId());
			System.out.println("New experiment SELECTED FAULTLOADS = " + Arrays.toString(experimentBean.getFaultloadIds()));

			experimentBean = new ExperimentBean();
			getSession().put("experimentBean", experimentBean);
		}

		return SUCCESS;
	}
}
