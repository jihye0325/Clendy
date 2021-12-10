package com.kh.clendy.sellerProduct.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.servlet.ModelAndView;

import com.kh.clendy.sellerProduct.model.service.SellerProductService;
import com.kh.clendy.sellerProduct.model.vo.ProductList;
import com.kh.clendy.sellerProduct.model.vo.SellerProduct;
import com.kh.clendy.sellerProduct.model.vo.SellerProductCategory;
import com.kh.clendy.sellerProduct.model.vo.SellerProductImage;

@Controller
@RequestMapping("/seller")
public class SellerProductController {
	
	private SellerProductService sellerProductService;
	/*
	@Bean
	public MultipartResolver multipartResolver(){
	    org.springframework.web.multipart.commons.CommonsMultipartResolver multipartResolver = new 
	    org.springframework.web.multipart.commons.CommonsMultipartResolver();
	    
	    multipartResolver.setMaxUploadSize(10485760); //1024 * 1024 * 10 (최대 10MB)
	    return multipartResolver;
	}
	*/
	@Autowired
	public SellerProductController(SellerProductService sellerProductService) {
		this.sellerProductService = sellerProductService;
	}
	
	/*
	@Resource(name = "uploadPath")
	private String uploadPath;
	*/
	
	@GetMapping("/index")
	public void toIndex() {}
	
	@GetMapping("/sub02")
	public ModelAndView selectProductList0(ModelAndView mv) {
		
		List<SellerProduct> sellerproductList = sellerProductService.sellerProductList();
		
		mv.addObject("sellerproductList", sellerproductList);
		mv.setViewName("seller/sub02");
		
		return mv;
	}
	
	@GetMapping("/sub03")
	public void registForm() {}
	
	@GetMapping(value = "category", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public List<SellerProductCategory> findCategoryList(){
		return sellerProductService.findAllCategory();
	}
	
	@PostMapping("/sub03")
	public String regist(SellerProduct sellerProduct, MultipartFile file) throws IOException {
		/*
		String imgUploadPath = uploadPath + File.separator + "imgUpload";
		String ymdPath = UploadFileUtils.calcPath(imgUploadPath);
		String fileName = null;

		if (file != null) {
			fileName = UploadFileUtils.fileUpload(imgUploadPath, file.getOriginalFilename(), file.getBytes(), ymdPath);
		} else {
			fileName = uploadPath + File.separator + "images" + File.separator + "none.png";
		}

		sellerProduct.setProductImg(File.separator + "imgUpload" + ymdPath + File.separator + fileName);
		sellerProduct.setProductThumbImg(File.separator + "imgUpload" + ymdPath + File.separator + "s" + File.separator + "s_" + fileName);
		*/
		sellerProductService.registNewProduct(sellerProduct);
		
		return "redirect:/";
	}
	
	@GetMapping("/sub04")
	public ModelAndView selectProductList(ModelAndView mv) {
		
		List<ProductList> productList = sellerProductService.selectProductList();
		
		mv.addObject("productList", productList);
		mv.setViewName("seller/sub04");
		
		return mv;
	}
	
	@GetMapping("/sub05")
	public ModelAndView selectProductList2(ModelAndView mv) {
		
		List<ProductList> productList = sellerProductService.selectProductList();
		
		mv.addObject("productList", productList);
		mv.setViewName("seller/sub05");
		
		return mv;
	}
	
	@GetMapping("/sub06")
	public ModelAndView selectProductList3(ModelAndView mv) {
		
		List<ProductList> listById = sellerProductService.selectProductListById();
		
		mv.addObject("listById", listById);
		mv.setViewName("seller/sub06");
		
		return mv;
	}
	
	@GetMapping("/sub07")
	public ModelAndView selectProductList4(ModelAndView mv) {
		
		List<ProductList> listById = sellerProductService.selectProductListById();

		mv.addObject("listById", listById);
		mv.setViewName("seller/sub07");

		return mv;
	}
}