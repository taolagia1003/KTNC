package com.poly.testDanhMuc;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import store.app.dao.DanhMucSpDAO;

public class testDanhMucDaoDelete {
    private DanhMucSpDAO dmdao;

    @BeforeClass
    public void setup() {
        dmdao = new DanhMucSpDAO();
    }

    @DataProvider(name = "danhMucProvider")
    public Object[][] danhMucProvider() {
        return new Object[][] {
            { "1", true },
            { null, false },
        };
    }

    @Test(dataProvider = "danhMucProvider")
    public void testCheckDelete(String maDM, boolean expectedResult) {
        boolean actualResult = dmdao.checkDeleteDM(maDM);
        assertEquals(actualResult, expectedResult);
    }

    @AfterClass
    public void tearDown() {
        dmdao = null;
    }
}
