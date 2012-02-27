/**
 * 
 */
package de.uka.ipd.sdq.dsexplore.qml.pcm.reader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.opt4j.core.SatisfactionConstraint;
import org.opt4j.core.Constraint.Direction;
import org.opt4j.core.Objective.Sign;

import de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.Constraint;
import de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.Criterion;
import de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.EnumOperator;
import de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.EvaluationAspect;
import de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.GenericQMLContract;
import de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.Goal;
import de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.NumericLiteral;
import de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.Objective;
import de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.Restriction;
import de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.SimpleQMLContract;
import de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.EnumRelationSemantics;
import de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.QMLContractType;
import de.uka.ipd.sdq.dsexplore.qml.declarations.QMLDeclarations.QMLDeclarations;
import de.uka.ipd.sdq.dsexplore.qml.handling.QMLConstantsContainer;
import de.uka.ipd.sdq.dsexplore.qml.pcm.datastructures.EvaluationAspectWithContext;
import de.uka.ipd.sdq.dsexplore.qml.pcm.datastructures.builder.InfeasibilityConstraintBuilder;
import de.uka.ipd.sdq.dsexplore.qml.pcm.datastructures.builder.ObjectiveBuilder;
import de.uka.ipd.sdq.dsexplore.qml.pcm.datastructures.builder.SatisfactionConstraintBuilder;
import de.uka.ipd.sdq.dsexplore.qml.profile.QMLProfile.Requirement;
import de.uka.ipd.sdq.dsexplore.qml.profile.QMLProfile.SimpleQMLProfile;
import de.uka.ipd.sdq.dsexplore.qml.reader.QMLDeclarationsReader;
import de.uka.ipd.sdq.pcm.usagemodel.UsageModel;
import de.uka.ipd.sdq.pcm.usagemodel.UsageScenario;

/**
 * Reads PCM specific QML definitions. It is used by quality attribute evaluators to get
 * the in QML defined objectives and constraints. Currently, the QML based mating heuristics
 * currently uses the retranslation to get the original information about the defined constraints.
 * 
 * @see QMLDeclarationsReader
 * @author noorshams
 *
 */
public class PCMDeclarationsReader {


	//protected final String PCMContractTypePath;
	protected final String[] PCMProfilePaths;
	
	protected static HashMap<String, EvaluationAspectWithContext> retranslationMap = new HashMap<String, EvaluationAspectWithContext>();
	
	protected QMLDeclarationsReader qmlReader = new QMLDeclarationsReader();;
	//protected QMLContractType pcmContractType;
	//Refined are not supported yet
	protected List<SimpleQMLProfile> pcmProfiles = new ArrayList<SimpleQMLProfile>();
	protected List<EvaluationAspectWithContext> pcmConstraints = new ArrayList<EvaluationAspectWithContext>();
	protected List<EvaluationAspectWithContext> pcmObjectives = new ArrayList<EvaluationAspectWithContext>();
	
//	protected String pcmContractTypeId = null;
	

	public PCMDeclarationsReader(String PCMProfilePath) {
		
		//this.PCMContractTypePath = QMLConstantsContainer.STANDARD_CONTRACT_TYPE_PATH;
		this.PCMProfilePaths = new String[]{PCMProfilePath};
		
		init();		
	}
	
	protected void init() {

		//initPCMContractType();
		initPCMProfiles();
		initPCMConstraintsAndObjectives();
				
//		initPCMContractTypeID();
	}
	
//	private void initPCMContractType() {
//		//XXX: Be sure to read the declarations correctly
//		QMLDeclarations declarations = qmlReader.getQMLDeclarations(PCMContractTypePath);
//		List<QMLContractType> ctList = qmlReader.getQMLContractTypes(declarations);
//		if(declarations != null && ctList.size() > 1) {
//			throw new RuntimeException("The pcm contract type definition contains multiple contract types.");
//		}
//		pcmContractType = ctList.get(0);
//	}
	
	private void initPCMProfiles() {
		//XXX: Be sure to read the declarations correctly
		//TODO: Support refinements
		for (int i = 0; i < PCMProfilePaths.length; i++) {
			String PCMProfilePath = PCMProfilePaths[i];
			QMLDeclarations declarations = qmlReader.getQMLDeclarations(PCMProfilePath);	
			pcmProfiles.addAll(qmlReader.getSimpleQMLProfiles(declarations));
			if(declarations != null && qmlReader.getRefinedQMLProfiles(declarations).size() > 0) {
				throw new RuntimeException("Refined QML profiles not supported!");
			}
		}
	}
	
