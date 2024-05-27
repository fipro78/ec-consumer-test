package org.fipro.ec_consumer_test.ec_consumer_main;

import org.fipro.ec_consumer_test.ec_consumer.CollectionsHelper;

public class SortInput {

	public static void main(String[] args) {
		CollectionsHelper.sort(args).forEach(System.out::println);
	}
	
}
