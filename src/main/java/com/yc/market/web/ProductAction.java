package com.yc.market.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.yc.market.bean.SfProduct;
import com.yc.market.biz.ProductBiz;

@Controller
public class ProductAction {

	@Resource
	private ProductBiz sfpbiz;
	/**
	 * 
	 * @param id
	 * @param page
	 * @param m
	 * @return
	 * 产品分类查询并且分页展示商城界面
	 * @throws Exception 
	 */
	@GetMapping("{product_list}")
	public String category(@RequestParam(defaultValue="1")Integer pageNum,
			@RequestParam(defaultValue="15") Integer pageSize,Model m) throws Exception {
		//调用service层来处理分页
		List<SfProduct> a = sfpbiz.getList(pageNum, pageSize);
		m.addAttribute("PL",a);
		return"products_list";
	}
}
