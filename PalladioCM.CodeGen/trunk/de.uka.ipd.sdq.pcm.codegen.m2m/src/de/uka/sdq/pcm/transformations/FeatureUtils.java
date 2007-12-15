package de.uka.sdq.pcm.transformations;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;

import de.uka.ipd.sdq.featureconfig.ConfigNode;
import de.uka.ipd.sdq.featureconfig.ConfigState;
import de.uka.ipd.sdq.featureconfig.FeatureConfig;

public class FeatureUtils {

	public static boolean hasFeature(FeatureConfig featureConfig, String featureName) {
		TreeIterator<EObject> it = featureConfig.eAllContents();
		while (it.hasNext()){
			EObject eObject = it.next();
			if (eObject instanceof ConfigNode){
				ConfigNode configNode = (ConfigNode) eObject;
				if (configNode.getOrigin().getName().equals(featureName)){
					if (configNode.getConfigState() == ConfigState.USER_SELECTED || configNode.getConfigState() == ConfigState.MASCHINE_SELECTED){
						return true;
					} else {
						return false;
					}
				}
			}
		}
		throw new RuntimeException("Feature Configuration not found: "+featureName);
	}

}
