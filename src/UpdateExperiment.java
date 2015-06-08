import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import faultinjector.entity.Experiment;

public class UpdateExperiment
{
   public static void main( String[ ] args )
   {
      EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "Eclipselink_JPA" );
      
      EntityManager entitymanager = emfactory.createEntityManager( );
      entitymanager.getTransaction( ).begin( );
      Experiment experiment = entitymanager.find( Experiment.class, 2 );
      
      //before update
      System.out.println( experiment );
      /*experiment.setName("Experiência_3_repetição");
      experiment.setTargetName("Intel i7 2.6 Ghz");
      experiment.setCreationDate("2015-02-02 12:00:41");
      experiment.setCreatorName("admin 1");
      experiment.setWorkloadName("CentOS + YCSB + VirtualBox");
      experiment.setOutputFilename("experiencia_3_2_repeticao.csv");
      experiment.setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nulla velit justo, tristique sit amet vestibulum id, molestie in nunc. Maecenas blandit turpis non lectus sollicitudin aliquet. Integer scelerisque at mauris vel porta.");
      experiment.setFaultloadName("Spatial_read");*/
      entitymanager.getTransaction().commit();
      
      //after update
      System.out.println( experiment );
      entitymanager.close();
      emfactory.close();
   }
}