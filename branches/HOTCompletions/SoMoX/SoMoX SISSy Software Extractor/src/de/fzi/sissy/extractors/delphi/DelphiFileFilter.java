/**
 * DelphiFileFilter.java, 17.01.2007
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
package de.fzi.sissy.extractors.delphi;

import java.io.File;
import java.io.FileFilter;

public class DelphiFileFilter implements FileFilter {

	public DelphiFileFilter() {
		super();
	}

	public boolean accept(File pathname) {
    	String fileName = pathname.getAbsolutePath().toLowerCase();
        if (fileName.endsWith(".pas") || fileName.endsWith(".dpr") || fileName.endsWith(".dpk")) {
        	return true;
        }
        return false;
	}

}
