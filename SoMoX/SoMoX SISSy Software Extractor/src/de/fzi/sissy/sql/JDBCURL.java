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
package de.fzi.sissy.sql;

import java.net.MalformedURLException;

/**
 * Handles URLs to access databases via JDBC.
 * 
 * Note: This has been tested with Postgres and MS-SQL databases.
 * It does not work with Oracle databases.
 * @author markus.bauer
 *
 */
public class JDBCURL {
	
	private String driverString;
	private String dbName;
	private String hostname;
	private int port;
	private String optionString;
	
	public JDBCURL(String url) throws MalformedURLException {
		initializeFromString(url);
	}
	
	public JDBCURL(String driver, String host, String db) {
		this.driverString = driver;
		this.dbName = db;
		this.hostname = host;
		this.port = -1;
	}
	
	public JDBCURL(String driver, String host, int port, String db) {
		this.driverString = driver;
		this.dbName = db;
		this.hostname = host;
		this.port = port; 
	}
	
	public void setDriverString(String driver) {
		this.driverString = driver;
	}
	
	public String getDriverString() {
		return(this.driverString);
	}
	
	public void setHostname(String host) {
		this.hostname = host;	
	}
	
	public String getHostname() {
		return this.hostname;
	}
	
	public void setPort(int port) {
		this.port = port;
	}
	
	public int getPort() {
		return (this.port);
	}
	
	public void setDBName(String db) {
		this.dbName = db;
	}
	
	public String getDBName() {
		return this.dbName;
	}
	
	public String toString() {
		String result = driverString + ":";
		if (hostname != null && !hostname.equals("")) { 
			result = result + "//" + hostname;
			if (port > 0) {
				result = result + ":" + String.valueOf(port);
			}
			result = result + "/";
		}
		result = result + dbName;
		if (optionString != null && !optionString.equals("")) {
			result = result + optionString;
		}
		return result;
	}
	
	private void initializeFromString(String url) throws MalformedURLException {
		
		int pos;
		
		pos = url.indexOf("://");
		if (pos >= 0) {
			driverString = url.substring(0, pos);
			
			// Hostname and Port...
			int posHostname = pos + 3;
			pos = url.indexOf('/', posHostname);
			if (pos < 0) {
				throw new MalformedURLException();
			}
			int posDBName = pos + 1;
			pos = url.indexOf(':', posHostname);
			if (pos >= 0) {
				int posPort = pos + 1;
				hostname = url.substring(posHostname, posPort-1);
				String portString = url.substring(posPort, posDBName-1);
				port = Integer.parseInt(portString);
			} else {
				hostname = url.substring(posHostname, posDBName-1);
			}
			
			// DB name and options/properties
			pos = url.indexOf(';', posDBName);
			if (pos >= 0) {
				dbName = url.substring(posDBName, pos);
				optionString = url.substring(pos);
			} else {
				dbName = url.substring(posDBName);
			}
			
		} else {
			pos = url.lastIndexOf(':');
			if (pos >= 0) {
				driverString = url.substring(0, pos);
				dbName = url.substring(pos+1);
			} else {
				throw new MalformedURLException();
			}		
		}
			
	}

}
