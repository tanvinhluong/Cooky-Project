
package com.cookyplan.Cooky.admin.controller;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.cookyplan.Cooky.dao.IngredientsDAO;
import com.cookyplan.Cooky.entity.Ingredients;




@Transactional
@Controller
@RequestMapping("admin/ingredients")
public class IngredientsController {

	@Autowired
	SessionFactory factory;

	@Autowired
	IngredientsDAO dao;

	@RequestMapping("index")
	public String index(Model model) {
		Ingredients entity = new Ingredients();

		model.addAttribute("model", entity);
		model.addAttribute("list", dao.findAll());

		return "admin/ingredients/index";
	}
	
	@RequestMapping("edit/{id}")
	public String edit(Model model, @PathVariable("id") Integer id) {
		Ingredients entity = dao.findById(id);
		
		model.addAttribute("model", entity);
		model.addAttribute("list", dao.findAll()); // ???
		return "admin/ingredients/index";
	}
	
	@RequestMapping("insert")
	public String create(RedirectAttributes model,@ModelAttribute("entity") Ingredients entity) {
		dao.create(entity);
		model.addAttribute("message", "Thêm mới thành công!");
		return "redirect:/admin/ingredients/index";
	}
	
	@RequestMapping("update")
	public String update(RedirectAttributes model,@ModelAttribute("entity") Ingredients entity) {
		dao.update(entity);
		model.addAttribute("message", "Cập nhật thành công!");
		return "redirect:/admin/ingredients/edit/" +entity.getId();
	}
	
	@RequestMapping(value={"delete", "delete/{id}"})
	public String delete(RedirectAttributes model,
			@RequestParam(value="id", required=false) Integer id1, 
			@PathVariable(value="id",required=false) Integer id2) {
		if(id1 != null) {
			dao.delete(id1);
		}
		else {
			dao.delete(id2);
		}
		model.addAttribute("message", "Xóa thành công!");
		return "redirect:/admin/ingredients/index";
	
	}
	
}
