package faultinjector.action;

import java.util.List;

import faultinjector.entity.InjectionRun;
import faultinjector.entity.Workload;

public class LoadWorkloads extends ApplicationSupport
{
	private static final long serialVersionUID = 4L;

	private List<Workload> workloads;
	private List<InjectionRun> injectionRuns;

	@Override
	public String execute()
	{
		this.workloads = this.getExperimentService().findAllWorkloads();

		System.out.println("LOAD WORKLOADS-------------------------------");

		for (Workload w : this.workloads)
		{
			System.out.println();
			System.out.println("Workload ID = " + w.getWorkloadId());
			System.out.println("Workload NAME = " + w.getName());

			for (int n = 0; n < w.getApplications().size(); n++)
			{
				System.out.println("Workload APP " + (n + 1) + " NAME = " + w.getApplications().get(n).getName());
			}

			injectionRuns = w.getInjectionRuns();

			for (InjectionRun i : injectionRuns)
			{
				if (i.getFaultload() != null)
					System.out.println("Workload FAULTLOAD NAME = " + i.getFaultload().getName());

				System.out.println("Workload OUTPUT FILENAME = " + i.getOutputFilename());
			}

			System.out.println("Workload TARGET NAME = " + w.getTarget().getName());
		}

		return SUCCESS;
	}

	public List<Workload> getWorkloads()
	{
		return workloads;
	}
}
