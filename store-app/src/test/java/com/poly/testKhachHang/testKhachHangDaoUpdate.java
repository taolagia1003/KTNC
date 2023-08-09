package com.poly.testKhachHang;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import store.app.dao.KhachHangDAO;

public class testKhachHangDaoUpdate {
	private KhachHangDAO khdao;

	@BeforeClass
	public void start() {
		khdao = new KhachHangDAO();
	}

	@DataProvider(name = "khachHangProvider")
	public static Object[][] khachHangProvider() {
		return new Object[][] {
			{ "KH026", "Nguyen Van A", "123 ABC Street", "0123456789", "nguyenvana@example.com", true, true },
			{ "KH26", null, "123 ABC Street", "0123456789", "nguyenvana@example.com", true, false },
			{ "KH26", "Nguyen Van A", null, "0123456789", "nguyenvana@example.com", true, false },
			{ "KH26", "Nguyen Van A", "123 ABC Street", null, "nguyenvana@example.com", true, false },
			{ "KH26", "Nguyen Van A", "123 ABC Street", "0123456789", null, true, false },
			{ "KH26", null, null, null, null, true, false }
		};
	}

	@Test(dataProvider = "khachHangProvider")
	public void testUpdate(String maKH, String tenKH, String diaChi, String sdt, String email, boolean thanhVien,
			boolean expectedResult) {
		boolean actualResult = khdao.checkUpdateKH(maKH, tenKH, diaChi, sdt, email, thanhVien);
		Assert.assertEquals(actualResult, expectedResult);
	}

	@AfterClass
	public void tearDown() {
		khdao = null;
	}
}
