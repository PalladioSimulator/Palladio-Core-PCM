using System;
using SimpleTemplateFileProviderXML;

namespace Palladio.Webserver.SimpleTemplateFileProvider
{
	/// <summary>
	/// SimpleTemplateFileProviderConfiguration
	/// </summary>
	public class SimpleTemplateFileProviderConfiguration
	{

		
		private ConfigType configRoot;


		public SimpleTemplateFileProviderConfiguration(ConfigType configRoot)
		{
			this.configRoot = configRoot;
		}


		/// <summary>
		/// The File-Extensions the SimpleTemplateFileProvider handles.
		/// </summary>
		public string[] HandledFileExtensions
		{
			get
			{
				int numberOfFileExtensions = configRoot.GetHandledFileTypes().GetFileCount();
				string[] fileExtensions = new string[numberOfFileExtensions];

				for(int x = 0; x < numberOfFileExtensions; x++)
				{
					fileExtensions[x] = configRoot.GetHandledFileTypes().GetFileAt(x).Extension.Value;
				}

				return fileExtensions;
			}
		}



		/// <summary>
		/// String that delimits variables-names.
		/// </summary>
		public string VariablesNameDelimiter
		{
			get
			{
				return configRoot.GetVariablesname().GetDelimiter().Value;
			}
		}

	}
}
