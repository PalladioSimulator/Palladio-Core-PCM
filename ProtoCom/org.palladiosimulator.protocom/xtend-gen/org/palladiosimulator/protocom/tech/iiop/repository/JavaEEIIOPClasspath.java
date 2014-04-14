package org.palladiosimulator.protocom.tech.iiop.repository;

import de.uka.ipd.sdq.pcm.repository.BasicComponent;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.palladiosimulator.protocom.lang.java.util.JavaNames;
import org.palladiosimulator.protocom.tech.iiop.JavaEEIIOPClasspathFile;

@SuppressWarnings("all")
public class JavaEEIIOPClasspath extends JavaEEIIOPClasspathFile<BasicComponent> {
  public JavaEEIIOPClasspath(final BasicComponent pcmEntity) {
    super(pcmEntity);
  }
  
  public String classPathEntries() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<classpathentry kind=\"src\" path=\"ejbModule\"/>");
    _builder.newLine();
    _builder.append("<classpathentry kind=\"con\" path=\"org.eclipse.jdt.launching.JRE_CONTAINER/org.eclipse.jdt.internal.debug.ui.launcher.StandardVMType/jdk7\">");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<attributes>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<attribute name=\"owner.project.facets\" value=\"java\"/>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("</attributes>");
    _builder.newLine();
    _builder.append("</classpathentry>");
    _builder.newLine();
    _builder.append("<classpathentry kind=\"con\" path=\"oracle.eclipse.tools.glassfish.lib.system\">");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<attributes>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<attribute name=\"owner.project.facets\" value=\"jst.ejb\"/>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("</attributes>");
    _builder.newLine();
    _builder.append("</classpathentry>");
    _builder.newLine();
    _builder.append("<classpathentry kind=\"con\" path=\"org.eclipse.jst.j2ee.internal.module.container\"/>");
    _builder.newLine();
    _builder.append("<classpathentry kind=\"output\" path=\"build/classes\"/>");
    _builder.newLine();
    return _builder.toString();
  }
  
  public String filePath() {
    return ".classpath";
  }
  
  public String projectName() {
    return JavaNames.fqnJavaEEDescriptorProjectName(this.pcmEntity);
  }
}
