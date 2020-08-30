package at.ratbox.groceries_list.controller;

import at.ratbox.groceries_list.model.Grocery;
import at.ratbox.groceries_list.repository.GroceryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RESTController {
	@Autowired
	GroceryRepository groceryRepository;

	// Create a grocery listing
	@PostMapping("create")
	public Grocery createGrocery(@Validated @RequestBody Grocery grocery) {
		return groceryRepository.save(grocery);
	}
}
