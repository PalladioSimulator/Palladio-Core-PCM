package org.palladiosimulator.protocom.tech.servlet

import de.uka.ipd.sdq.pcm.core.entity.Entity
import org.palladiosimulator.protocom.tech.ConceptMapping
import org.palladiosimulator.protocom.lang.xml.IClasspath
import org.eclipse.core.runtime.Path
import org.eclipse.jdt.launching.JavaRuntime

/**
 * @author Christian Klaussner
 */
class ServletClasspath<E extends Entity> extends ConceptMapping<E> implements IClasspath {
	new(E pcmEntity) {
		super(pcmEntity)
	}
	
	override classPathEntries() {
		'''
		<classpathentry kind="src" path="src"/>
		<classpathentry kind="output" path="build/classes"/>
		
		<classpathentry kind="con" path="org.eclipse.jst.server.core.container/org.eclipse.jst.server.tomcat.runtimeTarget/Apache Tomcat v7.0">
			<attributes>
				<attribute name="owner.project.facets" value="jst.web"/>
			</attributes>
		</classpathentry>
		
		<classpathentry kind="con" path="«new Path(JavaRuntime.JRE_CONTAINER)»">
			<attributes>
				<attribute name="owner.project.facets" value="java"/>
			</attributes>
		</classpathentry>
		
		<classpathentry kind="con" path="org.eclipse.jst.j2ee.internal.web.container"/>
		<classpathentry kind="con" path="org.eclipse.jst.j2ee.internal.module.container"/>
        '''
	}
	
	override filePath() {
		".classpath"
	}
	
	override projectName() {
	}
}
