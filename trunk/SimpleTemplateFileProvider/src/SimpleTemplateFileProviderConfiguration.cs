using System;
using System.Text;
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
				// convert the given string (usually 2 digits) into a char.
				// the given string is interpreted as a ascii-code-no.
				// This is necessary as a "&" (38) has to be decoded from &amp; in a XML-Document.
				// So this is a kind of workaround to be able to specify special characters as well.
				string urwert = configRoot.GetVariablesname().GetDelimiter().Value;
				char c = Convert.ToChar(Int32.Parse(urwert));
				return "" + c;
			}
		}

	}
}
