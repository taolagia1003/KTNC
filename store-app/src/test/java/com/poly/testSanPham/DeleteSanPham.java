package com.poly.testSanPham;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import store.app.dao.SanPhamDAO;

public class DeleteSanPham {
	private SanPhamDAO spdao;

	@BeforeClass
	public void start() {
		spdao = new SanPhamDAO();
	}

	@DataProvider(name = "SanPhamProvider")
	private Object[][] dp() {
		return new Object[][] { 
			{ "SP026", true },
			{ "SP026000", false },
			{ null, false }
		};
	}

	@Test(dataProvider = "SanPhamProvider")
	public void testInsert(String maKh, boolean expectedResult) {
		boolean actualResult = spdao.checkXoa(maKh);
		assertEquals(actualResult, expectedResult);
	}

	@AfterClass
	public void tearDown() {
		spdao = null;
	}
}
