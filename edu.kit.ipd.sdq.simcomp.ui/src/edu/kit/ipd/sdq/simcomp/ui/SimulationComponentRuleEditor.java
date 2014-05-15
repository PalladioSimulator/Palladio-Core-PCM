package edu.kit.ipd.sdq.simcomp.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

import edu.kit.ipd.sdq.simcomp.ui.data.SimulationComponentType;
import edu.kit.ipd.sdq.simcomp.ui.data.SimulationContextField;

public class SimulationComponentRuleEditor {

	private SimulationComponentType simCompType;

	public SimulationComponentRuleEditor(Composite parent, SimulationComponentType simCompType) {

		this.simCompType = simCompType;

		final Group simCompTypeGroup = new Group(parent, SWT.NONE);
		simCompTypeGroup.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));
		simCompTypeGroup.setText(simCompType.getTitle());
		simCompTypeGroup.setLayout(new GridLayout(2, false));

		this.createRuleTable(simCompTypeGroup);

		final Composite controls = new Composite(simCompTypeGroup, SWT.NONE);
		controls.setLayout(new GridLayout(1, false));

		this.createControls(controls);
	}

	/**
	 * Creates the table for the rule editing
	 * 
	 * @param parent
	 */
	private void createRuleTable(Composite parent) {

		// create the basic table
		final Table table = new Table(parent, SWT.BORDER | SWT.MULTI);
		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		table.setLinesVisible(true);
		table.setHeaderVisible(true);

		// create the context field columns
		for (SimulationContextField ctxType : this.simCompType.getContextFields()) {
			TableColumn column = new TableColumn(table, SWT.NONE);
			column.setText(ctxType.getTitle());
			column.setWidth(200);
		}
		// add selected component column
		TableColumn column = new TableColumn(table, SWT.NONE);
		column.setText("Simulation Component");
		column.setWidth(200);

		for (int i = 0; i < 3; i++) {
			TableItem item = new TableItem(table, SWT.NONE);
			item.setText(new String[] { "" + i, "" + i, "" + i });
		}

		final TableEditor editor = new TableEditor(table);
		editor.horizontalAlignment = SWT.LEFT;
		editor.grabHorizontal = true;
		editor.minimumWidth = 50;

		table.addListener(SWT.MouseDown, new Listener() {
			@Override
			public void handleEvent(Event event) {
				Rectangle clientArea = table.getClientArea();
				Point pt = new Point(event.x, event.y);
				int index = table.getTopIndex();
				while (index < table.getItemCount()) {
					boolean visible = false;
					final TableItem item = table.getItem(index);
					for (int i = 0; i < table.getColumnCount(); i++) {
						Rectangle rect = item.getBounds(i);

						if (rect.contains(pt)) {
							final int column = i;

							final Combo combo = new Combo(table, SWT.READ_ONLY);
							combo.setItems(new String[] { "Value 1", "Value 2", "Value 3", "Value 4" });

							Listener comboListener = new Listener() {
								@Override
								public void handleEvent(final Event e) {
									switch (e.type) {
									case SWT.FocusOut:
										item.setText(column, combo.getText());
										combo.dispose();
										break;
									case SWT.Traverse:
										switch (e.detail) {
										case SWT.TRAVERSE_RETURN:
											item.setText(column, combo.getText());
											// FALL THROUGH
										case SWT.TRAVERSE_ESCAPE:
											combo.dispose();
											e.doit = false;
										}
										break;
									}
								}
							};

							combo.addListener(SWT.FocusOut, comboListener);
							combo.addListener(SWT.Traverse, comboListener);
							editor.setEditor(combo, item, i);

							combo.setText(item.getText(i));
							combo.setFocus();

							return;
						}
						if (!visible && rect.intersects(clientArea)) {
							visible = true;
						}
					}
					if (!visible)
						return;
					index++;
				}
			}
		});
	}

	/**
	 * Creates the controls which create, delete or modify a rules position.
	 * 
	 * @param parent
	 */
	private void createControls(Composite parent) {
		final Button btnCreate = new Button(parent, SWT.PUSH);
		btnCreate.setText("Create Rule");
		btnCreate.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));

		final Button btnDelete = new Button(parent, SWT.PUSH);
		btnDelete.setText("Delete Rule");
		btnDelete.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));

		final Button btnMoveUp = new Button(parent, SWT.PUSH);
		btnMoveUp.setText("Move Up");
		btnMoveUp.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));

		final Button btnMoveDown = new Button(parent, SWT.PUSH);
		btnMoveDown.setText("Move Down");
		btnMoveDown.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));
	}

}
