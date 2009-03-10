package de.uka.ipd.sdq.dsexplore.opt4j.representation;


import org.opt4j.core.Phenotype;

import de.uka.ipd.sdq.dsexplore.PCMInstance;

/**
 * Just holds a PCM Instance
 * @author Anne
 *
 */
@SuppressWarnings("serial")
public class PCMPhenotype implements Phenotype {
	
	PCMInstance pcm = null;
	
	public PCMPhenotype(PCMInstance pcm){
		this.pcm = pcm;
	}

	public PCMInstance getPcm() {
		return pcm;
	}

	public void setPcm(PCMInstance pcm) {
		this.pcm = pcm;
	}
	
	

}
