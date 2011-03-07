/**
 * 
 */
package de.uka.ipd.sdq.dsexplore.qml.reader;

import java.util.ArrayList;
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
import de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.Dimension;
import de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.QMLContractType;
import de.uka.ipd.sdq.dsexplore.qml.declarations.QMLDeclarations.QMLDeclarations;
import de.uka.ipd.sdq.dsexplore.qml.profile.QMLProfile.Requirement;
import de.uka.ipd.sdq.dsexplore.qml.profile.QMLProfile.SimpleQMLProfile;
import de.uka.ipd.sdq.pcm.usagemodel.UsageModel;
import de.uka.ipd.sdq.pcm.usagemodel.UsageScenario;

/**
 * @author Qais
 *
 */
public class PCMDeclarationsReader {

	//TODO: Delete
//	private final static String defaultQMLContractTypePath = 
//		//"pathmap://PCM_MODELS/PCMStandardQMLContractType.qmldeclarations";
//		"C:\\Dokumente und Einstellungen\\Qais\\Desktop\\workspace_dipl\\" +
//		"de.uka.ipd.sdq.dsexplore.constrainthandling.qmldeclarations\\PCMStandardQMLContractType.qmldeclarations";
//	
//	
//	private final static String[] defaultPCMProfilePaths = {
//		"C:\\Dokumente und Einstellungen\\Qais\\Desktop\\workspace_dipl\\" +
//		"de.uka.ipd.sdq.dsexplore.constrainthandling.qmldeclarations\\PCMProfile.qmldeclarations"
//	};
	
	//TODO: Move to DSEConstantsContainer (?)
	private final static String costDimensionName = "cost";
	private final static String pofodDimensionName = "POFOD";
	private final static String responseTimeDimensionName = "response time";

	protected final String PCMContractTypePath;
	protected final String[] PCMProfilePaths;
	
	
	protected QMLDeclarationsReader qmlReader;
	protected QMLContractType pcmContractType;
	//Refined are not supported yet
	protected List<SimpleQMLProfile> pcmProfiles = new ArrayList<SimpleQMLProfile>();
	protected List<EvaluationAspectWithContext> pcmConstraints = new ArrayList<EvaluationAspectWithContext>();
	protected List<EvaluationAspectWithContext> pcmObjectives = new ArrayList<EvaluationAspectWithContext>();
	
	protected String dimensionId_Cost = null;
	protected String dimensionId_POFOD = null;
	protected String dimensionId_ResponseTime = null;
	protected String pcmContractTypeId = null;
	
//	public PCMDeclarationsReader() {
//		this(new QMLDeclarationsReader());
//	}
	
//	@Inject 
//	public PCMDeclarationsReader(QMLDeclarationsReader reader) {
//		this(reader, defaultQMLContractTypePath, defaultPCMProfilePaths);
//		
//	}
	
	public PCMDeclarationsReader(String PCMContractTypePath, 
			String PCMProfilePath) {
		this(new QMLDeclarationsReader(), PCMContractTypePath, new String[]{PCMProfilePath});
	}
	
	protected PCMDeclarationsReader(QMLDeclarationsReader reader, 
			String PCMContractTypePath, 
			String[] PCMProfilePaths) {
		this.qmlReader = reader;
		this.PCMContractTypePath = PCMContractTypePath;
		this.PCMProfilePaths = PCMProfilePaths;
		
		init();
	}
	
	protected void init() {

		initPCMContractType();
		initPCMProfiles();
		initPCMConstraintsAndObjectives();
				
		initPCMContractTypeID();
		initDimensionIds();
	}
	
	protected void initPCMContractType() {
		//XXX: Be sure to read the declarations correctly
		QMLDeclarations declarations = qmlReader.getQMLDeclarations(PCMContractTypePath).get(0);
		List<QMLContractType> ctList = qmlReader.getQMLContractTypes(declarations);
		pcmContractType = ctList.get(0);
	}
	
