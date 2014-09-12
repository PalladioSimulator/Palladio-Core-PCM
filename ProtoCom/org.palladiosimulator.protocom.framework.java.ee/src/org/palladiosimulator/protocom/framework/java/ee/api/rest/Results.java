package org.palladiosimulator.protocom.framework.java.ee.api.rest;

import java.io.IOException;
import java.io.OutputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;

import org.palladiosimulator.protocom.framework.java.ee.experiment.ExperimentData;
import org.palladiosimulator.protocom.framework.java.ee.experiment.Experiment;
import org.palladiosimulator.protocom.framework.java.ee.json.JsonHelper;
import org.palladiosimulator.protocom.framework.java.ee.storage.IStorage;

import com.sun.jersey.core.header.ContentDisposition;

@Path("/results")
public class Results {
	@Inject
	private IStorage storage;

	@Inject
	private Experiment experiment;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getResults() {
		List<ExperimentData> result = new LinkedList<ExperimentData>();

		try {
			for (String folder : storage.getFiles("results")) {
				String dataPath = "results/" + folder + "/experiment.json";

				String json = storage.readFileAsString(dataPath);
				result.add(JsonHelper.fromJson(json, ExperimentData.class));
			}
		} catch (IOException e) {
			// No experiments stored yet.
		}

		return Response.ok(JsonHelper.toJson(result)).build();
	}

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_OCTET_STREAM)
	public Response getResult(@PathParam("id") final String id) {
		ExperimentData data;

		try {
			String path = "results/" + id + "/experiment.json";
			String json = storage.readFileAsString(path);

			data = JsonHelper.fromJson(json, ExperimentData.class);
		} catch (IOException e) {
			return Response.serverError().build();
		}

		StreamingOutput stream = new StreamingOutput() {

			@Override
			public void write(OutputStream out)
				throws IOException, WebApplicationException {

				zipResults(id, out);
			}
		};

		ContentDisposition disposition = ContentDisposition
			.type("attachement")
			.fileName(data.getName() + ".zip")
			.build();

		return Response
			.ok(stream)
			.header("Content-Disposition", disposition)
			.build();
	}

	@DELETE
	@Path("{id}")
	public Response deleteResult(@PathParam("id") String id) {

		// Delete all result files of the experiment.

		try {
			String root = "results/" + id;

			for (String file : storage.getFiles(root)) {
				storage.deleteFile(root + "/" + file);
			}

			storage.deleteFile(root);
		} catch (IOException e) {
			return Response.serverError().build();
		}

		// Reset the experiment if it is currently initialized.

		if (id.equals(experiment.getId())) {
			experiment.reset();
		}

		return Response.noContent().build();
	}

	/**
	 *
	 * @param id
	 * @param out
	 */
	private void zipResults(String id, OutputStream out) {
		Set<String> files;
		String root = "results/" + id;

		try {
			files = storage.getFiles(root);
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}

		ZipOutputStream stream = new ZipOutputStream(out);

		try {
			for (String file : files) {
				if (file.equals("experiment.json")) {
					continue;
				}

				ZipEntry entry = new ZipEntry(file);

				stream.putNextEntry(entry);
				stream.write(storage.readFile(root + "/" + file));
				stream.closeEntry();
			}

			stream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
