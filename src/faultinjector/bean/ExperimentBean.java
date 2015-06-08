package faultinjector.bean;

public class ExperimentBean
{
	private String name;
	private String description;
	private int targetId;
	private int workloadId;
	private String[] faultloadIds;
	private int id;

	public ExperimentBean()
	{
		this.id = -1;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public int getTargetId()
	{
		return targetId;
	}

	public void setTargetId(int targetId)
	{
		this.targetId = targetId;
	}

	public int getWorkloadId()
	{
		return workloadId;
	}

	public void setWorkloadId(int workloadId)
	{
		this.workloadId = workloadId;
	}

	public String[] getFaultloadIds()
	{
		return faultloadIds;
	}

	public void setFaultloadIds(String[] faultloadIds)
	{
		this.faultloadIds = faultloadIds;
	}

	public boolean containsFaultloadId(String id)
	{
		for (String s : faultloadIds)
		{
			if (s.equals(id))
				return true;
		}
		return false;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}
}
