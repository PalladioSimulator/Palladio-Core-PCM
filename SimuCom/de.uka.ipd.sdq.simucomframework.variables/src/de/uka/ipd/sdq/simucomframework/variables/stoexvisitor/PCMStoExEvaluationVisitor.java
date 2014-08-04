package de.uka.ipd.sdq.simucomframework.variables.stoexvisitor;

import java.util.ArrayList;
import java.util.Map.Entry;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.pcm.parameter.CharacterisedVariable;
import de.uka.ipd.sdq.pcm.stochasticexpressions.PCMStoExPrettyPrintVisitor;
import de.uka.ipd.sdq.pcm.stochasticexpressions.PCMStoExSwitch;
import de.uka.ipd.sdq.probfunction.math.IProbabilityFunctionFactory;
import de.uka.ipd.sdq.simucomframework.variables.EvaluationProxy;
import de.uka.ipd.sdq.simucomframework.variables.StackContext;
import de.uka.ipd.sdq.simucomframework.variables.cache.StoExCacheEntry;
import de.uka.ipd.sdq.simucomframework.variables.exceptions.TypesIncompatibleInComparisionException;
import de.uka.ipd.sdq.simucomframework.variables.exceptions.TypesIncompatibleInProductException;
import de.uka.ipd.sdq.simucomframework.variables.exceptions.TypesIncompatibleInTermException;
import de.uka.ipd.sdq.simucomframework.variables.exceptions.ValueNotInFrameException;
import de.uka.ipd.sdq.simucomframework.variables.functions.FunctionLib;
import de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe;
import de.uka.ipd.sdq.stoex.BoolLiteral;
import de.uka.ipd.sdq.stoex.BooleanOperatorExpression;
import de.uka.ipd.sdq.stoex.CompareExpression;
import de.uka.ipd.sdq.stoex.DoubleLiteral;
import de.uka.ipd.sdq.stoex.Expression;
import de.uka.ipd.sdq.stoex.FunctionLiteral;
import de.uka.ipd.sdq.stoex.IfElseExpression;
import de.uka.ipd.sdq.stoex.IntLiteral;
import de.uka.ipd.sdq.stoex.NegativeExpression;
import de.uka.ipd.sdq.stoex.NotExpression;
import de.uka.ipd.sdq.stoex.Parenthesis;
import de.uka.ipd.sdq.stoex.PowerExpression;
import de.uka.ipd.sdq.stoex.ProbabilityFunctionLiteral;
import de.uka.ipd.sdq.stoex.ProductExpression;
import de.uka.ipd.sdq.stoex.StringLiteral;
import de.uka.ipd.sdq.stoex.TermExpression;
import de.uka.ipd.sdq.stoex.analyser.visitors.ExpressionInferTypeVisitor;
import de.uka.ipd.sdq.stoex.analyser.visitors.TypeEnum;

/**
 * Visitor to evaluate stoex. It executes the corresponding Java mathematical operations at each
 * operator. It partially relies on the types infered to do its casts
 * 
 * @author Steffen Becker
 *
 */
public class PCMStoExEvaluationVisitor extends PCMStoExSwitch {

    /**
     * This class' LOGGER
     */
    private static final Logger LOGGER = Logger.getLogger(PCMStoExEvaluationVisitor.class.getName());

    /**
     * Subvisitor to evaluate probability functions inside the visited stoex
     */
    private final PCMProbfunctionEvaluationVisitor probfunctionVisitor;

    /**
     * Stackframe against which variables will be evaluated
     */
    private final SimulatedStackframe<Object> myStackFrame;

    /**
     * Type infer visitor which will be used to infer the stoex's type
     */
    private final ExpressionInferTypeVisitor typeInferer;

    /**
     * Function lib contains functions like Exp, etc. This cannot be static as it depends on its
     * respective random number generator
     */
    private final FunctionLib functionLib;

    /**
     * Mode for evaluating variables. Determines when to throw Exceptions if some evaluation fails
     */
    private VariableMode mode;

    public PCMStoExEvaluationVisitor(StoExCacheEntry cacheEntry, SimulatedStackframe<Object> frame,
            VariableMode initialMode, IProbabilityFunctionFactory probFunctionFactory) {
        this.typeInferer = cacheEntry.getTypeInferer();
        myStackFrame = frame;
        this.mode = initialMode;
        probfunctionVisitor = new PCMProbfunctionEvaluationVisitor(cacheEntry);
        functionLib = new FunctionLib(probFunctionFactory.getRandomGenerator(), probFunctionFactory.getPDFFactory());
    }

    public void setVariableMode(VariableMode mode) {
        this.mode = mode;
    }

    public VariableMode getVariableMode() {
        return this.mode;
    }

