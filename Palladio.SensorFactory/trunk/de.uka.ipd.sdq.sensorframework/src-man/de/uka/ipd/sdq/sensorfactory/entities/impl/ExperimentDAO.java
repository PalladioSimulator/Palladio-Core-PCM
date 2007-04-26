package de.uka.ipd.sdq.sensorfactory.entities.impl;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import de.uka.ipd.sdq.sensorfactory.entities.Experiment;

public class ExperimentDAO {
	private static ExperimentDAO singletonInstance = new ExperimentDAO();
	EntityManagerFactory emFactory = null;
	private EntityManager em;

	public static ExperimentDAO singleton() {
		return singletonInstance;
	}
	
	public EntityManagerFactory getEntityManagerFactory(){
		return emFactory;
	}
	
	private ExperimentDAO() {
		emFactory = Persistence.createEntityManagerFactory("sensorfactory");
		em = emFactory.createEntityManager();
	};
	
	public Experiment createExperiment(String experimentName) {
		EntityTransaction t = em.getTransaction();
		t.begin();
		Experiment result = new ExperimentImpl();
		result.setExperimentName(experimentName);
		t.commit();
		return result;
	}
	
	public void storeExperiment(Experiment e) {
		EntityTransaction t = em.getTransaction();
		t.begin();
		em.persist(e);
		t.commit();
	}
	
	public Collection<Experiment> getExperiments() {
		List<Experiment> result = em.createQuery("FROM Experiment").getResultList();
		return result;
	}
}
