import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import faultinjector.entity.Experiment;

public class DeleteExperiment {
   public static void main( String[ ] args ) {
   
      EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("Eclipselink_JPA");
      EntityManager entitymanager = emfactory.createEntityManager();
      entitymanager.getTransaction().begin();
      
      Experiment experiment = entitymanager.find(Experiment.class, 2);
      entitymanager.remove(experiment);
      entitymanager.getTransaction().commit();
      entitymanager.close();
      emfactory.close();
   }
}