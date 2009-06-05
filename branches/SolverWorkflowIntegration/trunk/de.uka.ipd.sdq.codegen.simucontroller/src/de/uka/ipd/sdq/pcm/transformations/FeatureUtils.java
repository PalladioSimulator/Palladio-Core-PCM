package de.uka.ipd.sdq.pcm.transformations;

import java.util.Iterator;

import org.eclipse.emf.common.util.EList;

import de.uka.ipd.sdq.featureconfig.ConfigNode;
import de.uka.ipd.sdq.featureconfig.ConfigState;
import de.uka.ipd.sdq.featureconfig.FeatureConfig;
import de.uka.ipd.sdq.featuremodel.Feature;

public class FeatureUtils {

	public static boolean hasFeature(FeatureConfig featureConfig, String featureName) {
		EList<ConfigNode> nodes = featureConfig.getConfignode();
		Iterator<ConfigNode> it = nodes.iterator();
		while (it.hasNext()){
			ConfigNode configNode = it.next();
			if ( ((Feature)configNode.getOrigin()).getName().equals(featureName)) {
				return configNode.getConfigState() == ConfigState.SELECTED;
			}
		}
		return false;
		// throw new RuntimeException("Feature Configuration not found: "+featureName);
	}

}
