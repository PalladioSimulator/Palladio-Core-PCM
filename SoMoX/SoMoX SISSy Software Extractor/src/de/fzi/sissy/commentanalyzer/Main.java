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
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import de.fzi.sissy.metamod.Class;
import de.fzi.sissy.metamod.Comment;
import de.fzi.sissy.metamod.ModelElement;
import de.fzi.sissy.metamod.ModelElementList;
import de.fzi.sissy.metamod.ModelElementRepository;
import de.fzi.sissy.metamod.NamedModelElement;
import de.fzi.sissy.metamod.Position;
import de.fzi.sissy.metamod.Root;
import de.fzi.sissy.metamod.SourceEntity;
import de.fzi.sissy.metamod.Type;
import de.fzi.sissy.sql.JDBCWrapper;
import de.fzi.sissy.sql.ModelExporter;
import de.fzi.sissy.sql.ModelImporter;
import de.fzi.sissy.util.Debug;

/**
 * @author Philipp Haller
 */
public class Main {

	static final int NORMAL = 0;
	static final int INFORMAL_COMMENT = 1;
	static final int FORMAL_COMMENT = 2;

	private int state;
	private IConfig config;
	private Pattern[] patterns;
	private String lineStart, normalStart, normalEnd, formalStart, formalEnd;

	// information associated with current file
	private int loc;

	// maps file names to collections of comment objects
	private HashMap fileMap = new HashMap();

	// maps file names to lines of code
	private HashMap locMap = new HashMap();

	// file count
	private static int numFiles = 0;

	public Main(IConfig conf) {
		state = NORMAL;
		config = conf;
		// create compiled patterns for todo tags
		patterns = new Pattern[config.getTodoPatterns().length];
		for (int i = 0; i < config.getTodoPatterns().length; i++) {
			patterns[i] = Pattern.compile(".*" + config.getTodoPatterns()[i]
					+ ".*");
		}
		lineStart = config.getLineCommentStart();
		normalStart = config.getNormalBlockCommentStart();
		normalEnd = config.getNormalBlockCommentEnd();
		formalStart = config.getFormalBlockCommentStart();
		formalEnd = config.getFormalBlockCommentEnd();
	}

	/**
	 * @return the hash map that associates canonical path names with collections
	 * of {@link Comment} objects
	 * @see Comment
	 */
	public HashMap getFileMap() { return fileMap; }

	private int indexOfNormalStart(String line, int startpos) {
		String[] starts = config.getNormalBlockCommentStarts();
		int[] indices = new int[starts.length];
		for (int i = 0; i < starts.length; i++) {
			indices[i] = line.indexOf(starts[i], startpos);
		}
		Arrays.sort(indices);
		return indices[indices.length-1];

		//return line.indexOf(normalStart, startpos);
	}

	private int indexOfNormalEnd(String line, int startpos) {
		String[] ends = config.getNormalBlockCommentEnds();
		int[] indices = new int[ends.length];
		for (int i = 0; i < ends.length; i++) {
			indices[i] = line.indexOf(ends[i], startpos);
		}
		Arrays.sort(indices);
		return indices[indices.length-1];

		//return line.indexOf(normalEnd, startpos);
	}

	/**
	 * Extracts comments from file and associates a collection of comment
	 * objects with the canonical path name of file using the fileMap hash map.
	 * Also the lines of code are counted and associated with the canonical path
	 * name of file using the locMap hash map.
	 * <p>
	 * This method differs from the related extractComments method in that the
	 * analyze method can only take abstract path names that do <b>not</b> denote
	 * directories, whereas extractComments will recursively scan whole
	 * directory trees.
	 *
	 * @param file
	 *            the file from which comments are to be extracted
	 */
	public void analyze(File file) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			Collection comments = new ArrayList();
			String line;
			ArrayList commentLines = new ArrayList();
			int linepos = 0, colpos = -1, endpos = -1, startpos = -1;
			Comment c = null;
			Position pos = null;
			state = NORMAL;
			numFiles++;

