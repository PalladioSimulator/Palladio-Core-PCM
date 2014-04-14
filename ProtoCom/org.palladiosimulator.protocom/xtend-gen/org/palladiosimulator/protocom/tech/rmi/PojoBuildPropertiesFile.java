package org.palladiosimulator.protocom.tech.rmi;

import de.uka.ipd.sdq.pcm.core.entity.Entity;
import org.palladiosimulator.protocom.lang.properties.IBuildProperties;
import org.palladiosimulator.protocom.tech.ConceptMapping;

@SuppressWarnings("all")
public class PojoBuildPropertiesFile<E extends Entity> extends ConceptMapping<E> implements IBuildProperties {
  public PojoBuildPropertiesFile(final E pcmEntity) {
    super(pcmEntity);
  }
  
  public String output() {
    return null;
  }
  
  public String source() {
    return null;
  }
  
  public String binIncludes() {
    return null;
  }
  
  public String filePath() {
    return null;
  }
  
  public String projectName() {
    return null;
  }
}
