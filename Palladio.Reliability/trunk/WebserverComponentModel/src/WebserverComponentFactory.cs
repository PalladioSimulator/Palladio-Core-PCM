using System.Collections;
using Palladio.ComponentModel;

namespace Palladio.Reliability.WebserverComponentModel
{
	/// <summary>
	/// Zusammenfassung für WebserverComponentFactory.
	/// </summary>
	public class WebserverComponentFactory
	{
		#region BasicComponents

		#region DefaultDispatcher

		public static IBasicComponent CreateDefaultDispatcher()
		{
			string compName = "DefaultDispatcher";
			if (!componentHash.Contains(compName))
			{
				IBasicComponent comp = ComponentFactory.CreateBasicComponent(compName);

				comp.AddProvidesInterface(WebserverInterfaceFactory.CreateIDispatcher());
				comp.AddProvidesInterface(WebserverInterfaceFactory.CreateIPortListener());

				comp.AddRequiresInterface(WebserverInterfaceFactory.CreateIRequestParser());
				comp.AddRequiresInterface(WebserverInterfaceFactory.CreateIWebserverMonitor());
				comp.AddRequiresInterface(WebserverInterfaceFactory.CreateIWebserverConfiguration());

				comp.AddServiceEffectSpecification(
					WebserverSeffFactory.CreateService_DefaultDispatcher_Start(),
					WebserverSeffFactory.CreateSeff_DefaultDispatcher_Start()
					);

				comp.AddServiceEffectSpecification(
					WebserverSeffFactory.CreateService_DefaultDispatcher_Stop(),
					WebserverSeffFactory.CreateSeff_DefaultDispatcher_Stop()
					);

				comp.AddServiceEffectSpecification(
					WebserverSeffFactory.CreateService_DefaultDispatcher_StartListen(),
					WebserverSeffFactory.CreateSeff_DefaultDispatcher_StartListen()
					);

				componentHash[compName] = comp;
			}
			return (IBasicComponent) componentHash[compName];
		}

		#endregion

		#region HTTPRequestParser

		public static IBasicComponent CreateHTTPRequestParser()
		{
			string compName = "HTTPRequestParser";
			if (!componentHash.Contains(compName))
			{
				IBasicComponent comp = ComponentFactory.CreateBasicComponent(compName);

				comp.AddProvidesInterface(WebserverInterfaceFactory.CreateIRequestParser());

				comp.AddRequiresInterface(WebserverInterfaceFactory.CreateIRequestParser());
				comp.AddRequiresInterface(WebserverInterfaceFactory.CreateIWebserverMonitor());
				comp.AddRequiresInterface(WebserverInterfaceFactory.CreateIHTTPRequestProcessor());

				comp.AddServiceEffectSpecification(
					WebserverSeffFactory.CreateService_HTTPRequestParser_HandleRequest(),
					WebserverSeffFactory.CreateSeff_HTTPRequestParser_HandleRequest()
					);

				componentHash[compName] = comp;
			}
			return (IBasicComponent) componentHash[compName];
		}

		#endregion

		#region DefaultRequestParser

		public static IBasicComponent CreateDefaultRequestParser()
		{
			string compName = "DefaultRequestParser";
			if (!componentHash.Contains(compName))
			{
				IBasicComponent comp = ComponentFactory.CreateBasicComponent(compName);

				comp.AddProvidesInterface(WebserverInterfaceFactory.CreateIRequestParser());
				comp.AddRequiresInterface(WebserverInterfaceFactory.CreateIWebserverMonitor());

				comp.AddServiceEffectSpecification(
					WebserverSeffFactory.CreateService_DefaultRequestParser_HandleRequest(),
					WebserverSeffFactory.CreateSeff_DefaultRequestParser_HandleRequest()
					);

				componentHash[compName] = comp;
			}
			return (IBasicComponent) componentHash[compName];
		}

		#endregion

		#region DynamicFileProvider