	private void initPCMConstraintsAndObjectives(){
		for (SimpleQMLProfile simpleProfile : pcmProfiles) {
			//XXX: Only Simple Profiles atm! Adjust this, if refinements are possible!			
			for (Requirement requirement : simpleProfile.getRequirements()) {
				for (GenericQMLContract contract : requirement.getRequireContract()) {
					if (contract instanceof SimpleQMLContract) {
						SimpleQMLContract simpleContract = (SimpleQMLContract) contract;
						for (Criterion criterion : simpleContract.getCriteria()) {
							for (EvaluationAspect aspect : criterion.getAspects()) {
								if (criterion instanceof Objective) {
									this.pcmObjectives.add(new EvaluationAspectWithContext(simpleContract.getContractType(), criterion.getDimension(), criterion, aspect, simpleProfile.getUsageModel(), requirement));
								} else {
									//criterion instanceof Constraint
									this.pcmConstraints.add(new EvaluationAspectWithContext(simpleContract.getContractType(), criterion.getDimension(), criterion, aspect, simpleProfile.getUsageModel(), requirement));
								}
							}
						}
					} else {
						//TODO: Support Refinements
						throw new RuntimeException("Unsupported QML Contract! Simple QML Contract expected");
					}
				}
			}
		}
	}
	
//	private void initPCMContractTypeID() {
//		pcmContractTypeId = pcmContractType.getId();
//	}
	
	public List<EvaluationAspectWithContext> getDimensionObjectiveContextsForUsageModel(UsageModel usageModel, String dimensionId) {
		return new ArrayList<EvaluationAspectWithContext>(getDimensionCriterionContextsForUsageModel(usageModel, dimensionId, Objective.class));
	}
	
	public List<EvaluationAspectWithContext> getDimensionConstraintContextsForUsageModel(UsageModel usageModel, String dimensionId) {
		return new ArrayList<EvaluationAspectWithContext>(getDimensionCriterionContextsForUsageModel(usageModel, dimensionId, Constraint.class));
	}
	
	protected List<EvaluationAspectWithContext> getDimensionCriterionContextsForUsageModel(UsageModel usageModel, String dimensionId, Class<? extends Criterion> CriterionClass) {
		List<EvaluationAspectWithContext> returnList = new ArrayList<EvaluationAspectWithContext>();
		List<EvaluationAspectWithContext> tmpList = getDimensionCriterionContexts(dimensionId, CriterionClass);
		for (EvaluationAspectWithContext aspect : tmpList) {
			if(equalUsageModels(usageModel, aspect.getUsageModel())){
				returnList.add(aspect);
			}
		}
		
		return returnList;
	}
	
	protected boolean equalUsageModels(UsageModel um1, UsageModel um2){
		if (um1 == um2) { // 'pointer' equality
			return true;
		} else if (um1.getUsageScenario_UsageModel().size() != 0 && um2.getUsageScenario_UsageModel().size() != 0) {
			// compare UsageModels: as every Scenario is contained by exactly 1 UsageModel,
			// the Models are considered equal, if the first UsageScenario of UM1 is in UM2
			
			String us1_id = um1.getUsageScenario_UsageModel().get(0).getId();
			for (Iterator<UsageScenario> iterator2 = um2.getUsageScenario_UsageModel().iterator(); iterator2
			.hasNext();) {
				UsageScenario us2 = iterator2
				.next();
				if(us2.getId().equals(us1_id)) {
					return true;
				}
			}
			return false;
		} else {
			return false;
		}
	}
	
	protected List<EvaluationAspectWithContext> getDimensionCriterionContexts(String dimensionId, Class<? extends Criterion> criterionClass) {
		
		List<EvaluationAspectWithContext> list = new ArrayList<EvaluationAspectWithContext>();		
		List<EvaluationAspectWithContext> criterionList;		
		if (criterionClass == Objective.class) {
			criterionList = pcmObjectives;
		} else {
			//CriterionClass == Constraint.class
			criterionList = pcmConstraints;
		}
		
		for (Iterator<EvaluationAspectWithContext> iterator = criterionList.iterator(); iterator.hasNext();) {
			EvaluationAspectWithContext aspect = iterator.next();
//			if(aspect.getContractType().getId().equals(pcmContractTypeId)) {
				if (aspect.getDimension().getId().equals(dimensionId)) {
					list.add(aspect);
				}
//			}
		}		
		
		return list;
	}
	
	/*
	 * The following methods are used to transform the QML definitions to 
	 * criteria objects that can be used for the optimization. Always get it translated here as it 
	 * won't be reversible otherwise.
	 */
	
