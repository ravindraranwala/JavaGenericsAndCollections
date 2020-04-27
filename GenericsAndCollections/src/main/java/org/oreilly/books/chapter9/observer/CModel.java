package org.oreilly.books.chapter9.observer;

import java.util.EnumMap;
import java.util.Map;
import java.util.Observable;

public class CModel extends Observable<CModel, CView, Currency> {
	private final Map<Currency, Double> rates;
	private long value; // in cents

	public CModel() {
		rates = new EnumMap<Currency, Double>(Currency.class);
	}

	public void initialize(double... initialRates) {
		for (int i = 0; i < initialRates.length; i++)
			setRate(Currency.values()[i], initialRates[i]);
	}

	public void setRate(Currency c, double f) {
		rates.put(c, f);
		setChanged();
		notifyObservers(c);
	}

	public void setValue(Currency c, double v) {
		value = Math.round(v / getRate(c) * 100);
		setChanged();
		notifyObservers(null);
	}

	public double getRate(Currency c) {
		return rates.get(c);
	}

	public double getValue(Currency c) {
		return value * getRate(c) / 100;
	}
}
