using System;
using BibTeXProviderXML;


namespace Palladio.Webserver.BibTeXProvider
{
	/// <summary>
	/// </summary>
	/// 
	/// <remarks>
	/// <pre>
	/// Version history:
	///
	/// $Log$
	/// Revision 1.1  2004/12/03 11:09:32  kelsaka
	/// The BibTeXProvider now reads its configuration from a xml-file; fixed sql-search-error in the BibTeXProvider; added documentation especially about a strange behaviour of the socket-connection  in the BibTeXProvider;
	///
	/// </pre>
	/// </remarks>
	public class BibTeXProviderConfiguration
	{

		private ConfigType configRoot;


		public BibTeXProviderConfiguration(ConfigType configRoot)
		{
			this.configRoot = configRoot;
			
		}


		/// <summary>
		/// Name of the Database-Server.
		/// </summary>
		public string DataSource
		{
			get
			{
				return configRoot.GetDataSource().GetName().Value;
			}
		}

		/// <summary>
		/// Name of the Database, where the BibTeX-Entries are saved.
		/// </summary>
		public string DatabaseName
		{
			get
			{
				return configRoot.GetDatabaseName().GetName().Value;
			}
		}

		/// <summary>
		/// Name of the Table, where the BibTeX-Entries are saved.	
		/// </summary>
		public string DatabaseTableName
		{
			get
			{
				return configRoot.GetDatabaseTableName().GetName().Value;
			}
		}


		/// <summary>
		/// The following FieldNames are taken into consideration to search for BibTeX-Entries in the DB. This means
		/// if one of the following FieldNames occours in the post-request it is seen as a part of the search-request.
		/// </summary>
		public string[] SearchedBibTeXFieldNames
		{
			get
			{
				int numberOfBibTeXFieldNames = configRoot.GetSearchedBibTeXFieldNames().GetFieldNameCount();
				string[] fileExtensions = new string[numberOfBibTeXFieldNames];

				for(int x = 0; x < numberOfBibTeXFieldNames; x++)
				{
					fileExtensions[x] = configRoot.GetSearchedBibTeXFieldNames().GetFieldNameAt(x).Name.Value;
				}

				return fileExtensions;
			}
		}

		/// <summary>
		/// The File-Extensions the BibTeXProvider handles.
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
		/// If no connection can be established to the Database-Server this message is displayed to the users.	
		/// </summary>
		public string ErrorMessageOnConnectionProblems
		{
			get
			{
				return configRoot.GetErrorMessageOnConnectionProblems().GetMessage().Value;
			}
		}

	}
}