	public org.opt4j.core.InfeasibilityConstraint translateEvalAspectToInfeasibilityConstraint(EvaluationAspectWithContext aspectContext, InfeasibilityConstraintBuilder builder) {
		EvaluationAspect aspect = aspectContext.getEvaluationAspect();
		org.opt4j.core.InfeasibilityConstraint constraint;
		if(aspect.getAspectRequirement() instanceof Restriction){		
			if (((Restriction)aspect.getAspectRequirement()).getOperator() == EnumOperator.LESS) { 		
				if (((Restriction)aspect.getAspectRequirement()).getAspectRequirementLiteral() instanceof NumericLiteral) {
					constraint = builder.createInfeasibilityConstraint(aspect.getId(), 
							Direction.less, 
							((NumericLiteral)((Restriction)aspect.getAspectRequirement()).getAspectRequirementLiteral()).getValue());
				} else {
					//TODO: Handle Enums and Sets
					throw new RuntimeException("Unsupported Constraint literal in aspect. Only numeric literals are supported so far.");
				}
			} else {
				// TODO: Extend and remove Exception
				throw new RuntimeException("Unsupported constraint operator in aspect. Only LESS (<) supported so far.");
			}
		} else {
			throw new RuntimeException("Aspect must have aspect requirement of type Restriction to derive InfeasibilityConstraint.");
		}
		
		retranslationMap.put(constraint.getName(), aspectContext);
		return constraint;
	}
	
	public SatisfactionConstraint translateEvalAspectToSatisfactionConstraint(EvaluationAspectWithContext aspectContext, org.opt4j.core.Objective objective, SatisfactionConstraintBuilder builder){
		EvaluationAspect aspect = aspectContext.getEvaluationAspect();
		SatisfactionConstraint constraint = null;
		if (((Goal)aspect.getAspectRequirement()) == null) {
			if(objective.getSign() == Sign.MIN) {
				constraint = builder.createSatisfactionConstraint(
						aspect.getId(), 
						Direction.less, 
						Double.NEGATIVE_INFINITY, 
						objective);
			} else {
				//Sign == MAX
				constraint = builder.createSatisfactionConstraint(
						aspect.getId(), 
						Direction.greater, 
						Double.POSITIVE_INFINITY, 
						objective);
			}
		} else if(aspect.getAspectRequirement() instanceof Goal){			
			if (((Goal)aspect.getAspectRequirement()).getAspectRequirementLiteral() instanceof NumericLiteral) {
				if(objective.getSign() == Sign.MIN) {
					constraint = builder.createSatisfactionConstraint(
							aspect.getId(), 
							Direction.less, 
							((NumericLiteral)((Goal)aspect.getAspectRequirement()).getAspectRequirementLiteral()).getValue(), 
							objective);
				} else {
					//Sign == MAX
					constraint = builder.createSatisfactionConstraint(
							aspect.getId(), 
							Direction.greater, 
							((NumericLiteral)((Goal)aspect.getAspectRequirement()).getAspectRequirementLiteral()).getValue(), 
							objective);
				}
			} else {
				//TODO: Handle Enums and Sets
				throw new RuntimeException("Unsupported Goal literal in aspect. Only numeric literals supported in Goal aspect requirements so far.");
			}
		} else {
			throw new RuntimeException("Aspect must have aspect requirement of type Goal to derive SatisfactionConstraint!");
		}
		
		retranslationMap.put(constraint.getName(), aspectContext);
		return constraint;
	}
	
	public org.opt4j.core.Objective translateEvalAspectToObjective(String qualityAttribute, EvaluationAspectWithContext aspectContext, ObjectiveBuilder builder) {
		//Make sure, the aspect IS an objective
		org.opt4j.core.Objective objective;
		if(aspectContext.getDimension().getType().getRelationSemantics().getRelSem() == EnumRelationSemantics.DECREASING) {
			objective = builder.createObjective(qualityAttribute, org.opt4j.core.Objective.Sign.MIN);
		} else {
			//INCREASING
			objective = builder.createObjective(qualityAttribute, org.opt4j.core.Objective.Sign.MAX);
		}
		
		retranslationMap.put(objective.getName(), aspectContext);
		return objective;
	}
	
	
	/*
	 * Static method for global uniqueness of retranslationMap. Otherwise one 
	 * would have to save all existing PCMDeclarationsReader objects or have to ensure that it is
	 * a Singleton to be able to retrieve the original information on a Criterion.
	 * 
	 * As the "Guice injection chain" is broken on several parts, where this class is needed, 
	 * annotating the class with @Singleton is not possible unless you get this class explicitly injected 
	 * retrieving and calling *the* Injector. However, the Injector is encapsulated in the Opt4J Task
	 * object, thus you would have to get the Opt4J Task to get the Injector to get this class injected...
	 * I don't think this would be a very elegant way...
	 *
	 */
	public static EvaluationAspectWithContext retranslateCriterionToEvaluationAspect(org.opt4j.core.Criterion criterion){
		return retranslationMap.get(criterion.getName());
	}
}