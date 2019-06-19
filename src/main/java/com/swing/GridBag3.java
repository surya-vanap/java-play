package com.swing;

//file: GridBag4.java
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

public class GridBag3 extends JPanel {
	GridBagConstraints constraints = new GridBagConstraints();
	private final JPanel _panelToolBar = new JPanel();
	private final JPanel _panelIntervals = new JPanel();

	public GridBag3() {
		setLayout(new GridBagLayout());

		add(_panelToolBar, new GridBagConstraints(0, 0, 1, 1, 1.0, 0.0, GridBagConstraints.WEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));

		_panelToolBar.setLayout(new BorderLayout(0, 0));

		_panelToolBar.add(new JButton("one"), BorderLayout.WEST);
		_panelToolBar.add(new JButton("to"), BorderLayout.EAST);

		add(_panelIntervals, new GridBagConstraints(0, 1, 1, 1, 1.0, 1.0, GridBagConstraints.NORTHWEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
		GridBagLayout gbl_algorithmParmsPanel = new GridBagLayout();

		// gbl_algorithmParmsPanel.columnWidths = new int[] { 100, 50, 25};
		// gbl_algorithmParmsPanel.rowHeights = new int[] { 19, 135, 0 };
		// gbl_algorithmParmsPanel.columnWeights = new double[] { 0.0, 0.0,
		// 1.0};
		// gbl_algorithmParmsPanel.rowWeights = new double[] { 0.1, 0.1, 0.0,
		// 1.0};

		_panelIntervals.setLayout(gbl_algorithmParmsPanel);

		addParam(true, "min", 0);
		addParam(true, "max", 1);
	}

	private void addParam(boolean showCheck, String message, int gridy) {
		Dimension labelDimension = new Dimension(100, 24);
		Dimension valueDimension = new Dimension(75, 24);
		Dimension unitDimension = new Dimension(25, 24);

		JLabel param = new JLabel(message);

		_panelIntervals.add(param, new GridBagConstraints(0, gridy, 1, 1, 0.0, 0.0, GridBagConstraints.FIRST_LINE_START,
				GridBagConstraints.HORIZONTAL, new Insets(10, 0, 0, 0), 0, 0));

		if (showCheck) {
			JSlider _valueSlider = new JSlider();
			_valueSlider.setMinimum(1);
			_valueSlider.setMaximum(10);
			_valueSlider.setSnapToTicks(true);
			_valueSlider.setValue(4);
			_valueSlider.setMajorTickSpacing(1);
			_valueSlider.setMinorTickSpacing(1);
			_valueSlider.setPaintTicks(true);
			_valueSlider.setPaintLabels(true);

			_panelIntervals.add(_valueSlider,
					new GridBagConstraints(1, gridy, 1, 1, 0.0, 0.0, GridBagConstraints.FIRST_LINE_START,
							GridBagConstraints.HORIZONTAL, new Insets(0, 10, 0, 10), 0, 0));
		}

		JLabel param2 = new JLabel("");

		_panelIntervals.add(param2, new GridBagConstraints(0, gridy, 1, 1, 1.0, 0.0,
				GridBagConstraints.FIRST_LINE_START, GridBagConstraints.HORIZONTAL, new Insets(10, 0, 0, 0), 0, 0));
	}

	public class GridBag4 extends JPanel {
		public GridBag4() {
			JPanel panel = new GridBag4();
			// _conformanceQQSPanel.setVisible(false);
			add(panel, new GridBagConstraints(0, 0, 1, 1, 1.0, 1.0, GridBagConstraints.WEST, GridBagConstraints.BOTH,
					new Insets(0, 0, 0, 0), 0, 0));
		}
	}

	void addGB(Component component, int x, int y) {
		constraints.gridx = x;
		constraints.gridy = y;
		add(component, constraints);
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("GridBag4");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 100);
		frame.setLocation(200, 200);
		frame.setContentPane(new GridBag3());
		frame.setVisible(true);
	}
}