package edu.kit.ipd.sdq.simcomp.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.TableEditor;
import org.eclipse.swt.events.ModifyListener;
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

	private static String ANY_VALUE = "*";

	private IPCMModel model;
	private SimulationComponentType simCompType;
	private ModifyListener modificationListener;

	private Table tblCompositionRules;
	private Combo cmbDefaultComponent;
	private Button btnCreate;
	private Button btnDelete;
	private Button btnMoveUp;
	private Button btnMoveDown;

	public SimulationComponentRuleEditor(Composite parent, SimulationComponentType simCompType, ModifyListener modificationListener) {
		this.modificationListener = modificationListener;

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

		cmbDefaultComponent = new Combo(defaulSelection, SWT.READ_ONLY);
		cmbDefaultComponent.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));
		cmbDefaultComponent.setEnabled(false);
		cmbDefaultComponent.addModifyListener(modificationListener);
	}

	/**
	 * Creates the table for the rule editing
	 * 
	 * @param parent
	 */
	private void createRuleTable(Composite parent) {

		// create the basic table
		tblCompositionRules = new Table(parent, SWT.BORDER | SWT.MULTI);
		GridData gridData = new GridData(SWT.FILL, SWT.FILL, true, true);
		gridData.heightHint = 140;
		tblCompositionRules.setLayoutData(gridData);
		tblCompositionRules.setLinesVisible(true);
		tblCompositionRules.setHeaderVisible(true);

		// create the context field columns
		for (SimulationContextField contextField : this.simCompType.getContextFields()) {
			TableColumn column = new TableColumn(tblCompositionRules, SWT.NONE);
			column.setText(contextField.getName());
			column.setWidth(200);
		}
		// add selected component column
		TableColumn column = new TableColumn(tblCompositionRules, SWT.NONE);
		column.setText("Simulation Component");
		column.setWidth(200);

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
										modificationListener.modifyText(null);
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

		tblCompositionRules.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				int[] selection = tblCompositionRules.getSelectionIndices();
				// prevent user from moving if more than one item is selected
				if (tblCompositionRules.getItemCount() < 1 || selection.length != 1) {
					btnMoveUp.setEnabled(false);
					btnMoveDown.setEnabled(false);
					btnDelete.setEnabled(false);
					return;
				}

				// update move buttons enabled/disabled state
				int selectedIndex = selection[0];
				updateButtonsForSelection(selectedIndex);
			}

		});
	}

	private String[] getPossibleValuesForColumn(int column) {
		String[] possibleValues = new String[0];

		if (column < simCompType.getContextFields().size()) {
			// context field column selected
			List<String> possibleValueList = simCompType.getContextFields().get(column).getValueProvider().getPossibleValues(model);
			possibleValues = possibleValueList.toArray(new String[possibleValueList.size() + 1]);
			System.arraycopy(possibleValues, 0, possibleValues, 1, possibleValueList.size());
			possibleValues[0] = ANY_VALUE;

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
				createNewRuleItem(tblCompositionRules);

				tblCompositionRules.deselectAll();
				tblCompositionRules.setSelection(tblCompositionRules.getItems().length - 1);
				tblCompositionRules.setFocus();
				modificationListener.modifyText(null);
			}
		});

		btnDelete = new Button(parent, SWT.PUSH);
		btnDelete.setText("Delete Rule");
		btnDelete.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));
		btnDelete.setEnabled(false);
		btnDelete.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				tblCompositionRules.remove(tblCompositionRules.getSelectionIndices());
				modificationListener.modifyText(null);
			}
		});

		btnMoveUp = new Button(parent, SWT.PUSH);
		btnMoveUp.setText("Move Up");
		btnMoveUp.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));
		btnMoveUp.setEnabled(false);
		btnMoveUp.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int selectedIndex = tblCompositionRules.getSelectionIndices()[0];
				moveTableItem(tblCompositionRules, selectedIndex, selectedIndex - 1);
				modificationListener.modifyText(null);
			}
		});

		btnMoveDown = new Button(parent, SWT.PUSH);
		btnMoveDown.setText("Move Down");
		btnMoveDown.setLayoutData(new GridData(SWT.FILL, SWT.BEGINNING, true, false));
		btnMoveDown.setEnabled(false);
		btnMoveDown.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				int selectedIndex = tblCompositionRules.getSelectionIndices()[0];
				moveTableItem(tblCompositionRules, selectedIndex, selectedIndex + 1);
				modificationListener.modifyText(null);
			}
		});
	}

	/**
	 * Creates a new simulator composition rule entry with default values
	 * 
	 * @param table
	 */
	private void createNewRuleItem(Table table) {
		String[] values = new String[table.getColumnCount()];
		for (int i = 0; i < table.getColumnCount(); i++) {
			if (i < (table.getColumnCount() - 1)) {
				// field column
				values[i] = ANY_VALUE;
			} else {
				// component column
				values[i] = this.simCompType.getAvailableComponents().get(0).getName();
			}
		}

		TableItem item = new TableItem(table, SWT.NONE);
		item.setText(values);
	}

	/**
	 * Moves an item in the given table from a given index to specified target
	 * index.
	 * 
	 * @param table
	 * @param fromIndex
	 * @param toIndex
	 */
	public void moveTableItem(Table table, int fromIndex, int toIndex) {

		TableItem toItem = table.getItem(toIndex);
		String[] toValues = new String[table.getColumnCount()];
		for (int i = 0; i < toValues.length; i++) {
			toValues[i] = toItem.getText(i);
		}
		table.remove(toIndex);

		TableItem newItem = new TableItem(table, SWT.NONE, fromIndex);
		newItem.setText(toValues);

		table.select(toIndex);

		updateButtonsForSelection(toIndex);
	}

	/**
	 * Updates the enabled/disabled state of the move buttons depending on the
	 * selected index to prevent the user from moving border items out of the
	 * table.
	 * 
	 * @param selectedIndex
	 */
	private void updateButtonsForSelection(int selectedIndex) {
		btnDelete.setEnabled(true);
		
		if (tblCompositionRules.getItemCount() == 1) {
			btnMoveUp.setEnabled(false);
			btnMoveDown.setEnabled(false);
			
			return;
		}
		
		if (selectedIndex == 0) {
			btnMoveUp.setEnabled(false);
			btnMoveDown.setEnabled(true);

			return;
		}
		if (selectedIndex == (tblCompositionRules.getItemCount() - 1)) {
			btnMoveUp.setEnabled(true);
			btnMoveDown.setEnabled(false);

			return;
		}

		btnMoveUp.setEnabled(true);
		btnMoveDown.setEnabled(true);
	}

	/**
	 * Updates the default component configuration
	 * 
	 * @param simulationComponentMetaData
	 */
	public void updateDefaultComponent(SimulationComponentMetaData component) {
		if (component != null) {
			// TODO switch to something ID based
			String[] items = cmbDefaultComponent.getItems();
			for (int i = 0; i < items.length; i++) {
				if (items[i].equals(component.getName())) {
					cmbDefaultComponent.select(i);
					break;
				}
			}
		} else {
			cmbDefaultComponent.select(0);
		}
	}

	/**
	 * Returns the selected default component for the currently edited component
	 * type.
	 * 
	 * @return
	 */
	public SimulationComponentMetaData getDefaultComponent() {
		if (this.model == null) {
			return null;
		}

		if (cmbDefaultComponent.getSelectionIndex() > 0) {
			for (SimulationComponentMetaData component : this.simCompType.getAvailableComponents()) {
				if (component.getName().equals(cmbDefaultComponent.getItems()[cmbDefaultComponent.getSelectionIndex()])) {
					return component;
				}
			}
		}

		return null;
	}

	/**
	 * Updates the list of composition rules.
	 * 
	 * @param compositionRules
	 */
	public void updateCompositionRules(List<SimulatiorCompositonRule> compositionRules) {
		tblCompositionRules.clearAll();
		tblCompositionRules.setItemCount(0);

		if (compositionRules == null) {
			return;
		}

		for (SimulatiorCompositonRule rule : compositionRules) {
			TableItem ruleItem = new TableItem(tblCompositionRules, SWT.NONE);

			for (int i = 0; i < this.simCompType.getContextFields().size(); i++) {
				SimulationContextField contextField = this.simCompType.getContextFields().get(i);
				ruleItem.setText(i, rule.getFieldValues().get(contextField));
			}

			ruleItem.setText(this.simCompType.getContextFields().size(), rule.getComponent().getName());

		}
	}

	/**
	 * Returns the user configured simulator composition rules.
	 * 
	 * @return
	 */
	public List<SimulatiorCompositonRule> getCompositionRules() {
		List<SimulatiorCompositonRule> rules = new ArrayList<SimulatiorCompositonRule>();

		TableItem[] ruleTableItems = tblCompositionRules.getItems();
		// iterate over rule rows
		for (TableItem tableItem : ruleTableItems) {
			Map<SimulationContextField, String> fieldValues = new HashMap<SimulationContextField, String>();

			SimulationComponentMetaData selectedComponent = null;

			// iterate context field columns
			for (int i = 0; i < tblCompositionRules.getColumnCount(); i++) {
				if (i < (tblCompositionRules.getColumnCount() - 1)) {
					// field column
					SimulationContextField field = this.simCompType.getContextFields().get(i);
					fieldValues.put(field, tableItem.getText(i));
				} else {
					// component column
					for (SimulationComponentMetaData component : this.simCompType.getAvailableComponents()) {
						if (component.getName().equals(tableItem.getText(i))) {
							selectedComponent = component;
							break;
						}
					}
				}
			}

			rules.add(new SimulatiorCompositonRule(this.simCompType, fieldValues, selectedComponent));
		}

		return rules;
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
			this.cmbDefaultComponent.setEnabled(false);
		} else {
			this.tblCompositionRules.setEnabled(true);
			this.btnCreate.setEnabled(true);

			List<String> componentNames = new ArrayList<String>();
			for (SimulationComponentMetaData component : this.simCompType.getAvailableComponents()) {
				componentNames.add(component.getName());
			}
			this.cmbDefaultComponent.setItems(componentNames.toArray(new String[0]));
			this.cmbDefaultComponent.setEnabled(true);
		}
	}

}
