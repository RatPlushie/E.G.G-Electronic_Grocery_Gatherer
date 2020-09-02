package at.ratbox.groceries_list.controller;

import at.ratbox.groceries_list.exceptions.ResourceNotFoundException;
import at.ratbox.groceries_list.model.Grocery;
import at.ratbox.groceries_list.repository.GroceryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class WebController {
	// Wiring up the repository for db access
	@Autowired
	GroceryRepository groceryRepository;

	// Index page display
	@RequestMapping("/")
	public String displayIndex(Model model) {
		// Retrieving the current table from the db
		List<Grocery> groceryList = groceryRepository.findAll();

		// Adding the list to a thymeleaf accessible attribute
		model.addAttribute("groceryList", groceryList);

		// Adding the Grocery class to the thymeleaf attributes
		model.addAttribute("newGrocery", new Grocery());

		return "index";
	}

	// Item creation
	@PostMapping("/create")
	public String createItem(@ModelAttribute("newGrocery") Grocery grocery) {
		// POST request validation
		if (grocery.getName().isEmpty() || grocery.getQuantity() == 0) {
			// TODO - write modal prompt for invalid form submission

			return "redirect:/";
		}

		groceryRepository.save(grocery);

		return "redirect:/";
	}

	// Item delete button
	@RequestMapping("/delete/{id}")
	public String deleteItem(@PathVariable(value = "id") long groceryID) {
		// Locating the correct item via id
		Grocery grocery = groceryRepository.findById(groceryID).orElseThrow(() -> new ResourceNotFoundException("Grocery", "Id", groceryID));

		// Removing it from the list
		groceryRepository.delete(grocery);

		// Returning to the grocery list
		return "redirect:/";
	}

	// Delete ALL button
	@RequestMapping("/deleteALL")
	public String deleteAllItems() {
		groceryRepository.deleteAll();

		return "redirect:/";
	}
}
