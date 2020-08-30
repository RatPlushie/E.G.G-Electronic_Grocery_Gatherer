package at.ratbox.groceries_list.controller;

import at.ratbox.groceries_list.repository.GroceryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {
	// Wiring up the repository for db access
	@Autowired
	GroceryRepository groceryRepository;

	// Index page display
	@RequestMapping("/")
	public String displayIndex(Model model) {




		return "index";
	}



}
