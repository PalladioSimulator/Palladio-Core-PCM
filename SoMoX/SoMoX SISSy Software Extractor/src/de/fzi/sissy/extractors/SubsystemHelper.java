package de.fzi.sissy.extractors;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import de.fzi.sissy.metamod.Root;
import de.fzi.sissy.util.Debug;

public class SubsystemHelper {
    
    private class SSWrapper {
        de.fzi.sissy.metamod.Subsystem subsystem;
        List includedList;
        List excludedList;
    }
    
    private List ssWrappers = null;
    
    public SubsystemHelper() {
        ssWrappers = new ArrayList();
    }
    
    public void addSubsystemsToRoot(Root root) {
        for (int i=0; i<ssWrappers.size(); i++)
            root.addStructuralAbstraction(((SSWrapper)ssWrappers.get(i)).subsystem);
    }
    
    public void addFile(de.fzi.sissy.metamod.File f) {
        for (int k=0; k<ssWrappers.size(); k++) {
            SSWrapper ss = (SSWrapper) ssWrappers.get(k);
            for (int i=0; i<ss.excludedList.size(); i++) {
                String path = (String) ss.excludedList.get(i);
                String filePath = f.getPathName();
                // if the file is in the excluded path don't add it to any subsystem
                if (filePath.startsWith(path))
                    return;
            }
        }
        int closest = -1;
        int closestLength = 0;
        for (int k=0; k<ssWrappers.size(); k++) {
            SSWrapper ss = (SSWrapper) ssWrappers.get(k);
            for (int i=0; i<ss.includedList.size(); i++) {
                String path = (String) ss.includedList.get(i);
                String filePath = f.getPathName();
                if (File.pathSeparator.equals(";")) {
                	path = path.toLowerCase();
                	filePath = filePath.toLowerCase();
                }
                if (filePath.startsWith(path)) {
                	if (path.length() > closestLength) {
                    	closest = k;
                    	closestLength = path.length();
                    }
                }
            }
        }
        if (closest != -1)
            ((SSWrapper)ssWrappers.get(closest)).subsystem.addModelElement(f);
    }
    
    public void loadConfigFromFile(String path) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        Document document = null;
        try {
            DocumentBuilder parser = factory.newDocumentBuilder();
            document = parser.parse(new File(path));
            document.normalizeDocument();
            Node rootNode = document.getFirstChild();
            if ((rootNode == null) || (!rootNode.getNodeName().equals("subsystems"))) {
                Debug.error("Error loading subsystems specification file");
                return;
            }
            NodeList nl = rootNode.getChildNodes();
            for (int i=0; i<nl.getLength(); i++) {
            	Node n = nl.item(i);
            	if (n instanceof Element)
            		readSubsystemNode((Element)n, null);
            }
                
        } catch (Exception e) {
			Debug.warning("Exception caught: " + e.getClass().getCanonicalName());                	
            e.printStackTrace();
        }
        
    }
    
    private void readSubsystemNode(Element node, SSWrapper parent) {
        if (!node.getNodeName().equals("subsystem"))
            return;
        String ssName = "";
        ssName = node.getAttribute("name");
        SSWrapper ss = addSubsystem(parent, ssName);
        NodeList nl = node.getChildNodes();
        for (int i=0; i<nl.getLength(); i++) {
            Node child = nl.item(i);
            if (child.getNodeName().equals("include")) {
                ss.includedList.addAll(getPathEntries(child));
            }
            if (child.getNodeName().equals("exclude")) {
                ss.excludedList.addAll(getPathEntries(child));
            }
            if (child.getNodeName().equals("subsystem")) {
                readSubsystemNode((Element)child, ss);
            }
        
        }
    }
    
    private List getPathEntries(Node node) {
        List result = new ArrayList();
        NodeList nl = node.getChildNodes();
        for (int i=0; i<nl.getLength(); i++) {
            Node child = nl.item(i);
            if (!(child instanceof Element))
                continue;
            if (child.getNodeName().equals("path")) {
                String path = child.getTextContent();
                result.add(path);
            } else
                Debug.warning("SubsystemHelper::getPathEntries() - unknown tag found");
        }
        return result;
    }
    
    private SSWrapper addSubsystem(SSWrapper parent, String name) {
        SSWrapper ss = new SSWrapper();
        ss.includedList = new ArrayList();
        ss.excludedList = new ArrayList();
        ss.subsystem = new de.fzi.sissy.metamod.Subsystem(name);
        if (parent != null) {
        	parent.subsystem.addModelElement(ss.subsystem);
        }
        ssWrappers.add(ss);
        return ss;
    }
    
    boolean init = false;
    
    private void initMetamodEntities() {
        if (init)
            return;        
    }
}
