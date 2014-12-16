package org.palladiosimulator.protocom.framework.java.ee.protocol;

import java.io.IOException;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

/**
 * The Request class provides methods for performing HTTP requests.
 * @author Christian Klaussner
 */
public class Request {
	
	/**
	 * Performs a synchronous POST request at the given URL (concatenation of location and path).
	 * @param location the location part of the request URL
	 * @param path the path part of the request URL
	 * @param body the body of the request
	 */
	public static void post(String location, String path, String body) {
		HttpClient client =  new DefaultHttpClient();
		
		HttpPost post = new HttpPost(location + path);
		post.setHeader("Content-Type", "application/json");
		
		try {
			post.setEntity(new StringEntity(body));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		try {
			client.execute(post);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Performs a synchronous GET request at the given URL (concatenation of location and path).
	 * @param location the location part of the request URL
	 * @param path the the path part of the request URL
	 * @param parameters a list of GET parameters
	 * @return the response for the request
	 */
	public static String get(String location, String path, List<Parameter> parameters) {
		HttpGet get = null;
		StringWriter response = new StringWriter();
		
		HttpClient client = new DefaultHttpClient();
		
		try {
			StringBuilder uri = new StringBuilder();
			int i = 0;
			
			uri.append(location);
			uri.append(path);
			
			for (Parameter parameter : parameters) {
				String name = URLEncoder.encode(parameter.getName(), "UTF-8");
				String value = URLEncoder.encode(parameter.getValue(), "UTF-8");
				
				if (i == 0) {
					uri.append('?');
				} else {
					uri.append('&');
				}
				
				uri.append(name);
				uri.append("=");
				uri.append(value);
				
				i++;
			}
			
			get = new HttpGet(uri.toString());
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		try {
			HttpResponse stream = client.execute(get);
			IOUtils.copy(stream.getEntity().getContent(), response);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return response.toString();
	}
}
