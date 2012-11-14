package de.uka.ipd.sdq.stoex.analyser.visitors;

import java.util.ArrayList;
import java.util.Collection;

import de.uka.ipd.sdq.errorhandling.IIssue;
import de.uka.ipd.sdq.stoex.BooleanOperatorExpression;
import de.uka.ipd.sdq.stoex.IfElseExpression;
import de.uka.ipd.sdq.stoex.NotExpression;
import de.uka.ipd.sdq.stoex.ProductExpression;
import de.uka.ipd.sdq.stoex.TermExpression;
import de.uka.ipd.sdq.stoex.analyser.exceptions.ExpectedTypeMismatchIssue;
import de.uka.ipd.sdq.stoex.util.StoexSwitch;

public class TypeCheckVisitor extends StoexSwitch<Object> {

	private ExpressionInferTypeVisitor typeVisitor;
	private ArrayList<IIssue> issues = new ArrayList<IIssue>();

	public TypeCheckVisitor(NonProbabilisticExpressionInferTypeVisitor typeVisitor) {
		this.typeVisitor = typeVisitor;
	}

	@Override
	public Object caseBooleanOperatorExpression(BooleanOperatorExpression object) {
		if (!typesCompatible(typeVisitor.getType(object.getLeft()),TypeEnum.BOOL))
			issues.add(new ExpectedTypeMismatchIssue(TypeEnum.BOOL,typeVisitor.getType(object.getLeft())));
		if (!typesCompatible(typeVisitor.getType(object.getRight()),TypeEnum.BOOL))
			issues.add(new ExpectedTypeMismatchIssue(TypeEnum.BOOL,typeVisitor.getType(object.getRight())));
		return super.caseBooleanOperatorExpression(object);
	}

	@Override
	public Object caseIfElseExpression(IfElseExpression object) {
		if (!typesCompatible(typeVisitor.getType(object.getConditionExpression()),TypeEnum.BOOL))
			issues.add(new ExpectedTypeMismatchIssue(TypeEnum.BOOL,typeVisitor.getType(object.getConditionExpression())));
		return super.caseIfElseExpression(object);
	}

	@Override
	public Object caseNotExpression(NotExpression object) {
		if (!typesCompatible(typeVisitor.getType(object.getInner()),TypeEnum.BOOL))
			issues.add(new ExpectedTypeMismatchIssue(TypeEnum.BOOL,typeVisitor.getType(object.getInner())));
		return super.caseNotExpression(object);
	}

	@Override
	public Object caseProductExpression(ProductExpression object) {
		if (!isNummericType(typeVisitor.getType(object.getLeft())))
			issues.add(new ExpectedTypeMismatchIssue("Numeric",typeVisitor.getType(object.getLeft())));
		if (!isNummericType(typeVisitor.getType(object.getRight())))
			issues.add(new ExpectedTypeMismatchIssue("Numeric",typeVisitor.getType(object.getRight())));
		return super.caseProductExpression(object);
	}

	@Override
	public Object caseTermExpression(TermExpression object) {
		if (!isNummericType(typeVisitor.getType(object.getLeft())))
			issues.add(new ExpectedTypeMismatchIssue("Numeric",typeVisitor.getType(object.getLeft())));
		if (!isNummericType(typeVisitor.getType(object.getRight())))
			issues.add(new ExpectedTypeMismatchIssue("Numeric",typeVisitor.getType(object.getRight())));
		return super.caseTermExpression(object);
	}

	public static boolean typesCompatible(TypeEnum expectedType, TypeEnum foundType) {
		if (expectedType == TypeEnum.ANY)
			return true;
		if (expectedType == foundType)
			return true;
		if (foundType == TypeEnum.ANY) // Can only decide at run time...
			return true;
		if (expectedType == TypeEnum.DOUBLE && (foundType == TypeEnum.INT || foundType == TypeEnum.DOUBLE))
			return true;
		return false;
	}

	private boolean isNummericType(TypeEnum type) {
		if (type == TypeEnum.INT ||
			type == TypeEnum.DOUBLE ||
			type == TypeEnum.ANY)
			return true;
		return false;
	}
	
	public Collection<IIssue> getIssues() {
		return this.issues;
	}

}
