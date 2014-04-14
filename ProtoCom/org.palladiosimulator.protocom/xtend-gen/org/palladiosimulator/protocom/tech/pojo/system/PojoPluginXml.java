package org.palladiosimulator.protocom.tech.pojo.system;

import org.eclipse.xtend2.lib.StringConcatenation;
import org.palladiosimulator.protocom.tech.rmi.PojoPluginXmlFile;

@SuppressWarnings("all")
public class PojoPluginXml extends PojoPluginXmlFile<de.uka.ipd.sdq.pcm.system.System> {
  public PojoPluginXml(final de.uka.ipd.sdq.pcm.system.System pcmEntity) {
    super(pcmEntity);
  }
  
  public String extensionPoint() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("de.uka.ipd.sdq.simucomframework.controller");
    return _builder.toString();
  }
  
  public String actionDelegateClass() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("main.SimuComControl");
    return _builder.toString();
  }
  
  public String actionDelegateId() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("de.uka.ipd.sdq.codegen.simucominstance.actionDelegate");
    return _builder.toString();
  }
  
  public String filePath() {
    return "plugin.xml";
  }
}
