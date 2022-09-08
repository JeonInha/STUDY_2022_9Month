package kr.co.greenart.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.greenart.model.car.Car;
import kr.co.greenart.model.car.CarService;

@Controller
@RequestMapping("/car")
@ResponseBody
public class CarController {
	private static Logger logger = LoggerFactory.getLogger(CarController.class);
	@Autowired
	private CarService service;

	@GetMapping
	public List<Car> view() {
		return service.list();
	}

	@GetMapping("/{id}")
	public Car carById(@PathVariable int id) {
		return service.getById(id);
	}

	@PostMapping
	public ResponseEntity<String> add(@RequestBody Car car) {
		logger.info(car.toString());
		service.add(car);
		
		return ResponseEntity.ok("{ \"result\" : \"ok\" }");
	}

	@PutMapping
	public ResponseEntity<String> update(@RequestBody Car car) {
		service.update(car);
		
		return ResponseEntity.ok("{ \"result\" : \"ok\" }");
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable int id) {
		service.delete(id);
		
		return ResponseEntity.ok("{ \"result\" : \"ok\" }");
	}
}




















