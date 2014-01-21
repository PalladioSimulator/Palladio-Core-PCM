package org.palladiosimulator.protocom.lang.java.util;

import de.uka.ipd.sdq.pcm.parameter.VariableUsage;
import de.uka.ipd.sdq.pcm.repository.DataType;
import de.uka.ipd.sdq.pcm.repository.OperationProvidedRole;
import de.uka.ipd.sdq.pcm.repository.OperationRequiredRole;
import de.uka.ipd.sdq.pcm.repository.OperationSignature;
import de.uka.ipd.sdq.pcm.repository.Parameter;
import de.uka.ipd.sdq.pcm.seff.AbstractAction;
import de.uka.ipd.sdq.pcm.seff.AbstractBranchTransition;
import de.uka.ipd.sdq.pcm.seff.AcquireAction;
import de.uka.ipd.sdq.pcm.seff.BranchAction;
import de.uka.ipd.sdq.pcm.seff.CollectionIteratorAction;
import de.uka.ipd.sdq.pcm.seff.ExternalCallAction;
import de.uka.ipd.sdq.pcm.seff.ForkAction;
import de.uka.ipd.sdq.pcm.seff.GuardedBranchTransition;
import de.uka.ipd.sdq.pcm.seff.InternalAction;
import de.uka.ipd.sdq.pcm.seff.LoopAction;
import de.uka.ipd.sdq.pcm.seff.ProbabilisticBranchTransition;
import de.uka.ipd.sdq.pcm.seff.ReleaseAction;
import de.uka.ipd.sdq.pcm.seff.ResourceDemandingBehaviour;
import de.uka.ipd.sdq.pcm.seff.SetVariableAction;
import de.uka.ipd.sdq.pcm.seff.StartAction;
import de.uka.ipd.sdq.pcm.seff.StopAction;
import de.uka.ipd.sdq.pcm.usagemodel.AbstractUserAction;
import de.uka.ipd.sdq.pcm.usagemodel.Branch;
import de.uka.ipd.sdq.pcm.usagemodel.BranchTransition;
import de.uka.ipd.sdq.pcm.usagemodel.Delay;
import de.uka.ipd.sdq.pcm.usagemodel.EntryLevelSystemCall;
import de.uka.ipd.sdq.pcm.usagemodel.Loop;
import de.uka.ipd.sdq.pcm.usagemodel.ScenarioBehaviour;
import de.uka.ipd.sdq.pcm.usagemodel.Start;
import de.uka.ipd.sdq.pcm.usagemodel.Stop;
import java.util.Arrays;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.palladiosimulator.protocom.lang.java.util.DataTypes;
import org.palladiosimulator.protocom.lang.java.util.JavaNames;
import org.palladiosimulator.protocom.lang.java.util.PcmAction;
import org.palladiosimulator.protocom.lang.java.util.PcmCommons;

/**
 * Defines templates for actions of both kinds: SEFF actions and user actions.
 * 
 * TODO: Remove programming language and technology-depend source from this class
 * and use template methods instead. Also move it to .lang then.
 * 
 * @author Sebastian Lehrig
 */
@SuppressWarnings("all")
public class PcmCodeStubAction extends PcmAction {
  /**
   * No idea. We didn't implement this for the last ProtoCom either.
   * FIXME Implement this as it is a crucial part of the bahavior (lehrig)
   */
  protected String _action(final CollectionIteratorAction action) {
    StringConcatenation _builder = new StringConcatenation();
    return _builder.toString();
  }
  