		public static IBasicComponent CreateDynamicFileProvider()
		{
			string compName = "DynamicFileProvider";
			if (!componentHash.Contains(compName))
			{
				IBasicComponent comp = ComponentFactory.CreateBasicComponent(compName);

				comp.AddProvidesInterface(WebserverInterfaceFactory.CreateIHTTPRequestProcessor());

				comp.AddRequiresInterface(WebserverInterfaceFactory.CreateIHTTPRequestProcessor());
				comp.AddRequiresInterface(WebserverInterfaceFactory.CreateIHTTPRequestProcessorTools());
				comp.AddRequiresInterface(WebserverInterfaceFactory.CreateIWebserverConfiguration());
				comp.AddRequiresInterface(WebserverInterfaceFactory.CreateIWebserverMonitor());

				comp.AddServiceEffectSpecification(
					WebserverSeffFactory.CreateService_DynamicFileProvider_HandleRequest(),
					WebserverSeffFactory.CreateSeff_DynamicFileProvider_HandleRequest()
					);

				componentHash[compName] = comp;
			}
			return (IBasicComponent) componentHash[compName];
		}

		#endregion

		#region TemplateFileProvider

		public static IBasicComponent CreateTemplateFileProvider()
		{
			string compName = "TemplateFileProvider";
			if (!componentHash.Contains(compName))
			{
				IBasicComponent comp = ComponentFactory.CreateBasicComponent(compName);

				comp.AddProvidesInterface(WebserverInterfaceFactory.CreateIHTTPRequestProcessor());

				comp.AddRequiresInterface(WebserverInterfaceFactory.CreateIHTTPRequestProcessor());
				comp.AddRequiresInterface(WebserverInterfaceFactory.CreateIHTTPRequestProcessorTools());
				comp.AddRequiresInterface(WebserverInterfaceFactory.CreateIWebserverConfiguration());
				comp.AddRequiresInterface(WebserverInterfaceFactory.CreateIWebserverMonitor());

				comp.AddServiceEffectSpecification(
					WebserverSeffFactory.CreateService_TemplateFileProvider_HandleRequest(),
					WebserverSeffFactory.CreateSeff_TemplateFileProvider_HandleRequest()
					);

				componentHash[compName] = comp;
			}
			return (IBasicComponent) componentHash[compName];
		}

		#endregion

		#region BibTexProvider

		public static IBasicComponent CreateBibTexProvider()
		{
			string compName = "BibTexProvider";
			if (!componentHash.Contains(compName))
			{
				IBasicComponent comp = ComponentFactory.CreateBasicComponent(compName);

				comp.AddProvidesInterface(WebserverInterfaceFactory.CreateIHTTPRequestProcessor());

				comp.AddRequiresInterface(WebserverInterfaceFactory.CreateIHTTPRequestProcessor());
				comp.AddRequiresInterface(WebserverInterfaceFactory.CreateIBibTexDB());
				comp.AddRequiresInterface(WebserverInterfaceFactory.CreateIHTTPRequestProcessorTools());
				comp.AddRequiresInterface(WebserverInterfaceFactory.CreateIWebserverConfiguration());
				comp.AddRequiresInterface(WebserverInterfaceFactory.CreateIWebserverMonitor());

				comp.AddServiceEffectSpecification(
					WebserverSeffFactory.CreateService_BibTexProvider_HandleRequest(),
					WebserverSeffFactory.CreateSeff_BibTexProvider_HandleRequest()
					);

				componentHash[compName] = comp;
			}
			return (IBasicComponent) componentHash[compName];
		}

		public static IBasicComponent CreateBibTexDB()
		{
			string compName = "BibTexDB";
			if (!componentHash.Contains(compName))
			{
				IBasicComponent comp = ComponentFactory.CreateBasicComponent(compName);
				comp.AddProvidesInterface(WebserverInterfaceFactory.CreateIBibTexDB());
				componentHash[compName] = comp;
			}
			return (IBasicComponent) componentHash[compName];
		}

		#endregion

		#region StaticFileProvider

		public static IBasicComponent CreateStaticFileProvider()
		{
			string compName = "StaticFileProvider";
			if (!componentHash.Contains(compName))
			{
				IBasicComponent comp = ComponentFactory.CreateBasicComponent(compName);

				comp.AddProvidesInterface(WebserverInterfaceFactory.CreateIHTTPRequestProcessor());

				comp.AddRequiresInterface(WebserverInterfaceFactory.CreateIHTTPRequestProcessorTools());
				comp.AddRequiresInterface(WebserverInterfaceFactory.CreateIWebserverConfiguration());
				comp.AddRequiresInterface(WebserverInterfaceFactory.CreateIWebserverMonitor());

				comp.AddServiceEffectSpecification(
					WebserverSeffFactory.CreateService_StaticFileProvider_HandleRequest(),
					WebserverSeffFactory.CreateSeff_StaticFileProvider_HandleRequest()
					);

				componentHash[compName] = comp;
			}
			return (IBasicComponent) componentHash[compName];
		}

