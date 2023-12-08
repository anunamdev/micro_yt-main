package com.question.QuestionService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.*;
import java.util.stream.Collectors;

@SpringBootTest
class QuestionServiceApplicationTests {

	@Test
	void contextLoads() {

		Hashtable<String, Integer> table = new Hashtable<>();
		table.put("A",1);
		table.put("B",2);
		table.put("C",3);
		table.put("D",4);
		table.put("E",5);
		table.put("F",6);
//		table.put(null,null);

		System.out.println(table);

		System.out.println("------------------------------------");
		HashMap<String, Integer> map = new HashMap<>();
		map.put("A",1);
		map.put("B",2);
		map.put("C",3);
		map.put("D",4);
		map.put("E",5);
		map.put("F",6);
		map.put(null,null);
		System.out.println(map);
		Object o = new Object();
		Assertions.assertEquals(1,1);
	}
	@Test
	void test1(){

		List<Integer> numbers = Arrays.asList(101, 20, 320, 40, 50, 610, 70);
		System.out.println("numbers"+numbers);
		List<Integer> collect = numbers.stream().sorted().collect(Collectors.toList());
		System.out.println("collect"+collect);
		Object[] nos = numbers.toArray();
		Arrays.sort(nos);
		List<Object> sort = Arrays.asList(nos);
		System.out.println("Sorted"+nos.toString());
		System.out.println("Sorted"+sort);

		Integer max = numbers.stream().max(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1-o2;
			}
		}).get();

		Integer min = numbers.stream().min(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return o1-o2;
			}
		}).get();

		System.out.println("max"+max);
		System.out.println("min"+min);

	}
}

