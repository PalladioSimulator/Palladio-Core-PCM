package org.palladiosimulator.protocom.tech.rmi.system;

import org.eclipse.xtend2.lib.StringConcatenation;
import org.palladiosimulator.protocom.tech.rmi.PojoClasspathFile;

@SuppressWarnings("all")
public class PojoClasspath extends PojoClasspathFile<de.uka.ipd.sdq.pcm.system.System> {
  public PojoClasspath(final de.uka.ipd.sdq.pcm.system.System pcmEntity) {
    super(pcmEntity);
  }
  
  public String classPathEntries() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<classpathentry kind=\"con\" path=\"org.eclipse.jdt.launching.JRE_CONTAINER\"/>");
    _builder.newLine();
    _builder.append("<classpathentry kind=\"con\" path=\"org.eclipse.pde.core.requiredPlugins\"/>");
    _builder.newLine();
    _builder.append("<classpathentry kind=\"src\" path=\"src\"/>");
    _builder.newLine();
    _builder.append("<classpathentry kind=\"output\" path=\"bin\"/>");
    return _builder.toString();
  }
  
  public String filePath() {
    return ".classpath";
  }
}
