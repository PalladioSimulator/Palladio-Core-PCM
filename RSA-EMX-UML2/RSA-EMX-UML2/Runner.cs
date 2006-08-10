/*
 * Copyright 2006 by:
 * University of Karlsruhe (TH)
 * Faculty of Computer Science
 * Institute for Program Structures and Data Organization (IPD)
 * Software Design and Quality (SDQ)
 * Germany
 * Homepage: http://sdq.ipd.uni-karlsruhe.de
 * 
 * This is free software. You are welcome to redistribute it.
 * It comes with ABSOLUTELY NO WARRANTY.
 */
using System;
using System.Collections.Generic;
using System.Text;
using System.IO;
using System.Xml;

namespace RSA_EMX_UML2
{
    class Runner
    {
        private static string hints =
                "Please use the following search pattern to " +
                "specify the files to fix:\n" +
                "*: 0 or more characters\n" +
                "?: exactly one character.\n" +
                "Example usage: RSA-EMX-UML2.exe *.uml2";

        static void Main(string[] args)
        {
            Console.WriteLine("Fixes buggy RSA>UML2-Export for multiple linked/referenced models\n" +
                              "-----------------------------------------------------------------\n");

            if (args.Length == 1)
            {
                try
                {
                    string[] files = Directory.GetFiles(".", args[0], SearchOption.TopDirectoryOnly);

                    Converter converter = new Converter();
                    converter.Convert(files);
                }
                catch (Exception e)
                {
                    Console.WriteLine("ERROR: " + e.Message);
                    Console.Out.WriteLine(hints);
                }
            }
            else
            {
                Console.Out.WriteLine("Invalid arguments.\n");
                Console.Out.WriteLine(hints);
            }

            Console.WriteLine("Press ENTER to close application");
            Console.ReadLine();
        }
    }
}
