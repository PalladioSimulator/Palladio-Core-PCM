package org.palladiosimulator.protocom.tech.rmi;

import de.uka.ipd.sdq.pcm.core.entity.Entity;
import org.palladiosimulator.protocom.lang.xml.IClasspath;
import org.palladiosimulator.protocom.tech.ConceptMapping;

@SuppressWarnings("all")
public class PojoClasspathFile<E extends Entity> extends ConceptMapping<E> implements IClasspath {
  public PojoClasspathFile(final E pcmEntity) {
    super(pcmEntity);
  }
  
  public String classPathEntries() {
    return null;
  }
  
  public String filePath() {
    return null;
  }
  
  public String projectName() {
    return null;
  }
}