	protected void initPCMProfiles() {
		//XXX: Be sure to read the declarations correctly
		//TODO: Support refinements
		for (int i = 0; i < PCMProfilePaths.length; i++) {
			String PCMProfilePath = PCMProfilePaths[i];
			QMLDeclarations declarations = qmlReader.getQMLDeclarations(PCMProfilePath).get(0);	
			pcmProfiles.addAll(qmlReader.getSimpleQMLProfiles(declarations));
		}
	}
	
	protected void initPCMConstraintsAndObjectives(){
		for (Iterator<SimpleQMLProfile> iterator = pcmProfiles.iterator(); iterator.hasNext();) {
			//Only Simple Profiles atm
			SimpleQMLProfile simpleProfile = (SimpleQMLProfile) iterator.next();
			for (Iterator<Requirement> iterator2 = simpleProfile.getRequirements().iterator(); iterator2
					.hasNext();) {
				Requirement requirement = (Requirement) iterator2.next();
				for (Iterator<GenericQMLContract> iterator3 = requirement.getRequireContract().iterator(); iterator3
						.hasNext();) {
					GenericQMLContract contract = (GenericQMLContract) iterator3.next();
					if (contract instanceof SimpleQMLContract) {
						SimpleQMLContract simpleContract = (SimpleQMLContract) contract;
						for (Iterator<Criterion> iterator4 = simpleContract.getCriteria().iterator(); iterator4
								.hasNext();) {
							Criterion criterion = (Criterion) iterator4.next();
							for (Iterator<EvaluationAspect> iterator5 = criterion.getAspects().iterator(); iterator5
									.hasNext();) {
								EvaluationAspect aspect = (EvaluationAspect) iterator5.next();
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
						throw new RuntimeException("Unaccepted QML Contract! Simple QML Contract expected");
					}
				}
			}
		}
	}
	
	protected void initPCMContractTypeID() {
		pcmContractTypeId = pcmContractType.getId();
	}
	
	protected void initDimensionIds() {
		for (Iterator<Dimension> iterator = this.pcmContractType.getDimensions().iterator(); iterator.hasNext();) {
			Dimension d = (Dimension) iterator.next();
			if(d.getEntityName().equals(costDimensionName)) {
				dimensionId_Cost = d.getId();
			} else if(d.getEntityName().equals(pofodDimensionName)) {
				dimensionId_POFOD = d.getId();
			} else if(d.getEntityName().equals(responseTimeDimensionName)) {
				dimensionId_ResponseTime = d.getId();
			}
		}
	}
	
	public List<EvaluationAspectWithContext> getCostConstraintAspects(UsageModel usageModel) {		
		return new ArrayList<EvaluationAspectWithContext>(getDimensionCriterionContextsForUsageModel(usageModel, dimensionId_Cost, Constraint.class));
	}
	
	public List<EvaluationAspectWithContext> getPOFODConstraintAspects(UsageModel usageModel) {
		return new ArrayList<EvaluationAspectWithContext>(getDimensionCriterionContextsForUsageModel(usageModel, dimensionId_POFOD, Constraint.class));
	}
	
	public List<EvaluationAspectWithContext> getResponseTimeConstraintAspects(UsageModel usageModel) {
		return new ArrayList<EvaluationAspectWithContext>(getDimensionCriterionContextsForUsageModel(usageModel, dimensionId_ResponseTime, Constraint.class));
	}

	public List<EvaluationAspectWithContext> getCostObjectiveAspects(UsageModel usageModel) {
		return new ArrayList<EvaluationAspectWithContext>(getDimensionCriterionContextsForUsageModel(usageModel, dimensionId_Cost, Objective.class));
	}
	
	public List<EvaluationAspectWithContext> getPOFODObjectiveAspects(UsageModel usageModel) {
		return new ArrayList<EvaluationAspectWithContext>(getDimensionCriterionContextsForUsageModel(usageModel, dimensionId_POFOD, Objective.class));
	}
	
	public List<EvaluationAspectWithContext> getResponseTimeObjectiveAspects(UsageModel usageModel) {
		return new ArrayList<EvaluationAspectWithContext>(getDimensionCriterionContextsForUsageModel(usageModel, dimensionId_ResponseTime, Objective.class));
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
		if (um1.getUsageScenario_UsageModel().size() != 0 && um2.getUsageScenario_UsageModel().size() != 0) {
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
			// only 'pointer' equality can be considered, which is most likely to be false
			return (um1 == um2);
		}
	}
	
	protected List<EvaluationAspectWithContext> getDimensionCriterionContexts(String dimensionId, Class<? extends Criterion> CriterionClass) {
		
		List<EvaluationAspectWithContext> list = new ArrayList<EvaluationAspectWithContext>();		
		List<EvaluationAspectWithContext> criterionList;		
		if (CriterionClass == Objective.class) {
			criterionList = pcmObjectives;
		} else {
			//CriterionClass == Constraint.class
			criterionList = pcmConstraints;
		}
		
		for (Iterator<EvaluationAspectWithContext> iterator = criterionList.iterator(); iterator.hasNext();) {
			EvaluationAspectWithContext aspect = iterator.next();
			if(aspect.getContractType().getId().equals(pcmContractTypeId)) {
				if (aspect.getDimension().getId().equals(dimensionId)) {
					list.add(aspect);
				}
			}
		}		
		
		return list;
	}
	
	public org.opt4j.core.InfeasibilityConstraint translateEvalAspectToInfeasibilityConstraint(EvaluationAspect aspect) {
		if(aspect.getAspectRequirement() instanceof Restriction){		
			if (((Restriction)aspect.getAspectRequirement()).getOperator() == EnumOperator.LESS) { 		
				if (((Restriction)aspect.getAspectRequirement()).getAspectRequirementLiteral() instanceof NumericLiteral) {
					return new org.opt4j.core.InfeasibilityConstraint(aspect.getId(), 
							Direction.less, 
							((NumericLiteral)((Restriction)aspect.getAspectRequirement()).getAspectRequirementLiteral()).getValue());
				} else {
					//TODO: Handle Enums and Sets
					throw new RuntimeException("Unsupported Constraint literal in aspect");
				}
			} else {
				// TODO: Extend Opt4J and remove Exception
				throw new RuntimeException("Unsupported constraint operator in aspect");
			}
		} else {
			throw new RuntimeException("Aspect must have Restriction to derive InfeasibilityConstraint!");
		}
	}
	
	public SatisfactionConstraint translateEvalAspectToSatisfactionConstraint(EvaluationAspect aspect, org.opt4j.core.Objective objective){
		if (((Goal)aspect.getAspectRequirement()) == null) {
			if(objective.getSign() == Sign.MIN) {
				return new SatisfactionConstraint(
						aspect.getId(), 
						Direction.less, 
						Double.NEGATIVE_INFINITY, 
						objective);
			} else {
				//Sign == MAX
				return new SatisfactionConstraint(
						aspect.getId(), 
						Direction.greater, 
						Double.POSITIVE_INFINITY, 
						objective);
			}
		}
		if(aspect.getAspectRequirement() instanceof Goal){			
			if (((Goal)aspect.getAspectRequirement()).getAspectRequirementLiteral() instanceof NumericLiteral) {
				if(objective.getSign() == Sign.MIN) {
					return new SatisfactionConstraint(
							aspect.getId(), 
							Direction.less, 
							((NumericLiteral)((Goal)aspect.getAspectRequirement()).getAspectRequirementLiteral()).getValue(), 
							objective);
				} else {
					//Sign == MAX
					return new SatisfactionConstraint(
							aspect.getId(), 
							Direction.greater, 
							((NumericLiteral)((Goal)aspect.getAspectRequirement()).getAspectRequirementLiteral()).getValue(), 
							objective);
				}
			} else {
				//TODO: Handle Enums and Sets
				throw new RuntimeException("Unsupported Goal literal in aspect");
			}
		} else {
			throw new RuntimeException("Aspect must have Goal to derive SatisfactionConstraint!");
		}
	}
	
}