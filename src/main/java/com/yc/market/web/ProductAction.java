package com.yc.market.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
        //使用分页插件,核心代码就这一行
        PageHelper.startPage(pageNum, pageSize);
		//调用service层来处理分页
		List<SfProduct>  sf = sfpbiz.getList(pageNum, pageSize);
		System.out.println("===================="+sf.size());
		//使用PageInfo包装查询结果，只需要将pageInfo交给页面就可以
		PageInfo<SfProduct>  pageinfo = new PageInfo<>(sf,15);
		m.addAttribute("PL",sf);
		m.addAttribute("pageinfo",pageinfo);
		return"products_list";
	}
}
