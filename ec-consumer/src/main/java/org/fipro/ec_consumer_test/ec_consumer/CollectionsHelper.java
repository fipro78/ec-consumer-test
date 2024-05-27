package org.fipro.ec_consumer_test.ec_consumer;

import java.util.List;

import org.eclipse.collections.api.factory.Lists;
import org.eclipse.collections.api.list.MutableList;

public final class CollectionsHelper {

	private CollectionsHelper() {}
	
	public static List<String> sort(String... inputs) {
		MutableList<String> inputList = Lists.mutable.of(inputs);
		return inputList.sortThis();
	}
	
}
