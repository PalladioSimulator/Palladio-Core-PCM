/**
 * 
 */
package de.fzi.se.quality.qualityannotation.provider;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.edit.provider.ViewerNotification;

import util.Helper;
import de.fzi.se.quality.qualityannotation.QualityAnnotationPackage;
import de.fzi.se.quality.qualityannotation.REPrecision;

/**Text(REPrecision,x,y): NoC=x CP=y;
 * @author groenda
 *
 */
public class DetailedREPrecisionItemProvider extends REPrecisionItemProvider {
	public DetailedREPrecisionItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	@Override
	public String getText(Object object) {
		StringBuilder text = new StringBuilder();
		REPrecision target = (REPrecision) object;
		if (target.getDefaultPrecisionNumberOfCalls() != null) {
			text.append("NoC=(" + Helper.getText(adapterFactory, target.getDefaultPrecisionNumberOfCalls()) + ")");
		}
		if (target.getDefaultPrecisionCallParameter() != null) {
			if (text.length() > 0) text.append(" ");
			text.append("CP=(" + Helper.getText(adapterFactory, target.getDefaultPrecisionCallParameter()) + ")");
		}
		return text.toString();
	}
	
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(REPrecision.class)) {
			case QualityAnnotationPackage.RE_PRECISION__DEFAULT_PRECISION_CALL_PARAMETER:
			case QualityAnnotationPackage.RE_PRECISION__DEFAULT_PRECISION_NUMBER_OF_CALLS:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}
}
