#region Universität Oldenburg
//////////////////////////////////////////////////////////////////////////
//	Universität Oldenburg
//	Department für Informatik, Software Engineering
//	-----------------------------------------------------------------
//	Master-Arbeit "Entwicklung eines Editors für die modellgetriebene
//	Konstruktion komponentenbasierter Software-Architekturen"
//	Autor: Matthias Uflacker, 2004
//	eMail: matthias.uflacker@informatik.uni-oldenburg.de
//////////////////////////////////////////////////////////////////////////
#endregion

using System;
using System.Reflection;
using System.Collections;
using log4net;

using Palladio.Editor.Common;

namespace Palladio.Editor.Core
{
	/// <summary>
	/// Zusammenfassung für RemoteLoader.
	/// </summary>
	public class RemoteLoader : MarshalByRefObject
	{
		/// <summary>
		/// </summary>
		private static readonly ILog log = LogManager.GetLogger(typeof(RemoteLoader));

		/// <summary>
		/// 
		/// </summary>
		public RemoteLoader()
		{
		}

		/// <summary>
		/// 
		/// </summary>
		/// <param name="fileName"></param>
		/// <returns></returns>
		public PluginInfo[] GetPluginInfosFromAssembly(string fileName)
		{
			ArrayList infoList = new ArrayList();

			AssemblyName assName = AssemblyName.GetAssemblyName(fileName);
			Assembly assembly = AppDomain.CurrentDomain.Load(assName);

			System.Type[] types = assembly.GetTypes();

			foreach(System.Type type in types)
			{
				if(type.GetInterface("IViewPlugin")!=null)
				{
					Console.WriteLine("Found ViewPlugin "+type.Name);
					PluginInfo newPluginInfo;

					object[] attributes;

					attributes = type.GetCustomAttributes(typeof(PluginInfoAttribute), false);
					if (attributes.Length > 0)
					{
						PluginInfoAttribute attr = (PluginInfoAttribute)attributes[0];
						newPluginInfo = new PluginInfo(	type,
							PluginType.VIEW,
							attr.Name,
							attr.Description,
							attr.Author,
							attr.Version,
							fileName,
							PluginStatus.INACTIVE);
					} 
					else
					{
						newPluginInfo = new PluginInfo(	type,
							PluginType.VIEW,
							"Unspecified",
							"Unspecified",
							"Unspecified",
							"Unspecified",
							fileName,
							PluginStatus.INACTIVE);
					}
					infoList.Add(newPluginInfo);
				} 
			}
			PluginInfo[] returnArray = new PluginInfo[infoList.Count];
			returnArray = (PluginInfo[])infoList.ToArray(typeof(PluginInfo));
			return returnArray;
		}

		/// <summary>
		/// 
		/// </summary>
		/// <param name="shortInfo"></param>
		/// <returns></returns>
		public PluginInfo CompletePluginInfo(PluginInfo shortInfo)
		{
			PluginInfo fullInfo = new PluginInfo(shortInfo);
			
			AssemblyName assName = AssemblyName.GetAssemblyName(fullInfo.Assembly);
			Assembly assembly = AppDomain.CurrentDomain.Load(assName);

			System.Type type = assembly.GetType(fullInfo.TypeName);
			object[] attributes;
			attributes = type.GetCustomAttributes(typeof(PluginInfoAttribute), false);
			if (attributes.Length > 0)
			{
				PluginInfoAttribute attr = (PluginInfoAttribute)attributes[0];
				fullInfo.Name = attr.Name;
				fullInfo.Description = attr.Description;
				fullInfo.Author = attr.Author;
				fullInfo.Version = attr.Version;
			}

			if(type.GetInterface("IViewPlugin")!=null)
			{
				fullInfo.PluginType = PluginType.VIEW;
			}
			return fullInfo;
		}

		/// <summary>
		/// 
		/// </summary>
		/// <param name="pluginInfo"></param>
		/// <returns></returns>
		public IPlugin InstantiatePlugin(PluginInfo pluginInfo)
		{
			AssemblyName assName = AssemblyName.GetAssemblyName(pluginInfo.Assembly);
			Assembly assembly = AppDomain.CurrentDomain.Load(assName);

			System.Type type = assembly.GetType(pluginInfo.TypeName);

			IViewPlugin instance = Activator.CreateInstance(type, new object[]{pluginInfo.Name,pluginInfo.Description,pluginInfo.Author,pluginInfo.Version}) as IViewPlugin;

			return instance;
		}
	}
}