  /**
   * LoopAction is transformed into a simple FOR statement.
   */
  protected String _action(final LoopAction action) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("// TODO Configure maxIterationCount ");
    _builder.newLine();
    _builder.append("int maxIterationCount");
    String _id = action.getId();
    String _javaVariableName = JavaNames.javaVariableName(_id);
    _builder.append(_javaVariableName, "");
    _builder.append(" = 1;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("for (int iterationCount");
    String _id_1 = action.getId();
    String _javaVariableName_1 = JavaNames.javaVariableName(_id_1);
    _builder.append(_javaVariableName_1, "");
    _builder.append(" = 0; iterationCount");
    String _id_2 = action.getId();
    String _javaVariableName_2 = JavaNames.javaVariableName(_id_2);
    _builder.append(_javaVariableName_2, "");
    _builder.append(" < maxIterationCount");
    String _id_3 = action.getId();
    String _javaVariableName_3 = JavaNames.javaVariableName(_id_3);
    _builder.append(_javaVariableName_3, "");
    _builder.append("; iterationCount");
    String _id_4 = action.getId();
    String _javaVariableName_4 = JavaNames.javaVariableName(_id_4);
    _builder.append(_javaVariableName_4, "");
    _builder.append(" ++) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    ResourceDemandingBehaviour _bodyBehaviour_Loop = action.getBodyBehaviour_Loop();
    EList<AbstractAction> _steps_Behaviour = _bodyBehaviour_Loop.getSteps_Behaviour();
    StartAction _findStart = PcmAction.findStart(_steps_Behaviour);
    String _actions = this.actions(_findStart);
    _builder.append(_actions, "	");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder.toString();
  }
  
  /**
   * ExternalCallAction calls a remote service.
   * 
   * TODO: Move exception handling to RMI tech.
   */
  protected String _action(final ExternalCallAction action) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("{");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("try {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("// TODO Initialize parameters");
    _builder.newLine();
    {
      OperationSignature _calledService_ExternalService = action.getCalledService_ExternalService();
      EList<Parameter> _parameters__OperationSignature = _calledService_ExternalService.getParameters__OperationSignature();
      for(final Parameter parameter : _parameters__OperationSignature) {
        _builder.append("\t\t");
        DataType _dataType__Parameter = parameter.getDataType__Parameter();
        String _dataType = DataTypes.getDataType(_dataType__Parameter);
        String _plus = (_dataType + " param_");
        String _parameterName = parameter.getParameterName();
        String _plus_1 = (_plus + _parameterName);
        String _plus_2 = (_plus_1 + " = null;");
        _builder.append(_plus_2, "		");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    OperationSignature _calledService_ExternalService_1 = action.getCalledService_ExternalService();
    OperationSignature _calledService_ExternalService_2 = action.getCalledService_ExternalService();
    OperationRequiredRole _role_ExternalService = action.getRole_ExternalService();
    String _javaName = JavaNames.javaName(_role_ExternalService);
    String _plus_3 = ("myContext.getRole" + _javaName);
    String _plus_4 = (_plus_3 + "().");
    EList<VariableUsage> _inputVariableUsages__CallAction = action.getInputVariableUsages__CallAction();
    EList<VariableUsage> _returnVariableUsage__CallReturnAction = action.getReturnVariableUsage__CallReturnAction();
    String _callStub = PcmCommons.callStub(_calledService_ExternalService_1, _calledService_ExternalService_2, _plus_4, _inputVariableUsages__CallAction, _returnVariableUsage__CallReturnAction);
    _builder.append(_callStub, "		");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("} catch (java.rmi.RemoteException e) {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("// TODO: add logging");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder.toString();
  }
  
  /**
   * Currently, InteralActions are removed for stubs.
   */
  protected String _action(final InternalAction action) {
    StringConcatenation _builder = new StringConcatenation();
    return _builder.toString();
  }
  
  /**
   * BranchAction is implemented as an IF condition. A BranchAction may have two different transition types:
   * ProbabilisticBranchTransition and GuardedBranchTransition. For code stubs, they are both treated as a
   * normal if-else-if-else series.
   */
  protected String _action(final BranchAction action) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("// TODO Set condition.");
    _builder.newLine();
    _builder.append("Boolean condition = true;");
    _builder.newLine();
    {
      EList<AbstractBranchTransition> _branches_Branch = action.getBranches_Branch();
      boolean _hasElements = false;
      for(final AbstractBranchTransition branch : _branches_Branch) {
        if (!_hasElements) {
          _hasElements = true;
        } else {
          _builder.appendImmediate(" else ", "");
        }
        CharSequence _branchTransition = this.branchTransition(action, branch);
        _builder.append(_branchTransition, "");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder.toString();
  }
  
  /**
   * Branch transition for ProbabilisticBranchTransition entities. Handled like GuardedBranchTransition for code stubs.
   */
  protected CharSequence _branchTransition(final BranchAction action, final ProbabilisticBranchTransition transition) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("if (condition) {");
    _builder.newLine();
    _builder.append("\t");
    ResourceDemandingBehaviour _branchBehaviour_BranchTransition = transition.getBranchBehaviour_BranchTransition();
    EList<AbstractAction> _steps_Behaviour = _branchBehaviour_BranchTransition.getSteps_Behaviour();
    StartAction _findStart = PcmAction.findStart(_steps_Behaviour);
    String _actions = this.actions(_findStart);
    _builder.append(_actions, "	");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  /**
   * Branch transition for GuardedBranchTransition.
   */
  protected CharSequence _branchTransition(final BranchAction action, final GuardedBranchTransition transition) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("if (condition) {");
    _builder.newLine();
    _builder.append("\t");
    ResourceDemandingBehaviour _branchBehaviour_BranchTransition = transition.getBranchBehaviour_BranchTransition();
    EList<AbstractAction> _steps_Behaviour = _branchBehaviour_BranchTransition.getSteps_Behaviour();
    StartAction _findStart = PcmAction.findStart(_steps_Behaviour);
    String _actions = this.actions(_findStart);
    _builder.append(_actions, "	");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }
  
  /**
   * TODO Check whether SetVariableAction is needed.
   */
  protected String _action(final SetVariableAction action) {
    return null;
  }
  
  /**
   * A ForkAction spawns a new thread for each defined behavior. These should be processed asynchronously in parallel.
   * Please note that manually spawning new threads is discouraged on certain middlewares (like JavaEE)!
   * 
   * TODO Check whether ForkAction is needed.
   */
  protected String _action(final ForkAction action) {
    StringConcatenation _builder = new StringConcatenation();
    return _builder.toString();
  }
  
  /**
   * EntryLevelSystemCall is an user action which calls a system service from an usage scenario.
   */
  protected String _userAction(final EntryLevelSystemCall userAction) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("try {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("// EntryLevelSystemCall!");
    _builder.newLine();
    _builder.append("\t");
    OperationSignature _operationSignature__EntryLevelSystemCall = userAction.getOperationSignature__EntryLevelSystemCall();
    OperationProvidedRole _providedRole_EntryLevelSystemCall = userAction.getProvidedRole_EntryLevelSystemCall();
    String _portMemberVar = JavaNames.portMemberVar(_providedRole_EntryLevelSystemCall);
    String _plus = (_portMemberVar + ".");
    EList<VariableUsage> _inputParameterUsages_EntryLevelSystemCall = userAction.getInputParameterUsages_EntryLevelSystemCall();
    String _call = PcmCommons.call(_operationSignature__EntryLevelSystemCall, 
      null, _plus, _inputParameterUsages_EntryLevelSystemCall, 
      null);
    _builder.append(_call, "	");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t\t\t\t\t\t");
    _builder.newLine();
    _builder.append("} catch (java.rmi.RemoteException e) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("// TODO: Logger!");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder.toString();
  }
  
  /**
   * Loop actions are transformed into a simple FOR statement.
   */
  protected String _userAction(final Loop userAction) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("// TODO Configure maxIterationCount ");
    _builder.newLine();
    _builder.append("int maxIterationCount");
    String _id = userAction.getId();
    String _javaVariableName = JavaNames.javaVariableName(_id);
    _builder.append(_javaVariableName, "");
    _builder.append(" = 1;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("for (int iterationCount_");
    String _id_1 = userAction.getId();
    String _javaVariableName_1 = JavaNames.javaVariableName(_id_1);
    _builder.append(_javaVariableName_1, "");
    _builder.append(" = 0; ");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    _builder.append("iterationCount_");
    String _id_2 = userAction.getId();
    String _javaVariableName_2 = JavaNames.javaVariableName(_id_2);
    _builder.append(_javaVariableName_2, "	");
    _builder.append(" < maxIterationCount_");
    String _id_3 = userAction.getId();
    String _javaVariableName_3 = JavaNames.javaVariableName(_id_3);
    _builder.append(_javaVariableName_3, "	");
    _builder.append("; iterationCount_");
    String _id_4 = userAction.getId();
    String _javaVariableName_4 = JavaNames.javaVariableName(_id_4);
    _builder.append(_javaVariableName_4, "	");
    _builder.append(" ++) {");
    _builder.newLineIfNotEmpty();
    _builder.append("\t");
    ScenarioBehaviour _bodyBehaviour_Loop = userAction.getBodyBehaviour_Loop();
    EList<AbstractUserAction> _actions_ScenarioBehaviour = _bodyBehaviour_Loop.getActions_ScenarioBehaviour();
    Start _findUserStart = PcmAction.findUserStart(_actions_ScenarioBehaviour);
    String _userActions = this.userActions(_findUserStart);
    _builder.append(_userActions, "	");
    _builder.newLineIfNotEmpty();
    _builder.append("} ");
    _builder.newLine();
    return _builder.toString();
  }
  
  /**
   * UserActions only have probabilistic transitions. That might even make sense for test generation
   * for code stubs. Therefore, This might be added here.
   * 
   * TODO Branch user actions are currently not generated with code stubs. AS probabilities make sense here the ctx object might be useful. In any case, for test generation, user actions should be included in future.
   */
  protected String _userAction(final Branch userAction) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("double u");
    String _id = userAction.getId();
    String _javaVariableName = JavaNames.javaVariableName(_id);
    _builder.append(_javaVariableName, "");
    _builder.append(" = ctx.evaluate(\"DoublePDF[(1;1.0)]\", Double.class);");
    _builder.newLineIfNotEmpty();
    _builder.append("double sum");
    String _id_1 = userAction.getId();
    String _javaVariableName_1 = JavaNames.javaVariableName(_id_1);
    _builder.append(_javaVariableName_1, "");
    _builder.append(" = 0;");
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    {
      EList<BranchTransition> _branchTransitions_Branch = userAction.getBranchTransitions_Branch();
      for(final BranchTransition transition : _branchTransitions_Branch) {
        _builder.append("if (sum");
        String _id_2 = userAction.getId();
        String _javaVariableName_2 = JavaNames.javaVariableName(_id_2);
        _builder.append(_javaVariableName_2, "");
        _builder.append(" <= u");
        String _id_3 = userAction.getId();
        String _javaVariableName_3 = JavaNames.javaVariableName(_id_3);
        _builder.append(_javaVariableName_3, "");
        _builder.append(" && u");
        String _id_4 = userAction.getId();
        String _javaVariableName_4 = JavaNames.javaVariableName(_id_4);
        _builder.append(_javaVariableName_4, "");
        _builder.append(" < sum");
        String _id_5 = userAction.getId();
        String _javaVariableName_5 = JavaNames.javaVariableName(_id_5);
        _builder.append(_javaVariableName_5, "");
        _builder.append(" + ");
        double _branchProbability = transition.getBranchProbability();
        _builder.append(_branchProbability, "");
        _builder.append(") {");
        _builder.newLineIfNotEmpty();
        _builder.append("\t");
        ScenarioBehaviour _branchedBehaviour_BranchTransition = transition.getBranchedBehaviour_BranchTransition();
        EList<AbstractUserAction> _actions_ScenarioBehaviour = _branchedBehaviour_BranchTransition.getActions_ScenarioBehaviour();
        Start _findUserStart = PcmAction.findUserStart(_actions_ScenarioBehaviour);
        String _userActions = this.userActions(_findUserStart);
        _builder.append(_userActions, "	");
        _builder.newLineIfNotEmpty();
        _builder.append("}\t");
        _builder.newLine();
        _builder.append("sum");
        String _id_6 = userAction.getId();
        String _javaVariableName_6 = JavaNames.javaVariableName(_id_6);
        _builder.append(_javaVariableName_6, "");
        _builder.append(" += ");
        double _branchProbability_1 = transition.getBranchProbability();
        _builder.append(_branchProbability_1, "");
        _builder.append(";\t");
        _builder.newLineIfNotEmpty();
      }
    }
    return _builder.toString();
  }
  
  public String action(final AbstractAction action) {
    if (action instanceof CollectionIteratorAction) {
      return _action((CollectionIteratorAction)action);
    } else if (action instanceof LoopAction) {
      return _action((LoopAction)action);
    } else if (action instanceof AcquireAction) {
      return _action((AcquireAction)action);
    } else if (action instanceof BranchAction) {
      return _action((BranchAction)action);
    } else if (action instanceof ForkAction) {
      return _action((ForkAction)action);
    } else if (action instanceof InternalAction) {
      return _action((InternalAction)action);
    } else if (action instanceof ReleaseAction) {
      return _action((ReleaseAction)action);
    } else if (action instanceof SetVariableAction) {
      return _action((SetVariableAction)action);
    } else if (action instanceof StartAction) {
      return _action((StartAction)action);
    } else if (action instanceof StopAction) {
      return _action((StopAction)action);
    } else if (action instanceof ExternalCallAction) {
      return _action((ExternalCallAction)action);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(action).toString());
    }
  }
  
  public CharSequence branchTransition(final BranchAction action, final AbstractBranchTransition transition) {
    if (transition instanceof GuardedBranchTransition) {
      return _branchTransition(action, (GuardedBranchTransition)transition);
    } else if (transition instanceof ProbabilisticBranchTransition) {
      return _branchTransition(action, (ProbabilisticBranchTransition)transition);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(action, transition).toString());
    }
  }
  
  public String userAction(final AbstractUserAction userAction) {
    if (userAction instanceof Branch) {
      return _userAction((Branch)userAction);
    } else if (userAction instanceof Delay) {
      return _userAction((Delay)userAction);
    } else if (userAction instanceof EntryLevelSystemCall) {
      return _userAction((EntryLevelSystemCall)userAction);
    } else if (userAction instanceof Loop) {
      return _userAction((Loop)userAction);
    } else if (userAction instanceof Start) {
      return _userAction((Start)userAction);
    } else if (userAction instanceof Stop) {
      return _userAction((Stop)userAction);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(userAction).toString());
    }
  }
}
