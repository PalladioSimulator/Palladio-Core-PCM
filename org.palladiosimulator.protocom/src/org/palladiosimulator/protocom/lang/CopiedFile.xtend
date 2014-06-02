package org.palladiosimulator.protocom.lang

import org.eclipse.core.runtime.NullProgressMonitor
import org.eclipse.core.resources.IProject
import org.palladiosimulator.protocom.ProtoComProjectFactory
import com.google.inject.name.Named
import com.google.inject.Inject
import org.eclipse.core.resources.IFile
import java.io.InputStream
import org.eclipse.core.resources.IFolder

class CopiedFile {	
	@Inject
	@Named("ProjectURI")
	String projectURI
	
	String destinationPath
	InputStream sourceStream
	
	def build(String destinationPath, InputStream sourceStream) {
		this.destinationPath = destinationPath
		this.sourceStream = sourceStream
		
		this
	}
	
	private def void createFolders(IFolder folder) {
		if (!folder.exists) {
			if (folder.parent instanceof IFolder) createFolders(folder.parent as IFolder)
			folder.create(false, false, null)
		}
	}
	
	def store() {
		var monitor = new NullProgressMonitor;
		
		var IProject project = ProtoComProjectFactory.getProject(projectURI, destinationPath).IProject;
		var IFile file = project.getFile(destinationPath);
		
		createFolders(file.parent as IFolder);
		file.create(sourceStream, false, monitor);
	}
}
