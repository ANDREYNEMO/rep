package ua.kharkov.knure.golovyanko.Practise2.Queue;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyQueueImpl implements MyQueue, ListIterable {
	private Object[] array;
	private int countQueue;

	public MyQueueImpl() {
		array = new Object[10];
		countQueue = 0;
	}

	public void add(Object e) {
		Object[] mas;
		if (array.length == countQueue) {
			mas = new Object[countQueue * 2];
			System.arraycopy(array, 0, mas, 0, array.length);
			array = mas;
		}
		array[countQueue] = e;
		countQueue++;

	}

	public Object remove() {
		if (countQueue == 0)
			throw new NoSuchElementException("Queue is empty");
		Object o = array[0];
		System.arraycopy(array, 1, array, 0, countQueue - 1);
		array[countQueue - 1] = null;
		countQueue--;
		return o;
	}

	public boolean remove(Object o) {
		for (int i = 0; i < countQueue; i++) {
			if (array[i].equals(o)) {
				System.arraycopy(array, i + 1, array, i, countQueue - (i + 1));
				array[countQueue - 1] = null;
				countQueue -= 1;
				return true;

			}
		}

		return false;
	}

	public Object peek() {
		if (countQueue == 0)
			throw new NoSuchElementException("Queue is empty");
		return array[0];
	}

	public void clear() {
		for (int i = 0; i < countQueue; i++)
			array[i] = null;
		countQueue = 0;
	}

	public Object[] toArray() {
		Object[] mas = new Object[countQueue];
		System.arraycopy(array, 0, mas, 0, countQueue);
		/*
		 * for (int i = 0; i < countQueue; i++) { mas[i] = array[i]; }
		 */
		return mas;
	}

	public int size() {
		return countQueue;
	}

	public boolean contains(Object o) {
		for (int i = 0; i < countQueue; i++) {
			if (array[i].equals(o)) {
				return true;
			}
		}
		return false;
	}

	public boolean containsAll(MyQueue q) {
		Object[] n = q.toArray();
		for (int i = 0; i < n.length; i++)
			if (!contains(n[i]))
				return false;
		return true;
	}

	public String toString() {
		String s = "{";
		for (int i = 0; i < countQueue; i++) {
			s += array[i];
			if (i != countQueue - 1) {
				s += ", ";
			} else
				s += "}";
		}
		return s;
	}

	public Iterator<Object> iterator() {
		return new IteratorImpl();
	}

	private class IteratorImpl implements Iterator<Object> {

		private int cursor = 0;
		protected int last = -1;
		protected Object curent;

		public boolean hasNext() {
			return cursor != size();
		}

		public Object next() {
			int j = cursor;
			if (j >= countQueue)
				throw new IllegalStateException();
			else {
				curent = array[last = j];
				cursor = j + 1;
				return curent;
			}
		}

		public void remove() {
			if (last < 0) {
				throw new IllegalStateException();
			}
			MyQueueImpl.this.remove(curent);
			if (last < cursor)
				cursor--;
			last = -1;
		}

	}

	public ListIterator listIterator() {
		return new ListIteratorImpl();
	}

	private class ListIteratorImpl extends IteratorImpl implements ListIterator {
		private int cursor = countQueue - 1;
		private int first = -1;


		public boolean hasPrevious() {
			return cursor != -1;
		}

		public Object previous() {
			int i = cursor;
			if (i < 0)
				throw new IllegalStateException();
			else {
				curent = array[first = i];
				cursor = i - 1;
				return curent;
			}
		}

		public void set(Object e) {
			if (first < 0) {
				throw new IllegalStateException();
			}
			array[first] = e;
			first = -1;
		}

		public void remove() {
			if (first < 0) {
				throw new IllegalStateException();
			}

			MyQueueImpl.this.remove(curent);
			if (last < cursor)
				cursor--;
			last = -1;
		}

	}
}
