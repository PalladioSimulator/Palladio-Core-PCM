using System;
using System.Collections;
using Palladio.ComponentModel;
using Palladio.Reliability.WebserverComponentModel;

namespace Palladio.Reliability.WebserverAnalyser
{
	/// <summary>
	/// Maps fully qualified class names onto components.
	/// </summary>
	public class Class2Component : WebserverModelHelper
	{
		private static Hashtable class2ComponentHash = CreateClass2ComponentHash();

		/// <summary>
		/// Returns the basic component associated with the className.
		/// </summary>
		/// <param name="className"></param>
		/// <returns></returns>
		public static IBasicComponent GetBasicComponent(string className)
		{
			return (IBasicComponent) class2ComponentHash[className];
		}

		/// <summary>
		/// Returns all class names of the mapping.
		/// </summary>
		/// <returns></returns>
		public static string[] GetClassNames()
		{
			string[] classNames = new string[class2ComponentHash.Count];
			class2ComponentHash.Keys.CopyTo(classNames,0);
			return classNames;
		}

		/// <summary>
		/// Returns the service effect specification of the
		/// component associated with classname for the
		/// service specified by the interfaceName and methodName.
		/// </summary>
		/// <param name="className"></param>
		/// <param name="interfaceName"></param>
		/// <param name="methodName"></param>
		/// <returns></returns>
		public static IServiceEffectSpecification GetServiceEffect(string className, string interfaceName, string methodName)
		{
			IBasicComponent comp = (IBasicComponent) class2ComponentHash[className];
			if (comp == null)
				throw new ApplicationException("Class '" + className + "' is not associated to a component!");
			return FindServiceEffectSpecification(comp, interfaceName, methodName);
		}

		private static Hashtable CreateClass2ComponentHash()
		{
			Hashtable class2ComponentHash = new Hashtable();

			// Associate each ClassName with a component
			class2ComponentHash["Palladio.Webserver.DynamicFileProvider.DynamicFileProvider"]
				= WebserverComponentFactory.CreateDynamicFileProvider();
			class2ComponentHash["Palladio.Webserver.ConfigReader.XMLConfigReader"]
				= WebserverComponentFactory.CreateConfigReader();
			class2ComponentHash["Palladio.Webserver.HTTPRequestProcessor.DefaultHTTPRequestProcessorTools"]
				= WebserverComponentFactory.CreateDefaultHTTPRequestProcessor();
			class2ComponentHash["Palladio.Webserver.StaticFileProvider.StaticFileProvider"]
				= WebserverComponentFactory.CreateStaticFileProvider();
			class2ComponentHash["Palladio.Webserver.WebserverMonitor.DefaultWebserverMonitor"]
				= WebserverComponentFactory.CreateWebserverMonitor();
			class2ComponentHash["Palladio.Webserver.RequestParser.DefaultRequestParser"]
				= WebserverComponentFactory.CreateDefaultRequestParser();
			class2ComponentHash["Palladio.Webserver.HTTPRequestParser.HTTPRequestParser"]
				= WebserverComponentFactory.CreateHTTPRequestParser();
			class2ComponentHash["Palladio.Webserver.BibTeXProvider.BibTexDB"]
				= WebserverComponentFactory.CreateBibTexDB();
			class2ComponentHash["Palladio.Webserver.ConfigReader.WebserverConfiguration"]
				= WebserverComponentFactory.CreateConfigReader();
			class2ComponentHash["Palladio.Webserver.Dispatcher.DefaultDispatcher"]
				= WebserverComponentFactory.CreateDefaultDispatcher();
			class2ComponentHash["Palladio.Webserver.Dispatcher.PortListener"]
				= WebserverComponentFactory.CreateDefaultDispatcher();
			class2ComponentHash["Palladio.Webserver.SimpleTemplateFileProvider.SimpleTemplateFileProvider"]
				= WebserverComponentFactory.CreateTemplateFileProvider();
			class2ComponentHash["Palladio.Webserver.BibTeXProvider.BibTeXProvider"]
				= WebserverComponentFactory.CreateBibTexProvider();
			return class2ComponentHash;
		}
	}
}