    @Override
    public Object caseCharacterisedVariable(CharacterisedVariable object) {
        String variableID = new PCMStoExPrettyPrintVisitor().prettyPrint(object);
        try {
            Object value = this.myStackFrame.getValue(variableID);
            if (value instanceof EvaluationProxy) {
                EvaluationProxy proxy = (EvaluationProxy) value;
                return StackContext.evaluateStatic(proxy.getStoEx(), proxy.getStackFrame());
            } else {
                return value;
            }
        } catch (ValueNotInFrameException e) {
            if (mode == VariableMode.EXCEPTION_ON_NOT_FOUND) {
                LOGGER.error("Value should be in stackframe, but it is not!", e);
            }
        }
        if (mode == VariableMode.EXCEPTION_ON_NOT_FOUND) {
            String availableIDs = "";
            for (Entry<String, Object> e : this.myStackFrame.getContents()) {
                availableIDs += "<" + e.getKey() + "> ";
            }
            RuntimeException re = new RuntimeException(
                    "Architecture specification incomplete. Stackframe is missing id " + variableID
                            + "\nAvailable IDs are " + availableIDs);
            LOGGER.error("Value not found in specification", re);
            throw re;
        } else if (mode == VariableMode.RETURN_NULL_ON_NOT_FOUND) {
            return null;
        } else {
            if (typeInferer.getType(object) == TypeEnum.INT)
                return 0;
            if (typeInferer.getType(object) == TypeEnum.DOUBLE)
                return 0.0;
            if (typeInferer.getType(object) == TypeEnum.ENUM)
                return "";
            if (typeInferer.getType(object) == TypeEnum.BOOL)
                return false;
            RuntimeException re = new RuntimeException(
                    "Architecture specification incomplete. Stackframe is missing id " + variableID);
            LOGGER.error("Value not found in specification", re);
            throw re;
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public Object caseCompareExpression(CompareExpression object) {
        TypeEnum leftType = typeInferer.getType(object.getLeft());
        TypeEnum rightType = typeInferer.getType(object.getRight());
        Object leftExpr = doSwitch(object.getLeft());
        Object rightExpr = doSwitch(object.getRight());
        if (leftType == TypeEnum.ANY)
            leftType = getDynamicType(leftExpr);
        if (rightType == TypeEnum.ANY)
            rightType = getDynamicType(rightExpr);

        if (leftType == TypeEnum.INT && rightType == TypeEnum.DOUBLE)
            leftExpr = Double.valueOf((((Integer) leftExpr).intValue()));
        if (rightType == TypeEnum.INT && leftType == TypeEnum.DOUBLE)
            rightExpr = Double.valueOf((((Integer) rightExpr).intValue()));

        // If types still don't comply, give up!
        if (leftExpr.getClass() != rightExpr.getClass()) {
            throw new TypesIncompatibleInComparisionException("Can not compare " + leftExpr.getClass().getName()
                    + " to " + rightExpr.getClass().getName());
        }

        int result = ((Comparable) leftExpr).compareTo(rightExpr);
        switch (object.getOperation()) {
        case EQUALS:
            return result == 0;
        case LESS:
            return result < 0;
        case LESSEQUAL:
            return result <= 0;
        case GREATER:
            return result > 0;
        case GREATEREQUAL:
            return result >= 0;
        case NOTEQUAL:
            return result != 0;
        }
        throw new RuntimeException("Unknown Compare Operation found! Should not happen!");
    }

    @Override
    public Object caseDoubleLiteral(DoubleLiteral object) {
        return object.getValue();
    }

    @Override
    public Object caseIntLiteral(IntLiteral object) {
        return object.getValue();
    }

    @Override
    public Object caseStringLiteral(StringLiteral object) {
        return object.getValue();
    }

    @Override
    public Object caseParenthesis(Parenthesis object) {
        return doSwitch(object.getInnerExpression());
    }

    @Override
    public Object caseProbabilityFunctionLiteral(ProbabilityFunctionLiteral object) {
        return probfunctionVisitor.doSwitch(object.getFunction_ProbabilityFunctionLiteral());
    }

    @Override
    public Object caseProductExpression(ProductExpression object) {
        TypeEnum leftType = typeInferer.getType(object.getLeft());
        TypeEnum rightType = typeInferer.getType(object.getRight());
        Object left = doSwitch(object.getLeft());
        Object right = doSwitch(object.getRight());
        if (leftType == TypeEnum.ANY)
            leftType = getDynamicType(left);
        if (rightType == TypeEnum.ANY)
            rightType = getDynamicType(right);
        if (leftType == TypeEnum.INT && rightType == TypeEnum.INT) {
            if (!(left instanceof Integer) || !(right instanceof Integer)) {
                throw new TypesIncompatibleInProductException(
                        "Incompatible types in product expression. Expecting Integer!");
            }

            int leftInt = (Integer) left;
            int rightInt = (Integer) right;
            switch (object.getOperation()) {
            case DIV:
                return leftInt / rightInt;
            case MULT:
                return leftInt * rightInt;
            case MOD:
                return leftInt % rightInt;
            }
            throw new RuntimeException("This should never happen!");

        } else {
            double leftDouble = getDouble(left);
            double rightDouble = getDouble(right);
            switch (object.getOperation()) {
            case DIV:
                return leftDouble / rightDouble;
            case MULT:
                return leftDouble * rightDouble;
            case MOD:
                return leftDouble % rightDouble;
            }
            throw new RuntimeException("This should never happen!");
        }
    }

    private double getDouble(Object o) {
        if (o instanceof Double)
            return (Double) o;
        if (o instanceof Integer)
            return (Integer) o;
        throw new UnsupportedOperationException("Trying to cast a " + o.getClass().getCanonicalName() + " to a Double!");
    }

    private TypeEnum getDynamicType(Object o) {
        if (o instanceof Integer)
            return TypeEnum.INT;
        if (o instanceof Double)
            return TypeEnum.DOUBLE;
        if (o instanceof String)
            return TypeEnum.ENUM;
        if (o instanceof Boolean)
            return TypeEnum.BOOL;
        throw new RuntimeException("Unknown dynamic type found! Should never happen!");
    }

    @Override
    public Object caseTermExpression(TermExpression object) {
        TypeEnum leftType = typeInferer.getType(object.getLeft());
        TypeEnum rightType = typeInferer.getType(object.getRight());
        Object left = doSwitch(object.getLeft());
        Object right = doSwitch(object.getRight());
        if (leftType == TypeEnum.ANY)
            leftType = getDynamicType(left);
        if (rightType == TypeEnum.ANY)
            rightType = getDynamicType(right);
        if (leftType == TypeEnum.INT && rightType == TypeEnum.INT) {
            if (!(left instanceof Integer) || !(right instanceof Integer)) {
                throw new TypesIncompatibleInTermException("Incompatible types in term expression. Expecting Integer!");
            }
            int leftInt = (Integer) left;
            int rightInt = (Integer) right;
            switch (object.getOperation()) {
            case ADD:
                return leftInt + rightInt;
            case SUB:
                return leftInt - rightInt;
            }
            throw new RuntimeException("This should never happen!");

        } else {
            double leftDouble = getDouble(left);
            double rightDouble = getDouble(right);
            switch (object.getOperation()) {
            case ADD:
                return leftDouble + rightDouble;
            case SUB:
                return leftDouble - rightDouble;
            }
            throw new RuntimeException("This should never happen!");
        }
    }

    @Override
    public Object caseBooleanOperatorExpression(BooleanOperatorExpression object) {
        boolean b1 = (Boolean) this.doSwitch(object.getLeft());
        boolean b2 = (Boolean) this.doSwitch(object.getRight());
        switch (object.getOperation()) {
        case OR:
            return b1 || b2;
        case AND:
            return b1 && b2;
        case XOR:
            return b1 ^ b2;
        }
        throw new RuntimeException("This should never happen!");
    }

    @Override
    public Object caseNegativeExpression(NegativeExpression object) {
        Object value = this.doSwitch(object.getInner());
        if (value instanceof Integer)
            return -((Integer) value);
        if (value instanceof Double)
            return -((Double) value);
        throw new RuntimeException("Type mismatch, unary minus only supported for numbers!");
    }

    @Override
    public Object caseBoolLiteral(BoolLiteral object) {
        return object.isValue();
    }

    @Override
    public Object caseNotExpression(NotExpression object) {
        Boolean b = (Boolean) this.doSwitch(object.getInner());
        return !b;
    }

    @Override
    public Object casePowerExpression(PowerExpression object) {
        TypeEnum leftType = typeInferer.getType(object.getBase());
        TypeEnum rightType = typeInferer.getType(object.getExponent());
        Object leftExpr = doSwitch(object.getBase());
        Object rightExpr = doSwitch(object.getExponent());
        if (leftType == TypeEnum.ANY)
            leftType = getDynamicType(leftExpr);
        if (rightType == TypeEnum.ANY)
            rightType = getDynamicType(rightExpr);

        if (leftType == TypeEnum.INT)
            leftExpr = Double.valueOf((((Integer) leftExpr).intValue()));
        if (rightType == TypeEnum.INT)
            rightExpr = Double.valueOf((((Integer) rightExpr).intValue()));
        return Math.pow((Double) leftExpr, (Double) rightExpr);
    }

    @Override
    public Object caseFunctionLiteral(FunctionLiteral object) {
        String functionID = object.getId();
        ArrayList<Object> parameterValues = new ArrayList<Object>();
        for (Expression e : object.getParameters_FunctionLiteral()) {
            parameterValues.add(this.doSwitch(e));
        }
        return functionLib.evaluate(functionID, parameterValues);
    }

    @Override
    public Object caseIfElseExpression(IfElseExpression object) {
        boolean cond = (Boolean) this.doSwitch(object.getConditionExpression());
        if (cond)
            return this.doSwitch(object.getIfExpression());
        else
            return this.doSwitch(object.getElseExpression());
    }

}
