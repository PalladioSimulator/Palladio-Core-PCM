package org.palladiosimulator.protocom.tech.iiop;

import de.uka.ipd.sdq.pcm.core.entity.Entity;
import org.palladiosimulator.protocom.lang.xml.IJeeComponentFile;
import org.palladiosimulator.protocom.tech.ConceptMapping;

@SuppressWarnings("all")
public class JavaEEIIOPComponentFile<E extends Entity> extends ConceptMapping<E> implements IJeeComponentFile {
  public JavaEEIIOPComponentFile(final E pcmEntity) {
    super(pcmEntity);
  }
  
  public String wbModuleDeployName() {
    return null;
  }
  
  public String wbResource() {
    return null;
  }
  
  public String property() {
    return null;
  }
  
  public String filePath() {
    return null;
  }
  
  public String projectName() {
    return null;
  }
}
