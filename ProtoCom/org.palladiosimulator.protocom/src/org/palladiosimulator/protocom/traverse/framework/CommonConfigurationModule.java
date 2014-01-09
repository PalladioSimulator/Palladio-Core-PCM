package org.palladiosimulator.protocom.traverse.framework;

import org.eclipse.core.internal.resources.Workspace;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.xtext.builder.trace.TraceMarkers;
import org.eclipse.xtext.generator.AbstractFileSystemAccess2;
import org.eclipse.xtext.generator.trace.TraceFileNameProvider;
import org.eclipse.xtext.generator.trace.TraceRegionSerializer;
import org.eclipse.xtext.ui.resource.IStorage2UriMapper;
import org.eclipse.xtext.ui.resource.Storage2UriMapperImpl;

import com.google.inject.AbstractModule;
import com.google.inject.Singleton;
import com.google.inject.name.Names;
import org.palladiosimulator.protocom.FSAProvider;

/**
 * Common binding for Google Guice. It includes every binding needed by 
 * FileSystemAccess (which cannot be configured otherwise).
 * 
 * Don't mind the SuppressWarnings...
 * 
 * @author Thomas Zolynski
 */
@SuppressWarnings("restriction")
public class CommonConfigurationModule extends AbstractModule {

	private String projectURI = "de.uka.blablabla";
	
	public String getProjectURI() {
		return projectURI;
	}

	public void setProjectURI(String projectURI) {
		this.projectURI = projectURI;
	}

	@Override
	protected void configure() {

		bind(TraceMarkers.class).toInstance(new TraceMarkers());
		bind(TraceFileNameProvider.class).toInstance(new TraceFileNameProvider());
		bind(TraceRegionSerializer.class).toInstance(new TraceRegionSerializer());
		bind(IWorkspace.class).to(Workspace.class);
		bind(IStorage2UriMapper.class).to(Storage2UriMapperImpl.class);
			
		bind(String.class).annotatedWith(Names.named("ProjectURI")).toInstance(getProjectURI());

		bind(AbstractFileSystemAccess2.class).toProvider(FSAProvider.class).in(Singleton.class);
		
	}
}