			while ((line = reader.readLine()) != null) {
				startpos = 0;
				colpos = 0;
				linepos++;

				while (startpos < line.length()) {
					if (state == NORMAL) {
						//colpos = line.indexOf(formalStart, startpos);
						colpos = indexOfNormalStart(line, startpos);

						// switch to comment mode if line starts accordingly
						if (colpos > -1)
							state = INFORMAL_COMMENT;

						//int tmppos = indexOfNormalStart(line, startpos);
						int tmppos = line.indexOf(formalStart, startpos);
						if ((colpos == -1) || ((tmppos <= colpos) && (tmppos > -1))) {
							// no normal comment or formal comment starts before normal comment
							colpos = tmppos; // info about normal comment lost
							if (colpos > -1)
								state = FORMAL_COMMENT;
							else
								state = NORMAL;
							tmppos = line.indexOf(lineStart, startpos);
							if ((colpos == -1) || ((tmppos < colpos) && (tmppos > -1))) {
								// no formal comment or line comment starts before formal comment
								colpos = tmppos; // info about normal comment lost
								if (colpos > -1) { // there is a line comment
									state = NORMAL;
									pos = new Position(null, linepos, colpos, linepos, line.length());
									c = new Comment(false, line.substring(colpos), countTodos(line.substring(colpos)));
									c.setPosition(pos);
									comments.add(c);
								}
							}
						}

						if (state != NORMAL)
							pos = new Position(null, linepos, colpos, 0, 0);
						else
							startpos = line.length();
					}
					if (state != NORMAL) {
						endpos = -1;
						int diff = 0;
						if (state == FORMAL_COMMENT) {
							if (linepos == pos.getStartLine())
								diff = 3;
							endpos = line.indexOf(formalEnd, colpos + diff);
						}
						if (endpos > -1) {
							//End formal comment
							pos.setEndLine(linepos);
							pos.setEndColumn(endpos + formalEnd.length() - 1);
							commentLines.add(line.substring(colpos, endpos + formalEnd.length()));
							c = new Comment(true, commentLines, countTodos(commentLines));
							c.setPosition(pos);
							comments.add(c);
							state = NORMAL;
							startpos = endpos + formalEnd.length();
							commentLines = new ArrayList();
						}
						else {
							if (linepos == pos.getStartLine())
								diff = 2;
							endpos = indexOfNormalEnd(line, colpos + diff);
							if (endpos > -1) {
								//End normal comment
								pos.setEndLine(linepos);
								pos.setEndColumn(endpos + normalEnd.length());
								commentLines.add(line.substring(colpos, endpos + normalEnd.length()));
								c = new Comment(false, commentLines, countTodos(commentLines));
								c.setPosition(pos);
								comments.add(c);
								state = NORMAL;
								startpos = endpos + normalEnd.length();
								commentLines = new ArrayList();
							}
							else {
								commentLines.add(line.substring(colpos));
								startpos = line.length();
							}
						}
					}
				}
			}

			// associate comments with file
			fileMap.put(file.getCanonicalPath().toUpperCase(), comments);

