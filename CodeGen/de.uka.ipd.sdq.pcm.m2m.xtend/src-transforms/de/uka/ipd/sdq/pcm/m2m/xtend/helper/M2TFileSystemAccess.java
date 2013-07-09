package de.uka.ipd.sdq.pcm.m2m.xtend.helper;
import java.io.File;
import java.io.FileOutputStream;
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
		fileName = fileName + "_xtend";
		
		Path p = Paths.get(rootDirectory, fileName);

		System.out.println("WRITING FILE: " + p.toAbsolutePath());
		File newFile = p.toFile();
		
		try {
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
