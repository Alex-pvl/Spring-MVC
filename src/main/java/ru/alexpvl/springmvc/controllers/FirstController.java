package ru.alexpvl.springmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.jws.WebParam;

@Controller
@RequestMapping("/first")
public class FirstController {

	@GetMapping("/hello")
	public String helloPage(@RequestParam(value = "name", required = false) String name,
													@RequestParam(value = "surname", required = false) String surname,
													Model model) {

		model.addAttribute("message", "Hello, " + name + " " + surname);

		return "first/hello";
	}

	@GetMapping("/goodbye")
	public String goodByePage() {
		return "first/goodbye";
	}

	@GetMapping("/calculator")
	public String calculate(@RequestParam("a") int a,
													@RequestParam("b") int b,
													@RequestParam("action") String action,
													Model model) {

		String res = "";

		switch (action) {
			case "multiplication":
				res += a * b;
				break;
			case "addition":
				res += a + b;
				break;
			case "subtraction":
				res += a - b;
				break;
			case "division":
				if (b != 0) {
					res += a / b;
				} else {
					res = "Exception: division by zero!";
				}
				break;
		}
		model.addAttribute("result", a + " " + action + " " + b + " = " + res);
		return "first/calculator";
	}

}
