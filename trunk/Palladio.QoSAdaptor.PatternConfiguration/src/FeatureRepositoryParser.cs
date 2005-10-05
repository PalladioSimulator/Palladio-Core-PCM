#region info
///////////////////////////////////////////////////////////////////////////////
// This software has been developed as a part of the diploma thesis 
// "Einfluss von Generatorkonfiguration auf die QoS-Vorhersage für 
// Komponentenadapter" ("Influence of the configuration of a generator on the 
// prediction of the QoS of component adaptors")
// at the 
// University of Oldenburg
// Department of Computing Science
// Software Engineering Group
// Palladio Research Group
// (http://se.informatik.uni-oldenburg.de/research/projects/Palladio)
// 
// Development period: July 2005 - January 2006
// 
// Author: Niels Streekmann
// E-mail: niels.streekmann@informatik.uni-oldenburg.de
///////////////////////////////////////////////////////////////////////////////
#endregion

using System;
using System.IO;
using System.Xml;
using System.Xml.XPath;
using Palladio.Utils.Collections;

namespace Palladio.QoSAdaptor.PatternConfiguration
{
	/// <summary>
	/// Parser for XML files which implement cfrepository1_0.dtd. These files
	/// contain XML representations of feature diagrams created by
	/// CaptainFeature.
	/// </summary>
	class FeatureRepositoryParser
	{
		#region data
		/// <summary>
		/// Holds the root node of the feature diagramm, which also is the 
		/// return value of the parse method.
		/// </summary>
		private Feature rootNode;

		/// <summary>
		/// Holds all features in the diagram. The hash key is the name of the
		/// feature / node.
		/// </summary>
		private Hashmap features;
		#endregion

		#region constructor
		public FeatureRepositoryParser()
		{
			this.features = new Hashmap();
		}
		#endregion

		#region public methods
		/// <summary>
		/// Parses the file given by its filename.
		/// </summary>
		/// <param name="file">Name of a file containg a CaptainFeature
		/// repository.</param>
		/// <returns>The root feature of the feature diagram.</returns>
		public Feature Parse(string file)
		{
			XmlDocument doc;
			XPathNavigator nav;
			try 
			{
				doc = new XmlDocument();
				doc.Load(file);
				nav = doc.CreateNavigator();
				XPathNodeIterator it;
				it = nav.Select("/CFRepository/ModelSpace/ModelLevel/FeatureSpace");
				it.MoveNext();
				
				// Get FeatureSpace attributes
				XPathNavigator pathNavigator = it.Clone().Current;
				pathNavigator.MoveToFirstAttribute();
				Console.WriteLine("FeatureSpace name = "+pathNavigator.Value);
				//if (pathNavigator.Value.Equals(TODO: PatternName))
					ParseFeatureSpace(it);
			}
			catch (XmlException e) 
			{
				Console.WriteLine(e);
			} 
			catch (IOException e) 
			{
				Console.WriteLine("File Was not Found!");
				Console.WriteLine(e);
			}

			// TODO: return the root node of the feature diagram. The name of 
			// this node has to correspond to the name of the design pattern in
			// the PatternDesciption.
			return null;
		}
		#endregion

		#region private methods
		/// <summary>
		/// Parses the feature space and creates Feature objects including 
		/// their connections for all features described in it. 
		/// </summary>
		/// <param name="it">A XPathNodeIterator pointing to the FeatureSpace
		/// node.</param>
		private void ParseFeatureSpace (XPathNodeIterator it)
		{
			XPathNodeIterator it2 = it.Current.SelectChildren
										("Feature",it.Current.NamespaceURI);
			while (it2.MoveNext())
			{
				ParseFeature(it2);
			}

			it2 = it.Current.SelectChildren("Diagram",it.Current.NamespaceURI);
			while (it2.MoveNext())
			{
				ParseDiagram(it2);
			}
		}

		/// <summary>
		/// Parses a feature node and creates a Feature object containing the
		/// same information.
		/// </summary>
		/// <param name="it">XPathNodeIterator representing a "feature node"
		/// of the FeatureSpace.</param>
		private void ParseFeature(XPathNodeIterator it)
		{
			// it2 has to be cloned, because else the other children can
			// not be handled after reading the attributes.
			XPathNavigator it3 = it.Clone().Current;

			// Parse attributes
			it3.MoveToFirstAttribute();
			Console.WriteLine("Attribute "+it3.Value);
			string name = it3.Value;
			it3.MoveToNextAttribute();
			string description = it3.Value;
			it3.MoveToNextAttribute(); // premature is not saved in the feature
			it3.MoveToNextAttribute();
			string guid = it3.Value;
			// the constraint id is also not saved in the feature.
			Feature feature = new Feature(name, description, guid);

			// Get type
			XPathNodeIterator it4 = it.Current.SelectChildren(
				"SpecializationParameter", it.Current.NamespaceURI);
			if (it4.MoveNext())
			{
				it4.Current.MoveToFirstAttribute();
				feature.Type = it4.Current.Value;
			}

			// DEBUG OUTPUT
			Console.WriteLine(feature.ToString()+"\n");

			this.features.Add(name, feature);
		}

		/// <summary>
		/// Parses the feature diagramm and builds the internal feature tree.
		/// </summary>
		/// <param name="it">XPathNodeIterator representing the "diagram node"
		/// of the FeatureSpace.</param>
		private void ParseDiagram(XPathNodeIterator it)
		{
			// Get the root node
			XPathNodeIterator it2 = it.Current.SelectChildren(
				"FeatureNode", it.Current.NamespaceURI);
			it2.MoveNext();
			XPathNavigator root = it2.Clone().Current;
			root.MoveToFirstAttribute(); // guid is not needed
			root.MoveToNextAttribute(); // name of the root feature
			this.rootNode = (Feature)this.features[root.Value];
			Console.WriteLine("ROOT = "+root.Value);

			// Recursively parse all cardinalities
			XPathNodeIterator it3 = it2.Current.SelectChildren("Cardinality",
				it2.Current.NamespaceURI);
			while (it3.MoveNext())
			{
				this.rootNode.AddChild(ParseCardinality(it3.Current,rootNode));
			}
		}

		/// <summary>
		/// Parses a cardinality node of a feature diagram description. Adds 
		/// all necessary information to the Feature object represented in the
		/// current cardinality node and calls itself recursively for the 
		/// cardinality nodes that are children of the corresponding
		/// FeatureNode.
		/// </summary>
		/// <param name="it">XPathNavigator representing the current 
		/// Cardinality node.</param>
		/// <param name="parent">Feature representing the parent node of the 
		/// current Cardinality node.</param>
		/// <returns>Feature representing the current Cardinality node.
		/// </returns>
		private Feature ParseCardinality (XPathNavigator it, Feature parent)
		{
			Feature thisNode = null;
			return thisNode;
		}
		#endregion
	}
}
