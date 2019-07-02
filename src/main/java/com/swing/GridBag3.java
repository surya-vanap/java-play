package com.swing;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class GridBag3 extends JPanel {
	private static final long serialVersionUID = 2957839971021687243L;
	private final JPanel _panelToolBar = new JPanel();
	private final JPanel _panelIntervals = new JPanel();

	public GridBag3() {
		// setMinimumSize(new Dimension(200, 300));
		// setPreferredSize(new Dimension(300, 400));
		GridBagLayout gbl_mainPanel = new GridBagLayout();
		gbl_mainPanel.columnWidths = new int[] { 200 };
		gbl_mainPanel.rowHeights = new int[] { 0, 200 };
		gbl_mainPanel.columnWeights = new double[] { 1.0 };
		gbl_mainPanel.rowWeights = new double[] { 0.0, 1.0 };
		setLayout(gbl_mainPanel);

		add(_panelToolBar, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0, GridBagConstraints.NORTHWEST,
				GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));

		_panelToolBar.setLayout(new BorderLayout(0, 0));
		JButton btn = new JButton("one");
		JCheckBox cb = new JCheckBox();
		cb.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					System.out.println("HERE");
				}

			}
		});
		cb.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {

				System.out.println("HERE");
			}
		});
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cb.setSelected(!cb.isSelected());

			}
		});
		_panelToolBar.add(btn, BorderLayout.WEST);
		_panelToolBar.add(cb, BorderLayout.EAST);

		add(_panelIntervals, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.NORTHWEST,
				GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
		GridBagLayout gbl_algorithmParmsPanel = new GridBagLayout();

		// gbl_algorithmParmsPanel.columnWidths = new int[] { 100, 50, 25};
		// gbl_algorithmParmsPanel.rowHeights = new int[] { 19, 135, 0 };
		// gbl_algorithmParmsPanel.columnWeights = new double[] { 0.0, 0.0,
		// 1.0};
		// gbl_algorithmParmsPanel.rowWeights = new double[] { 0.1, 0.1, 0.0,
		// 1.0};

		_panelIntervals.setLayout(gbl_algorithmParmsPanel);

		addParam(true, "min", 0);
		addParam(false, "max", 1);
	}

	private void addParam(boolean showCheck, String message, int gridy) {
		Dimension labelDimension = new Dimension(100, 24);
		Dimension valueDimension = new Dimension(200, 24);
		Dimension unitDimension = new Dimension(200, 24);

		JLabel param = new JLabel(message);
		param.setPreferredSize(labelDimension);
		param.setMinimumSize(labelDimension);
		_panelIntervals.add(param, new GridBagConstraints(0, gridy, 1, 1, 0.7, 0.0, GridBagConstraints.FIRST_LINE_START,
				GridBagConstraints.HORIZONTAL, new Insets(10, 0, 0, 0), 0, 0));

		if (showCheck) {
			JSlider valueSlider = new JSlider();
			valueSlider.setMinimum(1);
			valueSlider.setMaximum(10);
			valueSlider.setSnapToTicks(true);
			valueSlider.setValue(4);
			valueSlider.setMajorTickSpacing(1);
			valueSlider.setMinorTickSpacing(1);
			valueSlider.setPaintTicks(true);
			valueSlider.setPaintLabels(true);
			valueSlider.setPreferredSize(valueDimension);
			valueSlider.setMinimumSize(valueDimension);
			_panelIntervals.add(valueSlider,
					new GridBagConstraints(1, gridy, 1, 1, 0.3, 0.0, GridBagConstraints.FIRST_LINE_START,
							GridBagConstraints.HORIZONTAL, new Insets(0, 10, 0, 10), 0, 0));
		} else {
			JCheckBox cb = new JCheckBox();
			cb.setMinimumSize(unitDimension);
			_panelIntervals.add(cb,
					new GridBagConstraints(1, gridy, 1, 1, 0.3, 0.0, GridBagConstraints.FIRST_LINE_START,
							GridBagConstraints.HORIZONTAL, new Insets(0, 10, 0, 10), 0, 0));
		}
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("GridBag4");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// frame.setSize(300, 100);
		// frame.setLocation(200, 200);
		JScrollPane scrollPaneGridDefPanel = new JScrollPane();
		scrollPaneGridDefPanel.setViewportBorder(null);
		// scrollPaneGridDefPanel.setPreferredSize(new Dimension(630, 300));
		// scrollPaneGridDefPanel.setMinimumSize(new Dimension(385, 240));

		scrollPaneGridDefPanel.setViewportView(new GridBag3());

		frame.setContentPane(scrollPaneGridDefPanel);
		frame.setVisible(true);
		frame.pack();
	}
}