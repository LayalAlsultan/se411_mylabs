package se.edu.psu.se411.ch07.demo02.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import se.edu.psu.se411.ch07.demo02.model.Item;

@RestController
@RequestMapping("/api/v1/items")
public class ItemController {

	private List<Item> items = Arrays.asList(
				new Item(1, "computer"),
				new Item(2, "smartphone")
			);
	
	@GetMapping
	public List<Item> findAll() {
		return items;
	}
	
}
