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
package de.fzi.sissy.metamod;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.SortedMap;
import java.util.zip.GZIPOutputStream;
import java.util.zip.GZIPInputStream;
import java.io.OutputStream;
import java.io.InputStream;
import de.fzi.sissy.util.*;
import java.io.ByteArrayInputStream;

/**
 * @author Mircea Trifu
 *
 */
public class ModelElementRepository {
	private static ArrayList repositories = new ArrayList();

	private static int currentRepository = 0;
	
	public static ModelElementRepository newRepository() {
		ModelElementRepository mer = new ModelElementRepository();
		repositories.add(mer);
		currentRepository = repositories.size() - 1;
		new Root(mer);		
		return mer;
	}

	public static int getWorkingRepositoryIndex() {
	    return currentRepository;
	}
	
	public static ModelElementRepository getWorkingRepository() {
	    if (repositories.isEmpty())
	        return newRepository();
	    return (ModelElementRepository) repositories.get(currentRepository);
	}
	
	public static void setWorkingRepository(int repositoryIndex) {
	    if ((repositoryIndex >=0) && (repositoryIndex < getNumberOfRepositories()))
	        currentRepository = repositoryIndex;
	}
	
	public static ModelElementRepository getRepository(int repId) {
		return (ModelElementRepository)repositories.get(repId);
	}

	public static int getNumberOfRepositories() {
		return repositories.size();
	}
		
    public static ModelElementRepository getLastRepository() {
        if (repositories.isEmpty())
            return newRepository();
        return (ModelElementRepository)repositories.get(repositories.size() - 1);
    }
    
    public static void removeRepository(ModelElementRepository mer) {
		Iterator it = mer.modelElements.values().iterator();
		while (it.hasNext()) {
			ModelElementImplementation elem = (ModelElementImplementation)it.next();
			elem.destroy();
		}
		mer.modelElements.clear();
		mer.modelElements = null;
		repositories.remove(mer);
	}
	
	public static void serializeToFile(ModelElementRepository mer, File file) {
		mer.serializeToFile(file);
	}
	
    public static void serializeToGZIPFile(ModelElementRepository mer, File file) {
        mer.serializeToGZIPFile(file);
    }

