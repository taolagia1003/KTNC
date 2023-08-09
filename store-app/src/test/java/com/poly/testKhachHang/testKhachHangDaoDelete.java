package com.poly.testKhachHang;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import store.app.dao.KhachHangDAO;
import store.app.entity.KhachHang;

public class testKhachHangDaoDelete {
	private KhachHangDAO khdao;

	@BeforeClass
	public void start() {
		khdao = new KhachHangDAO();
	}

	@DataProvider(name = "khachHangProvider")
	private Object[][] dp() {
		return new Object[][] { { "KH025", true },
			{ "0933", false }, 
			{ null, false }
		};
	}

	@Test(dataProvider = "khachHangProvider")
	public void testInsert(String maKh, boolean expectedResult) {
		boolean actualResult = khdao.checkXoa(maKh);
		assertEquals(actualResult, expectedResult);
	}

	@AfterClass
	public void tearDown() {
		khdao = null;
	}
}
