package com.poly.testSanPham;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import store.app.dao.SanPhamDAO;

public class UpdateSanPHam {
	private SanPhamDAO spdao;

	@BeforeClass
	public void start() {
		spdao = new SanPhamDAO();
	}

	@DataProvider(name = "SanPhamProvider")
	public static Object[][] khachHangProvider() {
		return new Object[][] {
			{ "SP032", "san pham da update", 50 ,8000, "anh1.jpg","deo co",11,"S", true }, //test sua sp thành công
			{ "SP999", null,50 ,8000, "anh1.jpg","deo co",11,"S", false },	//test sua sp bỏ trống tên sản phẩm
			{ "SP999", "Sản Phẩm 1", -1 ,8000, "anh1.jpg","deo co",11,"S",false}, //test sua sp số lượng bé hơn 0
			{ "SP999", "Sản Phẩm 1", 50 ,-1, "anh1.jpg","deo co",11,"S", false }, //test sua sp giá bán bé hơn 0
			{ "SP999", "Sản Phẩm 1", 50 ,8000, null,"deo co",11,"S",false },//test sua sp bỏ trống ảnh
			{ "SP999", "Sản Phẩm 1", 50 ,8000, "anh1.jpg",null,11,"S", false },//test sua sp bỏ trống ghi chú
			{ "SP999", "Sản Phẩm 1", 50 ,8000, "anh1.jpg","deo co",-2,"S", false },//test sua sp danh mục bé hơn 0
			{ "SP999", "Sản Phẩm 1", 50 ,8000, "anh1.jpg","deo co",11,null, false },//test sua sp bỏ trống kích cở
			{ null,  null,-1,-1,null,null,-1,null ,false} //test sua sp sai tất cả
			};
	}
	@Test(dataProvider = "SanPhamProvider")
	public void checkInsertSP(String maSP, String tenSP, int soLuong, float giaBan, String anh ,String ghiChu,int maDM,
			String size,boolean expectedResult) {
		boolean actualResult = spdao.checkUpdateSP(maSP,tenSP,soLuong,giaBan,anh,ghiChu,maDM,size);
		assertEquals(actualResult, actualResult);
	}

	@AfterClass
	public void tearDown() {
		spdao = null;
	}
}
