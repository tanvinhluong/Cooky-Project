
package com.cookyplan.Cooky.controller;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cookyplan.Cooky.dao.CategoryDAO;
import com.cookyplan.Cooky.entity.Category;

@Transactional

@Controller
public class CategoryController {

	@Autowired
	SessionFactory factory;

	@Autowired
	CategoryDAO dao;

	@RequestMapping("/category/index")
	public String index(Model model) {
		Category entity = new Category();

		model.addAttribute("model", entity);

		return "category/index";
	}
}
