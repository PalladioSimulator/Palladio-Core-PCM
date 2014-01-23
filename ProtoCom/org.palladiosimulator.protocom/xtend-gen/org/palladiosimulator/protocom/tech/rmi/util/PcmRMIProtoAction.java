package org.palladiosimulator.protocom.tech.rmi.util;

import de.uka.ipd.sdq.pcm.parameter.VariableUsage;
import de.uka.ipd.sdq.pcm.repository.OperationRequiredRole;
import de.uka.ipd.sdq.pcm.repository.OperationSignature;
import de.uka.ipd.sdq.pcm.seff.AbstractAction;
import de.uka.ipd.sdq.pcm.seff.AcquireAction;
import de.uka.ipd.sdq.pcm.seff.BranchAction;
import de.uka.ipd.sdq.pcm.seff.CollectionIteratorAction;
import de.uka.ipd.sdq.pcm.seff.EmitEventAction;
import de.uka.ipd.sdq.pcm.seff.ExternalCallAction;
import de.uka.ipd.sdq.pcm.seff.ForkAction;
import de.uka.ipd.sdq.pcm.seff.InternalAction;
import de.uka.ipd.sdq.pcm.seff.LoopAction;
import de.uka.ipd.sdq.pcm.seff.ReleaseAction;
import de.uka.ipd.sdq.pcm.seff.SetVariableAction;
import de.uka.ipd.sdq.pcm.seff.StartAction;
import de.uka.ipd.sdq.pcm.seff.StopAction;
import java.util.Arrays;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.palladiosimulator.protocom.lang.java.util.JavaNames;
import org.palladiosimulator.protocom.lang.java.util.PcmCommons;
import org.palladiosimulator.protocom.lang.java.util.PcmProtoAction;

/**
 * Defines templates for actions of both kinds: SEFF actions and user actions.
 * 
 * TODO: Remove programming language and technology-depend source from this class
 * and use template methods instead. Also move it to .lang then.
 * 
 * @author Thomas Zolynski, Sebastian Lehrig
 */
@SuppressWarnings("all")
public class PcmRMIProtoAction extends PcmProtoAction {
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
    _builder.append("// Start Simulate an external call");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> currentFrame = ctx.getStack().currentStackFrame();");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("// prepare stackframe");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("de.uka.ipd.sdq.simucomframework.variables.stackframe.SimulatedStackframe<Object> stackframe = ctx.getStack().createAndPushNewStackFrame();");
    _builder.newLine();
    _builder.append("\t\t\t\t");
    _builder.newLine();
    _builder.append("\t\t");
    OperationSignature _calledService_ExternalService = action.getCalledService_ExternalService();
    OperationSignature _calledService_ExternalService_1 = action.getCalledService_ExternalService();
    OperationRequiredRole _role_ExternalService = action.getRole_ExternalService();
    String _javaName = JavaNames.javaName(_role_ExternalService);
    String _plus = ("myContext.getRole" + _javaName);
    String _plus_1 = (_plus + "().");
    EList<VariableUsage> _inputVariableUsages__CallAction = action.getInputVariableUsages__CallAction();
    EList<VariableUsage> _returnVariableUsage__CallReturnAction = action.getReturnVariableUsage__CallReturnAction();
    String _call = PcmCommons.call(_calledService_ExternalService, _calledService_ExternalService_1, _plus_1, _inputVariableUsages__CallAction, _returnVariableUsage__CallReturnAction);
    _builder.append(_call, "		");
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
    _builder.append("} finally {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("ctx.getStack().removeStackFrame();");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
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
    } else if (action instanceof EmitEventAction) {
      return _action((EmitEventAction)action);
    } else if (action instanceof ExternalCallAction) {
      return _action((ExternalCallAction)action);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(action).toString());
    }
  }
}
