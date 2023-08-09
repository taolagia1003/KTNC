package com.poly.testNhanVien;

import static org.testng.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import store.app.dao.NhanVienDao;

public class testNhanVienDaoUpdate {
	private NhanVienDao nvdao;

	@BeforeClass
	public void setUp() {
		nvdao = new NhanVienDao();
	}

	@DataProvider(name = "nhanVienProvider")
	public static Object[][] nhanVienProvider() throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

		return new Object[][] {
				{ "NV011", "Nguyen Van Hung", false, "An Giang", "0987636088", dateFormat.parse("03/04/2000"), "123",
						false, true },
				{ "NV012", null, false, "An Giang", "0987636099", dateFormat.parse("2000/02/02"), "123", false, false },
				{ "NV012", "Nguyen Van A", false, null, "0987636099", dateFormat.parse("2000/02/02"), "123", false,
						false },
				{ "NV012", "Nguyen Van A", false, "An Giang", null, dateFormat.parse("2000/02/02"), "123", false,
						false },
				{ "NV012", "Nguyen Van A", false, "An Giang", "0987636099", null, "123", false, false },
				{ "NV012", null, false, null, null, null, null, false, false }, };
	}

	@Test(dataProvider = "nhanVienProvider")
	public void testCheckInsertNV(String maNV, String tenNV, boolean gioiTinh, String diaChi, String sdt, Date ngaySinh,
			String matKhau, boolean vaiTro, boolean expectedResult) {
		boolean actualResult = nvdao.checkInsertNV(maNV, tenNV, gioiTinh, diaChi, sdt, ngaySinh, matKhau, vaiTro);
		assertEquals(actualResult, expectedResult);
	}

	@AfterClass
	public void tearDown() {
		nvdao = null;
	}
}
