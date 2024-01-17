package ejercicios;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class AD04TE01HQLConsulta {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("AD04");
		EntityManager entityManager = factory.createEntityManager();
		
		try {			
			String hql = "SELECT s.firstName, s.lastName, u.name FROM Student s JOIN s.university u";

			Query query = entityManager.createQuery(hql);
			List<Object[]> resultado = query.getResultList();

			for (Object[] row : resultado) {
			    String firstName = (String) row[0];
			    String lastName = (String) row[1];
			    String universityName = (String) row[2];
			    System.out.println(firstName + " " + lastName + " - " + universityName);			    
			}
		}
		catch ( Exception e ) {
			e.printStackTrace();
		}
		finally {
			entityManager.close();
			factory.close();
		}
	}
	
}




