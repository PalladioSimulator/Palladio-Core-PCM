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
using System.Windows.Forms;
using log4net.Config;

using Palladio.Editor.Core.Interfaces;


namespace Palladio.Editor.Core
{
	/// <summary>
	/// Class containing the entry point for the application.
	/// </summary>
	/// <remarks>When the application is started, this class creates the
	/// PAC agent structure and starts the initializing process for all agents.
	/// It further configures the logger facility log4net.</remarks>
	internal class AppMain
	{

		/// <summary>
		/// The applications entry point
		/// </summary>
		[STAThread]
		static void Main() 
		{
			AppDomain.CurrentDomain.AppendPrivatePath("Assemblies");

			//splash

			Starter.Instance.Run();
		}

		private class Starter
		{
			/// <summary>
			/// Constructor for the inner private class Starter. It configures 
			/// the logger facility and starts the initializing process of the
			/// PAC agent structure.
			/// </summary>
			private Starter()
			{
				// configure log4net
				DOMConfigurator.Configure(new System.IO.FileInfo("log4net.config.xml"));

				// create PAC agent structure
				IRootAgent root = Agents.AgentFactory.CreateRootAgent();

				// start initalize process
				root.Initialize();
			}

			// Singleton instance
			private static Starter _instance;
			public static Starter Instance
			{
				get 
				{
					if (Starter._instance == null)
						Starter._instance = new Starter();
					return Starter._instance;
				}
			}

			/// <summary>
			/// Starts the event handling
			/// </summary>
			public void Run()
			{
				Application.Run();
			}
		}
	}
}
