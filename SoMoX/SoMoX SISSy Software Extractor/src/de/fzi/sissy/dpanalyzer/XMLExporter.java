/**
 * Copyright (c) 2005-2006 FZI Forschungszentrum Informatik, 
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
package de.fzi.sissy.dpanalyzer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;

import de.fzi.sissy.dpanalyzer.roles.Role;
import de.fzi.sissy.metamod.Function;
import de.fzi.sissy.metamod.ModelElement;
import de.fzi.sissy.metamod.NamedModelElement;
import de.fzi.sissy.metamod.Position;
import de.fzi.sissy.metamod.SourceEntity;
import de.fzi.sissy.util.Debug;


public class XMLExporter {
    
    public static final String DP_LIST_ELEMENT = "designpatternlist";
    public static final String DP_INSTANCE_ELEMENT = "dp-instance";
    public static final String DP_NAME_ATTRIBUTE = "dp-name";
    public static final String ROLE_ELEMENT = "role";
    public static final String ROLE_NAME_ATTRIBUTE = "role-name";
    public static final String ROLE_TYPE_ATTRIBUTE = "role-type";
    public static final String ROLE_MODELELEMENT_ATTRIBUTE = "role-modelelement";
    public static final String ROLE_TYPE_ACCESS = "access";
    public static final String ROLE_TYPE_METHOD = "method";
    public static final String ROLE_TYPE_CONSTRUCTOR = "constructor";
    public static final String ROLE_TYPE_CLASS = "class";
    public static final String ROLE_TYPE_VARIABLE = "variable";
    public static final String ROLE_TYPE_DEFAULT = "default";
    
    
    private Vector fullqualifiedlist;
    
    private static XMLExporter singleton;
    
    private XMLExporter() {
        fullqualifiedlist = new Vector();
    }
    
    public static XMLExporter getSingleton() {
        if (singleton==null) {
            singleton = new XMLExporter();
        }
        
        return singleton;
   }

   public void exportToXMLFile(Map resultPatternMap) {
       
       Document document = null;
       
       try {
       
           DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        
           DocumentBuilder builder = factory.newDocumentBuilder();
    
           document = builder.newDocument();
           
       } catch (ParserConfigurationException e) {
           e.printStackTrace();
       }
       
       // create and setup root-element
       createXMLRootElement(document, DP_LIST_ELEMENT);
       
       Iterator key_itr = resultPatternMap.keySet().iterator();
       
       while (key_itr.hasNext()) {
           String dp_name = (String) key_itr.next();
        
           // get mapped collection with dp_instances
           Collection dpi_collection = (Collection) resultPatternMap.get(dp_name);
           
           // iterate over dp-instances
           Iterator dpi_itr = dpi_collection.iterator();
           
           while(dpi_itr.hasNext()) {
               DesignPatternInstance dp_instance = (DesignPatternInstance)dpi_itr.next();
               
               createDPInstanceElement(document, dp_instance);
           }
       }
       
       // save document tree in xml-file
       if (document != null) {
           saveXMLDocument("dpilist.xml", document);
           saveListDocument("dpilist.csv");
       }
   }

   
   private void saveXMLDocument(String file_name, Document document) {
       
       String linesp = System.getProperty("line.separator");
       
       FileWriter writer = null;

       try {
        
           writer = new FileWriter(file_name);

           BufferedWriter bwriter = new BufferedWriter(writer);
           
           String heading = "<?xml version='1.0' encoding='iso-8859-1' ?>";

           String content = heading + linesp;
           
           content = content + stringForXMLElement(document.getDocumentElement());
           
           System.out.println(content);
           
           bwriter.write(content);
           bwriter.flush();
           bwriter.close();
           
       } catch (IOException e) {
           e.printStackTrace();
       }
       
   }

   private void saveListDocument(String file_name) {
       
       FileWriter writer = null;

       try {
        
           writer = new FileWriter(file_name);

           BufferedWriter bwriter = new BufferedWriter(writer);
           
           Iterator itr = fullqualifiedlist.iterator();
           
           while(itr.hasNext()) {
               String line = (String)itr.next();
               
               bwriter.write("\""+line+"\"\n");
           }
           
           bwriter.flush();
           bwriter.close();
           
       } catch (IOException e) {
           e.printStackTrace();
       }
       
   }


   private void createXMLRootElement(Document document, String elementName) {
       Element root = document.createElement(elementName);
       document.appendChild(root);
   }
   
   private void createDPInstanceElement(Document document, DesignPatternInstance dp_instance) {
       Element root = document.getDocumentElement();
       
       Element dpi_element = document.createElement(DP_INSTANCE_ELEMENT);
       
       // set dp-name as attribute
       dpi_element.setAttribute(DP_NAME_ATTRIBUTE, dp_instance.getDesignPatternName());
       
       // create and insert role-elements
       Map role_map = dp_instance.getRoleToMetamodMapping();
       
       Iterator role_itr = role_map.keySet().iterator(); 

       boolean exists_valid_role = false;

       nextRoleName:
       while(role_itr.hasNext()) {
           String role_name = (String)role_itr.next();
           
           boolean contained = false;
           Iterator itr = dp_instance.getDesignPatternDescription().getVisibleRoles().iterator();
           while (itr.hasNext()) {
               Role role = (Role)itr.next();
               
               if (role.getRoleName().equals(role_name)) {
                   contained = true;
                   break;
               }
           }
           if (!contained) {
               continue nextRoleName;
           }
           
           // get mapped metamod-object-collection
           Collection mm_collection = (Collection)role_map.get(role_name);
           
           Iterator mm_itr = mm_collection.iterator(); 
           
           
           while(mm_itr.hasNext()) {
               Object obj = mm_itr.next();
               //Debug.info(obj.getClass().getName());
               
               ModelElement model_obj = (ModelElement)obj;

               if (model_obj instanceof SourceEntity) {
                   SourceEntity se = (SourceEntity)model_obj;
                   
                   Position pos = se.getPosition();
                   
                   if (pos.getSourceFile()==null) {
                       
                       //Debug.warning("SourceEntity without SourceFile found!!!"+((N)candidate_element).getSimpleName()+" von "+((Method)candidate_element).getSurroundingClass().getQualifiedName());
                       //System.exit(0);
                       continue;
                   }
               }
               exists_valid_role = true;
               
               createRoleElement(document, dpi_element, role_name, model_obj);
           }
       

       }
       // insert in root
       if (exists_valid_role)
       root.appendChild(dpi_element);

   }

   private void createRoleElement(Document document, Element dpi_element, String role_name, ModelElement model_obj) {
       

       Element role_element = document.createElement(ROLE_ELEMENT);
       
       dpi_element.appendChild(role_element);
       
       role_element.setAttribute(ROLE_NAME_ATTRIBUTE, role_name);
       
       String type = "";
       if (model_obj instanceof de.fzi.sissy.metamod.Method) {
           type = ROLE_TYPE_METHOD;
       } else if (model_obj instanceof de.fzi.sissy.metamod.Constructor) {
           type = ROLE_TYPE_CONSTRUCTOR;
       } else if (model_obj instanceof de.fzi.sissy.metamod.Class) {
           type = ROLE_TYPE_CLASS;
       } else if (model_obj instanceof de.fzi.sissy.metamod.Variable) {
           type = ROLE_TYPE_VARIABLE;
       } else if (model_obj instanceof de.fzi.sissy.metamod.Access) {
           type = ROLE_TYPE_ACCESS;
       } else {
           type = ROLE_TYPE_DEFAULT;
       }
       
       
       role_element.setAttribute(ROLE_TYPE_ATTRIBUTE, type);
       
       String full_qualified_name = MetamodRetrievalEngineImplementation.getSingleton().getFullQualifiedNameOfMetamodObject(model_obj);
       role_element.setAttribute(ROLE_MODELELEMENT_ATTRIBUTE, full_qualified_name);
       //role_element.appendChild(document.createTextNode(full_qualified_name));
       this.fullqualifiedlist.add(full_qualified_name);
   }

   private static String linesp = System.getProperty("line.separator");
   
   private String stringForXMLElement(Element element) {
       String text = "";
       
       text = "<" + element.getTagName();
       
       NamedNodeMap attributes = element.getAttributes();
       
       for (int i=0; i < attributes.getLength(); i++) {
           
           Attr attrb = (Attr) attributes.item(i);
           
           text = text + " " + attrb.getName()+"=\""+ attrb.getValue()+"\"";
       }
       
       NodeList childnodes = element.getChildNodes();

       if (childnodes.getLength()>0) {
           text = text + ">" + linesp;
           
           for (int j=0; j < childnodes.getLength(); j++) {
               Node node = childnodes.item(j);
               
               if (node instanceof Element) {
                   
                   text = text + stringForXMLElement((Element)node)+linesp;
               
               } else if (node instanceof Text) {
                   
                   text = text + ((Text)node).getWholeText() + linesp;
                   
               }
           }
       
           text = text + "</" + element.getTagName()+ ">" + linesp;
       } else {
           
           text = text + "/>";

       }
       
       return text;
   }

}
