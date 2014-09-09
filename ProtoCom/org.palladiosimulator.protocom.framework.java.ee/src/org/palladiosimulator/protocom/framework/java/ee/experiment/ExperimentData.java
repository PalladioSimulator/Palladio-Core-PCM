package org.palladiosimulator.protocom.framework.java.ee.experiment;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonSetter;

public class ExperimentData {
	private static final SimpleDateFormat FORMAT = new SimpleDateFormat("dd.MM.yy kk:mm:ss");

	private String id;
	private String name;
	private String date;

	public ExperimentData() {
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@JsonSetter("date")
	public void setDate(String date) {
		this.date = date;
	}

	public void setDate(Date date) {
		this.date = FORMAT.format(date);
	}

	public String getDate() {
		return date;
	}

	/*@JsonGetter("date")
	public String getDateAsString() {
		return FORMAT.format(date);
	}*/
}
