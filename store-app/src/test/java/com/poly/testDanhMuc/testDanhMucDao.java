package com.poly.testDanhMuc;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import store.app.dao.DanhMucSpDAO;
import store.app.entity.DanhMucSP;

public class testDanhMucDao {
    private DanhMucSpDAO dmdao;
    private DanhMucSP dm;

    @BeforeClass
    public void setup() {
        dmdao = new DanhMucSpDAO();
        dm = new DanhMucSP();
    }

    @DataProvider(name = "danhMucProvider")
    public static Object[][] danhMucProvider() {
        return new Object[][] {
            { "10", "Quan", true },
            { null, "Quan", false },
            { null, null, false },
        };
    }

    @Test(dataProvider = "danhMucProvider")
    public void testCheckInsertDM(String maDM, String tenDM, boolean expectedResult) {
        boolean actualResult = dmdao.checkInsertDM(maDM, tenDM);
        assertEquals(actualResult, expectedResult);
    }
	@Test(priority = 0)
	public void timTenDM() {
		String maDM = "1";
		dm = dmdao.selectById(maDM);
		Assert.assertEquals("Áo", dm.getTenDM());
	}

    @AfterClass
    public void tearDown() {
        dmdao = null;
    }
}
