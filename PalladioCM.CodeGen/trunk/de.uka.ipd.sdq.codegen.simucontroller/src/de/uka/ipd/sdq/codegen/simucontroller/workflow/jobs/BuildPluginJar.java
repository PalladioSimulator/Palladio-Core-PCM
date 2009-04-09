package de.uka.ipd.sdq.codegen.simucontroller.workflow.jobs;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.eclipse.core.runtime.IProgressMonitor;

import de.uka.ipd.sdq.codegen.workflow.IJobWithResult;
import de.uka.ipd.sdq.codegen.workflow.exceptions.JobFailedException;
import de.uka.ipd.sdq.codegen.workflow.exceptions.RollbackFailedException;
import de.uka.ipd.sdq.codegen.workflow.exceptions.UserCanceledException;

public class BuildPluginJar implements IJobWithResult<byte[]> {

	private byte[] result = null;
	private CreatePluginProjectJob createPluginProject;

	public BuildPluginJar(CreatePluginProjectJob createPluginProjectJob){
		if (createPluginProjectJob == null)
			throw new IllegalArgumentException("Project cannot be null in BuildPluginJar job!");
		this.createPluginProject = createPluginProjectJob;
	}
	
	public byte[] getResult() {
		return result;
	}

	public void execute(IProgressMonitor monitor) throws JobFailedException, UserCanceledException {
		String location = null;
		try {
			location = new File(createPluginProject.getProject().getLocationURI()).getAbsolutePath()
					+ File.separator + "simucominstance.jar";
			this.result = loadBundle(location);
		} catch (IOException e) {
			throw new JobFailedException("Getting project location failed", e);
		}
	}

	public String getName() {
		return "Building simulation plugin JAR archive";
	}

	public void rollback(IProgressMonitor monitor) throws RollbackFailedException {
	}

	private byte[] loadBundle(String location) throws IOException {
		byte[] result = null;
		File bundleFile = new File(location);
		result = new byte[(int) bundleFile.length()];
		FileInputStream fis = new FileInputStream(bundleFile);
		fis.read(result);
		fis.close();
		return result;
	}
	
}
