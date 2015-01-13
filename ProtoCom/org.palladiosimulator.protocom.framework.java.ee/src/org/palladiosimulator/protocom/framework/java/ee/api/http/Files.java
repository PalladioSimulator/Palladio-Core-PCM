package org.palladiosimulator.protocom.framework.java.ee.api.http;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Set;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.palladiosimulator.protocom.framework.java.ee.storage.IStorage;

@Path("/files")
public class Files {
	@Inject
	private IStorage storage;

	private StringBuilder appendFiles(StringBuilder sb, String path, int level) throws IOException {
		Set<String> files = storage.getFiles(path);

		for (String file : files) {
			for (int i = 0; i < level; i++) {
				sb.append("    ");
			}

			if (storage.isFolder(path + "/" + file)) {
				sb.append(file + ":\n");
				appendFiles(sb, path + "/" + file, level + 1);
			} else {
				sb.append(file);
				sb.append("\n");
			}
		}

		return sb;
	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getFiles() {
		StringBuilder response = new StringBuilder();

		response.append("Files:\n");

		StringBuilder sb = new StringBuilder();
		try {
			appendFiles(sb, "", 0);
			response.append(sb.toString());
		} catch (IOException e) {
			response.append("error");
			e.printStackTrace();
		}

		/*try {
			Set<String> files = storage.getFiles("");

			for (String file : files) {
				response.append(file);
				response.append("\n");
			}
		} catch (IOException e) {
			response.append("error");
			e.printStackTrace();
		}*/

		return response.toString();
	}

	@GET
	@Path("{file}")
	@Produces(MediaType.APPLICATION_OCTET_STREAM)
	public Response getFile(@PathParam("file") String file) {
		try {
			byte[] data = storage.readFile(file);

			return Response.ok(data).build();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return Response.noContent().build();
		}
	}

	@GET
	@Path("delete/calibration")
	public void deleteCalibration() {
		storage.deleteFile("calibration/cpu.fibonacci");
		storage.deleteFile("calibration/hdd.largeChunks");
	}

	@GET
	@Path("delete/experiments")
	public void deleteExperiments() {
		try {
			for (String folder : storage.getFiles("experiments")) {
				for (String file : storage.getFiles("experiments/" + folder)) {
					storage.deleteFile("experiments/" + folder + "/" + file);
				}

				storage.deleteFile("experiments/" + folder);
			}

			storage.deleteFile("experiments");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@GET
	@Path("test/write")
	public void testWrite() {
		try {
			storage.createFolder("x");
			storage.createFolder("x/y");
			storage.writeFile("x.txt", "test");
			storage.writeFile("x/y.txt", "test");
			storage.writeFile("x/y/z.txt", "test");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@GET
	@Path("test/read")
	public void testRead() {
		try {
			String data = storage.readFileAsString("x/y.txt");
			System.out.println(data);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
