package faultinjector.action;

import java.util.List;

import faultinjector.entity.Architecture;

/**
 * This Action class accesses the database and provides the necessary data to populate the <s: radio> tag present in
 * new_target.jsp with the available architectures.
 * 
 * @author João Fernandes
 * @see struts.xml
 * @see ApplicationSupport
 * @see Architecture
 */

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
