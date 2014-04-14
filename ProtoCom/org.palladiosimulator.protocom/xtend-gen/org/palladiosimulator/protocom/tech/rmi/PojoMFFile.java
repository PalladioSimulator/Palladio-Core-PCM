package org.palladiosimulator.protocom.tech.rmi;

import de.uka.ipd.sdq.pcm.core.entity.Entity;
import org.palladiosimulator.protocom.lang.manifest.IJseManifest;
import org.palladiosimulator.protocom.tech.ConceptMapping;

@SuppressWarnings("all")
public class PojoMFFile<E extends Entity> extends ConceptMapping<E> implements IJseManifest {
  public PojoMFFile(final E pcmEntity) {
    super(pcmEntity);
  }
  
  public String bundleManifestVersion() {
    return null;
  }
  
  public String bundleName() {
    return null;
  }
  
  public String bundleSymbolicName() {
    return null;
  }
  
  public String bundleVersion() {
    return null;
  }
  
  public String bundleActivator() {
    return null;
  }
  
  public String requireBundle() {
    return null;
  }
  
  public String eclipseLazyStart() {
    return null;
  }
  
  public String bundleClassPath() {
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
