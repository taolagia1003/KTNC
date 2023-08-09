package com.poly.testKhachHang;

import org.testng.annotations.Test;

import store.app.dao.KhachHangDAO;
import store.app.entity.KhachHang;
import store.app.utils.XJDBC;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;

public class testKhachHangDao {
	private KhachHangDAO khdao;
	private KhachHang kh;

	@BeforeClass
	public void setup() {
		khdao = new KhachHangDAO();
		kh = new KhachHang();
	}

	@DataProvider(name = "khachHangProvider")
	public static Object[][] khachHangProvider() {
		return new Object[][] {
				{ "KH27", "Nguyen Van A", "123 ABC Street", "0123456789", "nguyenvana@example.com", false, true },
				{ "KH26", null, "123 ABC Street", "0123456789", "nguyenvana@example.com", false, false },
				{ "KH26", "Nguyen Van A", null, "0123456789", "nguyenvana@example.com", false, false },
				{ "KH26", "Nguyen Van A", "123 ABC Street", null, "nguyenvana@example.com", false, false },
				{ "KH26", "Nguyen Van A", "123 ABC Street", "0123456789", null, false, false },
				{ "KH26", null, null, null, null, false, false }, };
	}

	@Test(dataProvider = "khachHangProvider")
	public void testInsert(String maKH, String tenKH, String diaChi, String sdt, String email, boolean thanhVien,
			boolean expectedResult) {
		boolean actualResult = khdao.checkInsertKH(maKH, tenKH, diaChi, sdt, email, thanhVien);
		assertEquals(actualResult, expectedResult);
	}

	@Test(priority = 0)
	public void timTenKH() {
		String maKH = "KH025";
		kh = khdao.selectById(maKH);
		Assert.assertEquals("Nguyễn Văn Thành", kh.getTenKH());
	}
	@AfterClass
	public void tearDown() {
		// Code to clean up test resources
	}
}
