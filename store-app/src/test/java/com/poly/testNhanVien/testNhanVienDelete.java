package com.poly.testNhanVien;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import store.app.dao.NhanVienDao;

public class testNhanVienDelete {
    private NhanVienDao nvdao;

    @BeforeClass
    public void setup() {
        nvdao = new NhanVienDao();
    }

    @DataProvider(name = "nhanVienProvider")
    public Object[][] nhanVienProvider() {
        return new Object[][] {
            { "NV003", true },
            { null, false },
        };
    }

    @Test(dataProvider = "nhanVienProvider")
    public void testCheckDelete(String maNV, boolean expectedResult) {
        boolean actualResult = nvdao.checkDeleteNV(maNV);
        assertEquals(actualResult, expectedResult);
    }

    @AfterClass
    public void tearDown() {
        nvdao = null;
    }
}