		#endregion

		#region DefaultHTTPRequestProcessor

		public static IBasicComponent CreateDefaultHTTPRequestProcessor()
		{
			string compName = "DefaultHTTPRequestProcessor";
			if (!componentHash.Contains(compName))
			{
				IBasicComponent comp = ComponentFactory.CreateBasicComponent(compName);

				comp.AddProvidesInterface(WebserverInterfaceFactory.CreateIHTTPRequestProcessor());
				comp.AddProvidesInterface(WebserverInterfaceFactory.CreateIHTTPRequestProcessorTools());

				comp.AddRequiresInterface(WebserverInterfaceFactory.CreateIWebserverConfiguration());
				comp.AddRequiresInterface(WebserverInterfaceFactory.CreateIWebserverMonitor());

				comp.AddServiceEffectSpecification(
					WebserverSeffFactory.CreateService_DefaultHTTPRequestProcessor_BuildCompletePath(),
					WebserverSeffFactory.CreateSeff_DefaultHTTPRequestProcessor_BuildCompletePath()
					);

				comp.AddServiceEffectSpecification(
					WebserverSeffFactory.CreateService_DefaultHTTPRequestProcessor_SendContentDataToClient(),
					WebserverSeffFactory.CreateSeff_DefaultHTTPRequestProcessor_SendContentDataToClient()
					);

				comp.AddServiceEffectSpecification(
					WebserverSeffFactory.CreateService_DefaultHTTPRequestProcessor_SendContentToClient(),
					WebserverSeffFactory.CreateSeff_DefaultHTTPRequestProcessor_SendContentToClient()
					);

				comp.AddServiceEffectSpecification(
					WebserverSeffFactory.CreateService_DefaultHTTPRequestProcessor_SendHTTPError(),
					WebserverSeffFactory.CreateSeff_DefaultHTTPRequestProcessor_SendHTTPError()
					);

				comp.AddServiceEffectSpecification(
					WebserverSeffFactory.CreateService_DefaultHTTPRequestProcessor_SendHTTPHeader(),
					WebserverSeffFactory.CreateSeff_DefaultHTTPRequestProcessor_SendHTTPHeader()
					);

				comp.AddServiceEffectSpecification(
					WebserverSeffFactory.CreateService_DefaultHTTPRequestProcessor_GetFileMimeTypeFor(),
					WebserverSeffFactory.CreateSeff_DefaultHTTPRequestProcessor_GetFileMimeTypeFor()
					);
				componentHash[compName] = comp;
			}
			return (IBasicComponent) componentHash[compName];
		}

		#endregion

		#region WebserverMonitor

		public static IBasicComponent CreateWebserverMonitor()
		{
			string compName = "WebserverMonitor";
			if (!componentHash.Contains(compName))
			{
				IBasicComponent comp = ComponentFactory.CreateBasicComponent(compName);

				comp.AddProvidesInterface(WebserverInterfaceFactory.CreateIWebserverMonitor());
				comp.AddRequiresInterface(WebserverInterfaceFactory.CreateIWebserverConfiguration());

				comp.AddServiceEffectSpecification(
					WebserverSeffFactory.CreateService_WebserverMonitor_InitializeWriteAccess(),
					WebserverSeffFactory.CreateSeff_WebserverMonitor_InitializeWriteAccess()
					);

				componentHash[compName] = comp;
			}
			return (IBasicComponent) componentHash[compName];
		}

		#endregion

		#region ConfigReader

		public static IBasicComponent CreateConfigReader()
		{
			string compName = "ConfigReader";
			if (!componentHash.Contains(compName))
			{
				IBasicComponent comp = ComponentFactory.CreateBasicComponent(compName);

				comp.AddProvidesInterface(WebserverInterfaceFactory.CreateIConfigReader());
				comp.AddProvidesInterface(WebserverInterfaceFactory.CreateIConfiguration());
				comp.AddProvidesInterface(WebserverInterfaceFactory.CreateIWebserverConfiguration());

				componentHash[compName] = comp;
			}
			return (IBasicComponent) componentHash[compName];
		}

