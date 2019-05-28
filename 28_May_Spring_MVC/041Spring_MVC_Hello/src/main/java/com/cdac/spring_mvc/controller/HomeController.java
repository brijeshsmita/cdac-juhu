/**
 * 
 */
package com.cdac.spring_mvc.controller;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cdac.spring_mvc.model.User;
import com.cdac.spring_mvc.model.UserRegister;

/**
 * @author Smita B Kumar
 *
 */
//spring bean supporting functionalities of a controller
//controller accept the request , forward it to the specific service
//and return MOdelAnd ViewName to the DispatcherServlet
@Controller
public class HomeController {
	
	@RequestMapping(value="/")
	public String getHomePage(Model model) {
		model.addAttribute("today", LocalDate.now());
		model.addAttribute("title", "Welcome to Spring MVC");
		return "home";//viewName
	}
	@RequestMapping(value="/index")
	public String getIndexPage(Model model) {
		model.addAttribute("msg", "Welcome to Spring MVC Index Page");
		return "index";//viewName
	}
	@RequestMapping(value="/about")
	public ModelAndView getAboutPage() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("info", "We love the world of Spring! Cdac Mumbai");
		mv.addObject("date", LocalDate.now());
		mv.setViewName("aboutPage");
		return mv;//viewName
	}
	@RequestMapping(value="/login")
	public String getLoginPage(Model model) {
		User user = new User();
		user.setUsername("Smita");
		user.setPassword("passwor@123");
		model.addAttribute("user", user);
		return "loginPage";
	}
	@RequestMapping(value="/checkLogin" , method=RequestMethod.POST)
	public String checkLogin(@ModelAttribute User user,Model model) {
		System.out.println("User values from spring form : "+user);
		String status=user.getStatus();
		String viewName="welcomePage";
		if(status.equals("Valid")) {			
			model.addAttribute("msg", "Login Successful");
			model.addAttribute("user", user);
			System.out.println("User Status : "+status);
			viewName="welcomePage";
			System.out.println("ViewName : "+viewName);
		}else if(status.equals("InValid")) {
			viewName="loginPage";
			System.out.println("User Status : "+status);
			model.addAttribute("msg", "Invalid Credentials, Kindly re-login!!");
			System.out.println("ViewName : "+viewName);
		}/*else {
			viewName="loginPage";
			System.out.println("User Status : "+status);
			model.addAttribute("msg", "Login Failed, Kindly re-login!!");
			System.out.println("ViewName : "+viewName);
		}	*/	
		return viewName;
	}
	//register
	@RequestMapping(value="/register")
	public String getRegisterPage(Model model) {
		UserRegister userRegister = new UserRegister();
		//userRegister.setCountry("INDIA");
		model.addAttribute("userRegister", userRegister);
		return "registerPage";
	}
	@RequestMapping(value="/registration" , method=RequestMethod.POST)
	public String registration(@ModelAttribute UserRegister userRegister ,Model model) {
		String viewName="registerSuccessPage";
		System.out.println("Register user values from spring form : "+userRegister);
		model.addAttribute("userRegister", userRegister);
		model.addAttribute("msg", "Registration Successful!!");
		/*String status=user.getStatus();
		
		if(status.equalsIgnoreCase("Valid")) {
			model.addAttribute("msg", "Login Successful");
			model.addAttribute("user", user);
			System.out.println("User Status : "+status);
			viewName="welcomePage";
		}else if(status.equalsIgnoreCase("InValid")) {
			System.out.println("User Status : "+status);
			model.addAttribute("msg", "Login Failed, Kindly re-login!!");
			viewName="loginPage";
		}*/
		return viewName;
	}

}
