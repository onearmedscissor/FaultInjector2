package faultinjector.action;

import java.util.List;

import faultinjector.entity.Experiment;

/**
 * This Action class accesses the database and provides the necessary data to display a list of the available
 * experiments in user_main.jsp.
 * 
 * @author João Fernandes
 * @see struts.xml
 * @see ApplicationSupport
 * @see Experiment
 */

public class LoadExperiments extends ApplicationSupport
{
	private static final long serialVersionUID = 4L;

	private List<Experiment> experiments;

	@Override
	public String execute()
	{
		this.experiments = this.getExperimentService().findAllExperiments();

		System.out.println("LOAD EXPERIMENTS-------------------------------");

		for (Experiment e : this.experiments)
		{
			System.out.println();
			System.out.println("Experiment ID = " + e.getExperimentId());
			System.out.println("Experiment NAME = " + e.getName());
		}

		return SUCCESS;
	}

	public List<Experiment> getExperiments()
	{
		return experiments;
	}

	public void setExperiments(List<Experiment> experiments)
	{
		this.experiments = experiments;
	}
}
