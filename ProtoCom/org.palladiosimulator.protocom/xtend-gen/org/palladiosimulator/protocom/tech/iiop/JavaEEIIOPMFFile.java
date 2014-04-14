package org.palladiosimulator.protocom.tech.iiop;

import de.uka.ipd.sdq.pcm.core.entity.Entity;
import org.palladiosimulator.protocom.lang.manifest.IJeeManifest;
import org.palladiosimulator.protocom.tech.ConceptMapping;

@SuppressWarnings("all")
public class JavaEEIIOPMFFile<E extends Entity> extends ConceptMapping<E> implements IJeeManifest {
  public JavaEEIIOPMFFile(final E pcmEntity) {
    super(pcmEntity);
  }
  
  public String classPath() {
    return null;
  }
  
  public String manifestVersion() {
    return null;
  }
  
  public String filePath() {
    return null;
  }
  
  public String projectName() {
    return null;
  }
}
