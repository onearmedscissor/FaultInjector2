import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import faultinjector.entity.Application;
import faultinjector.entity.Experiment;
import faultinjector.entity.Faultload;
import faultinjector.entity.HardwareFault;
import faultinjector.entity.InjectionRun;
import faultinjector.entity.Register;
import faultinjector.entity.Target;
import faultinjector.entity.User;
import faultinjector.entity.Workload;

public class PopulateDatabase
{
	public static void main(String[] args)
	{
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Eclipselink_JPA");
		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();

		Experiment experiment = new Experiment();
		/*
		 * experiment.setEid(17); experiment.setName("Experiment_3"); experiment.setTarget_name("CentOS 6.5 32 bit"); experiment.setCreation_date("2014-12-08 00:00:00"); experiment.setCreator_name("jaff"); experiment.setWorkload_name("CentOS + YSCB"); experiment.setOutput_filename("experiment_3_2.csv"); experiment.setDescription( "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla velit justo, tristique sit amet vestibulum id, molestie in nunc. Maecenas blandit turpis non lectus sollicitudin aliquet. Integer scelerisque at mauris vel porta." ); experiment.setFaultload_name("Faultload #1");
		 */

		/*
		 * experiment.setEid(2); experiment.setName("Experiência_3_repetição"); experiment.setTargetName("Intel i7 2.6 Ghz"); experiment.setCreationDate("2015-02-02 12:00:41"); experiment.setCreatorName("admin 1"); experiment.setWorkloadName("CentOS + YCSB + VirtualBox"); experiment.setOutputFilename("experiencia_3_2_repeticao.csv"); experiment.setDescription( "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla velit justo, tristique sit amet vestibulum id, molestie in nunc. Maecenas blandit turpis non lectus sollicitudin aliquet. Integer scelerisque at mauris vel porta." ); experiment.setFaultloadName("Spatial_read");
		 */

		PopulateDatabase.population.persistAll(entitymanager);
		entitymanager.getTransaction().commit();

		entitymanager.close();
		emfactory.close();
	}

	public static final PopulateDatabase population = new PopulateDatabase();

	private PopulateDatabase()
	{

	}

	public void persistAll(EntityManager em)
	{
		System.out.println("Persisting samples objects.");

		Register register1, register2, register3, register4, register5, register6, register7, register8;

		register1 = new Register();
		register1.setName("Program counter (PC)");
		register2 = new Register();
		register2.setName("Stack pointer (SP)");
		register3 = new Register();
		register3.setName("Frame pointer (FP)");
		register4 = new Register();
		register4.setName("Processor status (EFLAGS)");
		register5 = new Register();
		register5.setName("EAX (general purpose)");
		register6 = new Register();
		register6.setName("EBX (general purpose)");
		register7 = new Register();
		register7.setName("ECX (general purpose)");
		register8 = new Register();
		register8.setName("EDX (general purpose)");

		List<Register> regs1 = new ArrayList<Register>();
		regs1.add(register1);
		regs1.add(register5);

		List<Register> regs2 = new ArrayList<Register>();
		regs2.add(register8);

		em.persist(experiment1(regs1));
		em.persist(experiment2(regs2));

		em.persist(register1);
		em.persist(register2);
		em.persist(register3);
		em.persist(register4);
		em.persist(register5);
		em.persist(register6);
		em.persist(register7);
		em.persist(register8);

		System.out.println("Flushing to database.");
		em.flush();
	}

