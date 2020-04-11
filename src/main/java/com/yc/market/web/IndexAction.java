package com.yc.market.web;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.yc.market.bean.SfProduct;
import com.yc.market.bean.SfProductCategory;
import com.yc.market.bean.SfProductCategoryExample;
import com.yc.market.bean.SfProductExample;
import com.yc.market.dao.SfProductCategoryMapper;
import com.yc.market.dao.SfProductMapper;

@Controller
public class IndexAction {
	@Resource
	private SfProductMapper sm;
	@Resource
	private SfProductCategoryMapper scm;
	/**
	 * 查询所有的商品分类信息，并添加相关的关联查询
	 *	// 127.0.0.1:80/getPc
	 */
	@GetMapping("getPc")
	public List<SfProductCategory> getPc(){
		SfProductCategoryExample sce = new SfProductCategoryExample();
		sce.createCriteria().andTypeEqualTo(1);
		List<SfProductCategory> list = scm.selectByExample(sce);
		return list;
	}
	@GetMapping("hotgetPc")
	public List<SfProductCategory> hotgetPc(){
		SfProductCategoryExample sce = new SfProductCategoryExample();
		sce.createCriteria().andIconclassEqualTo("hot");
		List<SfProductCategory> list = scm.selectByExample(sce);
		return list;
	}
	@GetMapping("plate1Pc")
	public List<SfProductCategory> getPlate1(){
		SfProductCategoryExample sce = new SfProductCategoryExample();
		sce.createCriteria().andIconclassEqualTo("plate1");
		List<SfProductCategory> list = scm.selectByExample(sce);
		return list;
	}
	@GetMapping("plate2Pc")
	public List<SfProductCategory> getPlate2(){
		SfProductCategoryExample sce = new SfProductCategoryExample();
		sce.createCriteria().andIconclassEqualTo("plate2");
		List<SfProductCategory> list = scm.selectByExample(sce);
		return list;
	}
	@GetMapping("plate3Pc")
	public List<SfProductCategory> getPlate3(){
		SfProductCategoryExample sce = new SfProductCategoryExample();
		sce.createCriteria().andIconclassEqualTo("plate3");
		List<SfProductCategory> list = scm.selectByExample(sce);
		return list;
	}
	@GetMapping("plate4Pc")
	public List<SfProductCategory> getPlate4(){
		SfProductCategoryExample sce = new SfProductCategoryExample();
		sce.createCriteria().andIconclassEqualTo("plate4");
		List<SfProductCategory> list = scm.selectByExample(sce);
		return list;
	}
	@GetMapping("hotgetPr")
	public List<SfProduct> hotgetPr(){
		SfProductExample sp = new SfProductExample();
		sp.createCriteria().andStockGreaterThanOrEqualTo(500);
		List<SfProduct> list = sm.selectByExample(sp);
		return list;
	}
	@GetMapping({ "/", "index", "index.html" })
	public ModelAndView index(ModelAndView mav) {
		// 通过方法调用方式获取分类信息展示到主页面
		mav.addObject("pclist", getPc());
		mav.addObject("hotpclist", hotgetPc());
		mav.addObject("hotplist", hotgetPr());
		mav.addObject("plate1list", getPlate1());
		mav.addObject("plate2list", getPlate2());
		mav.addObject("plate3list", getPlate3());
		mav.addObject("plate4list", getPlate4());
		mav.setViewName("index");
		return mav;
	}

}
