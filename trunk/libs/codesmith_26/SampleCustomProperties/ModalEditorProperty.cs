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
using System.ComponentModel;

namespace CodeSmith.Samples
{
	[Editor(typeof(CodeSmith.Samples.ModalEditorPropertyEditor), typeof(System.Drawing.Design.UITypeEditor))]
	public class ModalEditorProperty
	{
		private string _sampleString;
		private bool _sampleBoolean;
		
		public ModalEditorProperty(string sampleString, bool sampleBoolean)
		{
			_sampleString = sampleString;
			_sampleBoolean = sampleBoolean;
		}
		
		public string SampleString
		{
			get {return _sampleString;}
		}
		
		public bool SampleBoolean
		{
			get {return _sampleBoolean;}
		}
		
		public override string ToString()
		{
			return SampleString + ": " + SampleBoolean;
		}
	}
}
