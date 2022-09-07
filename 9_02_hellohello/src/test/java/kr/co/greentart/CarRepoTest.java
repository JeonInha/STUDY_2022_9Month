package kr.co.greentart;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Random;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import kr.co.greenart.model.cars.Car;
import kr.co.greenart.model.cars.CarRepository;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { kr.co.greenart.config.RootConfig.class })
public class CarRepoTest {

	@Autowired
	private CarRepository repository;

	@Test
	public void initTest() {
		assertNotNull(repository);
	}
	
	@BeforeClass
	// 테스트환경만들기
	public static void addTestData() {
		// 테스트 클래스 수행 전에 실행됨니다~~ 스태틱하게 선언
	}
	
	@Test
	public void create() {
		Random r = new Random();
		Car car = new Car("새모델" + r.nextInt(10000), 10);
		
		int result = repository.add(car);
		assertEquals(1, result);
	}
	
	@Test
	public void read() {
		List<Car> list = repository.getAll();
		assertNotNull(list);
	}
	
	@Test
	public void update() {
		int result = repository.update(new Car(1, "변경", 300));
		assertEquals(1, result);
		
	}
}
