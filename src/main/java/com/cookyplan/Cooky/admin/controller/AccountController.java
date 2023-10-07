package com.cookyplan.Cooky.admin.controller;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cookyplan.Cooky.dao.AccountDAO;
import com.cookyplan.Cooky.entity.Account;

@Transactional
@Controller
@RequestMapping("admin/account")
public class AccountController {
	@Autowired
	SessionFactory factory;
	
	@Autowired
	AccountDAO dao;
	
	@RequestMapping("index")
	public String index(Model model) {
		Account entity = new Account();		
		model.addAttribute("model", entity);
		model.addAttribute("list", getItems());		
		return "admin/account/index";
	}
	
	@RequestMapping("edit/{id}")
	public String edit(Model model, @PathVariable("id") Integer id) {
		Account entity = dao.findById(id);
		
		model.addAttribute("model", entity);
		model.addAttribute("list", dao.findAll());
		return "admin/account/index";
	}
	
	@RequestMapping("insert")
	public String create(RedirectAttributes model, @ModelAttribute("entity") Account entity) {
		dao.create(entity);
		model.addAttribute("message", "Thêm mới thành công!");
		return "redirect:/admin/account/index";
	}
	
	@RequestMapping("update")
	public String update(RedirectAttributes model, @ModelAttribute("entity") Account entity) {
		dao.update(entity);
		model.addAttribute("message", "Cập nhật thành công!");
		return "redirect:/admin/account/edit/" +entity.getId();
	}
	
	@RequestMapping(value= {"delete","delete/{id}"})
	public String delete(RedirectAttributes model,
			@RequestParam(value="id", required=false) Integer id1,
			@RequestParam(value="id", required=false) Integer id2) {
		if(id1 != null) {
			dao.delete(id1);
		}
		else {
			dao.delete(id2);
		}
		model.addAttribute("message", "Xóa thành công!");
		return "redirect:/admin/account/index";
	}
	public List<Account> getItems() {
		Session session = factory.getCurrentSession();
		String hql = "FROM Account";
		Query query = session.createQuery(hql);
		List<Account> list = query.list();
		return list;
	}
}
