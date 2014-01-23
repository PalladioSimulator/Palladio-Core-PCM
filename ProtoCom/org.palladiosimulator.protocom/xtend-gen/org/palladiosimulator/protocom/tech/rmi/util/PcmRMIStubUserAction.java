package org.palladiosimulator.protocom.tech.rmi.util;

import de.uka.ipd.sdq.pcm.parameter.VariableUsage;
import de.uka.ipd.sdq.pcm.repository.OperationProvidedRole;
import de.uka.ipd.sdq.pcm.repository.OperationSignature;
import de.uka.ipd.sdq.pcm.usagemodel.AbstractUserAction;
import de.uka.ipd.sdq.pcm.usagemodel.Branch;
import de.uka.ipd.sdq.pcm.usagemodel.Delay;
import de.uka.ipd.sdq.pcm.usagemodel.EntryLevelSystemCall;
import de.uka.ipd.sdq.pcm.usagemodel.Loop;
import de.uka.ipd.sdq.pcm.usagemodel.Start;
import de.uka.ipd.sdq.pcm.usagemodel.Stop;
import java.util.Arrays;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.palladiosimulator.protocom.lang.java.util.JavaNames;
import org.palladiosimulator.protocom.lang.java.util.PcmCommons;
import org.palladiosimulator.protocom.lang.java.util.PcmStubUserAction;

/**
 * Defines templates for actions of both kinds: SEFF actions and user actions.
 * 
 * TODO: Remove programming language and technology-depend source from this class
 * and use template methods instead. Also move it to .lang then.
 * 
 * @author Sebastian Lehrig
 */
@SuppressWarnings("all")
public class PcmRMIStubUserAction extends PcmStubUserAction {
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
