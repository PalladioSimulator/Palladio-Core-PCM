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

namespace TypedDataSetTester
{
	public class EntryPoint
	{
		[STAThread]
		static void Main(string[] args)
		{
			// Northwind
			CustomersDataSet cds = new CustomersDataSet();
			CustomersDataAdapter cda = new CustomersDataAdapter("ConnectionString");
			
			// fill all the records from the permission table.
			cda.Fill(cds);
			
			// make some changes and save
			cds.Customers[0].Address = cds.Customers[0].Address + "2";
			foreach (CustomersDataSet.CustomersRow row in cds.Customers)
			{
				if (row.Address == "blah") row.Delete();
			}
			cds.Customers.AddCustomersRow("sdfs", "af fasdf", "dsf asfasdF", "fd asfasdfasfsa", "blah", "fdsf", "df", "34343", "us", "435345", "4523423");
			cda.Update(cds);
			
			// reset changes and save
			while (cds.Customers[0].Address.EndsWith("2"))
			{
				cds.Customers[0].Address = cds.Customers[0].Address.Substring(0, cds.Customers[0].Address.Length - 1);
			}
			
			foreach (CustomersDataSet.CustomersRow row in cds.Customers)
			{
				if (row.Address == "blah") row.Delete();
			}
		}
	}
}
