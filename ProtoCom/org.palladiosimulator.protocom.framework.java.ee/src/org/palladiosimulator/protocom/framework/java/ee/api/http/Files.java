package org.palladiosimulator.protocom.framework.java.ee.api.http;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.palladiosimulator.protocom.framework.java.ee.main.JsonHelper;
import org.palladiosimulator.protocom.framework.java.ee.storage.IStorage;

/**
 * 
 * @author Christian Klaussner
 */
@Path("/files")
public class Files {
	@Inject
	private IStorage storage;
	
	/**
	 * Builds a set of file and folder names.
	 * @param path the root path
	 * @return a set of file names and folder names
	 * @throws IOException when an error occurred during accessing the storage
	 */
	private HashSet<Object> getFileSet(String path) throws IOException {
		HashSet<Object> result = new HashSet<Object>();
		Set<String> files = storage.getFiles(path);
		
		for (String file : files) {
			String name = path + "/" + file;
			
			if (storage.isFolder(name)) {
				HashMap<String, Object> folder = new HashMap<String, Object>();
				
				folder.put("name", file);
				folder.put("files", getFileSet(name));
				
				result.add(folder);
			} else {
				result.add(file);
			}
		}
		
		return result;
	}

	/**
	 * Lists all files and folders stored on the server.
	 * @return a JSON response containing file and folder names
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getFiles() {
		HashSet<Object> files = null;
		
		try {
			files = getFileSet("");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return Response.ok(JsonHelper.toJson(files)).build();
	}

	/**
	 * Gets the contents of a file.
	 * @param path the path to the file whose contents should be returned
	 * @return the contents of the specified file
	 */
	@GET
	@Produces(MediaType.APPLICATION_OCTET_STREAM)
	public Response getFile(@QueryParam("path") String path) {
		try {
			byte[] data = storage.readFile(path);

			return Response.ok(data).build();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return Response.noContent().build();
		}
	}
	
	/**
	 * Deletes a file.
	 * @param path the path to the file to be deleted
	 * @return an empty response
	 */
	@GET
	@Path("delete")
	public Response deleteFile(@QueryParam("path") String path) {
		storage.deleteFile(path);
		return Response.noContent().build();
	}
}