		#endregion

		#endregion

		#region CompositeComponents

		#region RequestParser

		public static ICompositeComponent CreateRequestParser()
		{
			string compName = "RequestParser";
			if (!componentHash.Contains(compName))
			{
				ICompositeComponent comp = ComponentFactory.CreateCompositeComponent(compName);

				IComponent httpRequestParser = CreateHTTPRequestParser();
				IComponent defaultRequestParser = CreateDefaultRequestParser();
				comp.AddComponents(httpRequestParser, defaultRequestParser);

				IInterfaceModel requestParser = WebserverInterfaceFactory.CreateIRequestParser();
				IInterfaceModel webserverConfiguration = WebserverInterfaceFactory.CreateIWebserverConfiguration();
				IInterfaceModel webserverMonitor = WebserverInterfaceFactory.CreateIWebserverMonitor();
				IInterfaceModel httpRequestProcessor = WebserverInterfaceFactory.CreateIHTTPRequestProcessor();

				comp.AddProvidesInterface(requestParser);
				comp.AddRequiresInterface(webserverConfiguration);
				comp.AddRequiresInterface(webserverMonitor);
				comp.AddRequiresInterface(httpRequestProcessor);

				comp.AddProvidesMappings(
					ComponentFactory.CreateProvidesMapping(
						comp, comp.GetProvidesRoleByInterfaceID(requestParser.ID).ID,
						httpRequestParser, httpRequestParser.GetProvidesRoleByInterfaceID(requestParser.ID).ID
						)
					);


				comp.AddRequiresMappings(
					// external requirements of HTTPRequestParser
					ComponentFactory.CreateRequiresMapping(
						httpRequestParser, httpRequestParser.GetRequiresRoleByInterfaceID(httpRequestProcessor.ID).ID,
						comp, comp.GetRequiresRoleByInterfaceID(httpRequestProcessor.ID).ID
						),
					ComponentFactory.CreateRequiresMapping(
						httpRequestParser, httpRequestParser.GetRequiresRoleByInterfaceID(webserverMonitor.ID).ID,
						comp, comp.GetRequiresRoleByInterfaceID(webserverMonitor.ID).ID
						),
					// external requirements of DefaultRequestParser
					ComponentFactory.CreateRequiresMapping(
						defaultRequestParser, defaultRequestParser.GetRequiresRoleByInterfaceID(webserverMonitor.ID).ID,
						comp, comp.GetRequiresRoleByInterfaceID(webserverMonitor.ID).ID
						)
					);

				// HTTPRequestParser -> DefaultRequestParser
				comp.AddBindings(
					ComponentFactory.CreateBinding(
						httpRequestParser, httpRequestParser.GetRequiresRoleByInterfaceID(requestParser.ID).ID,
						defaultRequestParser, defaultRequestParser.GetProvidesRoleByInterfaceID(requestParser.ID).ID
						)
					);

				componentHash[compName] = comp;
			}
			return (ICompositeComponent) componentHash[compName];
		}

		#endregion

		#region HTTPRequestProcessor

