package faultinjector.action;

import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import faultinjector.bean.ExperimentBean;
import faultinjector.entity.Experiment;
import faultinjector.entity.Faultload;
import faultinjector.entity.Target;
import faultinjector.entity.Workload;
import faultinjector.service.EclipseLinkPersistence;

public class CreateExperiment42 extends ActionSupport implements SessionAware
{
	private static final long serialVersionUID = 4L;

	private Map<String, Object> session;
	private ExperimentBean experimentBean;
	private Experiment experiment;
	private String[] fids;

	private EntityManager em;
	private EntityTransaction et;

	@Override
	public String execute()
	{
		if (!session.containsKey("experimentBean"))
		{
			this.experimentBean = new ExperimentBean();
			session.put("experimentBean", experimentBean);
		}
		else
			experimentBean = (ExperimentBean) session.get("experimentBean");

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

	public EclipseLinkPersistence getExperimentService()
	{
		if (!session.containsKey("experimentService"))
		{
			EclipseLinkPersistence experimentService = new EclipseLinkPersistence();

			this.setExperimentService(experimentService);
		}

		return (EclipseLinkPersistence) session.get("experimentService");
	}

	public void setExperimentService(EclipseLinkPersistence experimentService)
	{
		this.session.put("experimentService", experimentService);
	}

	@Override
	public void setSession(Map<String, Object> session)
	{
		this.session = session;
	}
}