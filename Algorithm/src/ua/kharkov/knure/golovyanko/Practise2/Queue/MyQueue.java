package ua.kharkov.knure.golovyanko.Practise2.Queue;

public interface MyQueue extends Iterable<Object> {
	void add(Object e);

	Object remove();

	Object peek();

	void clear();

	Object[] toArray();

	int size();

	boolean contains(Object o);

	boolean containsAll(MyQueue q);
}