package de.uka.ipd.sdq.dsexplore.launch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The QMLManager component can be queried for getting the currently activated QML criteria.
 * The {@link Dimension} class needs to be replaced later by the actual QML class, 
 * and the hard coded initialisation of the list with the three values 
 * needs to be moved and the initialisation needs to be done based on the chosen 
 * criteria in a contract.
 * 
 * Probably it will be useful to create a default contract (not only contract 
 * type and declaration) that optimises performance, reliability and costs that 
 * can be referenced as a default. Put that one in PCMMODELS 
 * (cf. glassfish.repository, it is in 
 * https://sdqweb.ipd.uka.de/svn/code/Palladio.EMFComponentModel/trunk/de.uka.ipd.sdq.pcm.resources/defaultModels) 
 * 
 * @author martens
 *
 */
public class QMLManager {
	
	private List<Dimension> dimensions;

	public QMLManager() {
		
		this.dimensions = Collections.synchronizedList(new ArrayList<Dimension>(4));
		this.dimensions.add(new Dimension(DSEConstantsContainer.MEAN_RESPONSE_TIME_QUALITY));
		this.dimensions.add(new Dimension(DSEConstantsContainer.COST));
		this.dimensions.add(new Dimension(DSEConstantsContainer.RELIABILITY));
	}
	
	public List<Dimension> getActivatedCriteria(){
		return this.dimensions;
	}

}


