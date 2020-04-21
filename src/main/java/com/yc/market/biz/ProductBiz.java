package com.yc.market.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yc.market.bean.SfProduct;
import com.yc.market.bean.SfProductExample;
import com.yc.market.dao.SfProductMapper;

@Service
@Transactional(rollbackFor = { RuntimeException.class, Exception.class })
public class ProductBiz {

	// 数据访问
    @Autowired
    private SfProductMapper sfpm;
    
    private SfProductExample se;

    /**
     * 
     * @Title: getList
     * @Description: 从数据库中获取所有商品列表的集合
     * @param pageNum 当前页
     * @param pageSize 当前页面展示数目
     * @return
     * @throws Exception
     */
    public List<SfProduct> getList(int pageNum, int pageSize) throws Exception {
        List<SfProduct> productList = sfpm.selectByExample(se);
        return productList;
    }
}
