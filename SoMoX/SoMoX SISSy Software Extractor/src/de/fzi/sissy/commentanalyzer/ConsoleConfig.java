/**
 * Copyright (c) 2004-2006 FZI Forschungszentrum Informatik, 
 * 10-14 Haid-und-Neu Street, 76131 Karlsruhe, Germany
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */
package de.fzi.sissy.commentanalyzer;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;

import de.fzi.sissy.util.Debug;

/**
 * Implementation of the {@link IConfig} interface that can read its
 * configuration information from command line arguments and configuration files
 * that are specified on the command line.
 * 
 * @author Philipp Haller
 */
public class ConsoleConfig extends GenericConfig {

	/**
	 * Reads configuration information from command line arguments and creates
	 * an appropriate configuration object. The following command line options
	 * are recognized:
	 * <ul>
	 * <li><code>-l</code> start of a line comment</li>
	 * <li><code>-ns</code> start of a normal block comment</li>
	 * <li><code>-ne</code> end of a normal block comment</li>
	 * <li><code>-fs</code> start of a formal (that is Javadoc or Doxygen)
	 * block comment</li>
	 * <li><code>-fe</code> end of a formal block comment</li>
	 * <li><code>-f</code> regular expression specifying accepted file names
	 * (file filter)</li>
	 * <li><code>-c</code> property file that specifies the form of comments.
	 * The following keys are recognized:
	 * <ul>
	 * <li><code>LINE_COMMENT_START</code></li>
	 * <li><code>NORMAL_BLOCK_COMMENT_START</code></li>
	 * <li><code>NORMAL_BLOCK_COMMENT_END</code></li>
	 * <li><code>FORMAL_BLOCK_COMMENT_START</code></li>
	 * <li><code>FORMAL_BLOCK_COMMENT_END</code></li>
	 * </ul>
	 * </li>
	 * <li><code>-todos</code> simple file with a line for every TO DO
	 * pattern as a regular expression (see {@link Pattern}).</li>
	 * <li><code>-all</code> property file that specifies configuration files
	 * to be used and other options. The rationale for this property file is
	 * that only a single command line option is necessary. The following keys
	 * are recognized:
	 * <ul>
	 * <li><code>TODO_SPEC</code></li>
	 * <li><code>COMMENT_SPEC</code></li>
	 * <li><code>FILE_FILTER</code></li>
	 * </ul>
	 * </li>
	 * </ul>
	 * 
	 * @param cmds
	 *            the full command line arguments as they are provided for the
	 *            comment analyzer (including the first argument which does not
	 *            contain configuration information)
	 * @return a configuration object that contains the configuration
	 *         information as specified in the provided arguments
	 */
	public static IConfig readInstanceConsole(String[] cmds) {
		GenericConfig configInstance = new GenericConfig();
		String value = null;
		for (int i = 1; i < cmds.length; i++) {
			// line comment start
			if (cmds[i].equals("-l")) {
				value = cmds[++i];
				configInstance.setLineCommentStart(value);
			}
			// normal block comment start
			else if (cmds[i].equals("-ns")) {
				value = cmds[++i];
				if (value.indexOf(',') != -1) {
					// contains list
					String[] list = value.split(",");
					configInstance.setNormalBlockCommentStarts(list);
					configInstance.setNormalBlockCommentStart(list[0]);
				}
				else {
					String[] list = { value };
					configInstance.setNormalBlockCommentStart(value);
					configInstance.setNormalBlockCommentStarts(list);
				}
			}
			// normal block comment end
			else if (cmds[i].equals("-ne")) {
				value = cmds[++i];
				if (value.indexOf(',') != -1) {
					// contains list
					String[] list = value.split(",");
					configInstance.setNormalBlockCommentEnds(list);
					configInstance.setNormalBlockCommentEnd(list[0]);
				}
				else {
					String[] list = { value };
					configInstance.setNormalBlockCommentEnd(value);
					configInstance.setNormalBlockCommentEnds(list);
				}
			}
			// formal block comment start
			else if (cmds[i].equals("-fs")) {
				value = cmds[++i];
				configInstance.setFormalBlockCommentStart(value);
			}
			// formal block comment end
			else if (cmds[i].equals("-fe")) {
				value = cmds[++i];
				configInstance.setFormalBlockCommentEnd(value);
			}
			else if (cmds[i].equals("-f")) {
				value = cmds[++i];
				configInstance.setFileFilter(value);
			}
			// name of the comments file
			else if (cmds[i].equals("-c")) {
				value = cmds[++i];
				readCommentSpec(configInstance, value);
			}
			// file with todo regexp patterns
			else if (cmds[i].equals("-todos")) {
				value = cmds[++i];
				readTodoPatterns(configInstance, value);
			}
			else if (cmds[i].equals("-all")) {
				value = cmds[++i];

				File propFile = new File(value);
				if (propFile.exists()) {
					Properties props = new Properties();
					try {
						props.load(new FileInputStream(value));
						Debug
								.info("General config property file successfully loaded.");

						Enumeration names = props.propertyNames();
						while (names.hasMoreElements()) {
							String key = (String) names.nextElement();
							String val = props.getProperty(key);
							Debug.info(key + " = " + val);

							if (key.equals("TODO_SPEC")) {
								readTodoPatterns(configInstance, val);
							} else if (key.equals("COMMENT_SPEC")) {
								readCommentSpec(configInstance, val);
							} else if (key.equals("FILE_FILTER")) {
								configInstance.setFileFilter(val);
							}
						}
					} catch (FileNotFoundException fnfe) {
						fnfe.printStackTrace();
					} catch (IOException ioe) {
						ioe.printStackTrace();
					}
				}
			}
		}
		
		Debug.info(configInstance.toString());
		return configInstance;
	}

