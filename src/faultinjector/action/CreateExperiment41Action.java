package faultinjector.action;

import java.util.Arrays;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import faultinjector.bean.ExperimentBean;

public class CreateExperiment41Action extends ActionSupport implements SessionAware
{
	private static final long serialVersionUID = 4L;

	private Map<String, Object> session;
	private ExperimentBean experimentBean;
	private String[] fids;

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

		experimentBean.setFaultloadIds(fids);

		//
		// Experiment experiment = new Experiment();
		//
		// experiment.setName(experimentBean.getName());
		// experiment.setDescription(experimentBean.getDescription());
		//
		// Target t =
		// this.getExperimentService().findTarget(experimentBean.getTargetId());
		// experiment.setTarget(t);
		//
		// Workload w =
		// this.getExperimentService().findWorkload(experimentBean.getWorkloadId());
		// experiment.getTarget().addWorkload(w);
		//
		// for (int n=0; n<fids.length; n++)
		// {
		// Faultload f =
		// this.getExperimentService().findFaultload(Integer.parseInt(fids[n]));
		//
		// experiment.addFaultload(f);
		// }
		//
		// this.getExperimentService().createExperiment(experiment);
		//
		System.out.println("NEW EXPERIMENT 4.1-------------------------------");
		System.out.println("BEAN");
		System.out.println("New experiment NAME = " + experimentBean.getName());
		System.out.println("New experiment DESCRIPTION = " + experimentBean.getDescription());
		System.out.println("New experiment SELECTED TARGET ID = " + experimentBean.getTargetId());
		System.out.println("New experiment SELECTED WORKLOAD ID = " + experimentBean.getWorkloadId());
		System.out.println("New experiment SELECTED FAULTLOAD(S) ID(S) = " + Arrays.toString(experimentBean.getFaultloadIds()));

		return SUCCESS;
	}

	public void setFids(String[] fids)
	{
		this.fids = fids;
	}

	@Override
	public void setSession(Map<String, Object> session)
	{
		this.session = session;
	}
}
