package com.springmvc.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.springmvc.dao.KullaniciDAO;
import com.springmvc.entity.Kullanici;

@Controller
@RequestMapping("/kullanici")
public class KullaniciController {
	
	@Autowired
	private KullaniciDAO kullaniciDAO;

	@GetMapping({"/", "/home", "/index",""})
	public ModelAndView home() {
		return new ModelAndView("kullanici/home");
	}
	
	@GetMapping("/add")
	public ModelAndView Add(Model model) {
		model.addAttribute("kullanici",new Kullanici());
		return new ModelAndView("kullanici/add");
	}
	
	@PostMapping("/add")
	public ModelAndView Add(@Valid @ModelAttribute("kullanici") Kullanici kullanici, BindingResult result, Model model) {
		if(result.hasErrors()) 
			return new ModelAndView("kullanici/add");
		else {
			kullaniciDAO.saveOrUpdate(kullanici);
			return new ModelAndView("redirect:/kullanici/list");
		}
	}
	
	@GetMapping(value="/delete{id}")
	public ModelAndView Delete(@RequestParam("id") int id, Model model) {
		Kullanici c=kullaniciDAO.find(id);
		if(c==null) {
			model.addAttribute("msg","Belirtilen yetki bulunamadı");
			return new ModelAndView("kullanici/list");
		}
		kullaniciDAO.remove(c);
		model.addAttribute("msg", "1");
		ModelAndView mv=new ModelAndView("redirect:/kullanici/list");
		return mv;
	}
	
	@GetMapping(value="/edit{id}")
	public ModelAndView Edit(@RequestParam("id") int id, Model model) {
		Kullanici c=kullaniciDAO.find(id);
		if(c==null) {
			model.addAttribute("msg","0");
			return new ModelAndView("kullanici/list");
		}
		model.addAttribute("kullanici", c);
		ModelAndView mv=new ModelAndView("kullanici/add");
		return mv;
	}
	
	@GetMapping({"/list"})
	public ModelAndView home(Model model) {
		model.addAttribute("kullanici", kullaniciDAO.getAll());
		return new ModelAndView("kullanici/list");
	}
}