			/* we cannot use autoboxing so we have to box the int loc
			 * manually as hash maps can only contain objects
			 */
			locMap.put(file.getCanonicalPath().toUpperCase(), new Integer(linepos));

		} catch (FileNotFoundException e) {
			Debug.error("File '" + file.getAbsolutePath() + "' not found.");
			e.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	/**
	 * @param f file to be tested
	 * @return true if file name matches filter, false otherwise
	 */
	private boolean accept(File f) {
		Matcher m = config.getFileFilter().matcher(f.getAbsolutePath());
		return m.matches();
	}

	private void readRecursive(File f) {
		if (!f.isDirectory()) {
			if (accept(f))
				analyze(f);
			else
				Debug.verbose("File not accepted: " + f);
		} else {
			File[] files = f.listFiles();
			for (int i = 0; i < files.length; i++) {
				readRecursive(files[i]);
			}
		}
	}

	private int countTodos(ArrayList lines) {
		int count = 0;
		Iterator it = lines.iterator();
		while (it.hasNext())
		{
			String tmp = (String)it.next();
			count += countTodos(tmp);
		}
		return count;
	}

	private boolean containsTodoTag(String line) {
		boolean flag = false;
		return flag;
	}

	private int countTodos(String line) {
		int count = 0;
		Matcher m = null;
		for (int i = 0; i < patterns.length; i++) {
			m = patterns[i].matcher(line);
			while (m.find())
				count++;
		}
		return count;
	}

	/**
	 * Extracts comment objects from the specified file or directory. Extracted
	 * comments are stored in a hash map that maps canonical path names to
	 * collections of comment objects. This hash map can be retrieved via the
	 * getFileMap method.
	 *
	 * @param file
	 *            file or directory from which comments (recursively) are to be
	 *            extracted
	 */
	public void extractComments(File file) {
		readRecursive(file);

		// print comments
		Iterator files = fileMap.keySet().iterator();
		while (files.hasNext()) {
			String fileName = (String) files.next();
			Debug.verbose("Comments for file " + fileName + ":");
			Collection comments = (Collection) fileMap.get(fileName);
			Iterator cs = comments.iterator();
			while (cs.hasNext()) {
				Comment c = (Comment) cs.next();
				Debug.verbose(c.toString());
			}
		}
	}

	private static void addCommentsToSourceEntity(Collection comments,
			SourceEntity entity) {
		Iterator citer = comments.iterator();
		while (citer.hasNext()) {
			Comment c = (Comment) citer.next();

			// comment inside or directly in front of source entity
			if (entity.getPosition().contains(c.getPosition())
					|| c.isDirectlyInFrontOf(entity.getPosition())) {
				Debug.verbose("Adding comment to entity '" + entity + "':");
				Debug.verbose(c.toString());
				// add comment to entity
				entity.addAnnotation(c);
			}
		}
	}

	private static void addCommentsToSourceEntities(Collection comments, ModelElementList modelElements) {
		Iterator elements = modelElements.iterator();
		while (elements.hasNext()) {
			ModelElement element = (ModelElement) elements.next();

			if (element instanceof SourceEntity) {
				SourceEntity entity = (SourceEntity) element;
				addCommentsToSourceEntity(comments, entity);
			}
		}
	}

	/**
	 * Adds comment annotations to model elements that
	 * <ul>
	 * <li>are {@link SourceEntity}s
	 * <li>contain a comment with respect to their {@link Position} or
	 * <li>have a comment directly in front of them (for example classes or methods)
	 * </ul>
	 *
	 * @param root the {@link Root} of the object model to which extracted comments
	 * are to be added.
	 */
	public void addCommentsToModel(Root root) {
		Collection modelElements = new ArrayList();

		ModelElementList allClasses = new ModelElementList();
		allClasses.addAll(root.getClasses());

		// recursively add inner classes to collection of all classes
		addInnerClasses(allClasses, allClasses);

		// First we try to add comments to methods, fields, properties and functions.
		// only if this fails we try to add them to classes.

		// Thus in modelElements there must not be any classes,
		// because they will get all the comments,
		// and after comments are removed, they cannot be added
		// to methods and fields any more.

		Iterator ci = allClasses.iterator();
		while (ci.hasNext()) {
			Class c = (Class) ci.next();
			modelElements.addAll(c.getFields());
			modelElements.addAll(c.getMethods());
			modelElements.addAll(c.getProperties());
		}

		modelElements.addAll(root.getFunctions());
		modelElements.addAll(root.getGlobalFunctions());
		modelElements.addAll(root.getGlobalVariables());

		ModelElementList otherTypes = new ModelElementList();

		ModelElementList rootTypes = root.getTypes();
		Iterator ti = rootTypes.iterator();
		while (ti.hasNext()) {
			Type t = (Type) ti.next();
			if (!(t instanceof de.fzi.sissy.metamod.Class)
					&& (t instanceof SourceEntity))
				otherTypes.add(t);
		}

		Set ents = new HashSet();
		Iterator modelElems = modelElements.iterator();
		while (modelElems.hasNext()) {
			ModelElement e = (ModelElement) modelElems.next();
			if (e instanceof SourceEntity)
				ents.add(e);
		}

		Object[] entsArray = ents.toArray();
		Arrays.sort(entsArray, new SourceEntityFilenameComparator());
		Arrays.sort(entsArray, new SourceEntityStartLineComparator());

		for (int i = 0; i < entsArray.length; i++) {
			SourceEntity entity = (SourceEntity) entsArray[i];
			Debug.verbose("Entity: " + entity.toString());
			if (entity instanceof NamedModelElement)
				Debug.verbose("Name: " + ((NamedModelElement) entity).getSimpleName());

			try {
				de.fzi.sissy.metamod.File srcFile = entity.getPosition().getSourceFile();
				String pathName = srcFile.getPathName();
				if (pathName.startsWith("FILE:"))
					pathName = pathName.substring(5);
				pathName = pathName.toUpperCase();
				Debug.verbose(pathName);

				Collection comments = (Collection) fileMap.get(pathName);
				Debug.verbose(comments.size() + " comments for file "
						+ pathName);

				if (comments.size() > 0) {
					Iterator cs = comments.iterator();
					while (cs.hasNext()) {
						Comment c = (Comment) cs.next();
						Position cpos = c.getPosition();
						cpos.setSourceFile(srcFile);
						if (((c.getPosition().getStartLine() <= entity
								.getPosition().getEndLine()) && (c
								.getPosition().getEndLine() >= entity
								.getPosition().getStartLine() - 2))
								|| ((c.getPosition().getStartLine() >= entity
										.getPosition().getStartLine()) && (c
										.getPosition().getEndLine() <= entity
										.getPosition().getEndLine()))) {
							Debug.verbose("Adding comment to entity '" + entity
									+ "':");
							Debug.verbose(c.toString());
							// add comment to entity
							entity.addAnnotation(c);
							// remove comment from collection
							cs.remove();
						}
					}
				}

				Debug.verbose(((Collection) fileMap.get(pathName)).size()
						+ " comments for file " + pathName + " left.");

			} catch (NullPointerException npe) {
			}
		}

		// try to add remaining comments to classes.
		Object[] classesArray = allClasses.toArray();
		Arrays.sort(classesArray, new SourceEntityFilenameComparator());
		Arrays.sort(classesArray, new SourceEntityStartLineComparator());

		for (int i = 0; i < classesArray.length; i++) {
			de.fzi.sissy.metamod.Class entity = (de.fzi.sissy.metamod.Class) classesArray[i];
			Debug.verbose("Class: " + entity.getSimpleName());

			try {
				String pathName = entity.getPosition().getSourceFile()
						.getPathName();
				if (pathName.startsWith("FILE:"))
					pathName = pathName.substring(5);
				pathName = pathName.toUpperCase();
				Debug.verbose(pathName);

				Collection comments = (Collection) fileMap.get(pathName);
				Debug.verbose(comments.size() + " comments for file "
						+ pathName);

				if (comments.size() > 0) {
					Iterator cs = comments.iterator();
					while (cs.hasNext()) {
						Comment c = (Comment) cs.next();
						if (((c.getPosition().getStartLine() <= entity
								.getPosition().getEndLine()) && (c
								.getPosition().getEndLine() >= entity
								.getPosition().getStartLine() - 2))
								|| ((c.getPosition().getStartLine() >= entity
										.getPosition().getStartLine()) && (c
										.getPosition().getEndLine() <= entity
										.getPosition().getEndLine()))) {
							Debug.verbose("Adding comment to entity '" + entity
									+ "':");
							Debug.verbose(c.toString());
							// add comment to entity
							entity.addAnnotation(c);
							// remove comment from collection
							cs.remove();
						}
					}
				}

				Debug.verbose(((Collection) fileMap.get(pathName)).size()
						+ " comments for file " + pathName + " left.");

			} catch (NullPointerException npe) {
			}
		}
	}

	private void addInnerClasses(ModelElementList allClasses, ModelElementList classes) {
		for (int i=0; i < classes.size(); i++) {
			de.fzi.sissy.metamod.Class c = (de.fzi.sissy.metamod.Class)classes.get(i);
			if (c.getInnerClasses().size() > 0) {
				allClasses.addAll(c.getInnerClasses());
				addInnerClasses(allClasses, c.getInnerClasses());
			}
		}
	}

	private void addLOCToFiles(Root root) {
		Iterator it = root.getFiles().iterator();
		while (it.hasNext()) {
			de.fzi.sissy.metamod.File f = (de.fzi.sissy.metamod.File)it.next();
			String name = f.getPathName();
			if (f.isSourceFile()) {
				if (name.startsWith("FILE:"))
					name = name.substring(5);
				name = name.toUpperCase();
				Integer loc = (Integer)locMap.get(name);
				if (loc != null)
					f.setLinesOfCode(loc.intValue());
			}
		}
	}

	/**
	 * Reads a configuration from the command line (via {@link ConsoleConfig})
	 * and configuration files that are passed as arguments.
	 * <p>
	 * Then comments are (recursively) extracted from the file or directory that
	 * is provided as the first argument on the command line.
	 * <p>
	 * Extracted comments are added to the object model that is imported from
	 * the database specified in the default "jdbc.cfg" file or the
	 * configuration file whose name is specified by either the "-cfg" option or
	 * the value of the JDBC_CFG property in the top-level configuration file
	 * specified by the "-all" option.
	 * <p>
	 * The augmented object model is then supposed to be exported back into the
	 * specified database. TODO: We don't do this yet as there are errors when
	 * importing the database again.
	 *
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {
		Debug.pushDebugLevel();
		Debug.setDebugLevel(7);

		IConfig conf = ConsoleConfig.readInstanceConsole(args);

		Root root = ModelElementRepository.getWorkingRepository().getRoot();

		Main main = new Main(conf);
		/*
		String[] pathList = calculatePathArray(args[0]);
		for (int i=0; i<pathList.length; i++)
			main.extractComments(new File(pathList[i]));
			*/

		List fileList = ModelElementRepository.getWorkingRepository().getFileList();
		for (int i=0; i<fileList.size(); i++) {
			main.extractComments(new File((String)fileList.get(i)));
		}

		Debug.verbose("#Files analyzed: " + numFiles);

		main.addCommentsToModel(root);

		main.addLOCToFiles(root);

		Debug.popDebugLevel();
	}

    private static String[] calculatePathArray(String pathList) {

        StringTokenizer pathTokenizer = new StringTokenizer(pathList,
                File.pathSeparator, false);

        String[] pathArray = new String[pathTokenizer.countTokens()];
        int i = 0;

        while (pathTokenizer.hasMoreTokens()) {
            String token = pathTokenizer.nextToken();
            pathArray[i] = token;
            i++;
        }

        return pathArray;
    }
}
