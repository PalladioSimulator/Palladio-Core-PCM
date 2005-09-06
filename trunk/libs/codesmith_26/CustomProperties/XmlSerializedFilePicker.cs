//------------------------------------------------------------------------------
//
// Copyright (c) 2002-2004 Eric J. Smith.  All rights reserved.
// 
// The terms of use for this software are contained in the file
// named sourcelicense.txt, which can be found in the root of this distribution.
// By using this software in any fashion, you are agreeing to be bound by the
// terms of this license.
// 
// You must not remove this notice, or any other, from this software.
//
//------------------------------------------------------------------------------

using System;
using System.IO;
using System.Xml;
using System.Xml.XPath;
using System.Xml.Serialization;
using System.ComponentModel;
using System.Windows.Forms;
using System.Windows.Forms.Design;
using System.Drawing.Design;
using CodeSmith.Gui;

namespace CodeSmith.CustomProperties
{
	public class XmlSerializedFilePicker : UITypeEditor
	{
		private IWindowsFormsEditorService editorService = null;
		private OpenFileDialog _openFileDialog = null;
		
		public XmlSerializedFilePicker(): base()
		{
		}
		
		public override object EditValue(ITypeDescriptorContext context, IServiceProvider provider, object value) 
		{
			if (provider != null) 
			{
				editorService = (IWindowsFormsEditorService)provider.GetService(typeof(IWindowsFormsEditorService));
				System.Windows.Forms.Control editorControl = editorService as System.Windows.Forms.Control;
				if (editorControl != null) 
				{
					if (_openFileDialog == null) _openFileDialog = new OpenFileDialog();
					_openFileDialog.CheckFileExists = true;
					_openFileDialog.DefaultExt = ".xml";
					_openFileDialog.Multiselect = false;
					_openFileDialog.Title = "Select an XML file:";
					_openFileDialog.Filter = "XML files (*.xml)|*.xml|All files (*.*)|*.*";
					DialogResult result = _openFileDialog.ShowDialog(editorControl);
					if (result == DialogResult.OK)
					{
						Type type = context.PropertyDescriptor.PropertyType;
						StreamReader reader = null;
						
						try
						{
							XmlSerializer serializer = new XmlSerializer(type);
							reader = new StreamReader(_openFileDialog.FileName);
							value = serializer.Deserialize(reader);
							reader.Close();
						}
						catch (Exception e)
						{
							ErrorDialog.Show(editorControl, String.Format("Unable to deserialize file ({0}) to type ({1}).", _openFileDialog.FileName, type.FullName), e.ToString());
						}
						finally
						{
							if (reader != null) reader.Close();
						}
					}
					else
					{
						value = null;
					}
				}
			}
			
			return value;
		}
		
		public override UITypeEditorEditStyle GetEditStyle(ITypeDescriptorContext context) 
		{
			return UITypeEditorEditStyle.Modal;
		}
	}
}
