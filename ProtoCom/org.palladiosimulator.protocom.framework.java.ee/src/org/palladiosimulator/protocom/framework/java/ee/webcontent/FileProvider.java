package org.palladiosimulator.protocom.framework.java.ee.webcontent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.eclipse.osgi.util.ManifestElement;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleException;
import org.osgi.framework.Constants;

/**
 * The FileProvider class is used to retrieve WebContent files during transformation.
 * @author Christian Klaussner
 */
public class FileProvider {

	/**
	 *
	 * @param source
	 * @param path
	 * @return
	 */
	private FrameworkFile processIndex(String source, String path) {
		System.out.println(source);

		URL url = getClass().getResource("files/" + source);
		String absolute = path + '/' + source.substring(source.lastIndexOf('/'));

		return new FrameworkFile(url, absolute);
	}

	/**
	 *
	 * @return
	 */
	public List<FrameworkFile> getFrameworkFiles() {
		List<FrameworkFile> files = new LinkedList<FrameworkFile>();

		InputStream in;

		try {
			in = getClass().getResource("index").openStream();
		} catch (IOException e) {
			throw new RuntimeException("Index file not found", e);
		}

		BufferedReader index = new BufferedReader(new InputStreamReader(in));
		String line;

		try {
			while ((line = index.readLine()) != null) {
				if (line.startsWith("#") || line.trim().isEmpty()) {
					continue;
				}

				String[] comp = line.split("->");

				if (comp.length != 2) {
					throw new RuntimeException("Wrong index file format");
				} else {
					files.add(processIndex(comp[0].trim(), comp[1].trim()));
				}
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		return files;
	}

	/**
	 * Fills the given set with the dependencies of the specified bundle.
	 * Used only for debugging purposes.
	 *
	 * @param bundleName the name of the bundle
	 * @param result the set used to store the names of the bundle's dependencies
	 */
	public void getDependencies(String bundleName, Set<String> result) {
		Bundle bundle = Platform.getBundle(bundleName);

		if (bundle == null) {
			return;
		}

		String header = bundle.getHeaders().get(Constants.REQUIRE_BUNDLE);
		String jar = "<unknown>";

		try {
			jar = FileLocator.getBundleFile(bundle).getName();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			ManifestElement[] elements;
			elements = ManifestElement.parseHeader(Constants.BUNDLE_CLASSPATH, header);

			if (elements != null) {
				for (ManifestElement element : elements) {
					String value = element.getValue();

					result.add(value + " (" + jar + ")");
					getDependencies(value, result);
				}
			}
		} catch (BundleException e) {
			e.printStackTrace();
		}
	}
}
