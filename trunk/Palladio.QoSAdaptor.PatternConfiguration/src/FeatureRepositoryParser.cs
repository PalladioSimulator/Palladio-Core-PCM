#region info
///////////////////////////////////////////////////////////////////////////////
/// This software has been developed as a part of the diploma thesis 
/// "Einfluss von Generatorkonfiguration auf die QoS-Vorhersage für 
/// Komponentenadapter" ("Influence of the configuration of a generator on the 
/// prediction of the QoS of component adaptors")
/// at the 
/// University of Oldenburg
/// Department of Computing Science
/// Software Engineering Group
/// Palladio Research Group
/// (http://se.informatik.uni-oldenburg.de/research/projects/Palladio)
/// 
/// Development period: July 2005 - January 2006
/// 
/// Author: Niels Streekmann
/// E-mail: niels.streekmann@informatik.uni-oldenburg.de
///////////////////////////////////////////////////////////////////////////////
#endregion
using System;
using System.IO;
using System.Xml;
using System.Xml.XPath;

namespace Palladio.QoSAdaptor.PatternConfiguration
{
	/// <summary>
	/// Parser for XML files which implement cfrepository1_0.dtd. These files
	/// contain XML representations of feature diagrams created by
	/// CaptainFeature.
	/// </summary>
	class FeatureRepositoryParser
	{
		/// <summary>
		/// Standard constructor
		/// </summary>
		public FeatureRepositoryParser()
		{
			
		}

		/// <summary>
		/// Parses the file given by its filename.
		/// </summary>
		/// <param name="file">Name of a file containg a CaptainFeature
		/// repository.</param>
		public void Parse(string file)
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
				if (it.Current == null) Console.WriteLine("it.Current == null");
				else Console.WriteLine("TEST: "+it.Current.Name);
				XPathNodeIterator it2;
				it2=it.Current.SelectChildren("Feature",it.Current.NamespaceURI);
				it2.MoveNext();
				if (it2.Current == null) Console.WriteLine("it2.Current == null");
				else Console.WriteLine("TEST2: "+it2.Current.Name);
				it2.Current.MoveToFirstAttribute();
				Console.WriteLine("HALLO "+it2.Current.Value);

				
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
		}
	}
}
