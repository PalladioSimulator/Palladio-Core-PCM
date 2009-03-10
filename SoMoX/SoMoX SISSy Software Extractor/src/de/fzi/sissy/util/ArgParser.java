/**
 * Copyright (c) 2004-2006 FZI Forschungszentrum Informatik, 
 * 10-14 Haid-und-Neu Street, 76131 Karlsruhe, Germany
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301  USA
 */
package de.fzi.sissy.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.ListIterator;

/**
 * @author woelker
 * 
 */
public class ArgParser {
	public static int helpWidth = 17;

	public class Option {
		public Option(String name, String arguments, String help) {
			this.name = name;
			this.arguments = arguments;
			this.help = charFill(' ', helpWidth - name.length()
					- ((arguments!=null)?arguments.length():-3))
					+ help.replaceAll("\n", "\n\t"
							+ charFill(' ', helpWidth + 4));
			
		}

		public String name;

		public String arguments;

		public String help;
	}

	public class Parameter {
		public Parameter(String name, String value) {
			this.name = name;
			this.value = value;
		}

		public String name;

		public String value;
	}

	protected char parameterSwitch = '-';

	protected String title;

	public String usage;

	protected ArrayList OptionList = new ArrayList();

	protected ArrayList ParameterList = new ArrayList();

	public ArrayList TargetList = new ArrayList();

	public ArgParser(String title, String usage) {
		this.title = title;
		this.usage = usage;
	}

	public void parse(String arg[]) {
		int i;
		for (i = 0; i < arg.length; i++) {
			String str = arg[i];
			if (str.charAt(0) == parameterSwitch) {
				String optname = str.substring(1);
				ListIterator it = OptionList.listIterator();
				while (it.hasNext()) {
					Option opt = (Option) it.next();
					if (opt.name.equals(optname)) {
						if (opt.arguments != null && i < arg.length - 1) {
							ParameterList.add(new Parameter(optname, arg[++i]));
						} else {
							ParameterList.add(new Parameter(optname, null));
						}
					}
				}
			} else {
				TargetList.add(str);
			}

		}
	}

	public void addOption(String name, String arguments, String help) {
		OptionList.add(new Option(name, arguments, help));
	}

	public boolean hasParameter(String name) {
		ListIterator it = ParameterList.listIterator();
		while (it.hasNext()) {
			Parameter param = (Parameter) it.next();
			if (param.name.equals(name))
				return true;
		}
		return false;
	}

	public String getParameter(String name) {
		ListIterator it = ParameterList.listIterator();
		while (it.hasNext()) {
			Parameter param = (Parameter) it.next();
			if (param.name.equals(name))
				return param.value;
		}
		return null;
	}

	public void printHelp() {
		PrintStream out = System.out;
		out.println("Usage: " + usage);
		out.println("Parameters: ");
		out.println();
		ListIterator it = OptionList.listIterator();
		while (it.hasNext()) {
			Option opt = (Option) it.next();
			if (opt.arguments != null)
				out.println("\t-" + opt.name + " <" + opt.arguments + ">"
						+ opt.help);
			else
				out.println("\t-" + opt.name + opt.help);
		}
	}

	public static String charFill(char c, int len) {
		StringBuffer buffer = new StringBuffer();
		while (len-- > 0) {
			buffer.append(c);
		}
		return buffer.toString();
	}

	public static boolean isFileWritable(String filename) {
		try {
			FileWriter file = new FileWriter(filename);
			file.close();
		} catch (IOException e) {
			return false;
		}
		return true;
	}

	public static boolean isFileReadable(String filename) {
		try {
			File file = new File(filename);
			return file.canRead();
		} catch (SecurityException e) {
			return false;
		}

	}
}