package faultinjector.action;

import java.util.List;

import faultinjector.entity.Architecture;

public class LoadArchitectures extends ApplicationSupport
{
	private static final long serialVersionUID = 4L;

	private List<Architecture> architectures;

	public String execute()
	{
		architectures = this.getExperimentService().findAllArchitectures();

		return SUCCESS;
	}

	public List<Architecture> getArchitectures()
	{
		return architectures;
	}

	public int getDefaultArchitectureId()
	{
		return architectures.get(0).getArchitectureId();
	}
}
