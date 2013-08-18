package ua.kharkov.knure.golovyanko.Practise2.Queue;

import java.util.Iterator;

public interface ListIterator extends Iterator<Object> {
	boolean hasPrevious();

	Object previous();

	void set(Object e);

	void remove();
}
