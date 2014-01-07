package com.palladio_simulator.protocom.tech.rmi;

import com.google.common.collect.Lists;
import com.palladio_simulator.protocom.lang.java.IJMethod;
import com.palladio_simulator.protocom.lang.java.impl.JMethod;
import com.palladio_simulator.protocom.lang.java.util.JavaNames;
import com.palladio_simulator.protocom.lang.java.util.PcmCalls;
import com.palladio_simulator.protocom.tech.rmi.PojoClass;
import de.uka.ipd.sdq.pcm.usagemodel.EntryLevelSystemCall;
import de.uka.ipd.sdq.pcm.usagemodel.ScenarioBehaviour;
import de.uka.ipd.sdq.pcm.usagemodel.UsageScenario;
import java.util.Collection;
import java.util.Collections;
import org.eclipse.xtend2.lib.StringConcatenation;

@SuppressWarnings("all")
public class PojoSystemMain extends PojoClass<UsageScenario> {
  public PojoSystemMain(final UsageScenario pcmEntity) {
    super(pcmEntity);
  }
  
  public String superClass() {
    return "com.palladio_simulator.protocom.framework.AbstractMain";
  }
  
  public String packageName() {
    return "ProtoComBootstrap";
  }
  
  public String compilationUnitName() {
    return "Main";
  }
  
  public Collection<? extends IJMethod> methods() {
    JMethod _jMethod = new JMethod();
    JMethod _withName = _jMethod.withName("initialiseThreads");
    JMethod _withParameters = _withName.withParameters("de.uka.ipd.sdq.sensorframework.entities.Experiment exp, de.uka.ipd.sdq.sensorframework.entities.ExperimentRun expRun");
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("int count = 1;");
    _builder.newLine();
    _builder.append("if (runProps.hasOption(\"c\")) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("count = (Integer) runProps.getOptionObject(\"c\");");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.append("for (int i = 0; i < count; i++) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("threads.add(new ");
    String _fqn = JavaNames.fqn(this.pcmEntity);
    _builder.append(_fqn, "	");
    _builder.append("Thread(exp, expRun,");
    _builder.newLineIfNotEmpty();
    _builder.append("\t\t\t");
    _builder.append("runProps));");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    JMethod _withImplementation = _withParameters.withImplementation(_builder.toString());
    JMethod _jMethod_1 = new JMethod();
    JMethod _withName_1 = _jMethod_1.withName("setupResources");
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("ResourceEnvironment.setUpResources(runProps.getOptionValue(\'p\'),");
    _builder_1.newLine();
    _builder_1.append("runProps.getOptionValue(\'H\'), runProps.getOptionValue(\'s\'),");
    _builder_1.newLine();
    _builder_1.append("getAccuracy());");
    _builder_1.newLine();
    JMethod _withImplementation_1 = _withName_1.withImplementation(_builder_1.toString());
    JMethod _jMethod_2 = new JMethod();
    JMethod _withName_2 = _jMethod_2.withName("initialiseSystems");
    StringConcatenation _builder_2 = new StringConcatenation();
    {
      ScenarioBehaviour _scenarioBehaviour_UsageScenario = this.pcmEntity.getScenarioBehaviour_UsageScenario();
      Iterable<EntryLevelSystemCall> _querySystemCalls = PcmCalls.querySystemCalls(_scenarioBehaviour_UsageScenario);
      Iterable<de.uka.ipd.sdq.pcm.system.System> _systemsFromCalls = PcmCalls.getSystemsFromCalls(_querySystemCalls);
      for(final de.uka.ipd.sdq.pcm.system.System system : _systemsFromCalls) {
        String _fqn_1 = JavaNames.fqn(system);
        _builder_2.append(_fqn_1, "");
        _builder_2.append(".main(runProps.getOptionValue(\'R\'), runProps.getOptionValue(\'O\'));");
        _builder_2.newLineIfNotEmpty();
      }
    }
    JMethod _withImplementation_2 = _withName_2.withImplementation(_builder_2.toString());
    JMethod _jMethod_3 = new JMethod();
    JMethod _withName_3 = _jMethod_3.withName("initAllocationStorage");
    StringConcatenation _builder_3 = new StringConcatenation();
    _builder_3.append("AllocationStorage.initSingleton(new AllocationStorage());");
    JMethod _withImplementation_3 = _withName_3.withImplementation(_builder_3.toString());
    JMethod _jMethod_4 = new JMethod();
    JMethod _withName_4 = _jMethod_4.withName("getSystems");
    JMethod _withReturnType = _withName_4.withReturnType("String[][]");
    StringConcatenation _builder_4 = new StringConcatenation();
    _builder_4.append("String[][] systems = {");
    _builder_4.newLine();
    _builder_4.append("\t");
    _builder_4.append("{ ");
    _builder_4.newLine();
    {
      ScenarioBehaviour _scenarioBehaviour_UsageScenario_1 = this.pcmEntity.getScenarioBehaviour_UsageScenario();
      Iterable<EntryLevelSystemCall> _querySystemCalls_1 = PcmCalls.querySystemCalls(_scenarioBehaviour_UsageScenario_1);
      Iterable<de.uka.ipd.sdq.pcm.system.System> _systemsFromCalls_1 = PcmCalls.getSystemsFromCalls(_querySystemCalls_1);
      for(final de.uka.ipd.sdq.pcm.system.System system_1 : _systemsFromCalls_1) {
        _builder_4.append("\t");
        _builder_4.append("\"");
        String _fqn_2 = JavaNames.fqn(system_1);
        _builder_4.append(_fqn_2, "	");
        _builder_4.append("\", \"");
        String _javaName = JavaNames.javaName(system_1);
        _builder_4.append(_javaName, "	");
        _builder_4.append("\"");
        _builder_4.newLineIfNotEmpty();
      }
    }
    _builder_4.append("\t");
    _builder_4.append("}");
    _builder_4.newLine();
    _builder_4.append("};");
    _builder_4.newLine();
    _builder_4.append("return systems;");
    JMethod _withImplementation_4 = _withReturnType.withImplementation(_builder_4.toString());
    JMethod _jMethod_5 = new JMethod();
    JMethod _withName_5 = _jMethod_5.withName("main");
    JMethod _withParameters_1 = _withName_5.withParameters("String[] args");
    StringConcatenation _builder_5 = new StringConcatenation();
    _builder_5.append("new Main().run(args);");
    JMethod _withImplementation_5 = _withParameters_1.withImplementation(_builder_5.toString());
    JMethod _withStaticModifier = _withImplementation_5.withStaticModifier();
    return Collections.<JMethod>unmodifiableList(Lists.<JMethod>newArrayList(_withImplementation, _withImplementation_1, _withImplementation_2, _withImplementation_3, _withImplementation_4, _withStaticModifier));
  }
  
  public String filePath() {
    return "ProtoComBootstrap/Main.java";
  }
}
