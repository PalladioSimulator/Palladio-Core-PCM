package org.palladiosimulator.pcm.pcmstoex.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import de.uka.ipd.sdq.pcm.parameter.CharacterisedVariable;
import de.uka.ipd.sdq.pcm.parameter.ParameterPackage;
import de.uka.ipd.sdq.probfunction.BoolSample;
import de.uka.ipd.sdq.probfunction.BoxedPDF;
import de.uka.ipd.sdq.probfunction.ContinuousSample;
import de.uka.ipd.sdq.probfunction.DoubleSample;
import de.uka.ipd.sdq.probfunction.IntSample;
import de.uka.ipd.sdq.probfunction.ProbabilityMassFunction;
import de.uka.ipd.sdq.probfunction.ProbfunctionPackage;
import de.uka.ipd.sdq.probfunction.StringSample;
import de.uka.ipd.sdq.stoex.BoolLiteral;
import de.uka.ipd.sdq.stoex.BooleanOperatorExpression;
import de.uka.ipd.sdq.stoex.CompareExpression;
import de.uka.ipd.sdq.stoex.DoubleLiteral;
import de.uka.ipd.sdq.stoex.FunctionLiteral;
import de.uka.ipd.sdq.stoex.IfElseExpression;
import de.uka.ipd.sdq.stoex.IntLiteral;
import de.uka.ipd.sdq.stoex.NamespaceReference;
import de.uka.ipd.sdq.stoex.NegativeExpression;
import de.uka.ipd.sdq.stoex.NotExpression;
import de.uka.ipd.sdq.stoex.Parenthesis;
import de.uka.ipd.sdq.stoex.PowerExpression;
import de.uka.ipd.sdq.stoex.ProbabilityFunctionLiteral;
import de.uka.ipd.sdq.stoex.ProductExpression;
import de.uka.ipd.sdq.stoex.StoexPackage;
import de.uka.ipd.sdq.stoex.StringLiteral;
import de.uka.ipd.sdq.stoex.TermExpression;
import de.uka.ipd.sdq.stoex.VariableReference;
import de.uka.ipd.sdq.units.BaseUnit;
import de.uka.ipd.sdq.units.UnitDivision;
import de.uka.ipd.sdq.units.UnitMultiplication;
import de.uka.ipd.sdq.units.UnitPower;
import de.uka.ipd.sdq.units.UnitsPackage;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticNodeProvider.INodesForEObjectProvider;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;
import org.palladiosimulator.commons.stoex.serializer.StoExSemanticSequencer;
import org.palladiosimulator.pcm.pcmstoex.services.PCMStoExGrammarAccess;

@SuppressWarnings("all")
public abstract class AbstractPCMStoExSemanticSequencer extends StoExSemanticSequencer {