		public static ICompositeComponent CreateHTTPRequestProcessor()
		{
			string compName = "HTTPRequestProcessor";
			if (!componentHash.Contains(compName))
			{
				ICompositeComponent comp = ComponentFactory.CreateCompositeComponent(compName);

				IComponent dynamicFileProvider = CreateDynamicFileProvider();
				IComponent templateFileProvider = CreateTemplateFileProvider();
				IComponent bibTexProvider = CreateBibTexProvider();
				IComponent staticFileProvider = CreateStaticFileProvider();
				IComponent defaultHTTPRequestProcessor = CreateDefaultHTTPRequestProcessor();
				comp.AddComponents(dynamicFileProvider, templateFileProvider, bibTexProvider, staticFileProvider, defaultHTTPRequestProcessor);

				IInterfaceModel httpRequestProcessor = WebserverInterfaceFactory.CreateIHTTPRequestProcessor();
				IInterfaceModel webserverConfiguration = WebserverInterfaceFactory.CreateIWebserverConfiguration();
				IInterfaceModel webserverMonitor = WebserverInterfaceFactory.CreateIWebserverMonitor();
				IInterfaceModel bibTexDB = WebserverInterfaceFactory.CreateIBibTexDB();
				IInterfaceModel httpRequestProcessorTools = WebserverInterfaceFactory.CreateIHTTPRequestProcessorTools();

				comp.AddProvidesInterface(httpRequestProcessor);
				comp.AddRequiresInterface(webserverConfiguration);
				comp.AddRequiresInterface(webserverMonitor);
				comp.AddRequiresInterface(bibTexDB);

				comp.AddProvidesMappings(
					ComponentFactory.CreateProvidesMapping(
						comp, comp.GetProvidesRoleByInterfaceID(httpRequestProcessor.ID).ID,
						dynamicFileProvider, dynamicFileProvider.GetProvidesRoleByInterfaceID(httpRequestProcessor.ID).ID
						)
					);

				comp.AddRequiresMappings(
					// external requirements of DynamicFileProvider
					ComponentFactory.CreateRequiresMapping(
						dynamicFileProvider, dynamicFileProvider.GetRequiresRoleByInterfaceID(webserverConfiguration.ID).ID,
						comp, comp.GetRequiresRoleByInterfaceID(webserverConfiguration.ID).ID
						),
					ComponentFactory.CreateRequiresMapping(
						dynamicFileProvider, dynamicFileProvider.GetRequiresRoleByInterfaceID(webserverMonitor.ID).ID,
						comp, comp.GetRequiresRoleByInterfaceID(webserverMonitor.ID).ID
						),
					// external requirements of TemplateileProvider
					ComponentFactory.CreateRequiresMapping(
						templateFileProvider, templateFileProvider.GetRequiresRoleByInterfaceID(webserverConfiguration.ID).ID,
						comp, comp.GetRequiresRoleByInterfaceID(webserverConfiguration.ID).ID
						),
					ComponentFactory.CreateRequiresMapping(
						templateFileProvider, templateFileProvider.GetRequiresRoleByInterfaceID(webserverMonitor.ID).ID,
						comp, comp.GetRequiresRoleByInterfaceID(webserverMonitor.ID).ID
						),
					// external requirements of BibTexProvider
					ComponentFactory.CreateRequiresMapping(
						bibTexProvider, bibTexProvider.GetRequiresRoleByInterfaceID(webserverConfiguration.ID).ID,
						comp, comp.GetRequiresRoleByInterfaceID(webserverConfiguration.ID).ID
						),
					ComponentFactory.CreateRequiresMapping(
						bibTexProvider, bibTexProvider.GetRequiresRoleByInterfaceID(webserverMonitor.ID).ID,
						comp, comp.GetRequiresRoleByInterfaceID(webserverMonitor.ID).ID
						),
					ComponentFactory.CreateRequiresMapping(
						bibTexProvider, bibTexProvider.GetRequiresRoleByInterfaceID(bibTexDB.ID).ID,
						comp, comp.GetRequiresRoleByInterfaceID(bibTexDB.ID).ID
						),
					// external requirements of StaticFileProvider
					ComponentFactory.CreateRequiresMapping(
						staticFileProvider, staticFileProvider.GetRequiresRoleByInterfaceID(webserverConfiguration.ID).ID,
						comp, comp.GetRequiresRoleByInterfaceID(webserverConfiguration.ID).ID
						),
					ComponentFactory.CreateRequiresMapping(
						staticFileProvider, staticFileProvider.GetRequiresRoleByInterfaceID(webserverMonitor.ID).ID,
						comp, comp.GetRequiresRoleByInterfaceID(webserverMonitor.ID).ID
						),
					// external requirements of DefaultHttpRequestProcessor
					ComponentFactory.CreateRequiresMapping(
						defaultHTTPRequestProcessor, defaultHTTPRequestProcessor.GetRequiresRoleByInterfaceID(webserverConfiguration.ID).ID,
						comp, comp.GetRequiresRoleByInterfaceID(webserverConfiguration.ID).ID
						),
					ComponentFactory.CreateRequiresMapping(
						defaultHTTPRequestProcessor, defaultHTTPRequestProcessor.GetRequiresRoleByInterfaceID(webserverMonitor.ID).ID,
						comp, comp.GetRequiresRoleByInterfaceID(webserverMonitor.ID).ID
						)
					);

				comp.AddBindings(
					// CoR
					ComponentFactory.CreateBinding(
						dynamicFileProvider, dynamicFileProvider.GetRequiresRoleByInterfaceID(httpRequestProcessor.ID).ID,
						templateFileProvider, templateFileProvider.GetProvidesRoleByInterfaceID(httpRequestProcessor.ID).ID
						),
					ComponentFactory.CreateBinding(
						templateFileProvider, templateFileProvider.GetRequiresRoleByInterfaceID(httpRequestProcessor.ID).ID,
						bibTexProvider, bibTexProvider.GetProvidesRoleByInterfaceID(httpRequestProcessor.ID).ID
						),
					ComponentFactory.CreateBinding(
						bibTexProvider, bibTexProvider.GetRequiresRoleByInterfaceID(httpRequestProcessor.ID).ID,
						staticFileProvider, staticFileProvider.GetProvidesRoleByInterfaceID(httpRequestProcessor.ID).ID
						),
					// HTTPRequestProcessorTools
					ComponentFactory.CreateBinding(
						dynamicFileProvider, dynamicFileProvider.GetRequiresRoleByInterfaceID(httpRequestProcessorTools.ID).ID,
						defaultHTTPRequestProcessor, defaultHTTPRequestProcessor.GetProvidesRoleByInterfaceID(httpRequestProcessorTools.ID).ID
						),
					ComponentFactory.CreateBinding(
						templateFileProvider, templateFileProvider.GetRequiresRoleByInterfaceID(httpRequestProcessorTools.ID).ID,
						defaultHTTPRequestProcessor, defaultHTTPRequestProcessor.GetProvidesRoleByInterfaceID(httpRequestProcessorTools.ID).ID
						),
					ComponentFactory.CreateBinding(
						bibTexProvider, bibTexProvider.GetRequiresRoleByInterfaceID(httpRequestProcessorTools.ID).ID,
						defaultHTTPRequestProcessor, defaultHTTPRequestProcessor.GetProvidesRoleByInterfaceID(httpRequestProcessorTools.ID).ID
						),
					ComponentFactory.CreateBinding(
						staticFileProvider, staticFileProvider.GetRequiresRoleByInterfaceID(httpRequestProcessorTools.ID).ID,
						defaultHTTPRequestProcessor, defaultHTTPRequestProcessor.GetProvidesRoleByInterfaceID(httpRequestProcessorTools.ID).ID
						)
					);

				componentHash[compName] = comp;
			}
			return (ICompositeComponent) componentHash[compName];
		}

