package org.palladiosimulator.protocom.traverse.jeeservlet.system

import java.net.URL
import org.palladiosimulator.protocom.lang.CopiedFile
import org.palladiosimulator.protocom.lang.java.impl.JClass
import org.palladiosimulator.protocom.lang.xml.impl.Classpath
import org.palladiosimulator.protocom.lang.xml.impl.JeeSettings
import org.palladiosimulator.protocom.tech.servlet.ServletClasspath
import org.palladiosimulator.protocom.tech.servlet.ServletDeploymentDescriptor
import org.palladiosimulator.protocom.tech.servlet.ServletSettings
import org.palladiosimulator.protocom.tech.servlet.system.ServletSystemClass
import org.palladiosimulator.protocom.tech.servlet.system.ServletSystemMain
import org.palladiosimulator.protocom.traverse.framework.system.XSystem
import org.palladiosimulator.protocom.tech.servlet.repository.ServletComposedStructurePortClass
import org.palladiosimulator.protocom.tech.servlet.repository.ServletComposedStructureInterface
import org.palladiosimulator.protocom.lang.java.impl.JInterface
import org.palladiosimulator.protocom.framework.java.ee.webcontent.FileProvider

class JeeServletSystem extends XSystem {
	val fileProvider = new FileProvider
	
	private def copyFiles(String folder, int type) {
		var urls = fileProvider.getFilesOfType(type);
		
		for (URL url : urls) {
			var stream = url.openStream
			
			var file = url.path.substring(url.path.lastIndexOf('/'))
			var path = "WebContent/" + folder + "/" + file
			
			copiedFiles.add(injector.getInstance(typeof(CopiedFile)).build(path, stream))
		}
	}
	
	private def generateSettingsFile(String contentId) {
		generatedFiles.add(injector.getInstance(typeof(JeeSettings)).createFor(new ServletSettings(entity, contentId)))
	}
	
	override protected generate() {
		// Generate system interface.
		generatedFiles.add(injector.getInstance(typeof(JInterface)).createFor(new ServletComposedStructureInterface(entity)))
		
		// Generate system class.
		generatedFiles.add(injector.getInstance(typeof(JClass)).createFor(new ServletSystemClass(entity)))
		
		// Generate ports.
		entity.providedRoles_InterfaceProvidingEntity.forEach[
			generatedFiles.add(injector.getInstance(typeof(JClass)).createFor(new ServletComposedStructurePortClass(it)))
		]
		
		// Generate settings files (.settings folder).
		generateSettingsFile(".jsdtscope");
		generateSettingsFile("org.eclipse.jdt.core.prefs");
		generateSettingsFile("org.eclipse.wst.common.component");
		generateSettingsFile("org.eclipse.wst.common.project.facet.core.xml");
		generateSettingsFile("org.eclipse.wst.jsdt.ui.superType.container");
		generateSettingsFile("org.eclipse.wst.jsdt.ui.superType.name");
		
		// Generate class path file.
		generatedFiles.add(injector.getInstance(typeof(Classpath)).createFor(new ServletClasspath(entity)))
		
		// Generate deployment descriptor (web.xml).
		generatedFiles.add(injector.getInstance(typeof(ServletDeploymentDescriptor)))
		
		// Copy WebContent files.
		copyFiles("css", FileProvider.CSS);
		copyFiles("fonts", FileProvider.FONTS);
		copyFiles("img", FileProvider.IMG);
		copyFiles("js", FileProvider.JS);
		copyFiles("", FileProvider.JSP);
		copyFiles("WEB-INF/lib", FileProvider.LIB);
		
		// Generate main class for entry point.
		generatedFiles.add(injector.getInstance(typeof(JClass)).createFor(new ServletSystemMain(entity)))
	}
}