	private static void readCommentSpec(GenericConfig configInstance, String value) {
		File propFile = new File(value);
		if (propFile.exists()) {
			Properties props = new Properties();
			try {
				props.load(new FileInputStream(value));
				Debug
						.info("Comment property file successfully loaded.");

				Enumeration names = props.propertyNames();
				while (names.hasMoreElements()) {
					String key = (String) names.nextElement();
					String val = props.getProperty(key);
					Debug.info(key + " = " + val);

					if (key.equals("LINE_COMMENT_START"))
						configInstance.setLineCommentStart(val);
					else if (key.equals("NORMAL_BLOCK_COMMENT_START")) {
						if (val.indexOf(',') != -1) {
							// value contains list
							String list[] = val.split(",");
							configInstance.setNormalBlockCommentStart(list[0]);
							configInstance.setNormalBlockCommentStarts(list);
						}
						else {
							configInstance.setNormalBlockCommentStart(val);
							String[] list = { val };
							configInstance.setNormalBlockCommentStarts(list);
						}
					}
					else if (key.equals("NORMAL_BLOCK_COMMENT_END")) {
						if (val.indexOf(',') != -1) {
							// value contains list
							String list[] = val.split(",");
							configInstance.setNormalBlockCommentEnd(list[0]);
							configInstance.setNormalBlockCommentEnds(list);
						}
						else {
							configInstance.setNormalBlockCommentEnd(val);
							String[] list = { val };
							configInstance.setNormalBlockCommentEnds(list);
						}
					}
					else if (key.equals("FORMAL_BLOCK_COMMENT_START"))
						configInstance.setFormalBlockCommentStart(val);
					else if (key.equals("FORMAL_BLOCK_COMMENT_END"))
						configInstance.setFormalBlockCommentEnd(val);
				}
			} catch (FileNotFoundException fnfe) {
				fnfe.printStackTrace();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
	}

	private static void readTodoPatterns(GenericConfig configInstance, String value) {
		List regexps = new ArrayList();
		try {
			BufferedReader reader = new BufferedReader(new FileReader(value));
			String regexp = null;
			while ((regexp = reader.readLine()) != null) {
				regexps.add(regexp);
			}
		} catch (FileNotFoundException e) {
			Debug.error("File '" + value + "' not found.");
			e.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
		configInstance.setTodoPatterns((String[]) regexps.toArray(new String[0]));
	}

}
