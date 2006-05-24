package de.uka.ipd.sdq.simucom.activity;

import org.eclipse.emf.common.util.EList;
import org.eclipse.uml2.Activity;
import org.eclipse.uml2.InitialNode;

import de.uka.ipd.sdq.simucom.emfhelper.EMFHelper;

public class ActivityQueries {

	public static InitialNode getInitialNode(Activity a)
	{
		return (InitialNode)EMFHelper.getObjectByType(a.getNodes(),InitialNode.class);
	}

	public static InitialNode getInitialNode(EList actions)
	{
		return (InitialNode)EMFHelper.getObjectByType(actions,InitialNode.class);
	}
}
