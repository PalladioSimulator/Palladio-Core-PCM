package org.palladiosimulator.protocom.framework.java.ee.storage;

import java.io.ByteArrayInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.inject.Singleton;

import org.apache.chemistry.opencmis.client.api.CmisObject;
import org.apache.chemistry.opencmis.client.api.Document;
import org.apache.chemistry.opencmis.client.api.Folder;
import org.apache.chemistry.opencmis.client.api.ObjectFactory;
import org.apache.chemistry.opencmis.client.api.Session;
import org.apache.chemistry.opencmis.commons.PropertyIds;
import org.apache.chemistry.opencmis.commons.data.ContentStream;
import org.apache.chemistry.opencmis.commons.enums.VersioningState;
import org.apache.chemistry.opencmis.commons.exceptions.CmisNameConstraintViolationException;
import org.apache.chemistry.opencmis.commons.exceptions.CmisObjectNotFoundException;
import org.apache.commons.io.IOUtils;

/**
 *
 * @author Christian Klaussner
 */
@Singleton
public class EcmStorage implements IStorage {
	private static final String NAME = "ProtoCom-Repository";
	private static final String KEY = "protocom_key";

	private static final String MIME = "application/octet-stream";
	private static final Charset UTF_8 = Charset.forName("UTF-8");

	private Session session;

	/**
	 *
	 * @param path
	 * @return
	 */
	private Map<String, Object> getProperties(String path, boolean folder) {
		Map<String, Object> properties = new HashMap<String, Object>();

		String type = folder ? "cmis:folder" : "cmis:document";

		properties.put(PropertyIds.OBJECT_TYPE_ID, type);
		properties.put(PropertyIds.NAME, path);

		return properties;
	}

	/**
	 *
	 * @param file
	 * @param data
	 * @return
	 */
	private ContentStream createContentStream(String file, byte[] data) {
		InputStream stream = new ByteArrayInputStream(data);
		ObjectFactory factory = session.getObjectFactory();

		return factory.createContentStream(file, data.length, MIME, stream);
	}

	/**
	 *
	 * @param path
	 * @return
	 * @throws IOException
	 */
	private Folder getParentFolder(String path) throws IOException {
		String parent = getPathParent(path);

		if (parent != null) {
			try {
				return (Folder) session.getObjectByPath(checkPath(parent));
			} catch (CmisObjectNotFoundException e) {
				throw new IOException("Parent folder does not exist");
			}
		} else {
			return session.getRootFolder();
		}
	}

	/**
	 *
	 * @param path
	 * @return
	 */
	private String checkPath(String path) {
		if (!path.startsWith("/")) {
			return "/" + path;
		} else {
			return path;
		}
	}

	private String getPathParent(String path) {
		int lastIndex = path.lastIndexOf('/');

		if (lastIndex > 0) {
			return path.substring(0, lastIndex);
		} else {
			return null;
		}
	}

	private String getPathFile(String path) {
		int lastIndex = path.lastIndexOf('/');

		if (lastIndex > 0) {
			return path.substring(lastIndex + 1);
		} else {
			return path;
		}
	}

	/**
	 *
	 */
	public EcmStorage() {
		// TODO: Improve exception handling in case ECM is not available
		session = EcmProxy.getSession(NAME, KEY);
	}

	@Override
	public void createFolder(String path) throws IOException {
		try {
			getParentFolder(path).createFolder(getProperties(getPathFile(path), true));
		} catch (CmisNameConstraintViolationException e) {
			// Folder already exists.
		}
	}

	@Override
	public void writeFile(String path, byte[] data) throws IOException {
		String file = getPathFile(path);
		ContentStream content = createContentStream(file, data);

		Folder folder = getParentFolder(path);

		try {
			Document document = (Document) session.getObjectByPath(checkPath(path));
			document.setContentStream(content, true);
		} catch (CmisObjectNotFoundException e1) {
			try {
				folder.createDocument(getProperties(file, false), content, VersioningState.NONE);
			} catch (CmisNameConstraintViolationException e2) {
				e2.printStackTrace();
			}
		}
	}

	@Override
	public void writeFile(String path, String data) throws IOException {
		byte[] bytes = data.getBytes(UTF_8);
		writeFile(path, bytes);
	}

	@Override
	public byte[] readFile(String path) throws FileNotFoundException {
		Document document;

		try {
			document = (Document) session.getObjectByPath(checkPath(path));
		} catch (CmisObjectNotFoundException e) {
			throw new FileNotFoundException();
		}

		ContentStream content = document.getContentStream();

		byte[] data = null;

		try {
			data = IOUtils.toByteArray(content.getStream());
		} catch (IOException e) {
			e.printStackTrace();
		}

		return data;
	}

	@Override
	public String readFileAsString(String path) throws FileNotFoundException {
		byte[] bytes = readFile(path);
		return new String(bytes, UTF_8);
	}

	@Override
	public Set<String> getFiles(String path) throws IOException {
		Folder folder;
		Set<String> files;

		try {
			folder = (Folder) session.getObjectByPath(checkPath(path));
		} catch (CmisObjectNotFoundException e) {
			throw new IOException("Folder does not exist");
		}

		files = new HashSet<String>();

		for (CmisObject object : folder.getChildren()) {
			files.add(object.getName());
		}

		return files;
	}

	@Override
	public void deleteFile(String path) {
		CmisObject object = session.getObjectByPath(checkPath(path));
		object.delete();
	}

	@Override
	public boolean isFolder(String path) {
		try {
			CmisObject object = session.getObjectByPath(path);

			if (object instanceof Folder) {
				return true;
			} else {
				return false;
			}
		} catch (CmisObjectNotFoundException e) {
			return false;
		}
	}

	@Override
	public boolean fileExists(String path) {
		try {
			session.getObjectByPath(checkPath(path));
			return true;
		} catch (CmisObjectNotFoundException e) {
			return false;
		}
	}
}
