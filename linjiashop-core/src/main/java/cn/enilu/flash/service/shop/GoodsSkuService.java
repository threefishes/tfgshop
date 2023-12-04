package cn.enilu.flash.service.shop;


import cn.enilu.flash.bean.entity.shop.GoodsSku;
import cn.enilu.flash.bean.vo.query.SearchFilter;
import cn.enilu.flash.dao.shop.GoodsSkuRepository;
import cn.enilu.flash.service.BaseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsSkuService extends BaseService<GoodsSku,Long,GoodsSkuRepository>  {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private GoodsSkuRepository goodsSkuRepository;

    public List<GoodsSku> queryByIdGoods(Long idGoods){
        return queryAll(SearchFilter.build("idGoods",idGoods));
    }

}

