package org.palladiosimulator.protocom.tech.iiop.repository;

import com.google.common.collect.Lists;
import de.uka.ipd.sdq.pcm.repository.BasicComponent;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pair;
import org.palladiosimulator.protocom.lang.java.util.JavaNames;
import org.palladiosimulator.protocom.tech.iiop.JavaEEIIOPFacetCoreFile;

@SuppressWarnings("all")
public class JavaEEIIOPFacetCore extends JavaEEIIOPFacetCoreFile<BasicComponent> {
  public JavaEEIIOPFacetCore(final BasicComponent pcmEntity) {
    super(pcmEntity);
  }
  
  public String runtimeName() {
    return "GlassFish 4.0";
  }
  
  public Collection<String> fixedFacet() {
    return Collections.<String>unmodifiableList(Lists.<String>newArrayList("java", "jst.ejb"));
  }
  
  public HashMap<String,String> installedFacet() {
    Pair<String,String> _mappedTo = Pair.<String, String>of("java", "1.7");
    Pair<String,String> _mappedTo_1 = Pair.<String, String>of("jst.ejb", "3.1");
    Pair<String,String> _mappedTo_2 = Pair.<String, String>of("glassfish.ejb", "4.0");
    return CollectionLiterals.<String, String>newHashMap(_mappedTo, _mappedTo_1, _mappedTo_2);
  }
  
  public String filePath() {
    String _fqnJavaEEPreferencesPath = JavaNames.fqnJavaEEPreferencesPath(this.pcmEntity);
    return (_fqnJavaEEPreferencesPath + "org.eclipse.wst.common.project.facet.core.xml");
  }
  
  public String projectName() {
    return JavaNames.fqnJavaEEDescriptorProjectName(this.pcmEntity);
  }
}
