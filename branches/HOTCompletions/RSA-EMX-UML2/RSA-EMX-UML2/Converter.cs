/*
 * Copyright 2006 by:
 * University of Karlsruhe (TH)
 * Faculty of Computer Science
 * Institute for Program Structures and Data Organization (IPD)
 * Software Design and Quality (SDQ)
 * Germany
 * Homepage: http://sdq.ipd.uni-karlsruhe.de
 * 
 * This is free software. You are welcome to redistribute it.
 * It comes with ABSOLUTELY NO WARRANTY.
 */
using System;
using System.Collections.Generic;
using System.Text;
using System.IO;
using System.Xml.XPath;
using System.Xml;

namespace RSA_EMX_UML2
{
    class Converter
    {
        private XmlNamespaceManager nsMgr;

        public Converter()
        {

        }

        private void InitNamespaceManager(XmlNameTable nameTable)
        {
            nsMgr = new XmlNamespaceManager(nameTable);
            nsMgr.AddNamespace("uml", "http://www.eclipse.org/uml2/1.0.0/UML");
            nsMgr.AddNamespace("xmi", "http://www.omg.org/XMI");
        }

        /// <summary>
        /// Main method to fix buggy RSA output.
        /// </summary>
        /// <param name="fileList"></param>
        public void Convert(String[] fileList) 
        {
            foreach (string file in fileList)
            {
                Console.WriteLine("Trying to fix " + file);

                XmlDocument xmlDoc = new XmlDocument();
                xmlDoc.Load(file);
                InitNamespaceManager(xmlDoc.NameTable);

                try
                {
                    bool foundNavPath = false;
                    XmlNodeList nodes = xmlDoc.SelectNodes("//*[@href]", nsMgr);

                    foreach (XmlNode node in nodes)
                    {
                        String hrefExpression = node.Attributes.GetNamedItem("href").Value;

                        if (IsNavPath(hrefExpression))
                        {
                            foundNavPath = true;

                            hrefExpression = ReplaceEmxWithUml2(hrefExpression);

                            String navPath = GetNavPath(hrefExpression);
                            Console.WriteLine("Searching for reference: " + navPath);

                            String referencedFile = GetReferencedFile(hrefExpression);
                            Console.WriteLine("Searching in file " + referencedFile + " for references...");
                            String newId = ExtractIdFromReferencedFile(referencedFile, navPath);

                            hrefExpression = ReplaceHashedId(hrefExpression, newId);
                            hrefExpression = RemoveNavPath(hrefExpression);

                            Console.WriteLine("Fixed expression: " + hrefExpression);
                            // write new expression
                            node.Attributes.GetNamedItem("href").Value = hrefExpression;
                        }
                    }
                    if (!foundNavPath)
                    {
                        Console.WriteLine("No fixes required.");
                    }
                }
                finally
                {
                    xmlDoc.Save(file);
                    Console.WriteLine("Done. File saved.\n");
                }              
            }
            Console.WriteLine("Run complete.");
        }

        /// <summary>
        /// Delete the navigation part "?ModelName/EntityName"
        /// </summary>
        /// <param name="hrefExpression"></param>
        /// <returns></returns>
        private string RemoveNavPath(string hrefExpression)
        {
            int qmPosition = hrefExpression.LastIndexOf('?');
            return hrefExpression.Remove(qmPosition);
        }

        /// <summary>
        /// Returns the xmi:id form the referenced file with the given navigation Path
        /// </summary>
        /// <param name="referencedFile"></param>
        /// <param name="navPath"></param>
        /// <returns></returns>
        private string ExtractIdFromReferencedFile(string referencedFile, string navPath)
        {
            navPath = GetXPathForNavPath(navPath);

            XmlDocument xmlDoc = new XmlDocument();
            xmlDoc.Load(referencedFile);
            InitNamespaceManager(xmlDoc.NameTable);

            XmlNodeList nodes = xmlDoc.SelectNodes(navPath, nsMgr);
            return nodes[0].Attributes.GetNamedItem("xmi:id").Value;
        }

        /// <summary>
        /// Creates the XPath expression for ModelName/EntityName
        /// </summary>
        /// <param name="navPath"></param>
        /// <returns></returns>
        private string GetXPathForNavPath(string navPath)
        {
            string[] navParts = navPath.Split('/');
            string result = "/uml:Model[@name=\"" + navParts[0] + "\"]";

            if (navParts.Length == 1)
                return result;

            for (int i = 1; i < navParts.Length; i++)
            {
                result += "/ownedMember[@name=\"" + navParts[i] + "\"]";
            }
            return result;
        }

        /// <summary>
        /// Form must be abc.emx#abcdef?abcd
        /// </summary>
        /// <param name="hrefExpression"></param>
        /// <returns></returns>
        private bool IsNavPath(String hrefExpression)
        {
            if (hrefExpression.IndexOf('?') != -1 &&
                hrefExpression.Contains(".emx#"))
            {
                return true;
            }
            else
            {
                return false;
            }
        }

        /// <summary>
        /// abc.emx#abcdef?123/456 --> 123/456
        /// + Converts URL spaces into real spaces: "%20" --> " "
        /// </summary>
        /// <param name="hrefExpression"></param>
        /// <returns></returns>
        private String GetNavPath(String hrefExpression)
        {
            String returnString = hrefExpression;

            int qmPosition = returnString.LastIndexOf('?') + 1; //1: without "?"
            if (qmPosition != -1)
            {
                returnString = returnString.Substring(qmPosition, returnString.Length - qmPosition); //1: without "
                returnString = System.Web.HttpUtility.UrlDecode(returnString);
                return returnString;
            }
            else
            {
                return null;
            }
        }

        /// <summary>
        /// Return File name of referenced File.
        /// + Converts URL spaces into real spaces: "%20" --> " "
        /// </summary>
        /// <param name="hrefExpression"></param>
        /// <returns></returns>
        private String GetReferencedFile(String hrefExpression)
        {
            String returnString = "";
        
            int hashPosition = hrefExpression.IndexOf('#');
            returnString = hrefExpression.Substring(0, hashPosition);

            returnString = System.Web.HttpUtility.UrlDecode(returnString);                
            return returnString;
        }

        /// <summary>
        /// Removes the "abc.emx#abcdef?123" part --> "abc.emx?123"
        /// </summary>
        /// <param name="hrefExpression"></param>
        /// <returns></returns>
        private String ReplaceHashedId(String hrefExpression, String newId)
        {
            String returnString = hrefExpression;

            int hashPosition = returnString.IndexOf('#');
            int qmPosition = returnString.IndexOf('?');

            string oldId = returnString.Substring(hashPosition + 1, qmPosition - hashPosition - 1);
            returnString = returnString.Replace(oldId, newId);
            return returnString;          
        }

        /// <summary>
        /// ".emx#" --> ".uml2#"
        /// </summary>
        /// <param name="hrefExpression"></param>
        /// <returns></returns>
        private String ReplaceEmxWithUml2(String hrefExpression)
        {
            return hrefExpression.Replace(".emx#", ".uml2#");
        }

    }
}
