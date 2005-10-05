using System;
using System.Collections;
using System.Collections.Specialized;

namespace QmlParser.Semantic
{
	public class OrderTable
	{
		private bool _isValid;
		private HybridDictionary _elementOrder;

		public OrderTable(ArrayList elements)
		{
			this._isValid = true;
			this._elementOrder = new HybridDictionary();
			foreach (string element in elements)
			{
				this._elementOrder.Add(element, null);
			}
		}

		public void Add(string lesser, string greater)
		{
			// check if only specified elements are used
			if (!this._elementOrder.Contains(lesser))
			{
				this._isValid = false;
				throw new SemanticException("Use only specified names. '" + lesser + "' is not specified.");
			}

			if (!this._elementOrder.Contains(greater))
			{
				this._isValid = false;
				throw new SemanticException("Use only specified names. '" + greater + "' is not specified.");
			}			

			object entry = this._elementOrder[lesser];
			if (entry == null)
				this._elementOrder[lesser] = new ArrayList();
			else
			{
				if (((ArrayList)this._elementOrder[lesser]).Contains(greater))
				{
					this._isValid = false;
					throw new SemanticException("Order. '" + lesser + "' < '" + greater + "' is already specified.");
				}
			}
			((ArrayList)this._elementOrder[lesser]).Add(greater);
		}

		public void ResolveTransitiveRelations()
		{
			// check order
			bool isValid = true;
			foreach (DictionaryEntry entry in this._elementOrder)
			{
				ArrayList list = (ArrayList)entry.Value;

				if (list != null)
				{
					foreach (string listEntry in list)
					{
						isValid = Validate((string)entry.Key, listEntry);
						if (!isValid)
						{
							this._isValid = false;
							throw new SemanticException("Your order definition is wrong. Please correct the errors.");
						}
					}
				}
			}

			// resolve transitive relations
			foreach (DictionaryEntry entry in this._elementOrder)
			{
				ArrayList baseList = (ArrayList)entry.Value;
				ArrayList addList = new ArrayList();

				if (baseList != null)
				{
					foreach (string listEntry in baseList)
					{
						addList.AddRange(Resolve((string)entry.Key, listEntry, baseList));
					}

					baseList.AddRange(addList);
				}
			}
		}

		public bool Validate(string startElement, string nextElement)
		{
			ArrayList list = (ArrayList)this._elementOrder[nextElement];

			if (list != null)
			{
				foreach (string listEntry in list)
				{
					if (listEntry == startElement)
						return false;
					else
						return Validate(startElement, listEntry);
				}
			}

			return true;
		}

		private ArrayList Resolve(string startElement, string nextElement, ArrayList baseList)
		{
			ArrayList resultList = new ArrayList();
			ArrayList list = (ArrayList)this._elementOrder[nextElement];

			if (list != null)
			{
				foreach (string listEntry in list)
				{
					if (!baseList.Contains(listEntry))
					{
						resultList.Add(listEntry);
						ArrayList tempResultList = Resolve(startElement, listEntry, baseList);
						resultList.AddRange(tempResultList);
						return resultList;
					}
				}
			}
			return new ArrayList();
		}

		public bool IsValid
		{
			get
			{
				return this._isValid;
			}
		}

		public override string ToString()
		{
			string toString = String.Empty;

			foreach (DictionaryEntry entry in this._elementOrder)
			{
				toString += (string)entry.Key;
				toString += ": ";
				if (entry.Value != null)
				{
					ArrayList list = (ArrayList)entry.Value;
					foreach (string element in list)
						toString += element + " ";									
				}
				toString += ",  ";
			}

			return toString;
		}

	}
}
