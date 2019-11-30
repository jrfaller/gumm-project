package com.googlecode.gumm.flood;

import java.util.LinkedList;
import java.util.List;

/**
 * Gather and apply a list of filters on a mapping.
 * @author Jean-Rémy Falleri
 *
 */
public class FilterManager {

	private List<Filter> filters;

	private Alignment alignment;

	/**
	 * Builds a filter manager on the given alignment.
	 * @param alignment an alignment.
	 */
	public FilterManager(Alignment alignment) {
		this.alignment = alignment;
		this.filters = new LinkedList<Filter>();
	}

	/**
	 * Builds a filter manager on the given alignment using a given list of filters.
	 * @param alignment an alignment.
	 * @param filters a list of filters.
	 */
	public FilterManager(Alignment alignment,List<Filter> filters) {
		this(alignment);
		for(Filter f: filters)
			addFilter(f);
	}

	/**
	 * Adds a filter to the list of filters.
	 * @param f a filter.
	 */
	public void addFilter(Filter f) {
		f.setAlignment(alignment);
		filters.add(f);
	}

	/**
	 * Applies all the filters of the list.
	 */
	public void applyFilters() {
		for(Filter f: filters)
			f.filter();
	}

	/**
	 * Returns the alignment.
	 * @return the alignment.
	 */
	public Alignment getAlignment() {
		return this.alignment;
	}

}
