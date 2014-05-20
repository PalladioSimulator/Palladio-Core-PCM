package edu.kit.ipd.sdq.simcomp.ui;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;

import edu.kit.ipd.sdq.simcomp.component.IPCMModel;
import edu.kit.ipd.sdq.simcomp.component.meta.SimulationComponentMetaData;
import edu.kit.ipd.sdq.simcomp.component.meta.SimulationComponentType;
import edu.kit.ipd.sdq.simcomp.component.meta.SimulationContextField;
import edu.kit.ipd.sdq.simcomp.middleware.simulation.config.SimulatiorCompositonRule;

public class SimulationComponentRuleEditor {

	private IPCMModel model;
	private SimulationComponentType simCompType;

	private Table tblCompositionRules;
	private Combo cmbDefaultComponent;
	private Button btnCreate;
	private Button btnDelete;
	private Button btnMoveUp;
	private Button btnMoveDown;

	public SimulationComponentRuleEditor(Composite parent, SimulationComponentType simCompType) {

		this.simCompType = simCompType;

		final Group simCompTypeGroup = new Group(parent, SWT.NONE);
		simCompTypeGroup.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));
		simCompTypeGroup.setText(simCompType.getName());
		simCompTypeGroup.setLayout(new GridLayout(2, false));

		final Composite tableContainer = new Composite(simCompTypeGroup, SWT.NONE);
		tableContainer.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		tableContainer.setLayout(new GridLayout(1, false));

		this.createDefaultComponentSelection(tableContainer);

		this.createRuleTable(tableContainer);

		final Composite controls = new Composite(simCompTypeGroup, SWT.NONE);
		controls.setLayout(new GridLayout(1, false));

		this.createControls(controls);
	}

	/**
	 * Creates the controls for the default component selection.
	 * 
	 * @param parent
	 */
	private void createDefaultComponentSelection(Composite parent) {
		Composite defaulSelection = new Composite(parent, SWT.NONE);
		defaulSelection.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));
		defaulSelection.setLayout(new GridLayout(2, false));

		final Label label = new Label(defaulSelection, SWT.NONE);
		label.setText("Default component:");

		List<String> componentNames = new ArrayList<String>();
		for (SimulationComponentMetaData component : this.simCompType.getAvailableComponents()) {
			componentNames.add(component.getName());
		}

		cmbDefaultComponent = new Combo(defaulSelection, SWT.READ_ONLY);
		cmbDefaultComponent.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));
		cmbDefaultComponent.setItems(componentNames.toArray(new String[0]));
	}

	/**
	 * Creates the table for the rule editing
	 * 
	 * @param parent
	 */
	private void createRuleTable(Composite parent) {

		// create the basic table
		tblCompositionRules = new Table(parent, SWT.BORDER | SWT.MULTI);
		tblCompositionRules.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		tblCompositionRules.setLinesVisible(true);
		tblCompositionRules.setHeaderVisible(true);

		// create the context field columns
		for (SimulationContextField ctxType : this.simCompType.getContextFields()) {
			TableColumn column = new TableColumn(tblCompositionRules, SWT.NONE);
			column.setText(ctxType.getName());
			column.setWidth(200);
		}
		// add selected component column
		TableColumn column = new TableColumn(tblCompositionRules, SWT.NONE);
		column.setText("Simulation Component");
		column.setWidth(200);

		for (int i = 0; i < 3; i++) {
			TableItem item = new TableItem(tblCompositionRules, SWT.NONE);
			item.setText(new String[] { "*", "*", "*" });
		}

		final TableEditor editor = new TableEditor(tblCompositionRules);
		editor.horizontalAlignment = SWT.LEFT;
		editor.grabHorizontal = true;
		editor.minimumWidth = 50;

		tblCompositionRules.addListener(SWT.MouseDown, new Listener() {
			@Override
			public void handleEvent(Event event) {
				Rectangle clientArea = tblCompositionRules.getClientArea();
				Point pt = new Point(event.x, event.y);
				int index = tblCompositionRules.getTopIndex();
				while (index < tblCompositionRules.getItemCount()) {
					boolean visible = false;
					final TableItem item = tblCompositionRules.getItem(index);
					for (int i = 0; i < tblCompositionRules.getColumnCount(); i++) {
						Rectangle rect = item.getBounds(i);

						if (rect.contains(pt)) {
							final int column = i;

							final Combo combo = new Combo(tblCompositionRules, SWT.READ_ONLY);
							combo.setItems(getPossibleValuesForColumn(column));
							combo.select(0); // TODO (SimComp): If row has value
												// select the value

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

	private String[] getPossibleValuesForColumn(int column) {
		String[] possibleValues = new String[0];

		if (column < simCompType.getContextFields().size()) {
			// context field column selected
			List<String> possibleValueList = simCompType.getContextFields().get(column).getPossibleValues();
			possibleValues = possibleValueList.toArray(new String[possibleValueList.size() + 1]);
			System.arraycopy(possibleValues, 0, possibleValues, 1, possibleValueList.size());
			possibleValues[0] = "*";

			return possibleValues;
		} else {
			// simulation component field selected
			List<SimulationComponentMetaData> components = simCompType.getAvailableComponents();
			possibleValues = new String[components.size()];
			for (int j = 0; j < components.size(); j++) {
				possibleValues[j] = components.get(j).toString();
			}

			return possibleValues;
		}
	}

	/**
	 * Creates the controls which create, delete or modify a rules position.
	 * 
	 * @param parent
	 */
	private void createControls(Composite parent) {
		btnCreate = new Button(parent, SWT.PUSH);
		btnCreate.setText("Create Rule");
		btnCreate.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));
		btnCreate.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				TableItem item = new TableItem(tblCompositionRules, SWT.NONE);
				item.setText(new String[] { "*", "*", "*" });

				tblCompositionRules.deselectAll();
				tblCompositionRules.select(tblCompositionRules.getItems().length - 1);
				tblCompositionRules.setFocus();
			}
		});

		btnDelete = new Button(parent, SWT.PUSH);
		btnDelete.setText("Delete Rule");
		btnDelete.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));
		btnDelete.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				tblCompositionRules.remove(tblCompositionRules.getSelectionIndices());
			}
		});

		btnMoveUp = new Button(parent, SWT.PUSH);
		btnMoveUp.setText("Move Up");
		btnMoveUp.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));

		btnMoveDown = new Button(parent, SWT.PUSH);
		btnMoveDown.setText("Move Down");
		btnMoveDown.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));
	}

	/**
	 * Updates the default component configuration
	 * 
	 * @param simulationComponentMetaData
	 */
	public void updateDefaultComponent(SimulationComponentMetaData simulationComponentMetaData) {
		System.out.println("updateDefaultComponent");
		// TODO (SimComp): update the default component control
	}

	/**
	 * Returns the selected default component for the currently edited component
	 * type.
	 * 
	 * @return
	 */
	public SimulationComponentMetaData getDefaultComponent() {
		System.out.println("getDefaultComponent");
		// TODO (SimComp): return the selected default component
		return null;
	}

	/**
	 * Updates the list of composition rules.
	 * 
	 * @param compositionRules
	 */
	public void updateCompositionRules(List<SimulatiorCompositonRule> compositionRules) {
		System.out.println("updateCompositionRules");
		// TODO (SimComp): update the composition rules table
	}

	/**
	 * Returns the user configured simulator composition rules.
	 * 
	 * @return
	 */
	public List<SimulatiorCompositonRule> getCompositionRules() {
		System.out.println("getCompositionRules");
		// TODO (SimComp): return the composition rules
		return null;
	}

	/**
	 * Updates the user specified PCM model.
	 * 
	 * @param pcmModel
	 *            A loaded PCM model or null if the user deselected it
	 */
	public void updatePCMModel(IPCMModel model) {
		this.model = model;

		if (model == null) {
			this.tblCompositionRules.setEnabled(false);
			this.btnCreate.setEnabled(false);
			this.btnDelete.setEnabled(false);
			this.btnMoveUp.setEnabled(false);
			this.btnMoveDown.setEnabled(false);
		} else {
			this.tblCompositionRules.setEnabled(true);
			this.btnCreate.setEnabled(true);
			this.btnDelete.setEnabled(true);
			this.btnMoveUp.setEnabled(true);
			this.btnMoveDown.setEnabled(true);
		}
	}

}
