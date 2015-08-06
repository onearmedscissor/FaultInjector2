package faultinjector.action;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import faultinjector.service.EclipseLinkPersistence;

/**
 * This Action class is a utility class that is extended by all the other Action classes present in this application. It
 * provides access to both Action and sessions Struts 2 functionalities. Furthermore, it provides access to the internal
 * EclipseLinkPersistence class functionalities. Finally, it also sets and provides access to a list of the available
 * fault trigger access types in the application.
 * 
 * @author João Fernandes
 * @see struts.xml
 * @see EclipseLinkPersistence
 */

public abstract class ApplicationSupport extends ActionSupport implements SessionAware
{
	private static final long serialVersionUID = 4L;

	private Map<String, Object> session;
	private List<String> accessTypes = Arrays.asList(read, write);
	private static final String read = "read", write = "write";

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

	public List<String> getAccessTypes()
	{
		return accessTypes;
	}

	public Map<String, Object> getSession()
	{
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session)
	{
		this.session = session;
	}
}
