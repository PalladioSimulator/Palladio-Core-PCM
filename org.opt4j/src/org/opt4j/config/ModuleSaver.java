/**
 * Opt4J is free software: you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the
 * Free Software Foundation, either version 3 of the License, or (at your
 * option) any later version.
 * 
 * Opt4J is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public
 * License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with Opt4J. If not, see http://www.gnu.org/licenses/. 
 */

package org.opt4j.config;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.Collection;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

import com.google.inject.Module;

/**
 * Helper class for saving the {@code PropertyModule} configurations or adding
 * these to XML {@code Nodes}.
 * 
 * @author lukasiewycz
 * 
 */
public class ModuleSaver {

	/**
	 * Constructs a {@code ModuleSaver}.
	 */
	public ModuleSaver() {
		super();
	}

	/**
	 * Save the module configurations to a file (as filename).
	 * 
	 * @param filename
	 *            the name of the file
	 * @param modules
	 *            the modules
	 * @return {@code true} if successful
	 */
	public boolean save(String filename, Collection<? extends Module> modules) {
		File file = new File(filename);
		return save(file, modules);
	}

	/**
	 * Save the module configurations to a {@code File}.
	 * 
	 * @param file
	 *            the {@code File}
	 * @param modules
	 *            the modules
	 * @return {@code true} if successful
	 */
	public boolean save(File file, Collection<? extends Module> modules) {

		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.newDocument();

			Node node = document.createElement("application");
			document.appendChild(node);
			add(node, modules);

			TransformerFactory tf = TransformerFactory.newInstance();
			tf.setAttribute("indent-number", 2);
			Transformer trans = tf.newTransformer();
			trans.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
			trans.setOutputProperty(OutputKeys.INDENT, "yes");
			trans.setOutputProperty(OutputKeys.METHOD, "xml");

			FileOutputStream out = new FileOutputStream(file);

			StreamResult result = new StreamResult(new OutputStreamWriter(out,
					"utf-8"));
			DOMSource source = new DOMSource(document);
			trans.transform(source, result);

			return true;

		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			e.printStackTrace();
		} catch (TransformerException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		return false;

	}

	/**
	 * Add the module configuration to an XML {@code Node}.
	 * 
	 * @param node
	 *            the XML {@code Node}
	 * @param modules
	 *            the modules
	 * 
	 */
	public void add(Node node, Collection<? extends Module> modules) {
		JNode parent = new JNode(node);

		for (Module module : modules) {
			PropertyModule pModule;
			if (module instanceof PropertyModule) {
				pModule = (PropertyModule) module;
			} else {
				pModule = new PropertyModule(module);
			}
			JNode n = new JNode(pModule.getConfiguration(parent.getDocument()));
			parent.appendChild(n);
		}
	}

}
