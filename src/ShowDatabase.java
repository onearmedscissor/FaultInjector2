import java.util.List;

import faultinjector.entity.Experiment;
import faultinjector.entity.Faultload;
import faultinjector.entity.InjectionRun;

import faultinjector.service.EclipseLinkPersistence;

public class ShowDatabase
{
	public static void main(String[] args)
	{
	    EclipseLinkPersistence service = new EclipseLinkPersistence();
		
	    List <Experiment> experiments = service.findAllExperiments();
	    List <Faultload> faultloads;
	    List <InjectionRun> injectionRuns;
	    
	    for (Experiment e : experiments)
	    {
	    	System.out.println("experiment ID = "+e.getExpId());
	    	System.out.println("experiment NAME = "+e.getName());
	    	//System.out.println("experiment TARGET NAME = "+e.getTargetName());
	    	System.out.println("experiment TARGET NAME = "+e.getTarget().getName());
	    	//System.out.println("experiment CREATION DATE = "+e.getCreationDate());
	    	System.out.println("experiment CREATION DATE = "+e.getCreationDate());
	    	//System.out.println("experiment CREATOR NAME = "+e.getCreatorName());
	    	System.out.println("experiment CREATOR NAME = "+e.getUser().getName());
	    	//System.out.println("experiment WORKLOAD NAME = "+e.getWorkloadName());
	    	//System.out.println("experiment OUTPUT FILENAME = "+e.getOutputFilename());
	    	System.out.println("experiment DESCRIPTION = "+e.getDescription());
	    	
	    	faultloads = e.getFaultloads();
	    	for (Faultload f : faultloads)
	    	{
	    		System.out.println("experiment FAULTLOAD NAME(S) = "+f.getName());
	    		
	    		injectionRuns = f.getInjectionRuns();
	    		for (InjectionRun i: injectionRuns)
	    		{
	    			System.out.println("experiment WORKLOAD NAME(S) = "+i.getWorkload().getName());
	    			System.out.println("experiment OUTPUT FILENAME = "+i.getOutputFilename());
	    		}
	    	}
	    }
	    
	    service.closeFactory();
	}
}
