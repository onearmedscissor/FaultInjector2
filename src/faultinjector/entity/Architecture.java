package faultinjector.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the Architecture database table.
 * 
 */
@Entity
@Table(name = "Architecture")
@NamedQuery(name = "Architecture.findAll", query = "SELECT a FROM Architecture a")
public class Architecture implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Architecture_id")
	private int architectureId;

	@Column(name = "Name")
	private String name;

	// bi-directional many-to-one association to Target
	@OneToMany(mappedBy = "architecture")
	private List<Target> targets;

	public int getArchitectureId()
	{
		return architectureId;
	}

	public void setArchitectureId(int architectureId)
	{
		this.architectureId = architectureId;
	}

	public String getName()
	{
		return this.name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public List<Target> getTargets()
	{
		if (this.targets == null)
			this.targets = new ArrayList<Target>();

		return this.targets;
	}

	public void setTargets(List<Target> targets)
	{
		this.targets = targets;
	}

	public Target addTarget(Target target)
	{
		getTargets().add(target);
		target.setArchitecture(this);

		return target;
	}

	public Target removeTarget(Target target)
	{
		getTargets().remove(target);
		target.setArchitecture(null);

		return target;
	}
}