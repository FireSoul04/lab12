package it.unibo.es1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LogicsImpl implements Logics {

	private final List<Integer> values;

	public LogicsImpl(final int size) {
		if (size <= 0) {
			throw new IllegalArgumentException("List cannot have a size negative or zero");
		}
		this.values = new ArrayList<>(size);
		for (int i = 0; i < size; i++) {
			this.values.add(0);
		}
	}

	@Override
	public int size() {
		return this.values.size();
	}

	@Override
	public List<Integer> values() {
		return List.copyOf(this.values);
	}

	@Override
	public List<Boolean> enablings() {
		return this.values.stream()
			.map(t -> t < this.values.size())
			.toList();
	}

	@Override
	public int hit(final int elem) {
		final int buttonVal = this.values.get(elem) + 1;
		this.values.set(elem, buttonVal);
		return buttonVal;
	}

	@Override
	public String result() {
		return this.values.stream()
			.map(t -> Integer.toString(t))
			.collect(Collectors.joining("|", "<<", ">>"));
	}

	@Override
	public boolean toQuit() {
		return this.values.stream()
			.allMatch(t -> t == this.values.get(0));
	}
}
