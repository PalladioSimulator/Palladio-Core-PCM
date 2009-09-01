package de.fzi.stanja.ui.preferences;

import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.jface.viewers.TableViewer;

public class AnalyzerCellModifier implements ICellModifier{

	private TableViewer tableviewer;
	@Override
	public boolean canModify(Object element, String property) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Object getValue(Object element, String property) {
		PreferenceAnalyzer analyzer = (PreferenceAnalyzer) element;
		if (property.equals("active"){
			return new Boolean(analyzer.isActive());
		}
		else {
			return null;
		}
	}

	@Override
	public void modify(Object element, String property, Object value) {
		PreferenceAnalyzer analyzer = (PreferenceAnalyzer) element;
		if (property == "active"){
			analyzer.setActive(Boolean.getBoolean((String) value));
			System.out.println("I was here");
		}
		else {
			
		}
		// TODO Auto-generated method stub
		
	}
