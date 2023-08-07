package com.poly;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

import store.app.ui.ThongKe_Dialog;

public class testThongKe {
	
    @Test
    public void TestThangDung() {
    	ThongKe_Dialog obj = new ThongKe_Dialog(null, false);
        String validThang = "12";
        boolean result = obj.checkSo(validThang);
        assertTrue(result, "Phải trả về giá trị true với đầu vào hợp lệ.");
    }

    @Test(priority = 1)
    public void TestThangBeHon1() {
    	ThongKe_Dialog obj = new ThongKe_Dialog(null, false);
        String invalidNumber = "0";
        boolean result = obj.checkSo(invalidNumber);
        assertFalse(result, "Phải trả về giá trị false với số không hợp lệ.");
    }

    @Test(priority = 2)
    public void TestThangLonHon12() {
    	ThongKe_Dialog obj = new ThongKe_Dialog(null, false);
        String outOfRangeNumber = "13";
        boolean result = obj.checkSo(outOfRangeNumber);
        assertFalse(result, "Phải trả về giá trị false với số nằm ngoài khoảng từ 1 đến 12.");
    }

    @Test(priority = 3)
    public void TestThangKhongPhaiSo() {
    	ThongKe_Dialog obj = new ThongKe_Dialog(null, false);
        String nonNumeric = "abc";
        boolean result = obj.checkSo(nonNumeric);
        assertFalse(result, "Phải trả về giá trị false với đầu vào không phải là số (abc).");
    }
}

