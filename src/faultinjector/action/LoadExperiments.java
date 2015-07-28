package faultinjector.action;

import java.util.List;

import faultinjector.entity.Experiment;

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
