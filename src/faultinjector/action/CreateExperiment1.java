package faultinjector.action;

import faultinjector.bean.ExperimentBean;

/**
 * This Action class validates and applies the form data input submitted in new_experiment_1.jsp (experiment name and
 * description) to a temporary experiment JavaBean.
 * 
 * @author João Fernandes
 * @see struts.xml
 * @see ApplicationSupport
 * @see ExperimentBean
 */

public class CreateExperiment1 extends ApplicationSupport
{
	private static final long serialVersionUID = 4L;

	private ExperimentBean experimentBean;
	private String name, description;

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

		experimentBean.setName(name);
		experimentBean.setDescription(description);

		System.out.println("NEW EXPERIMENT 1-------------------------------");
		System.out.println("New experiment NAME = " + experimentBean.getName());
		System.out.println("New experiment DESCRIPTION = " + experimentBean.getDescription());

		return SUCCESS;
	}

	public void validate()
	{
		if (name == null || name.length() == 0 || name.length() > 50)
			addFieldError("experimentBean.name", "Experiment name is required and can't have more than 50 characters!");

		if (description == null || description.length() == 0 || description.length() > 300)
			addFieldError("experimentBean.description", "Experiment description is required  and can't have more than 300 characters!");
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}
}