using System;
using System.Collections;
using BibTeX.Parser.Interfaces;

namespace BibTeX.Parser.Types
{
	/// <summary>
	/// Zusammenfassung für FieldArray.
	/// </summary>
	internal class FieldArray : IFieldArray
	{
		protected Hashtable fieldHash = new Hashtable();
		protected ArrayList fields = new ArrayList();
		private IEnumerator lastEnumerator;

		public IField this[string fieldID]
		{
			get
			{
				return (IField)fields[(int)fieldHash[fieldID.ToLower()]];
			}
		}
	
		public IField[] Fields
		{
			get
			{
				IField[] result = new IField[fields.Count];
				fields.CopyTo(result);
				return result;
			}
			set
			{
				fields = new ArrayList(value);
				fieldHash = new Hashtable();
				for (int i = 0; i < value.Length; i++)
				{
					fieldHash.Add(value[i].ID.ToLower(),i);
				}
			}
		}

		public bool IsSynchronized
		{
			get
			{
				return fields.IsSynchronized;
			}
		}

		public int Count
		{
			get
			{
				return fields.Count;
			}
		}
		
		public object SyncRoot
		{
			get
			{
				return fields.SyncRoot;
			}
		}

		public bool HasField(string fieldID)
		{
			return fieldHash.Contains(fieldID.ToLower());
		}

		public FieldArray() : base()
		{
		}

		public void AddField (IField field)
		{
			fields.Add (field);
			fieldHash.Add (field.ID.ToLower(), fields.Count-1);
		}

		public IEnumerator GetEnumerator()
		{
			lastEnumerator = fields.GetEnumerator();
			return lastEnumerator;
		}

		public void CopyTo(Array a, int i)
		{
			fields.CopyTo(a,i);
		}
	}
}