    public static ModelElementRepository deserializeFromFile(java.io.File file) {
		try {
			ObjectInputStream serin = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file), 1048576));
			ModelElementRepository mer = newRepository();
			mer.modelElements = (HashMap)serin.readObject();
            mer.nextId = serin.readInt();
			serin.close();
			return mer;
		} catch(IOException e) {
			java.lang.System.err.println("ERROR: Unable to load from cache !");
			e.printStackTrace();
		} catch(ClassNotFoundException e) {
			java.lang.System.err.println("ERROR: Unable to load from cache !");
			e.printStackTrace();
		}
		return null;
	}

    public static ModelElementRepository deserializeFromGZIPFile(java.io.File file) {
        try {
            ObjectInputStream serin = new ObjectInputStream(new GZIPInputStream(new BufferedInputStream(new FileInputStream(file), 1048576)));
            ModelElementRepository mer = newRepository();
            mer.modelElements = (HashMap)serin.readObject();
            mer.nextId = serin.readInt();
            serin.close();
            return mer;
        } catch(IOException e) {
            java.lang.System.err.println("ERROR: Unable to load from cache !");
            e.printStackTrace();
        } catch(ClassNotFoundException e) {
            java.lang.System.err.println("ERROR: Unable to load from cache !");
            e.printStackTrace();
        }
        return null;
    }

    private List fileList = new ArrayList();
    private List libFileList = new ArrayList();
    private List pathListCache = null;
	private int nextId = 0;
	public HashMap modelElements;    
   
    public int getRepositoryIndex() {
	    return repositories.indexOf(this);
	}
		
	private ModelElementRepository() {
		modelElements = new HashMap();
	}
	
	/**
	 * @param fileList The fileList to set.
	 */
	public void setFileList(List fileList) {
		if (fileList != null)
			this.fileList = fileList;
		else
			this.fileList = new ArrayList();
		pathListCache = null;
	}

	/**
	 * @return Returns the fileList.
	 */
	public List getFileList() {
		return fileList;
	}
	
	/**
	 * @param libFileList The libFileList to set.
	 */
	public void setLibFileList(List libFileList) {
		if (libFileList != null)
			this.libFileList = libFileList;
		else
			this.libFileList = new ArrayList();
		fileList.removeAll(libFileList);
		pathListCache = null;
	}

	/**
	 * @return Returns the libFileList.
	 */
	public List getLibFileList() {
		return libFileList;
	}

	public List getAnalysisPathList() {
		if (pathListCache == null) {
			pathListCache = new ArrayList();
			HashSet paths = new HashSet();
			Iterator it = fileList.iterator();
			while (it.hasNext()) {
				String file = (String)it.next();
				File f = new File(file);
				paths.add(f.getParent());
			}
			pathListCache.addAll(paths);
		}
		return pathListCache;
	}

	int getNextId(ModelElement elem) {
		modelElements.put(new Integer(nextId), elem);
		return nextId++;
	}
	
	void updateId(ModelElement elem, int id) {
		modelElements.remove(new Integer(elem.getUniqueId()));
		modelElements.put(new Integer(id), elem);
		if (id >= nextId)
			nextId = id + 1; 
	}
	
	public int getSize() {
		return modelElements.size();
	}
	
	public Root getRoot() {
		return (Root)modelElements.get(new Integer(0));
	}

	public ModelElement getModelElementById(int id) {
		return (ModelElement)modelElements.get(new Integer(id));
	}
	
    public void serializeToGZIPFile(java.io.File file) {
        try {
            file.createNewFile();
            ObjectOutputStream serout = new ObjectOutputStream((new GZIPOutputStream(new BufferedOutputStream(new FileOutputStream(file), 1048576))));
            serout.writeObject(modelElements);
            serout.writeInt(nextId);
            serout.close();
        } catch (IOException e) {
            Debug.error("ModelElementRepository::serializeToFile - Unable to create the cache !");
            e.printStackTrace();
        }           
    }

    public void serializeToFile(java.io.File file) {
	    try {
			file.createNewFile();
			ObjectOutputStream serout = new ObjectOutputStream((new BufferedOutputStream(new FileOutputStream(file), 1048576)));
			serout.writeObject(modelElements);
            serout.writeInt(nextId);
			serout.close();
		} catch (IOException e) {
			Debug.error("ModelElementRepository::serializeToFile - Unable to create the cache !");
			e.printStackTrace();
		}			
	}
	
	public ArrayList getModelElements() {
		ArrayList elems = new ArrayList(modelElements.values()); 
		Collections.sort(elems);
		return elems;
	}
	
	// save saving and restoring features
	
	private DirectByteArrayOutputStream modelState = new DirectByteArrayOutputStream(); 
	
	private boolean compressedState = false;
	private boolean lastStateCompressed = false;
	
	public boolean getMemorySavingRollback() {
	    return compressedState;
	}
	
	public void setMemorySavingRollback(boolean saveMemory) {
	    compressedState = saveMemory;
	}
	
	public void saveState() {
	    try {
	        OutputStream s;
	        if (compressedState) {
	            s = new GZIPOutputStream(modelState);
	            lastStateCompressed = true;
	        } else {
	            s = modelState;
	            lastStateCompressed = false;
	        }
	        ObjectOutputStream objOut = new ObjectOutputStream(s);
	        objOut.writeObject(modelElements);
	        objOut.close();
	        Debug.info("Model size: " + Integer.toString(modelState.size()));
	    } catch (IOException e) {
	        Debug.error("ModelElementRepository::saveState - could not save the state of the model");
	    }
	}
	
	public void restoreState() {
	    if (modelState.size() < 1) {
	        Debug.warning("ModelElementRepository::restoreState - saved state is empty, not restoring");
	        return;
	    }
	    try {
	        InputStream s;
	        if (lastStateCompressed)
	            s = new GZIPInputStream(new ByteArrayInputStream(modelState.toByteArray()));
	        else
	            s = new ByteArrayInputStream(modelState.toByteArray());
	        ObjectInputStream objIn = new ObjectInputStream(s);
	        modelElements = (HashMap)objIn.readObject();
	        objIn.close();
	        modelState.reset();
	    } catch (Exception e) {
	        Debug.error("ModeElementRepository::restoreState - could not restore the state of the model, it may be left in undefined state");
	    }
	}

	public void removeElement(ModelElement me) {
	    modelElements.remove(new Integer(me.getUniqueId()));
	}


}
