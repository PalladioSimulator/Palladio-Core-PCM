/**
 * 
 */
package de.fzi.se.quality.qualityannotation.provider;

import org.eclipse.emf.common.notify.AdapterFactory;

import de.uka.ipd.sdq.pcm.core.entity.Entity;
import de.uka.ipd.sdq.pcm.parameter.VariableCharacterisation;
import de.uka.ipd.sdq.pcm.parameter.VariableUsage;
import de.uka.ipd.sdq.pcm.parameter.provider.VariableUsageItemProvider;
import de.uka.ipd.sdq.pcm.repository.ImplementationComponentType;

/**
 * @author groenda
 *
 */
public class DetailedVariableUsageItemProvider extends
		VariableUsageItemProvider {
	
	public DetailedVariableUsageItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	@Override
	public String getText(Object object) {
		StringBuilder result = new StringBuilder();
		if (object != null && object instanceof VariableUsage) {
			VariableUsage vu = (VariableUsage) object;
			// determine location: [Entity.Name] <[Type]>:
			Entity entity = null;
			if (vu.getSetVariableAction_VariableUsage() != null) {
				entity = vu.getSetVariableAction_VariableUsage();
			}
			if (vu.getAssemblyContext__VariableUsage() != null) {
				entity = vu.getAssemblyContext__VariableUsage();
			}
			if (vu.getEntryLevelSystemCall_InputParameterUsage() != null) {
				result.append("input ");
				entity = vu.getEntryLevelSystemCall_InputParameterUsage();
			}
			if (vu.getEntryLevelSystemCall_OutputParameterUsage() != null) {
				result.append("output ");
				entity = vu.getEntryLevelSystemCall_OutputParameterUsage();
			}
			if (vu.eContainer() instanceof ImplementationComponentType) {
				entity = (ImplementationComponentType) vu.eContainer();
			}
			if (vu.getCallAction__VariableUsage() != null) {
				entity = (Entity) vu.getCallAction__VariableUsage(); //instances are of type Entity, although not defined in the metamodel
			}
			if (vu.getCallReturnAction__VariableUsage() != null) {
				entity = (Entity) vu.getCallReturnAction__VariableUsage(); //instances are of type Entity, although not defined in the metamodel
			}
			if (entity != null) {
				result.append(entity.getEntityName()+ " <" + entity.eClass().getName() + "> [" + entity.getId() + "]: ");
			}
			// determine others
			if (vu.getSpecifiedOutputParameterAbstraction_expectedExternalOutputs_VariableUsage() != null) {
				result.append(vu.getSpecifiedOutputParameterAbstraction_expectedExternalOutputs_VariableUsage().getSignature_SpecifiedOutputParameterAbstraction().getEntityName());
				result.append("::" + vu.getSpecifiedOutputParameterAbstraction_expectedExternalOutputs_VariableUsage().getRole_SpecifiedOutputParameterAbstraction().getEntityName() + " ");
				entity = vu.getSpecifiedOutputParameterAbstraction_expectedExternalOutputs_VariableUsage().getQosAnnotations_SpecifiedOutputParameterAbstraction();
			}
			if (vu.getUserData_VariableUsage() != null) {
				entity = vu.getUserData_VariableUsage().getAssemblyContext_userData();
			}
			if (vu.getSynchronisationPoint_VariableUsage() != null) {
				result.append("synchronized ");
				entity = vu.getSynchronisationPoint_VariableUsage().getForkAction_SynchronisationPoint();
			}
			// [Variable.name].[VariableChracterisation]
			for (VariableCharacterisation vc : vu.getVariableCharacterisation_VariableUsage()) {
				result.append(vu.getNamedReference__VariableUsage().getReferenceName());
				result.append(".");
				result.append(vc.getType() + " = " + vc.getSpecification_VariableCharacterisation().getSpecification() + " ");
			}
		}
		if (result.length() == 0) {
			return super.getText(object);
		}
		return result.toString();
	}
}
