package faultinjector.action;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import faultinjector.bean.ExperimentBean;
import faultinjector.entity.Experiment;
import faultinjector.entity.Faultload;
import faultinjector.entity.Target;
import faultinjector.entity.Workload;

public class CreateExperiment42 extends ApplicationSupport
{
	private static final long serialVersionUID = 4L;

	private ExperimentBean experimentBean;
	private Experiment experiment;
	private String[] fids;

	private EntityManager em;
	private EntityTransaction et;

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

		fids = experimentBean.getFaultloadIds();

		em = this.getExperimentService().getEntityManager();
		et = em.getTransaction();
		et.begin();

		experiment = new Experiment();

		experiment.setName(experimentBean.getName());
		experiment.setDescription(experimentBean.getDescription());

		Target t = this.getExperimentService().findTarget(experimentBean.getTargetId());
		experiment.setTarget(t);

		Workload w = this.getExperimentService().findWorkload(experimentBean.getWorkloadId());
		experiment.getTarget().addWorkload(w);

		for (int n = 0; n < fids.length; n++)
		{
			Faultload f = this.getExperimentService().findFaultload(Integer.parseInt(fids[n]));

			experiment.addFaultload(f);
		}

		et.commit();
		em.close();

		System.out.println("NEW EXPERIMENT 4.2");

		return SUCCESS;
	}
}