package faultinjector.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import faultinjector.entity.Architecture;
import faultinjector.entity.Experiment;
import faultinjector.entity.FaultClass;
import faultinjector.entity.FaultMode;
import faultinjector.entity.Faultload;
import faultinjector.entity.HardwareFaultType;
import faultinjector.entity.Register;
import faultinjector.entity.Target;
import faultinjector.entity.Workload;

public class ExperimentService implements Persistable
{
	private EntityManager em;
	private EntityManagerFactory emfactory;
	private EntityTransaction et;

	public ExperimentService()
	{
		emfactory = Persistence.createEntityManagerFactory("Eclipselink_JPA");
		em = emfactory.createEntityManager();
		et = em.getTransaction();
	}

	public void closeFactory()
	{
		this.emfactory.close();
	}

	@SuppressWarnings("unchecked")
	public List<Experiment> findAllExperiments()
	{
		this.em = this.getEntityManagerFactory().createEntityManager();

		Query query = this.em.createQuery("select e FROM Experiment e");

		return query.getResultList();
	}

	public Experiment findExperiment(int id)
	{
		return this.em.find(Experiment.class, id);
	}

	public void deleteExperiment(int id)
	{
		this.em = this.getEntityManagerFactory().createEntityManager();

		this.et = this.em.getTransaction();

		this.et.begin();

		Experiment experiment = findExperiment(id);

		this.em.remove(experiment);

		this.getEt().commit();

		this.em.close();
	}

	public void createExperiment(Experiment e)
	{
		this.em = this.getEntityManagerFactory().createEntityManager();

		this.et = this.em.getTransaction();

		this.et.begin();

		this.em.merge(e);

		this.et.commit();

		this.em.close();
	}

	@SuppressWarnings("unchecked")
	public List<Target> findAllTargets()
	{
		this.em = this.getEntityManagerFactory().createEntityManager();

		Query query = this.em.createQuery("select t FROM Target t");

		return query.getResultList();
	}

	public Target findTarget(int id)
	{
		return this.em.find(Target.class, id);
	}

	public void deleteTarget(int id)
	{
		this.em = this.getEntityManagerFactory().createEntityManager();

		this.et = this.em.getTransaction();

		this.et.begin();

		Target target = findTarget(id);

		this.em.remove(target);

		this.getEt().commit();

		this.em.close();
	}

	public void createTarget(Target t)
	{
		this.em = this.getEntityManagerFactory().createEntityManager();

		this.et = this.em.getTransaction();

		this.et.begin();

		this.em.merge(t);

		this.et.commit();

		this.em.close();
	}

	@SuppressWarnings("unchecked")
	public List<Architecture> findAllArchitectures()
	{
		this.em = this.getEntityManagerFactory().createEntityManager();

		Query query = this.em.createQuery("select a FROM Architecture a");

		return query.getResultList();
	}

	public Architecture findArchitecture(int id)
	{
		return this.em.find(Architecture.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Workload> findAllWorkloads()
	{
		this.em = this.getEntityManagerFactory().createEntityManager();

		Query query = this.em.createQuery("select w FROM Workload w");

		return query.getResultList();
	}

	public Workload findWorkload(int id)
	{
		return this.em.find(Workload.class, id);
	}

	public void deleteWorkload(int id)
	{
		this.em = this.getEntityManagerFactory().createEntityManager();

		this.et = this.em.getTransaction();

		this.et.begin();

		Workload workload = findWorkload(id);

		this.em.remove(workload);

		this.getEt().commit();

		this.em.close();
	}

	public void createWorkload(Workload w)
	{
		this.em = this.getEntityManagerFactory().createEntityManager();

		this.et = this.em.getTransaction();

		this.et.begin();

		this.em.merge(w);

		this.et.commit();

		this.em.close();
	}

	@SuppressWarnings("unchecked")
	public List<Faultload> findAllFaultloads()
	{
		this.em = this.getEntityManagerFactory().createEntityManager();

		Query query = this.em.createQuery("select f FROM Faultload f");

		return query.getResultList();
	}

	public Faultload findFaultload(int id)
	{
		return this.em.find(Faultload.class, id);
	}

	public void deleteFaultload(int id)
	{
		this.em = this.getEntityManagerFactory().createEntityManager();

		this.et = this.em.getTransaction();

		this.et.begin();

		Faultload faultload = findFaultload(id);

		this.em.remove(faultload);

		this.getEt().commit();

		this.em.close();
	}

	public int createFaultload(Faultload f)
	{
		int id;

		this.em = this.getEntityManagerFactory().createEntityManager();

		this.et = this.em.getTransaction();

		this.et.begin();

		Faultload fl = this.em.merge(f);

		this.et.commit();

		this.em.close();

		id = fl.getFaultloadlId();

		return id;
	}

	@SuppressWarnings("unchecked")
	public List<Register> findAllRegisters()
	{
		this.em = this.getEntityManagerFactory().createEntityManager();

		Query query = this.em.createQuery("select r FROM Register r");

		return query.getResultList();
	}

	public Register findRegister(int id)
	{
		return this.em.find(Register.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<FaultMode> findAllFaultModes()
	{
		this.em = this.getEntityManagerFactory().createEntityManager();

		Query query = this.em.createQuery("select fm FROM FaultMode fm");

		return query.getResultList();
	}

	public FaultMode findFaultMode(int id)
	{
		return this.em.find(FaultMode.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<FaultClass> findAllFaultClasses()
	{
		this.em = this.getEntityManagerFactory().createEntityManager();

		Query query = this.em.createQuery("select fc FROM FaultClass fc");

		return query.getResultList();
	}

	public FaultClass findFaultClass(int id)
	{
		return this.em.find(FaultClass.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<HardwareFaultType> findAllHardwareFaultTypes()
	{
		this.em = this.getEntityManagerFactory().createEntityManager();

		Query query = this.em.createQuery("select hft FROM HardwareFaultType hft");

		return query.getResultList();
	}

	public HardwareFaultType findHardwareFaultType(int id)
	{
		return this.em.find(HardwareFaultType.class, id);
	}

	public EntityManager getEntityManager()
	{
		return this.em;
	}

	public EntityManagerFactory getEntityManagerFactory()
	{
		return this.emfactory;
	}

	public EntityTransaction getEt()
	{
		return et;
	}
}
