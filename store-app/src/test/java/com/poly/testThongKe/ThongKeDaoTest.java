package com.poly.testThongKe;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import store.app.dao.ThongKeDao;

public class ThongKeDaoTest {
    private ThongKeDao thongKeDao;

    @BeforeMethod
    public void setUp() {
        // Khởi tạo đối tượng ThongKeDao trước mỗi phương thức kiểm tra
        thongKeDao = new ThongKeDao();
    }

    @AfterMethod
    public void tearDown() {
        // Giải phóng bất kỳ tài nguyên nào sau mỗi phương thức kiểm tra
    }

    @Test
    public void testGetDoanhThuTheoThang() {
        // Thay 'thangValue' bằng một tháng hợp lệ cho kết quả mong muốn
        int thangValue = 9;
        List<Object[]> result = thongKeDao.getDoanhThuTheoThang(thangValue);
        // Thêm các khẳng định để kiểm tra tính chính xác của danh sách 'result'
        Assert.assertNotNull(result);
        Assert.assertTrue(result.size() > 0, "Mong đợi danh sách không rỗng");
        // Thêm các khẳng định cụ thể hơn dựa trên kết quả mong muốn
    }

    @Test
    public void testGetDoanhThuTheoNgay() {
        // Thay 'ngayValue' bằng một chuỗi ngày hợp lệ cho kết quả mong muốn
        String ngayValue = "2023-08-07";
        List<Object[]> result = thongKeDao.getDoanhThuTheoNgay(ngayValue);
        // Thêm các khẳng định để kiểm tra tính chính xác của danh sách 'result'
        Assert.assertNotNull(result);
        Assert.assertTrue(result.size() > 0, "Mong đợi danh sách không rỗng");
        // Thêm các khẳng định cụ thể hơn dựa trên kết quả mong muốn
    }

    // Thêm các phương thức kiểm tra TestNG khác cho các phương thức trong lớp ThongKeDao
    // Sử dụng các mẫu tương tự của việc thiết lập dữ liệu, gọi phương thức và khẳng định kết quả

    // Ví dụ:
    @Test
    public void testGetSanPhamTheoNgay() {
        String ngayValue = "2023-08-07";
        List<Object[]> result = thongKeDao.getSanPhamTheoNgay(ngayValue);
        Assert.assertNotNull(result);
        // Thêm các khẳng định cụ thể hơn dựa trên kết quả mong muốn
    }
}


