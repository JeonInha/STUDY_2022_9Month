package kr.co.greenart;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Repository;


@Repository("mylist")
public class MySetRepository implements MyDataRepository {

	@Override
	public Iterable<Integer> getMyNumbers() {
		Set<Integer> list = new HashSet<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		return list;
	}

}