		#endregion

		#endregion

		#region Webserver

		public static ICompositeComponent CreateWebserver()
		{
			string compName = "Webserver";
			if (!componentHash.Contains(compName))
			{
				ICompositeComponent comp = ComponentFactory.CreateCompositeComponent(compName);

				IComponent dispatcher = CreateDefaultDispatcher();
				IComponent webserverMonitor = CreateWebserverMonitor();
				IComponent configReader = CreateConfigReader();
				IComponent bibTexDB = CreateBibTexDB();
				IComponent httpRequestProcessor = CreateHTTPRequestProcessor();
				IComponent requestParser = CreateRequestParser();
				comp.AddComponents(dispatcher, webserverMonitor, configReader, bibTexDB, httpRequestProcessor, requestParser);

				IInterfaceModel requestParserIM = WebserverInterfaceFactory.CreateIRequestParser();
				IInterfaceModel httpRequestProcessorIM = WebserverInterfaceFactory.CreateIHTTPRequestProcessor();
				IInterfaceModel webserverConfigurationIM = WebserverInterfaceFactory.CreateIWebserverConfiguration();
				IInterfaceModel webserverMonitorIM = WebserverInterfaceFactory.CreateIWebserverMonitor();
				IInterfaceModel bibTexDBIM = WebserverInterfaceFactory.CreateIBibTexDB();

				comp.AddBindings(
					// Dispatcher
					ComponentFactory.CreateBinding(
						dispatcher, dispatcher.GetRequiresRoleByInterfaceID(requestParserIM.ID).ID,
						requestParser, requestParser.GetProvidesRoleByInterfaceID(requestParserIM.ID).ID
						),
					ComponentFactory.CreateBinding(
						dispatcher, dispatcher.GetRequiresRoleByInterfaceID(webserverMonitorIM.ID).ID,
						webserverMonitor, webserverMonitor.GetProvidesRoleByInterfaceID(webserverMonitorIM.ID).ID
						),
					ComponentFactory.CreateBinding(
						dispatcher, dispatcher.GetRequiresRoleByInterfaceID(webserverConfigurationIM.ID).ID,
						configReader, configReader.GetProvidesRoleByInterfaceID(webserverConfigurationIM.ID).ID
						),
					// RequestParser
					ComponentFactory.CreateBinding(
						requestParser, requestParser.GetRequiresRoleByInterfaceID(httpRequestProcessorIM.ID).ID,
						httpRequestProcessor, httpRequestProcessor.GetProvidesRoleByInterfaceID(httpRequestProcessorIM.ID).ID
						),
					ComponentFactory.CreateBinding(
						requestParser, requestParser.GetRequiresRoleByInterfaceID(webserverMonitorIM.ID).ID,
						webserverMonitor, webserverMonitor.GetProvidesRoleByInterfaceID(webserverMonitorIM.ID).ID
						),
					ComponentFactory.CreateBinding(
						requestParser, requestParser.GetRequiresRoleByInterfaceID(webserverConfigurationIM.ID).ID,
						configReader, configReader.GetProvidesRoleByInterfaceID(webserverConfigurationIM.ID).ID
						),
					// HTTPRequestProcessor
					ComponentFactory.CreateBinding(
						httpRequestProcessor, httpRequestProcessor.GetRequiresRoleByInterfaceID(bibTexDBIM.ID).ID,
						bibTexDB, bibTexDB.GetProvidesRoleByInterfaceID(bibTexDBIM.ID).ID
						),
					ComponentFactory.CreateBinding(
						httpRequestProcessor, httpRequestProcessor.GetRequiresRoleByInterfaceID(webserverMonitorIM.ID).ID,
						webserverMonitor, webserverMonitor.GetProvidesRoleByInterfaceID(webserverMonitorIM.ID).ID
						),
					ComponentFactory.CreateBinding(
						httpRequestProcessor, httpRequestProcessor.GetRequiresRoleByInterfaceID(webserverConfigurationIM.ID).ID,
						configReader, configReader.GetProvidesRoleByInterfaceID(webserverConfigurationIM.ID).ID
						),
					// WebserverMonitor
					ComponentFactory.CreateBinding(
						webserverMonitor, webserverMonitor.GetRequiresRoleByInterfaceID(webserverConfigurationIM.ID).ID,
						configReader, configReader.GetProvidesRoleByInterfaceID(webserverConfigurationIM.ID).ID
						)
					);

				componentHash[compName] = comp;
			}
			return (ICompositeComponent) componentHash[compName];
		}

