package org.oreilly.books.chapter9.observer;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Converter extends JFrame {
	public Converter() {
		CModel model = new CModel();
		setTitle("Currency converter");
		setLayout(new GridLayout(Currency.values().length + 1, 3));
		add(new JLabel("currency"));
		add(new JLabel("rate"));
		add(new JLabel("value"));
		for (Currency c : Currency.values()) {
			add(new JLabel(c.name()));
			add(new RateView(model, c));
			add(new ValueView(model, c));
		}
		model.initialize(1.0, 0.83, 0.56);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
	}

	public static void main(String[] args) {
		new Converter().setVisible(true);
	}
}
