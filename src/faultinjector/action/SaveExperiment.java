package faultinjector.action;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import faultinjector.entity.Experiment;
import faultinjector.entity.Faultload;
import faultinjector.entity.InjectionRun;

/**
 * This Action class validates and applies the form data input submitted in edit_experiment.jsp to the experiment entity
 * instance being edited, accessible via the session HTTP object (Session), after starting a new database entity
 * transaction. Finally, it persists the changes made to the experiment entity into the database.
 * 
 * @author João Fernandes
 * @see struts.xml
 * @see ApplicationSupport
 * @see Experiment
 * @see Faultload
 * @see InjectionRun
 */

public class SaveExperiment extends ApplicationSupport
{
	private static final long serialVersionUID = 4L;

	private Experiment experiment;
	private EntityManager em;
	private EntityTransaction et;
	private List<Faultload> faultloads;
	private Faultload faultload;
	private List<InjectionRun> injectionRuns;
	private InjectionRun injectionRun;

	private int id;
	private String name, creatorName, targetName, workloadName, faultloadName, outputFilename, description;

	@Override
	public String execute()
	{
		System.out.println("SAVE EXPERIMENT ID HIDDEN FORM VALUE FIELD -> " + id);

		em = this.getExperimentService().getEntityManager();
		et = em.getTransaction();
		et.begin();

		experiment = this.getExperimentService().findExperiment(id);

		experiment.setName(name);

		experiment.getTarget().setName(targetName);

		faultloads = experiment.getFaultloads();
		if (!faultloads.isEmpty())
		{
			faultload = faultloads.get(0);
			injectionRuns = faultload.getInjectionRuns();
			if (!injectionRuns.isEmpty())
			{
				injectionRun = injectionRuns.get(0);
				injectionRun.getWorkload().setName(workloadName);
			}

			faultload.setName(faultloadName);
		}

		experiment.setDescription(description);

		et.commit();
		em.close();

		System.out.println("SAVE EXPERIMENT-------------------------------");
		System.out.println("Experiment ID = " + experiment.getExperimentId());
		System.out.println("Experiment NAME = " + experiment.getName());
		System.out.println("Experiment TARGET NAME = " + experiment.getTarget().getName());
		System.out.println("Experiment CREATION DATE = " + experiment.getCreationDate());

		if (experiment.getUser() != null)
			System.out.println("Experiment CREATOR NAME = " + experiment.getUser().getName());

		for (Faultload f : faultloads)
		{
			injectionRuns = f.getInjectionRuns();

			System.out.println("Experiment FAULTLOAD NAME = " + f.getName());

			for (InjectionRun i : injectionRuns)
			{
				System.out.println("Faultload WORKLOAD NAME = " + i.getWorkload().getName());
				System.out.println("Faultload OUTPUT FILENAME = " + i.getOutputFilename());
			}
		}

		System.out.println("Experiment DESCRIPTION = " + experiment.getDescription());

		return SUCCESS;
	}

	public void validate()
	{
		System.out.println("SAVE EXPERIMENT VALIDATE ID -> " + id);

		if (name == null || name.length() == 0 || name.length() > 50)
			addFieldError("experiment.name", "Experience name is required and can't have more than 50 characters!");

		if (targetName == null || targetName.length() == 0 || targetName.length() > 50)
			addFieldError("experiment.targetName", "Target name is required and can't have more than 50 characters!");

		if (workloadName == null || workloadName.length() == 0 || workloadName.length() > 30)
			addFieldError("experiment.workloadName", "Workload name is required and can't have more than 30 characters!");

		if (faultloadName == null || faultloadName.length() == 0 || faultloadName.length() > 30)
			addFieldError("experiment.faultloadName", "Faultload name is required and can't have more than 30 characters!");

		if (description == null || description.length() == 0 || description.length() > 300)
			addFieldError("experiment.description", "Description is required and can't have more than 300 characters!");
	}

	public Experiment getExperiment()
	{
		return experiment;
	}

	public void setExperiment(Experiment experiment)
	{
		this.experiment = experiment;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public int getId()
	{
		return id;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public void setCreatorName(String creatorName)
	{
		this.creatorName = creatorName;
	}

	public void setTargetName(String targetName)
	{
		this.targetName = targetName;
	}

	public void setWorkloadName(String workloadName)
	{
		this.workloadName = workloadName;
	}

	public void setFaultloadName(String faultloadName)
	{
		this.faultloadName = faultloadName;
	}

	public void setOutputFilename(String outputFilename)
	{
		this.outputFilename = outputFilename;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public String getName()
	{
		return name;
	}

	public String getCreatorName()
	{
		return creatorName;
	}

	public String getTargetName()
	{
		return targetName;
	}

	public String getWorkloadName()
	{
		return workloadName;
	}

	public String getFaultloadName()
	{
		return faultloadName;
	}

	public String getOutputFilename()
	{
		return outputFilename;
	}

	public String getDescription()
	{
		return description;
	}
}
