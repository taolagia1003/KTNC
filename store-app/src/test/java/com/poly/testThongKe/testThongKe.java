package com.poly.testThongKe;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

import store.app.ui.ThongKe_Dialog;

public class testThongKe {
	ThongKe_Dialog obj = new ThongKe_Dialog(new javax.swing.JFrame(), true);
    @Test
    public void TestThangDung() {
        String validThang = "12";
        boolean result = obj.checkSo(validThang);
        assertTrue(result, "Phải trả về giá trị true với đầu vào hợp lệ.");
    }
    
    @Test(priority = 1)
    public void TestThangBeHon1() {
        String NhoHon1 = "0";
        boolean result = obj.checkSo(NhoHon1);
        assertFalse(result, "Phải trả về giá trị false với số không hợp lệ.");
    }

    @Test(priority = 2)
    public void TestThangLonHon12() {
        String LonHon12 = "13";
        boolean result = obj.checkSo(LonHon12);
        assertFalse(result, "Phải trả về giá trị false với số nằm ngoài khoảng từ 1 đến 12.");
    }

    @Test(priority = 3)
    public void TestThangKhongPhaiSo() {
        String Chu = "abc";
        boolean result = obj.checkSo(Chu);
        assertFalse(result, "Phải trả về giá trị false với đầu vào không phải là số (abc).");
    }
}