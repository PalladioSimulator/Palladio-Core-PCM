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
	[Serializable]
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
				PluginInfo newPluginInfo;

				if(type.IsSubclassOf(typeof(Palladio.Editor.Common.ViewPluginSkeleton)))
				{
					object[] attributes = type.GetCustomAttributes(typeof(PluginInfoAttribute), false);

					if (attributes != null && attributes.Length > 0)
						newPluginInfo = CreatePluginInfo(type, PluginType.VIEW, (PluginInfoAttribute)attributes[0], fileName);
					else
						newPluginInfo = CreatePluginInfo(type, PluginType.VIEW, null, fileName);
					infoList.Add(newPluginInfo);
				}
				else if(type.IsSubclassOf(typeof(Palladio.Editor.Common.AnalyzePluginSkeleton)))
				{
					object[] attributes = type.GetCustomAttributes(typeof(PluginInfoAttribute), false);

					if (attributes != null && attributes.Length > 0)
						newPluginInfo = CreatePluginInfo(type, PluginType.ANALYZE, (PluginInfoAttribute)attributes[0], fileName);
					else
						newPluginInfo = CreatePluginInfo(type, PluginType.ANALYZE, null, fileName);
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

			if(type.IsSubclassOf(typeof(Palladio.Editor.Common.ViewPluginSkeleton)))
			{
				fullInfo.PluginType = PluginType.VIEW;
			}
			else if(type.IsSubclassOf(typeof(Palladio.Editor.Common.AnalyzePluginSkeleton)))
			{
				fullInfo.PluginType = PluginType.ANALYZE;
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

		/// <summary>
		/// 
		/// </summary>
		/// <param name="sType"></param>
		/// <param name="pType"></param>
		/// <param name="attr"></param>
		/// <param name="filename"></param>
		/// <returns></returns>
		private PluginInfo CreatePluginInfo(System.Type sType, PluginType pType, PluginInfoAttribute attr, string filename)
		{
			if (attr != null)
				return new PluginInfo(	
					sType,
					pType,
					attr.Name,
					attr.Description,
					attr.Author,
					attr.Version,
					filename,
					PluginStatus.INACTIVE );
			else
				return new PluginInfo(
					sType,
					pType,
					"Unspecified",
					"Unspecified",
					"Unspecified",
					"Unspecified",
					filename,
					PluginStatus.INACTIVE );
		}
	}
}
