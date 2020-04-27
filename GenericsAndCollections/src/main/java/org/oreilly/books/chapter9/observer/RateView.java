package org.oreilly.books.chapter9.observer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class RateView extends JTextField implements CView {
	private final CModel model;
	private final Currency currency;

	public RateView(final CModel model, final Currency currency) {
		this.model = model;
		this.currency = currency;
		addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double rate = Double.parseDouble(getText());
				model.setRate(currency, rate);
			}
		});
		model.addObserver(this);
	}

	@Override
	public void update(CModel model, Currency currency) {
		if (this.currency == currency) {
			double rate = model.getRate(currency);
			setText(String.format("%10.6f", rate));
		}
	}
}
