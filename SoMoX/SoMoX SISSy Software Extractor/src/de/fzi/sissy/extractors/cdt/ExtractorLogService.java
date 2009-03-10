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
package de.fzi.sissy.extractors.cdt;

import de.fzi.sissy.util.Debug;

/**
 * @author phil
 */
public class ExtractorLogService implements IExtractorLogService {

	public ExtractorLogService() {
	}
		
	/* (non-Javadoc)
	 * @see org.eclipse.cdt.core.parser.IParserLogService#traceLog(java.lang.String)
	 */
	public void traceLog(String message) {
		Debug.verbose(message);
	}
	/* (non-Javadoc)
	 * @see de.fzi.sissy.extractors.cdt.IExtractorLogService#errorLog(java.lang.String)
	 */
	public void errorLog(String message) {
		Debug.error(message);
	}
	/* (non-Javadoc)
	 * @see de.fzi.sissy.extractors.cdt.IExtractorLogService#includeLog(java.lang.String)
	 */
	public void includeLog(String message) {
		Debug.error(message);
	}
	/* (non-Javadoc)
	 * @see org.eclipse.cdt.core.parser.IParserLogService#isTracing()
	 */
	public boolean isTracing() {
		return true;
	}
}
