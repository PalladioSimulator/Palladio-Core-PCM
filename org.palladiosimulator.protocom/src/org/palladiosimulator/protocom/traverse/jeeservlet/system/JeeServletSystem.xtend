package org.palladiosimulator.protocom.traverse.jeeservlet.system

import java.net.URL
import org.palladiosimulator.protocom.framework.jee.servlet.webcontent.FileProvider
import org.palladiosimulator.protocom.lang.CopiedFile
import org.palladiosimulator.protocom.lang.java.impl.JClass
import org.palladiosimulator.protocom.lang.xml.impl.Classpath
import org.palladiosimulator.protocom.tech.servlet.ServletClasspath
import org.palladiosimulator.protocom.tech.servlet.system.ServletSystemClass
import org.palladiosimulator.protocom.tech.servlet.system.ServletSystemMain
import org.palladiosimulator.protocom.traverse.framework.system.XSystem
import org.palladiosimulator.protocom.tech.servlet.ServletDeploymentDescriptor
import org.palladiosimulator.protocom.lang.manifest.impl.JeeManifest
import org.palladiosimulator.protocom.tech.servlet.ServletManifest
import org.palladiosimulator.protocom.lang.xml.impl.PluginXml
import org.palladiosimulator.protocom.tech.servlet.ServletPlugin

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
	
	override protected generate() {
		generatedFiles.add(injector.getInstance(typeof(JClass)).createFor(new ServletSystemClass(entity)))
		generatedFiles.add(injector.getInstance(typeof(Classpath)).createFor(new ServletClasspath(entity)))
		generatedFiles.add(injector.getInstance(typeof(JClass)).createFor(new ServletSystemMain(entity)))
		
		// Generate plug-in manifest (MANIFEST.MF).
		generatedFiles.add(injector.getInstance(typeof(JeeManifest)).createFor(new ServletManifest(entity)))
		
		generatedFiles.add(injector.getInstance(typeof(PluginXml)).createFor(new ServletPlugin(entity)))
		
		// Generate deployment descriptor (web.xml).
		generatedFiles.add(injector.getInstance(typeof(ServletDeploymentDescriptor)))
		
		// Copy WebContent files.
		copyFiles("css", FileProvider.CSS);
		copyFiles("img", FileProvider.IMG);
		copyFiles("js", FileProvider.JS);
		copyFiles("", FileProvider.JSP);
		copyFiles("WEB-INF/lib", FileProvider.LIB);
	}
}
