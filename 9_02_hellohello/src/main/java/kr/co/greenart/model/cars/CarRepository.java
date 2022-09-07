package kr.co.greenart.model.cars;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public interface CarRepository {
	// 전체 목록
	public List<Car> getAll();
	
	// id로 검색하여 하나의 행 조회
	public Car getById(int id);
	
	// 추가
	public int add(Car car);
	
	// 자동차 목록 추가하기
	public int[] batchInsert(List<Car> list);
	
	// 수정
	public int update(Car car);
	
	// 삭제
	public int delete(int id);
}
