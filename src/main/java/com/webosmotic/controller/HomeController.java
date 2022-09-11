package com.webosmotic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.webosmotic.model.CustomerDto;
import com.webosmotic.service.CustomerService;

@Controller
@RequestMapping("/registration")
public class HomeController {

	@Autowired
	private CustomerService customerService;

	@ModelAttribute("customer")
	public CustomerDto getCustomerDto() {
		return new CustomerDto();
	}

	@GetMapping
	public String registerFormView(Model model) {
		model.addAttribute("customer", new CustomerDto());
		return "registration";
	}

	@PostMapping
	public String registerCustomerAccount(@ModelAttribute("customer") CustomerDto customerDto) {
		customerService.save(customerDto);
		return "redirect:/registration?success";
	}
}
