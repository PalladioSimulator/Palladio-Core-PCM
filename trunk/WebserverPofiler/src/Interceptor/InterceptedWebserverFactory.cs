using System;
using Palladio.Webserver.BibTeXProvider;
using Palladio.Webserver.ConfigReader;
using Palladio.Webserver.Dispatcher;
using Palladio.Webserver.FTPRequestProcessor;
using Palladio.Webserver.HTTPRequestProcessor;
using Palladio.Webserver.Request;
using Palladio.Webserver.RequestParser;
using Palladio.Webserver.WebserverFactory;
using Palladio.Webserver.WebserverMonitor;

namespace Palladio.Reliability.WebserverProfiler.Interceptor
{
	/// <summary>
	/// Decorator for <c>IWebserverFactory</c>. Wrapps each object with an interceptor.
	/// </summary>
	public class InterceptedWebserverFactory : IWebserverFactory
	{
		private IWebserverFactory factory;

		public InterceptedWebserverFactory(IWebserverFactory factory)
		{
			this.factory = factory;
		}


		/// <summary>
		/// Creates the DefaultDispatcher.
		/// </summary>
		/// <param name="requestParser">A component that fullfills the required-interface.</param>
		/// <returns>IDispatcher, using the services from the reqestParser.</returns>
		public IDispatcher CreateDispatcher(IRequestParser requestParser, IWebserverMonitor webserverMonitor, IWebserverConfiguration webserverConfiguration, IRequestFactory requestFactory, IPortListenerFactory portListenerFactory)
		{
			IDispatcher dispatcher = factory.CreateDispatcher(requestParser, webserverMonitor, webserverConfiguration, requestFactory, portListenerFactory);
			return new DispatcherInterceptor(dispatcher);
		}

		/// <summary>
		/// Creates a WebserverMonitor: a component for logging- and debuggin-features. 
		/// </summary>
		/// <returns></returns>
		public IWebserverMonitor CreateWebserverMonitor(IWebserverConfiguration webserverConfiguration)
		{
			IWebserverMonitor monitor = factory.CreateWebserverMonitor(webserverConfiguration);
			return new WebserverMonitorInterceptor(monitor);
		}

		/// <summary>
		/// Creates a ConfigReader to get settings for the webserver.
		/// </summary>
		/// <returns></returns>
		public IConfigReader CreateConfigReader()
		{
			IConfigReader reader = factory.CreateConfigReader();
			return new ConfigReaderInterceptor(reader);
		}

		/// <summary>
		/// Creates a HTTPRequestParser. This component can handle requests in a Chain Of Responsibility (COR).
		/// </summary>
		/// <param name="requestProcessor">The component used as HTTPRequestProcessor.</param>
		/// <param name="CorSuccessor">The successor in the COR to handle requests by using the IRequestParser-Interface.</param>
		/// <returns>HTTPRequestParser</returns>
		public IRequestParser CreateHTTPRequestParser(IHTTPRequestProcessor requestProcessor, IRequestParser CorSuccessor, IWebserverMonitor webserverMonitor, IWebserverConfiguration webserverConfiguration, IRequestFactory requestFactory)
		{
			IRequestParser parser = factory.CreateHTTPRequestParser(requestProcessor,CorSuccessor,webserverMonitor,webserverConfiguration,requestFactory);
			return new RequestParserInterceptor(parser);
		}

		/// <summary>
		/// Creates a FTPRequestParser. This component can handle requests in a Chain Of Responsibility (COR).
		/// </summary>
		/// <param name="requestProcessor">The component used as FTPRequestProcessor.</param>
		/// <param name="CorSuccessor">The successor in the COR to handle requests by using the IRequestParser-Interface.</param>
		/// <returns>FTPRequestParser</returns>
		public IRequestParser CreateFTPRequestParser(IFTPRequestProcessor requestProcessor, IRequestParser CorSuccessor, IWebserverMonitor webserverMonitor, IWebserverConfiguration webserverConfiguration)
		{
			IRequestParser parser = factory.CreateFTPRequestParser(requestProcessor,CorSuccessor,webserverMonitor,webserverConfiguration);
			return new RequestParserInterceptor(parser);
		}

		/// <summary>
		/// This parser does not use other components as it catches errors on parsing the request in the COR. This
		/// means that it is a error-handler of streams that cannot be parsed. It should be the last link in the COR.
		/// </summary>
		/// <returns>ErrorRequestParser</returns>
		public IRequestParser CreateDefaultRequestParser(IWebserverMonitor webserverMonitor, IWebserverConfiguration webserverConfiguration)
		{
			IRequestParser parser = factory.CreateDefaultRequestParser(webserverMonitor,webserverConfiguration);
			return new RequestParserInterceptor(parser);
		}

		public IHTTPRequestProcessor CreateTimeConsumingProcessor(IHTTPRequestProcessor corSuccessor, IWebserverMonitor webserverMonitor, IWebserverConfiguration webserverConfiguration, IHTTPRequestProcessorTools requestProcessorTools)
		{
			throw new NotImplementedException();
		}

