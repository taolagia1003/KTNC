package com.poly.testSanPham;

import org.testng.annotations.Test;

import store.app.dao.KhachHangDAO;
import store.app.dao.SanPhamDAO;
import store.app.entity.KhachHang;
import store.app.entity.SanPham;
import store.app.utils.XJDBC;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;

public class SanPhamTest {
	private SanPhamDAO spdao;
	private SanPham sp;

	@BeforeClass
	public void setup() {
		spdao = new SanPhamDAO();
		sp = new SanPham();
	}

	@DataProvider(name = "SanPhamProvider")
	public static Object[][] khachHangProvider() {
		return new Object[][] {
				{ "SP032", "Sản Phẩm 1", 50 ,8000, "anh1.jpg","deo co",11,"S", true }, //test thêm sp thành công
				{ "SP999", null,50 ,8000, "anh1.jpg","deo co",11,"S", false },	//test thêm sp bỏ trống tên sản phẩm
				{ "SP999", "Sản Phẩm 1", -1 ,8000, "anh1.jpg","deo co",11,"S",false}, //test thêm sp số lượng bé hơn 0
				{ "SP999", "Sản Phẩm 1", 50 ,-1, "anh1.jpg","deo co",11,"S", false }, //test thêm sp giá bán bé hơn 0
				{ "SP999", "Sản Phẩm 1", 50 ,8000, null,"deo co",11,"S",false },//test thêm sp bỏ trống ảnh
				{ "SP999", "Sản Phẩm 1", 50 ,8000, "anh1.jpg",null,11,"S", false },//test thêm sp bỏ trống ghi chú
				{ "SP999", "Sản Phẩm 1", 50 ,8000, "anh1.jpg","deo co",-2,"S", false },//test thêm sp danh mục bé hơn 0
				{ "SP999", "Sản Phẩm 1", 50 ,8000, "anh1.jpg","deo co",11,null, false },//test thêm sp bỏ trống kích cở
				{ null,  null,-1,-1,null,null,-1,null ,false} //test thêm sp sai tất cả
				};
	}

	@Test(dataProvider = "SanPhamProvider")
	public void checkInsertSP(String maSP, String tenSP, int soLuong, float giaBan, String anh ,String ghiChu,int maDM,
			String size,boolean expectedResult) {
		boolean actualResult = spdao.checkInsertSP(maSP,tenSP,soLuong,giaBan,anh,ghiChu,maDM,size);
		assertEquals(actualResult, actualResult);
	}

	@Test(priority = 0)
	public void timTenSP() {
		String maSP = "SP001";
		sp = spdao.selectById(maSP);
		Assert.assertEquals("Giày Nike SB Dunk Blue", sp.getTenSP());
	}
	@AfterClass
	public void tearDown() {
		// Code to clean up test resources
	}
}
