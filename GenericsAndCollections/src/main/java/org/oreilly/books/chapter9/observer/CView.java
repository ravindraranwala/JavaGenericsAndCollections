package org.oreilly.books.chapter9.observer;

import java.util.Observer;

public interface CView extends Observer<CModel,CView,Currency> {

}
