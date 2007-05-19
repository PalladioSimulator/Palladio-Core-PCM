package de.uka.ipd.sdq.sensorfactory.entities.impl;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import de.uka.ipd.sdq.sensorfactory.IExperimentDAO;
import de.uka.ipd.sdq.sensorfactory.entities.Experiment;
import de.uka.ipd.sdq.sensorfactory.entities.ExperimentRun;
import de.uka.ipd.sdq.sensorfactory.entities.Measurement;
import de.uka.ipd.sdq.sensorfactory.entities.Sensor;

public class JPAExperimentDAO implements IExperimentDAO {
	EntityManagerFactory emFactory = null;
	private EntityManager em;
	private String name;
	
	protected EntityManagerFactory getEntityManagerFactory(){
		return emFactory;
	}
	
	public JPAExperimentDAO(String name) {
		emFactory = Persistence.createEntityManagerFactory("sensorfactory");
		em = emFactory.createEntityManager();
		this.name = name;
	};
	
	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.sensorfactory.entities.impl.IExperimentDAO#createExperiment(java.lang.String)
	 */
	public Experiment createExperiment(String experimentName) {
		EntityTransaction t = em.getTransaction();
		t.begin();
		Experiment result = new ExperimentImpl();
		result.setExperimentName(experimentName);
		em.persist(result);
		t.commit();
		return result;
	}
	
	public void storeExperiment(Experiment e) {
		EntityTransaction t = em.getTransaction();
		t.begin();
		int i = 0;
		for (Sensor s : e.getSensors())
			em.persist(s);
		for (ExperimentRun er:e.getExperimentRuns()) {
			for (Measurement m : er.getMeasurements()) {
				em.persist(m);
				if (i % 50 == 0) {
					em.flush();
					em.clear();
					t.commit();
					em.close();
					em = emFactory.createEntityManager();
					t = em.getTransaction();
					t.begin();
				}
				i++;
				if (i % 1000 == 0)
					System.out.print(".");
			}
		}
		em.persist(e);
		t.commit();
	}
	
	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.sensorfactory.entities.impl.IExperimentDAO#getExperiments()
	 */
	public Collection<Experiment> getExperiments() {
		List<Experiment> result = em.createQuery("FROM Experiment").getResultList();
		return result;
	}

	public String getDescription() {
		return "Datasource based on a relational database controlled by JPA";
	}

	public String getName() {
		return name;
	}

	public void insertExperiment(Experiment experiment) {
		storeExperiment(experiment);
	}

	@Override
	public Experiment createOrReuseExperiment(String nameExperimentRun) {
		List<Experiment> result = em.createQuery("FROM Experiment WHERE Name='"+nameExperimentRun+"'").getResultList();
		if (result.size() > 0)
			return result.get(0);
		else
			return createExperiment(nameExperimentRun);
		
	}
}
