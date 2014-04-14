package org.palladiosimulator.protocom.tech.rmi.system;

import org.eclipse.xtend2.lib.StringConcatenation;
import org.palladiosimulator.protocom.tech.rmi.PojoBuildPropertiesFile;

@SuppressWarnings("all")
public class PojoBuildProperties extends PojoBuildPropertiesFile<de.uka.ipd.sdq.pcm.system.System> {
  public PojoBuildProperties(final de.uka.ipd.sdq.pcm.system.System pcmEntity) {
    super(pcmEntity);
  }
  
  public String output() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("bin/");
    return _builder.toString();
  }
  
  public String source() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("src/");
    return _builder.toString();
  }
  
  public String binIncludes() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("\t");
    _builder.append("plugin.xml,\\");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("META-INF/,\\");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append(".");
    return _builder.toString();
  }
  
  public String filePath() {
    return "build.properties";
  }
}
