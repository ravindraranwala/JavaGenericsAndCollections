package org.oreilly.books.chapter9.observer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class ValueView extends JTextField implements CView {
	private final CModel model;
	private final Currency currency;

	public ValueView(final CModel model, final Currency currency) {
		this.model = model;
		this.currency = currency;
		addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double value = Double.parseDouble(getText());
				model.setValue(currency, value);
			}
		});
		model.addObserver(this);
	}

	@Override
	public void update(CModel model, Currency currency) {
		if (currency == null || currency == this.currency) {
			double value = model.getValue(this.currency);
			setText(String.format("%15.2f", value));
		}
	}
}
