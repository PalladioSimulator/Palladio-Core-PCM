using System;
using System.Collections;

namespace QmlParser
{

	public class Error 
	{
		private String _filenname;
		private int _line;
		private int _column;
		private int _length;
		private String _message;

		public Error(String filename, int line, int column, int length, String message)
		{
			this._filenname = filename;
			this._line = line;
			this._column = column;
			this._length = length;
			this._message = message;
		}

		public String Filename
		{
			get
			{
				return this._filenname;
			}
		}

		public int Line
		{
			get
			{
				return this._line;
			}
		}

		public int Column
		{
			get
			{
				return this._column;
			}
		}

		public int Length
		{
			get
			{
				return this._length;
			}
		}

		public String Message
		{
			get
			{
				return this._message;
			}
		}
	}

	public class Report
	{
		private ArrayList _errorList;
		
		public Report()
		{
			this._errorList = new ArrayList();
		}

		public void ReportError(String filename, String message)
		{
			ReportError(filename, -1, -1, -1, message);
		}

		public void ReportError(String filename, int line, int column, int length, String message)
		{
			Error error = new Error(filename, line, column, length, message);
			this._errorList.Add(error);
		}

		public IEnumerator GetEnumerator()
		{
			return this._errorList.GetEnumerator();
		}

		public int Count
		{
			get
			{
				return this._errorList.Count;
			}
		}
	}
}
