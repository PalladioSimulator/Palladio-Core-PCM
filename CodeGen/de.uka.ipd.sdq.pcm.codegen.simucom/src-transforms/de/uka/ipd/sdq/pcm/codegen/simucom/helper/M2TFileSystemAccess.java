package de.uka.ipd.sdq.pcm.codegen.simucom.helper;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class M2TFileSystemAccess {
	private String rootDirectory;

	public M2TFileSystemAccess(String rootDirectory) {
		this.rootDirectory = rootDirectory;
	}
	
	public void generateFile(String fileName, CharSequence contents) {		
		Path p = Paths.get(rootDirectory, fileName);
		
		File newFile = p.toFile();
		
		try {
			//Create source folder if it does not exist yet
			File rootFile = Paths.get(rootDirectory).toFile();
			if (!rootFile.exists()) {
				rootFile.mkdirs();
			}
			
			if (newFile.exists())
				newFile.delete();
			
			newFile.getParentFile().mkdirs();
			newFile.createNewFile();
		} catch (IOException e) {
			System.out.println("Error while creating " + newFile.getPath());
			e.printStackTrace();
		}
		
		try {
			FileWriter fw = new FileWriter(newFile);
			fw.write(contents.toString());
			fw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