	@Inject
	private PCMStoExGrammarAccess grammarAccess;
	
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == ParameterPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case ParameterPackage.CHARACTERISED_VARIABLE:
				if(context == grammarAccess.getBooleanExpressionRule() ||
				   context == grammarAccess.getBooleanExpressionAccess().getBooleanOperatorExpressionLeftAction_1_0() ||
				   context == grammarAccess.getCharacterisedVariableRule() ||
				   context == grammarAccess.getVariableRule() ||
				   context == grammarAccess.getAtomRule() ||
				   context == grammarAccess.getAusdruckRule() ||
				   context == grammarAccess.getBoolAndExprRule() ||
				   context == grammarAccess.getBoolAndExprAccess().getBooleanOperatorExpressionLeftAction_1_0() ||
				   context == grammarAccess.getBoolOrExprRule() ||
				   context == grammarAccess.getBoolOrExprAccess().getBooleanOperatorExpressionLeftAction_1_0() ||
				   context == grammarAccess.getCompareExprRule() ||
				   context == grammarAccess.getCompareExprAccess().getCompareExpressionLeftAction_1_0() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getIfelseExprRule() ||
				   context == grammarAccess.getIfelseExprAccess().getIfElseExpressionConditionExpressionAction_1_0() ||
				   context == grammarAccess.getPowExprRule() ||
				   context == grammarAccess.getPowExprAccess().getPowerExpressionBaseAction_1_0() ||
				   context == grammarAccess.getProdExprRule() ||
				   context == grammarAccess.getProdExprAccess().getProductExpressionLeftAction_1_0() ||
				   context == grammarAccess.getSumExprRule() ||
				   context == grammarAccess.getSumExprAccess().getTermExpressionLeftAction_1_0() ||
				   context == grammarAccess.getUnaryExprRule()) {
					sequence_CharacterisedVariable(context, (CharacterisedVariable) semanticObject); 
					return; 
				}
				else break;
			}
		else if(semanticObject.eClass().getEPackage() == ProbfunctionPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case ProbfunctionPackage.BOOL_SAMPLE:
				if(context == grammarAccess.getBoolsampleRule()) {
					sequence_boolsample(context, (BoolSample) semanticObject); 
					return; 
				}
				else break;
			case ProbfunctionPackage.BOXED_PDF:
				if(context == grammarAccess.getBoxedPDFRule() ||
				   context == grammarAccess.getProbabilityDensityFunctionRule() ||
				   context == grammarAccess.getDefinitionRule()) {
					sequence_BoxedPDF(context, (BoxedPDF) semanticObject); 
					return; 
				}
				else break;
			case ProbfunctionPackage.CONTINUOUS_SAMPLE:
				if(context == grammarAccess.getReal_pdf_sampleRule()) {
					sequence_real_pdf_sample(context, (ContinuousSample) semanticObject); 
					return; 
				}
				else break;
			case ProbfunctionPackage.DOUBLE_SAMPLE:
				if(context == grammarAccess.getNumeric_real_sampleRule()) {
					sequence_numeric_real_sample(context, (DoubleSample) semanticObject); 
					return; 
				}
				else break;
			case ProbfunctionPackage.INT_SAMPLE:
				if(context == grammarAccess.getNumeric_int_sampleRule()) {
					sequence_numeric_int_sample(context, (IntSample) semanticObject); 
					return; 
				}
				else break;
			case ProbfunctionPackage.PROBABILITY_MASS_FUNCTION:
				if(context == grammarAccess.getProbabilityMassFunctionRule() ||
				   context == grammarAccess.getDefinitionRule()) {
					sequence_ProbabilityMassFunction(context, (ProbabilityMassFunction) semanticObject); 
					return; 
				}
				else break;
			case ProbfunctionPackage.STRING_SAMPLE:
				if(context == grammarAccess.getStringsampleRule()) {
					sequence_stringsample(context, (StringSample) semanticObject); 
					return; 
				}
				else break;
			}
		else if(semanticObject.eClass().getEPackage() == StoexPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case StoexPackage.BOOL_LITERAL:
				if(context == grammarAccess.getBoolLiteralRule() ||
				   context == grammarAccess.getBooleanExpressionRule() ||
				   context == grammarAccess.getBooleanExpressionAccess().getBooleanOperatorExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAtomRule() ||
				   context == grammarAccess.getAusdruckRule() ||
				   context == grammarAccess.getBoolAndExprRule() ||
				   context == grammarAccess.getBoolAndExprAccess().getBooleanOperatorExpressionLeftAction_1_0() ||
				   context == grammarAccess.getBoolOrExprRule() ||
				   context == grammarAccess.getBoolOrExprAccess().getBooleanOperatorExpressionLeftAction_1_0() ||
				   context == grammarAccess.getCompareExprRule() ||
				   context == grammarAccess.getCompareExprAccess().getCompareExpressionLeftAction_1_0() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getIfelseExprRule() ||
				   context == grammarAccess.getIfelseExprAccess().getIfElseExpressionConditionExpressionAction_1_0() ||
				   context == grammarAccess.getPowExprRule() ||
				   context == grammarAccess.getPowExprAccess().getPowerExpressionBaseAction_1_0() ||
				   context == grammarAccess.getProdExprRule() ||
				   context == grammarAccess.getProdExprAccess().getProductExpressionLeftAction_1_0() ||
				   context == grammarAccess.getSumExprRule() ||
				   context == grammarAccess.getSumExprAccess().getTermExpressionLeftAction_1_0() ||
				   context == grammarAccess.getUnaryExprRule()) {
					sequence_BoolLiteral(context, (BoolLiteral) semanticObject); 
					return; 
				}
				else break;
			case StoexPackage.BOOLEAN_OPERATOR_EXPRESSION:
				if(context == grammarAccess.getBooleanExpressionRule() ||
				   context == grammarAccess.getBooleanExpressionAccess().getBooleanOperatorExpressionLeftAction_1_0()) {
					sequence_BooleanExpression_boolOrExpr(context, (BooleanOperatorExpression) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getAusdruckRule() ||
				   context == grammarAccess.getBoolAndExprRule() ||
				   context == grammarAccess.getBoolAndExprAccess().getBooleanOperatorExpressionLeftAction_1_0() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getIfelseExprRule() ||
				   context == grammarAccess.getIfelseExprAccess().getIfElseExpressionConditionExpressionAction_1_0()) {
					sequence_boolAndExpr_boolOrExpr(context, (BooleanOperatorExpression) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getBoolOrExprRule() ||
				   context == grammarAccess.getBoolOrExprAccess().getBooleanOperatorExpressionLeftAction_1_0()) {
					sequence_boolOrExpr(context, (BooleanOperatorExpression) semanticObject); 
					return; 
				}
				else break;
			case StoexPackage.COMPARE_EXPRESSION:
				if(context == grammarAccess.getBooleanExpressionRule() ||
				   context == grammarAccess.getBooleanExpressionAccess().getBooleanOperatorExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAusdruckRule() ||
				   context == grammarAccess.getBoolAndExprRule() ||
				   context == grammarAccess.getBoolAndExprAccess().getBooleanOperatorExpressionLeftAction_1_0() ||
				   context == grammarAccess.getBoolOrExprRule() ||
				   context == grammarAccess.getBoolOrExprAccess().getBooleanOperatorExpressionLeftAction_1_0() ||
				   context == grammarAccess.getCompareExprRule() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getIfelseExprRule() ||
				   context == grammarAccess.getIfelseExprAccess().getIfElseExpressionConditionExpressionAction_1_0()) {
					sequence_compareExpr(context, (CompareExpression) semanticObject); 
					return; 
				}
				else break;
			case StoexPackage.DOUBLE_LITERAL:
				if(context == grammarAccess.getBooleanExpressionRule() ||
				   context == grammarAccess.getBooleanExpressionAccess().getBooleanOperatorExpressionLeftAction_1_0() ||
				   context == grammarAccess.getDoubleLiteralRule() ||
				   context == grammarAccess.getAtomRule() ||
				   context == grammarAccess.getAusdruckRule() ||
				   context == grammarAccess.getBoolAndExprRule() ||
				   context == grammarAccess.getBoolAndExprAccess().getBooleanOperatorExpressionLeftAction_1_0() ||
				   context == grammarAccess.getBoolOrExprRule() ||
				   context == grammarAccess.getBoolOrExprAccess().getBooleanOperatorExpressionLeftAction_1_0() ||
				   context == grammarAccess.getCompareExprRule() ||
				   context == grammarAccess.getCompareExprAccess().getCompareExpressionLeftAction_1_0() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getIfelseExprRule() ||
				   context == grammarAccess.getIfelseExprAccess().getIfElseExpressionConditionExpressionAction_1_0() ||
				   context == grammarAccess.getPowExprRule() ||
				   context == grammarAccess.getPowExprAccess().getPowerExpressionBaseAction_1_0() ||
				   context == grammarAccess.getProdExprRule() ||
				   context == grammarAccess.getProdExprAccess().getProductExpressionLeftAction_1_0() ||
				   context == grammarAccess.getSumExprRule() ||
				   context == grammarAccess.getSumExprAccess().getTermExpressionLeftAction_1_0() ||
				   context == grammarAccess.getUnaryExprRule()) {
					sequence_DoubleLiteral(context, (DoubleLiteral) semanticObject); 
					return; 
				}
				else break;
			case StoexPackage.FUNCTION_LITERAL:
				if(context == grammarAccess.getBooleanExpressionRule() ||
				   context == grammarAccess.getBooleanExpressionAccess().getBooleanOperatorExpressionLeftAction_1_0() ||
				   context == grammarAccess.getFunctionLiteralRule() ||
				   context == grammarAccess.getAtomRule() ||
				   context == grammarAccess.getAusdruckRule() ||
				   context == grammarAccess.getBoolAndExprRule() ||
				   context == grammarAccess.getBoolAndExprAccess().getBooleanOperatorExpressionLeftAction_1_0() ||
				   context == grammarAccess.getBoolOrExprRule() ||
				   context == grammarAccess.getBoolOrExprAccess().getBooleanOperatorExpressionLeftAction_1_0() ||
				   context == grammarAccess.getCompareExprRule() ||
				   context == grammarAccess.getCompareExprAccess().getCompareExpressionLeftAction_1_0() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getIfelseExprRule() ||
				   context == grammarAccess.getIfelseExprAccess().getIfElseExpressionConditionExpressionAction_1_0() ||
				   context == grammarAccess.getPowExprRule() ||
				   context == grammarAccess.getPowExprAccess().getPowerExpressionBaseAction_1_0() ||
				   context == grammarAccess.getProdExprRule() ||
				   context == grammarAccess.getProdExprAccess().getProductExpressionLeftAction_1_0() ||
				   context == grammarAccess.getSumExprRule() ||
				   context == grammarAccess.getSumExprAccess().getTermExpressionLeftAction_1_0() ||
				   context == grammarAccess.getUnaryExprRule()) {
					sequence_FunctionLiteral(context, (FunctionLiteral) semanticObject); 
					return; 
				}
				else break;
			case StoexPackage.IF_ELSE_EXPRESSION:
				if(context == grammarAccess.getAusdruckRule() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getIfelseExprRule()) {
					sequence_ifelseExpr(context, (IfElseExpression) semanticObject); 
					return; 
				}
				else break;
			case StoexPackage.INT_LITERAL:
				if(context == grammarAccess.getBooleanExpressionRule() ||
				   context == grammarAccess.getBooleanExpressionAccess().getBooleanOperatorExpressionLeftAction_1_0() ||
				   context == grammarAccess.getIntLiteralRule() ||
				   context == grammarAccess.getAtomRule() ||
				   context == grammarAccess.getAusdruckRule() ||
				   context == grammarAccess.getBoolAndExprRule() ||
				   context == grammarAccess.getBoolAndExprAccess().getBooleanOperatorExpressionLeftAction_1_0() ||
				   context == grammarAccess.getBoolOrExprRule() ||
				   context == grammarAccess.getBoolOrExprAccess().getBooleanOperatorExpressionLeftAction_1_0() ||
				   context == grammarAccess.getCompareExprRule() ||
				   context == grammarAccess.getCompareExprAccess().getCompareExpressionLeftAction_1_0() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getIfelseExprRule() ||
				   context == grammarAccess.getIfelseExprAccess().getIfElseExpressionConditionExpressionAction_1_0() ||
				   context == grammarAccess.getPowExprRule() ||
				   context == grammarAccess.getPowExprAccess().getPowerExpressionBaseAction_1_0() ||
				   context == grammarAccess.getProdExprRule() ||
				   context == grammarAccess.getProdExprAccess().getProductExpressionLeftAction_1_0() ||
				   context == grammarAccess.getSumExprRule() ||
				   context == grammarAccess.getSumExprAccess().getTermExpressionLeftAction_1_0() ||
				   context == grammarAccess.getUnaryExprRule()) {
					sequence_IntLiteral(context, (IntLiteral) semanticObject); 
					return; 
				}
				else break;
			case StoexPackage.NAMESPACE_REFERENCE:
				if(context == grammarAccess.getAbstractNamedReferenceRule() ||
				   context == grammarAccess.getNamespaceReferenceRule()) {
					sequence_NamespaceReference(context, (NamespaceReference) semanticObject); 
					return; 
				}
				else break;
			case StoexPackage.NEGATIVE_EXPRESSION:
				if(context == grammarAccess.getBooleanExpressionRule() ||
				   context == grammarAccess.getBooleanExpressionAccess().getBooleanOperatorExpressionLeftAction_1_0() ||
				   context == grammarAccess.getNegativeExpressionRule() ||
				   context == grammarAccess.getAusdruckRule() ||
				   context == grammarAccess.getBoolAndExprRule() ||
				   context == grammarAccess.getBoolAndExprAccess().getBooleanOperatorExpressionLeftAction_1_0() ||
				   context == grammarAccess.getBoolOrExprRule() ||
				   context == grammarAccess.getBoolOrExprAccess().getBooleanOperatorExpressionLeftAction_1_0() ||
				   context == grammarAccess.getCompareExprRule() ||
				   context == grammarAccess.getCompareExprAccess().getCompareExpressionLeftAction_1_0() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getIfelseExprRule() ||
				   context == grammarAccess.getIfelseExprAccess().getIfElseExpressionConditionExpressionAction_1_0() ||
				   context == grammarAccess.getPowExprRule() ||
				   context == grammarAccess.getPowExprAccess().getPowerExpressionBaseAction_1_0() ||
				   context == grammarAccess.getProdExprRule() ||
				   context == grammarAccess.getProdExprAccess().getProductExpressionLeftAction_1_0() ||
				   context == grammarAccess.getSumExprRule() ||
				   context == grammarAccess.getSumExprAccess().getTermExpressionLeftAction_1_0() ||
				   context == grammarAccess.getUnaryExprRule()) {
					sequence_NegativeExpression(context, (NegativeExpression) semanticObject); 
					return; 
				}
				else break;
			case StoexPackage.NOT_EXPRESSION:
				if(context == grammarAccess.getBooleanExpressionRule() ||
				   context == grammarAccess.getBooleanExpressionAccess().getBooleanOperatorExpressionLeftAction_1_0() ||
				   context == grammarAccess.getNotExpressionRule() ||
				   context == grammarAccess.getAusdruckRule() ||
				   context == grammarAccess.getBoolAndExprRule() ||
				   context == grammarAccess.getBoolAndExprAccess().getBooleanOperatorExpressionLeftAction_1_0() ||
				   context == grammarAccess.getBoolOrExprRule() ||
				   context == grammarAccess.getBoolOrExprAccess().getBooleanOperatorExpressionLeftAction_1_0() ||
				   context == grammarAccess.getCompareExprRule() ||
				   context == grammarAccess.getCompareExprAccess().getCompareExpressionLeftAction_1_0() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getIfelseExprRule() ||
				   context == grammarAccess.getIfelseExprAccess().getIfElseExpressionConditionExpressionAction_1_0() ||
				   context == grammarAccess.getPowExprRule() ||
				   context == grammarAccess.getPowExprAccess().getPowerExpressionBaseAction_1_0() ||
				   context == grammarAccess.getProdExprRule() ||
				   context == grammarAccess.getProdExprAccess().getProductExpressionLeftAction_1_0() ||
				   context == grammarAccess.getSumExprRule() ||
				   context == grammarAccess.getSumExprAccess().getTermExpressionLeftAction_1_0() ||
				   context == grammarAccess.getUnaryExprRule()) {
					sequence_NotExpression(context, (NotExpression) semanticObject); 
					return; 
				}
				else break;
			case StoexPackage.PARENTHESIS:
				if(context == grammarAccess.getBooleanExpressionRule() ||
				   context == grammarAccess.getBooleanExpressionAccess().getBooleanOperatorExpressionLeftAction_1_0() ||
				   context == grammarAccess.getParenthesisRule() ||
				   context == grammarAccess.getAtomRule() ||
				   context == grammarAccess.getAusdruckRule() ||
				   context == grammarAccess.getBoolAndExprRule() ||
				   context == grammarAccess.getBoolAndExprAccess().getBooleanOperatorExpressionLeftAction_1_0() ||
				   context == grammarAccess.getBoolOrExprRule() ||
				   context == grammarAccess.getBoolOrExprAccess().getBooleanOperatorExpressionLeftAction_1_0() ||
				   context == grammarAccess.getCompareExprRule() ||
				   context == grammarAccess.getCompareExprAccess().getCompareExpressionLeftAction_1_0() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getIfelseExprRule() ||
				   context == grammarAccess.getIfelseExprAccess().getIfElseExpressionConditionExpressionAction_1_0() ||
				   context == grammarAccess.getPowExprRule() ||
				   context == grammarAccess.getPowExprAccess().getPowerExpressionBaseAction_1_0() ||
				   context == grammarAccess.getProdExprRule() ||
				   context == grammarAccess.getProdExprAccess().getProductExpressionLeftAction_1_0() ||
				   context == grammarAccess.getSumExprRule() ||
				   context == grammarAccess.getSumExprAccess().getTermExpressionLeftAction_1_0() ||
				   context == grammarAccess.getUnaryExprRule()) {
					sequence_Parenthesis(context, (Parenthesis) semanticObject); 
					return; 
				}
				else break;
			case StoexPackage.POWER_EXPRESSION:
				if(context == grammarAccess.getBooleanExpressionRule() ||
				   context == grammarAccess.getBooleanExpressionAccess().getBooleanOperatorExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAusdruckRule() ||
				   context == grammarAccess.getBoolAndExprRule() ||
				   context == grammarAccess.getBoolAndExprAccess().getBooleanOperatorExpressionLeftAction_1_0() ||
				   context == grammarAccess.getBoolOrExprRule() ||
				   context == grammarAccess.getBoolOrExprAccess().getBooleanOperatorExpressionLeftAction_1_0() ||
				   context == grammarAccess.getCompareExprRule() ||
				   context == grammarAccess.getCompareExprAccess().getCompareExpressionLeftAction_1_0() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getIfelseExprRule() ||
				   context == grammarAccess.getIfelseExprAccess().getIfElseExpressionConditionExpressionAction_1_0() ||
				   context == grammarAccess.getPowExprRule() ||
				   context == grammarAccess.getProdExprRule() ||
				   context == grammarAccess.getProdExprAccess().getProductExpressionLeftAction_1_0() ||
				   context == grammarAccess.getSumExprRule() ||
				   context == grammarAccess.getSumExprAccess().getTermExpressionLeftAction_1_0()) {
					sequence_powExpr(context, (PowerExpression) semanticObject); 
					return; 
				}
				else break;
			case StoexPackage.PROBABILITY_FUNCTION_LITERAL:
				if(context == grammarAccess.getBooleanExpressionRule() ||
				   context == grammarAccess.getBooleanExpressionAccess().getBooleanOperatorExpressionLeftAction_1_0() ||
				   context == grammarAccess.getProbabilityFunctionLiteralRule() ||
				   context == grammarAccess.getAtomRule() ||
				   context == grammarAccess.getAusdruckRule() ||
				   context == grammarAccess.getBoolAndExprRule() ||
				   context == grammarAccess.getBoolAndExprAccess().getBooleanOperatorExpressionLeftAction_1_0() ||
				   context == grammarAccess.getBoolOrExprRule() ||
				   context == grammarAccess.getBoolOrExprAccess().getBooleanOperatorExpressionLeftAction_1_0() ||
				   context == grammarAccess.getCompareExprRule() ||
				   context == grammarAccess.getCompareExprAccess().getCompareExpressionLeftAction_1_0() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getIfelseExprRule() ||
				   context == grammarAccess.getIfelseExprAccess().getIfElseExpressionConditionExpressionAction_1_0() ||
				   context == grammarAccess.getPowExprRule() ||
				   context == grammarAccess.getPowExprAccess().getPowerExpressionBaseAction_1_0() ||
				   context == grammarAccess.getProdExprRule() ||
				   context == grammarAccess.getProdExprAccess().getProductExpressionLeftAction_1_0() ||
				   context == grammarAccess.getSumExprRule() ||
				   context == grammarAccess.getSumExprAccess().getTermExpressionLeftAction_1_0() ||
				   context == grammarAccess.getUnaryExprRule()) {
					sequence_ProbabilityFunctionLiteral(context, (ProbabilityFunctionLiteral) semanticObject); 
					return; 
				}
				else break;
			case StoexPackage.PRODUCT_EXPRESSION:
				if(context == grammarAccess.getBooleanExpressionRule() ||
				   context == grammarAccess.getBooleanExpressionAccess().getBooleanOperatorExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAusdruckRule() ||
				   context == grammarAccess.getBoolAndExprRule() ||
				   context == grammarAccess.getBoolAndExprAccess().getBooleanOperatorExpressionLeftAction_1_0() ||
				   context == grammarAccess.getBoolOrExprRule() ||
				   context == grammarAccess.getBoolOrExprAccess().getBooleanOperatorExpressionLeftAction_1_0() ||
				   context == grammarAccess.getCompareExprRule() ||
				   context == grammarAccess.getCompareExprAccess().getCompareExpressionLeftAction_1_0() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getIfelseExprRule() ||
				   context == grammarAccess.getIfelseExprAccess().getIfElseExpressionConditionExpressionAction_1_0() ||
				   context == grammarAccess.getProdExprRule() ||
				   context == grammarAccess.getProdExprAccess().getProductExpressionLeftAction_1_0() ||
				   context == grammarAccess.getSumExprRule() ||
				   context == grammarAccess.getSumExprAccess().getTermExpressionLeftAction_1_0()) {
					sequence_prodExpr(context, (ProductExpression) semanticObject); 
					return; 
				}
				else break;
			case StoexPackage.STRING_LITERAL:
				if(context == grammarAccess.getBooleanExpressionRule() ||
				   context == grammarAccess.getBooleanExpressionAccess().getBooleanOperatorExpressionLeftAction_1_0() ||
				   context == grammarAccess.getStringLiteralRule() ||
				   context == grammarAccess.getAtomRule() ||
				   context == grammarAccess.getAusdruckRule() ||
				   context == grammarAccess.getBoolAndExprRule() ||
				   context == grammarAccess.getBoolAndExprAccess().getBooleanOperatorExpressionLeftAction_1_0() ||
				   context == grammarAccess.getBoolOrExprRule() ||
				   context == grammarAccess.getBoolOrExprAccess().getBooleanOperatorExpressionLeftAction_1_0() ||
				   context == grammarAccess.getCompareExprRule() ||
				   context == grammarAccess.getCompareExprAccess().getCompareExpressionLeftAction_1_0() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getIfelseExprRule() ||
				   context == grammarAccess.getIfelseExprAccess().getIfElseExpressionConditionExpressionAction_1_0() ||
				   context == grammarAccess.getPowExprRule() ||
				   context == grammarAccess.getPowExprAccess().getPowerExpressionBaseAction_1_0() ||
				   context == grammarAccess.getProdExprRule() ||
				   context == grammarAccess.getProdExprAccess().getProductExpressionLeftAction_1_0() ||
				   context == grammarAccess.getSumExprRule() ||
				   context == grammarAccess.getSumExprAccess().getTermExpressionLeftAction_1_0() ||
				   context == grammarAccess.getUnaryExprRule()) {
					sequence_StringLiteral(context, (StringLiteral) semanticObject); 
					return; 
				}
				else break;
			case StoexPackage.TERM_EXPRESSION:
				if(context == grammarAccess.getBooleanExpressionRule() ||
				   context == grammarAccess.getBooleanExpressionAccess().getBooleanOperatorExpressionLeftAction_1_0() ||
				   context == grammarAccess.getAusdruckRule() ||
				   context == grammarAccess.getBoolAndExprRule() ||
				   context == grammarAccess.getBoolAndExprAccess().getBooleanOperatorExpressionLeftAction_1_0() ||
				   context == grammarAccess.getBoolOrExprRule() ||
				   context == grammarAccess.getBoolOrExprAccess().getBooleanOperatorExpressionLeftAction_1_0() ||
				   context == grammarAccess.getCompareExprRule() ||
				   context == grammarAccess.getCompareExprAccess().getCompareExpressionLeftAction_1_0() ||
				   context == grammarAccess.getExpressionRule() ||
				   context == grammarAccess.getIfelseExprRule() ||
				   context == grammarAccess.getIfelseExprAccess().getIfElseExpressionConditionExpressionAction_1_0() ||
				   context == grammarAccess.getSumExprRule() ||
				   context == grammarAccess.getSumExprAccess().getTermExpressionLeftAction_1_0()) {
					sequence_sumExpr(context, (TermExpression) semanticObject); 
					return; 
				}
				else break;
			case StoexPackage.VARIABLE_REFERENCE:
				if(context == grammarAccess.getAbstractNamedReferenceRule() ||
				   context == grammarAccess.getVariableReferenceRule()) {
					sequence_VariableReference(context, (VariableReference) semanticObject); 
					return; 
				}
				else break;
			}
		else if(semanticObject.eClass().getEPackage() == UnitsPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case UnitsPackage.BASE_UNIT:
				if(context == grammarAccess.getBaseUnitRule() ||
				   context == grammarAccess.getUnitRule() ||
				   context == grammarAccess.getUnitDivRule() ||
				   context == grammarAccess.getUnitDivAccess().getUnitDivisionDividendAction_1_0() ||
				   context == grammarAccess.getUnitMultiRule() ||
				   context == grammarAccess.getUnitMultiAccess().getUnitMultiplicationUnitsAction_1_0() ||
				   context == grammarAccess.getUnitPowRule() ||
				   context == grammarAccess.getUnitPowAccess().getUnitPowerUnitAction_1_0()) {
					sequence_BaseUnit(context, (BaseUnit) semanticObject); 
					return; 
				}
				else break;
			case UnitsPackage.UNIT_DIVISION:
				if(context == grammarAccess.getUnitRule() ||
				   context == grammarAccess.getUnitDivRule() ||
				   context == grammarAccess.getUnitDivAccess().getUnitDivisionDividendAction_1_0() ||
				   context == grammarAccess.getUnitMultiRule() ||
				   context == grammarAccess.getUnitMultiAccess().getUnitMultiplicationUnitsAction_1_0() ||
				   context == grammarAccess.getUnitPowRule() ||
				   context == grammarAccess.getUnitPowAccess().getUnitPowerUnitAction_1_0()) {
					sequence_unitDiv(context, (UnitDivision) semanticObject); 
					return; 
				}
				else break;
			case UnitsPackage.UNIT_MULTIPLICATION:
				if(context == grammarAccess.getUnitRule() ||
				   context == grammarAccess.getUnitDivRule() ||
				   context == grammarAccess.getUnitDivAccess().getUnitDivisionDividendAction_1_0() ||
				   context == grammarAccess.getUnitMultiRule() ||
				   context == grammarAccess.getUnitMultiAccess().getUnitMultiplicationUnitsAction_1_0() ||
				   context == grammarAccess.getUnitPowRule() ||
				   context == grammarAccess.getUnitPowAccess().getUnitPowerUnitAction_1_0()) {
					sequence_unitMulti(context, (UnitMultiplication) semanticObject); 
					return; 
				}
				else break;
			case UnitsPackage.UNIT_POWER:
				if(context == grammarAccess.getUnitRule() ||
				   context == grammarAccess.getUnitDivRule() ||
				   context == grammarAccess.getUnitDivAccess().getUnitDivisionDividendAction_1_0() ||
				   context == grammarAccess.getUnitMultiRule() ||
				   context == grammarAccess.getUnitMultiAccess().getUnitMultiplicationUnitsAction_1_0() ||
				   context == grammarAccess.getUnitPowRule() ||
				   context == grammarAccess.getUnitPowAccess().getUnitPowerUnitAction_1_0()) {
					sequence_unitPow(context, (UnitPower) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (id_Variable=VariableReference characterisationType=VariableCharacterisationType)
	 */
	protected void sequence_CharacterisedVariable(EObject context, CharacterisedVariable semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient((EObject)semanticObject, StoexPackage.Literals.VARIABLE__ID_VARIABLE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject)semanticObject, StoexPackage.Literals.VARIABLE__ID_VARIABLE));
			if(transientValues.isValueTransient((EObject)semanticObject, ParameterPackage.Literals.CHARACTERISED_VARIABLE__CHARACTERISATION_TYPE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing((EObject)semanticObject, ParameterPackage.Literals.CHARACTERISED_VARIABLE__CHARACTERISATION_TYPE));
		}
		INodesForEObjectProvider nodes = createNodeProvider((EObject)semanticObject);
		SequenceFeeder feeder = createSequencerFeeder((EObject)semanticObject, nodes);
		feeder.accept(grammarAccess.getCharacterisedVariableAccess().getId_VariableVariableReferenceParserRuleCall_0_0(), semanticObject.getId_Variable());
		feeder.accept(grammarAccess.getCharacterisedVariableAccess().getCharacterisationTypeVariableCharacterisationTypeEnumRuleCall_2_0(), semanticObject.getCharacterisationType());
		feeder.finish();
	}
}
