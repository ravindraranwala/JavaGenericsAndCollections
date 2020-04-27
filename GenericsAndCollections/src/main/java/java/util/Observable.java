package java.util;

public class Observable<S extends Observable<S, O, A>, O extends Observer<S, O, A>, A> {
	public void addObserver(O o) {
		throw new UnsupportedOperationException();
	}

	protected void clearChanged() {
		throw new UnsupportedOperationException();
	}

	public int countObservers() {
		throw new UnsupportedOperationException();
	}

	public void deleteObserver(O o) {
		throw new UnsupportedOperationException();
	}

	public boolean hasChanged() {
		throw new UnsupportedOperationException();
	}

	public void notifyObservers() {
		throw new UnsupportedOperationException();
	}

	public void notifyObservers(A a) {
		throw new UnsupportedOperationException();
	}

	protected void setChanged() {
		throw new UnsupportedOperationException();
	}
}
