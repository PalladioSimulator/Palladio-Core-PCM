package org.palladiosimulator.protocom.framework.java.ee.api.rest;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.palladiosimulator.protocom.framework.java.ee.storage.Storage;

@Path("/files")
public class Files {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getFiles() {
		Storage storage = new Storage();
		StringBuilder response = new StringBuilder();

		response.append("Files:\n");

		try {
			Set<String> files = storage.getFiles("calibration");

			for (String file : files) {
				response.append(file);
				response.append("\n");
			}
		} catch (IOException e) {
			response.append("error");
			e.printStackTrace();
		}

		return response.toString();
	}

	@GET
	@Path("{file}")
	@Produces(MediaType.APPLICATION_OCTET_STREAM)
	public Response getFile(@PathParam("file") String file) {
		try {
			Storage storage = new Storage();
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
		Storage storage = new Storage();

		storage.deleteFile("calibration/low.cpu.fibonacci");
		storage.deleteFile("calibration/low.hdd.largeChunks");
	}
}
