package org.palladiosimulator.protocom.framework.java.ee.experiment;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonSetter;

/**
 * The ExperimentData class is used to store the data of an experiment.
 * @author Christian Klaussner
 */
public class ExperimentData {
	private static final SimpleDateFormat FORMAT = new SimpleDateFormat("dd.MM.yy kk:mm:ss");

	private String id;
	private String name;
	private String date;

	/**
	 * Constructs a new ExperimentData object.
	 */
	public ExperimentData() {
	}

	/**
	 * Sets the ID.
	 * @param id the ID
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Gets the ID.
	 * @return the ID
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the name of the experiment.
	 * @param name the name of the experiment
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the name of the experiment.
	 * @return the name of the experiment
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the date on which the experiment was conducted.
	 * @param date a string containing the date
	 */
	@JsonSetter("date")
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * Sets the date on which the experiment was conducted.
	 * @param date the date
	 */
	public void setDate(Date date) {
		this.date = FORMAT.format(date);
	}

	/**
	 * Gets the date on which the experiment was conducted.
	 * @return a string containing the date
	 */
	public String getDate() {
		return date;
	}
}
