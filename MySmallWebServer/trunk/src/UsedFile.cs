using System;
using System.Collections;

namespace MySmallWebServer
{
	/// <summary>
	/// 
	/// </summary>
	public class UsedFile : FileID
	{
		/// <summary>
		/// The input of the forumlar which is has been enterd by the user
		/// as a <code>string</code>.
		/// </summary>
		protected string formularContent;

		/// <summary>
		/// A <code>Hashatble</code> which contains the formualr input in a mapping
		/// key: FormularName
		/// Value: the content of this field enterd by user
		/// </summary>
		protected Hashtable userInput;
		
		/// <summary>
		/// Retrun a <code>string</code> which contains the formualr input
		/// </summary>
		public string FormularContent
		{
			get{return this.formularContent;}
			set{this.formularContent = value;}
		}

		/// <summary>
		/// Different to FileID, because an instance of this class is
		/// iniziated when a PostMethod (formular sended) is orderd by
		/// the client. this contains not the requested file, but the file 
		/// which was use to generate the formular content.
		/// </summary>
		/// <param name="file">The used file as <code>string</code></param>
		public UsedFile(string file)
		{
		}

		/// <summary>
		/// An empty constructor for this class.
		/// </summary>
		public UsedFile(){}




	}
}
