using System;

namespace MySmallWebServer
{
	/// <summary>
	/// Rrepresents the requested file from the client
	/// </summary>
	public class FileID
	{
		/// <summary>
		/// The requested File as <code>string</code>
		/// </summary>
		protected string requestedFile;

		/// <summary>
		/// The requested dir as <code>string</code>
		/// </summary>
		protected string requestedDir;

		/// <summary>
		/// The extension of the requested file
		/// </summary>
		protected string fileExtension;


		/// <summary>
		/// Initates an emty <code>FileID</code>
		/// </summary>
		public FileID(){}

		/// <summary>
		/// Retruns and set the extension of the requested file as string
		/// </summary>
		public string FileExtension
		{
			get{ return this.fileExtension;}
			set{ this.fileExtension = value;}
		}


		/// <summary>
		/// Initates a <code>FileID</code> with a given FileID
		/// (copy constructor)
		/// </summary>
		/// <param name="fileID"></param>
		public FileID(string fileID)
		{
			this.requestedFile = fileID;
		}


		/// <summary>
		/// Returns and set the name of the requested File as <code>string</code>
		/// </summary>
		public string RequestedFileName
		{
			get{return this.requestedFile;}
			set{this.requestedFile = value;}
		}


		/// <summary>
		/// Returns the requested dir of the client as <code>string</code>
		/// </summary>
		public string RequestedDirectory
		{
			get{return this.requestedDir;}
			set{ this.requestedDir = value;}
		}
	}
}
