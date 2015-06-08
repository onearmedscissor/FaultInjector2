package faultinjector.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

import faultinjector.entity.Experiment;
import faultinjector.entity.Faultload;
import faultinjector.entity.Register;
import faultinjector.entity.Target;
import faultinjector.entity.Workload;

public interface Persistable
{
	public void closeFactory();

	public List<Experiment> findAllExperiments();

	public Experiment findExperiment(int id);

	public void deleteExperiment(int id);

	public void createExperiment(Experiment e);

	public List<Target> findAllTargets();

	public Target findTarget(int id);

	public void deleteTarget(int id);

	public void createTarget(Target t);

	public List<Workload> findAllWorkloads();

	public Workload findWorkload(int id);

	public void deleteWorkload(int id);

	public void createWorkload(Workload w);

	public List<Faultload> findAllFaultloads();

	public Faultload findFaultload(int id);

	public void deleteFaultload(int id);

	public int[] createFaultload(Faultload f);

	public List<Register> findAllRegisters();

	public Register findRegister(int id);

	public EntityManager getEntityManager();

	public EntityManagerFactory getEntityManagerFactory();

	public EntityTransaction getEt();
}
