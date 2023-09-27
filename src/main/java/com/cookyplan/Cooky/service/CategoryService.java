
package com.cookyplan.Cooky.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cookyplan.Cooky.dao.CategoryDAO;
import com.cookyplan.Cooky.entity.Category;

@Service("categoryService")

@Transactional
public class CategoryService {

	@Autowired
	private CategoryDAO categoryDAO;

	public List<Category> getAllCategory() {
		return categoryDAO.getAllCategory();
	}

}
