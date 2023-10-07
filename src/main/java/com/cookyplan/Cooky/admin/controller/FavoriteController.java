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

import com.cookyplan.Cooky.dao.FavoriteDAO;
import com.cookyplan.Cooky.entity.Favorite;

@Transactional
@Controller
@RequestMapping("admin/favorite")
public class FavoriteController {
	@Autowired
	SessionFactory factory;

	@Autowired
	FavoriteDAO dao;

	@RequestMapping("index")
	public String index(Model model) {
		Favorite entity = new Favorite();

		model.addAttribute("model", entity);
		model.addAttribute("list", dao.findAll());

		return "admin/favorite/index";
	}
	
	@RequestMapping("edit/{id}")
	public String edit(Model model, @PathVariable("id") Integer id) {
		Favorite entity = dao.findById(id);
		
		model.addAttribute("model", entity);
		model.addAttribute("list", dao.findAll()); // ???
		return "admin/favorite/index";
	}
	
	@RequestMapping("insert")
	public String create(RedirectAttributes model,@ModelAttribute("entity") Favorite entity) {
		dao.create(entity);
		model.addAttribute("message", "Thêm mới thành công!");
		return "redirect:/admin/favorite/index";
	}
	
	@RequestMapping("update")
	public String update(RedirectAttributes model,@ModelAttribute("entity") Favorite entity) {
		dao.update(entity);
		model.addAttribute("message", "Cập nhật thành công!");
		return "redirect:/admin/favorite/edit/" +entity.getId();
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
		return "redirect:/admin/favorite/index";
	
	}
}
