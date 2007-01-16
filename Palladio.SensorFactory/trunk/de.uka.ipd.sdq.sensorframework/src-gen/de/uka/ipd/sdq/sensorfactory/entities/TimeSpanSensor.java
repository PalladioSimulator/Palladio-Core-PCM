package de.uka.ipd.sdq.sensorfactory.entities;

@javax.persistence.Entity
public abstract class TimeSpanSensor extends de.uka.ipd.sdq.sensorfactory.entities.Sensor {
    @javax.persistence.OneToMany(cascade = javax.persistence.CascadeType.ALL)
    @javax.persistence.JoinColumn(name = "FK_TIMESPANSENSOR")
    private java.util.Collection<de.uka.ipd.sdq.sensorfactory.entities.TimeSpan> m_timespans =
        java.util.Collections.synchronizedList(new java.util.ArrayList<de.uka.ipd.sdq.sensorfactory.entities.TimeSpan>(
                10000));

    public de.uka.ipd.sdq.sensorfactory.entities.TimeSpan addTimeSpan(
        double p_timespan, double p_eventtime) {
        de.uka.ipd.sdq.sensorfactory.entities.TimeSpan result = new de.uka.ipd.sdq.sensorfactory.entities.impl.TimeSpanImpl();

        result.setTimeSpan(p_timespan);

        result.setEventTime(p_eventtime);

        m_timespans.add(result);

        return result;
    }

    public java.util.Collection<de.uka.ipd.sdq.sensorfactory.entities.TimeSpan> getTimespans() {
        return this.m_timespans;
    }
}