	private Experiment experiment1(List<Register> regs)
	{
		Experiment experiment = new Experiment();

		experiment.setName("Experiment_3");
		experiment.setCreationDate(getCurrentTimestamp());
		experiment.setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla velit justo, tristique sit amet vestibulum id, molestie in nunc. Maecenas blandit turpis non lectus sollicitudin aliquet. Integer scelerisque at mauris vel porta.");

		User user = new User();
		user.setName("João Fernandes");
		user.setEmail("blabla@bla.com");
		user.setAdministrator(false);
		user.setInstitution("DEI");
		user.setUsername("jaff");
		user.setPassword("faultinjector");

		// experiment.setUser(user);
		user.addExperiment(experiment);

		Target target = new Target();
		target.setName("Intel i7 2.6 Ghz + 8 GB");
		// target.setI386Arch(true);
		target.setIp("127.0.0.1");
		target.setOperatingSystem("CentOS 6.5 32 bit");

		target.addExperiment(experiment);
		/* experiment.setTarget(target); */

		Workload workload = new Workload();
		workload.setName("CentOS + YSCB");

		Application app1 = new Application();
		app1.setName("CentOS 6.5 32 bit");

		Application app2 = new Application();
		app2.setName("Yahoo Cloud Service Benchmark");

		List<Application> apps = new ArrayList<Application>();
		apps.add(app1);
		apps.add(app2);
		workload.setApplications(apps);

		// workload.setTarget(target);
		target.addWorkload(workload);

		Faultload faultload = new Faultload();
		faultload.setName("Faultload #1");
		faultload.setCreationDate(getCurrentTimestamp());
		faultload.setTimeInterval(500);
		faultload.setMemoryRangeBeginning(9600);
		faultload.setMemoryRangeEnd(21833);
		faultload.setNumberFaults(1000);
		faultload.setDescription("Veni, vidi, vici");
		faultload.setRegisters(regs);

		// faultload.setExperiment(experiment);
		experiment.addFaultload(faultload);

		HardwareFault hardwareFault = new HardwareFault();
		hardwareFault.setCreationDate(getCurrentTimestamp());
		hardwareFault.setTriggerType("sc");
		// hardwareFault.setKernel_mode(false);
		hardwareFault.setPid(6667);
		hardwareFault.setInjected(false);
		hardwareFault.setReadAddress(true);

		// hardwareFault.setBit_flip(false);
		hardwareFault.setBitStart(7);
		// hardwareFault.setHw_fault_type('m');
		hardwareFault.setBitEnd(15);
		hardwareFault.setMemAddress(6969);

		// softwareFault.setFaultload(faultload);
		faultload.addFault(hardwareFault);

		InjectionRun injection_Run = new InjectionRun();
		injection_Run.setOutputFilename("experiment_3_2.csv");

		// injection_Run.setWorkload(workload);
		workload.addInjectionRun(injection_Run);

		// injection_Run.setFaultload(faultload);
		faultload.addInjectionRun(injection_Run);

		// injection_Run.setFault(softwareFault);
		hardwareFault.addInjectionRun(injection_Run);

		return experiment;
	}

	private Experiment experiment2(List<Register> regs)
	{
		Experiment experiment = new Experiment();

		experiment.setName("Nova experiência");
		experiment.setCreationDate(getCurrentTimestamp());
		experiment.setDescription("Descrição");

		User user = new User();
		user.setName("Admin 1");
		user.setEmail("admin@faultinjector.pt");
		user.setAdministrator(false);
		user.setInstitution("FCTUC - DEI");
		user.setUsername("admin_1");
		user.setPassword("pass");

		// experiment.setUser(user);
		user.addExperiment(experiment);

		Target target = new Target();
		target.setName("Vaio VGN-CS11Z 4GB Core 2 Duo 64 bits");
		// target.setI386Arch(true);
		target.setIp("127.1.1.1");
		target.setOperatingSystem("Elementary OS 64 bit");

		target.addExperiment(experiment);
		/* experiment.setTarget(target); */

		Workload workload = new Workload();
		workload.setName("Elementary + VirtualBox + YSCB");

		Application app1 = new Application();
		app1.setName("Elementary OS 64 bit");

		Application app2 = new Application();
		app2.setName("VirtualBox");

		Application app3 = new Application();
		app3.setName("Yahoo Cloud Service Benchmark");

		List<Application> apps = new ArrayList<Application>();
		apps.add(app1);
		apps.add(app2);
		apps.add(app3);
		workload.setApplications(apps);

		// workload.setTarget(target);
		target.addWorkload(workload);

		Faultload faultload = new Faultload();
		faultload.setName("Fault set 666 1234");
		faultload.setCreationDate(getCurrentTimestamp());
		faultload.setTimeInterval(666);
		faultload.setNumberFaults(1234);
		faultload.setDescription("Blue screen");
		faultload.setRegisters(regs);

		// faultload.setExperiment(experiment);
		experiment.addFaultload(faultload);

		HardwareFault hardwareFault = new HardwareFault();
		hardwareFault.setCreationDate(getCurrentTimestamp());
		hardwareFault.setTriggerType("sd");
		// hardwareFault.setKernel_mode(true);
		hardwareFault.setPid(3140);
		hardwareFault.setInjected(false);
		hardwareFault.setReadAddress(false);
		// hardwareFault.setBit_flip(true);
		hardwareFault.setBitStart(0);
		// hardwareFault.setHw_fault_type('r');
		hardwareFault.setBitEnd(4);
		// hardwareFault.setRegister("eax");
		hardwareFault.setMemAddress(1234);

		// softwareFault.setFaultload(faultload);
		faultload.addFault(hardwareFault);

		InjectionRun injection_Run = new InjectionRun();
		injection_Run.setOutputFilename("experiencia_nova_injeccao_67.txt");

		// injection_Run.setWorkload(workload);
		workload.addInjectionRun(injection_Run);

		// injection_Run.setFaultload(faultload);
		faultload.addInjectionRun(injection_Run);

		// injection_Run.setFault(softwareFault);
		hardwareFault.addInjectionRun(injection_Run);

		return experiment;
	}

	private Timestamp getCurrentTimestamp()
	{
		Timestamp currentTimestamp = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());

		return currentTimestamp;
	}
}