		/// <summary>
		/// Creates a BibTeXProvider. This component makes a bibtex-db accessible.
		/// </summary>
		/// <param name="CorSuccessor">COR-Successor to process HTTPRequest.</param>
		/// <param name="webserverMonitor">Writes Log-Information to this monitor.</param>
		/// <param name="webserverConfiguration">The Configuration of the actual webserver.</param>
		/// <returns>BibTeXProvider</returns>
		public IHTTPRequestProcessor CreateBibTeXProvider(IBibTexDB bibTexDB, IHTTPRequestProcessor CorSuccessor, IWebserverMonitor webserverMonitor, IWebserverConfiguration webserverConfiguration, IHTTPRequestProcessorTools requestProcessorTools)
		{
			IHTTPRequestProcessor processor = factory.CreateBibTeXProvider(bibTexDB, CorSuccessor,webserverMonitor, webserverConfiguration, requestProcessorTools);
			return new HTTPRequestProcessorInterceptor(processor);
		}

		/// <summary>
		/// Creates a SimpleTemplateFileProvider.
		/// </summary>
		/// <param name="CorSuccessor">COR-Successor to process HTTPRequest.</param>
		/// <param name="webserverMonitor">Writes Log-Information to this monitor.</param>
		/// <param name="webserverConfiguration">The Configuration of the actual webserver.</param>
		/// <returns>SimpleTemplateFileProvider</returns>
		public IHTTPRequestProcessor CreateSimpleTemplateFileProvider(IHTTPRequestProcessor CorSuccessor, IWebserverMonitor webserverMonitor, IWebserverConfiguration webserverConfiguration, IHTTPRequestProcessorTools requestProcessorTools)
		{
			IHTTPRequestProcessor processor = factory.CreateSimpleTemplateFileProvider(CorSuccessor,webserverMonitor, webserverConfiguration, requestProcessorTools);
			return new HTTPRequestProcessorInterceptor(processor);
		}

		/// <summary>
		/// Creates a StaticFileProvider.
		/// </summary>
		/// <param name="CorSuccessor">COR-Successor to process HTTPRequest.</param>
		/// <param name="webserverMonitor">Writes Log-Information to this monitor.</param>
		/// <param name="webserverConfiguration">The Configuration of the actual webserver.</param>
		/// <returns>StaticFileProvider</returns>
		public IHTTPRequestProcessor CreateStaticFileProvider(IHTTPRequestProcessor CorSuccessor, IWebserverMonitor webserverMonitor, IWebserverConfiguration webserverConfiguration, IHTTPRequestProcessorTools requestProcessorTools)
		{
			IHTTPRequestProcessor processor = factory.CreateStaticFileProvider(CorSuccessor,webserverMonitor, webserverConfiguration, requestProcessorTools);
			return new HTTPRequestProcessorInterceptor(processor);
		}

		/// <summary>
		/// Creates a StaticFileProvider.
		/// </summary>
		/// <param name="webserverMonitor">Writes Log-Information to this monitor.</param>
		/// <param name="webserverConfiguration">The Configuration of the actual webserver.</param>
		/// <param name="CorSuccessor">COR-Successor to process HTTPRequest.</param>
		/// <returns>StaticFileProvider</returns>
		public IHTTPRequestProcessor CreateDynamicFileProvider(IHTTPRequestProcessor CorSuccessor, IWebserverMonitor webserverMonitor, IWebserverConfiguration webserverConfiguration, IHTTPRequestProcessorTools requestProcessorTools)
		{
			IHTTPRequestProcessor processor = factory.CreateDynamicFileProvider(CorSuccessor,webserverMonitor, webserverConfiguration, requestProcessorTools);
			return new HTTPRequestProcessorInterceptor(processor);
		}

		/// <summary>
		/// This processor does not use other components as it catches errors on processing the request in the COR. This
		/// means that it is a error-handler of streams that cannot be processed. It should be the last link in the COR.
		/// </summary>
		/// <param name="webserverMonitor">Writes Log-Information to this monitor.</param>
		/// <param name="webserverConfiguration">The Configuration of the actual webserver.</param>
		/// <returns>DefaultRequestProcessor</returns>
		public IHTTPRequestProcessor CreateDefaultRequestProcessor(IWebserverMonitor webserverMonitor, IWebserverConfiguration webserverConfiguration, IHTTPRequestProcessorTools requestProcessorTools)
		{
			IHTTPRequestProcessor processor = factory.CreateDefaultRequestProcessor(webserverMonitor, webserverConfiguration, requestProcessorTools);
			return new HTTPRequestProcessorInterceptor(processor);
		}

		public IHTTPRequestProcessorTools CreateRequestProcessorTools(IWebserverMonitor webserverMonitor, IWebserverConfiguration webserverConfiguration)
		{
			IHTTPRequestProcessorTools tools = factory.CreateRequestProcessorTools(webserverMonitor, webserverConfiguration);
			return new HTTPRequestProcessorToolsInterceptor(tools);
		}

		public IWebserverConfiguration CreateWebserverConfiguration(IConfigReader configReader, string pathToConfigFile, string xmlConfigFile)
		{
			IWebserverConfiguration conf = factory.CreateWebserverConfiguration(configReader, pathToConfigFile, xmlConfigFile);
			return new WebserverConfigurationInterceptor(conf);
		}

		public IBibTexDB CreateBibTexDB()
		{
			IBibTexDB bibTexDB = factory.CreateBibTexDB();
			return new BibTexDBInterceptor(bibTexDB);
		}

	}
}
