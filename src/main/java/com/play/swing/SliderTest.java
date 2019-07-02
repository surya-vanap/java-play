package com.play.swing;

import java.awt.BorderLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;

import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SliderTest {
	public static void main(String[] args) {
		final DecimalFormat df = new DecimalFormat("0.########");
		final JFrame frame = new JFrame();
		final JTextField text = new JTextField(20);
		final DoubleJSlider slider = new DoubleJSlider(0, 100, 0, 100, 10);
		slider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				text.setText(df.format(slider.getScaledValue()));
			}
		});
		text.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent ke) {
				String typed = text.getText();
				// slider.setValue(0);
				// if (!typed.matches("\\d+(\\.\\d*)?")) {
				// return;
				// }
				double value = (Double.parseDouble(typed) / 10.0) * slider.scale;
				slider.setValue((int) value);
			}
		});
		frame.setLayout(new BorderLayout());
		frame.add(text, BorderLayout.NORTH);
		frame.add(slider, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.pack();
		final Double doubleValue = 0.5;
		slider.setValue(doubleValue.intValue());
	}
}

class DoubleJSlider extends JSlider {
	private static final long serialVersionUID = 1L;
	final int scale;
	private double _maxValue;

	public DoubleJSlider(int min, int max, int value, int scale, double maxValue) {
		super(min, max, value);
		this.scale = scale;
		_maxValue = maxValue;
	}

	public double getScaledValue() {
		return ((double) super.getValue() * _maxValue) / this.scale;
	}
}