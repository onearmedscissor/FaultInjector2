package faultinjector.action;

import java.util.List;

import faultinjector.entity.Target;

public class LoadTargets extends ApplicationSupport
{
	private static final long serialVersionUID = 4L;

	private List<Target> targets;

	@Override
	public String execute()
	{
		this.targets = this.getExperimentService().findAllTargets();

		System.out.println("LOAD TARGETS-------------------------------");

		for (Target t : this.targets)
		{
			System.out.println();
			System.out.println("Target ID = " + t.getTargetId());
			System.out.println("Target NAME = " + t.getName());
			System.out.println("Target ARCHITECTURE = " + t.getArchitecture().getName());
			System.out.println("Target IP = " + t.getIp());
			System.out.println("Target OPERATING SYSTEM = " + t.getOperatingSystem());
		}

		return SUCCESS;
	}

	public List<Target> getTargets()
	{
		return targets;
	}
}