		#endregion

		public static IBasicComponent[] GetBasicComponents()
		{
			IBasicComponent[] components = new IBasicComponent[11];
			components[0] = CreateDefaultDispatcher();
			components[1] = CreateHTTPRequestParser();
			components[2] = CreateDefaultRequestParser();
			components[3] = CreateDynamicFileProvider();
			components[4] = CreateTemplateFileProvider();
			components[5] = CreateBibTexProvider();
			components[6] = CreateBibTexDB();
			components[7] = CreateStaticFileProvider();
			components[8] = CreateDefaultHTTPRequestProcessor();
			components[9] = CreateWebserverMonitor();
			components[10] = CreateConfigReader();
			return components;
		}

		public static IComponent[] GetAllComponents()
		{
			IComponent[] components = new IBasicComponent[13];
			components[0] = CreateDefaultDispatcher();
			components[1] = CreateHTTPRequestParser();
			components[2] = CreateDefaultRequestParser();
			components[3] = CreateDynamicFileProvider();
			components[4] = CreateTemplateFileProvider();
			components[5] = CreateBibTexProvider();
			components[6] = CreateBibTexDB();
			components[7] = CreateStaticFileProvider();
			components[8] = CreateDefaultHTTPRequestProcessor();
			components[9] = CreateWebserverMonitor();
			components[10] = CreateConfigReader();
			components[11] = CreateRequestParser();
			components[12] = CreateDefaultHTTPRequestProcessor();
			return components;
		}

		private WebserverComponentFactory()
		{
		}

		private static Hashtable componentHash = new Hashtable();
	}
}