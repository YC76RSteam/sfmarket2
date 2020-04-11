package com.yc.market.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductAction {

	@GetMapping({ "/prodcut" })
	public ModelAndView index(ModelAndView mav) {
		// 通过方法调用方式获取分类信息展示到主页面
		mav.setViewName("Product_Detailed");
		return mav;
	}
}
