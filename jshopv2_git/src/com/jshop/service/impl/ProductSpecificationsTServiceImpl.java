package com.jshop.service.impl;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.jshop.dao.ProductSpecificationsTDao;
import com.jshop.entity.ProductSpecificationsT;
import com.jshop.service.ProductSpecificationsTService;

@Service("productSpecificationsTService")
@Scope("prototype")
public class ProductSpecificationsTServiceImpl implements ProductSpecificationsTService {

	private ProductSpecificationsTDao productSpecificationsTDao;

	public ProductSpecificationsTDao getProductSpecificationsTDao() {
		return productSpecificationsTDao;
	}

	public void setProductSpecificationsTDao(ProductSpecificationsTDao productSpecificationsTDao) {
		this.productSpecificationsTDao = productSpecificationsTDao;
	}

	public int delProductSpecification(String[] list) {
		return this.getProductSpecificationsTDao().delProductSpecification(list);
	}

	public List<ProductSpecificationsT> findAllProductSpecificationsT(int currentPage, int lineSize) {
		return this.getProductSpecificationsTDao().findAllProductSpecificationsT(currentPage, lineSize);
	}

	public ProductSpecificationsT findProductSpecificationsTByspecificationsid(String specificationsid) {
		return this.getProductSpecificationsTDao().findProductSpecificationsTByspecificationsid(specificationsid);
	}

	public int updateProductSpecification(ProductSpecificationsT pst) {
		return this.getProductSpecificationsTDao().updateProductSpecification(pst);
	}

	public List<ProductSpecificationsT> findAllProductSpecificationsTWithoutPage() {
		return this.getProductSpecificationsTDao().findAllProductSpecificationsTWithoutPage();
	}

	public List<ProductSpecificationsT> sortAllProductSpecificationsT(int currentPage, int lineSize, String queryString) {

		return this.getProductSpecificationsTDao().sortAllProductSpecificationsT(currentPage, lineSize, queryString);
	}

	public void addProductSpecification(ProductSpecificationsT pst) {
		this.getProductSpecificationsTDao().addProductSpecification(pst);
	}

	public int countfindAllProductSpecificationsT() {
		return this.getProductSpecificationsTDao().countfindAllProductSpecificationsT();
	}
	
	
	
}
