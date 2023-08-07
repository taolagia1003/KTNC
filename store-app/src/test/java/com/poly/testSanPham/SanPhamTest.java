package com.poly.testSanPham;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import store.app.dao.SanPhamDAO;
import store.app.entity.SanPham;

public class SanPhamTest {
    private SanPhamDAO sanPhamDAO;

    @BeforeClass
    public void setUp() {
        sanPhamDAO = new SanPhamDAO();
        // Thực hiện cài đặt hoặc khởi tạo trước khi các test chạy.
    }

    @AfterClass
    public void tearDown() {
        // Thực hiện dọn dẹp sau khi các test đã chạy xong.
    }

    @Test(dataProvider = "sanPhamDataProvider")
    public void testInsert(SanPham testSanPham) {
        // Thực hiện thêm dữ liệu bằng đối tượng testSanPham.
        // Vì phương thức insert không trả về giá trị, chúng ta có thể kiểm tra xem đối tượng đã được thêm thành công hay không
        // bằng cách truy vấn vào cơ sở dữ liệu để tìm đối tượng đã thêm.

        sanPhamDAO.insert(testSanPham);

        // Tiếp theo, lấy đối tượng đã thêm từ cơ sở dữ liệu bằng phương thức selectById
        SanPham insertedSanPham = sanPhamDAO.selectById(testSanPham.getMaSP());

        assertNotNull(insertedSanPham);
        // Thêm các câu kiểm tra khác để xác minh dữ liệu đã được thêm chính xác.
        assertEquals(insertedSanPham.getTenSP(), testSanPham.getTenSP());
        assertEquals(insertedSanPham.getSoLuong(), testSanPham.getSoLuong());
        assertEquals(insertedSanPham.getGiaBan(), testSanPham.getGiaBan());
        // Thêm các câu kiểm tra cho các thuộc tính khác nếu cần.
    }

    @DataProvider(name = "sanPhamDataProvider")
    public Object[][] provideSanPhamData() {
        // Cung cấp dữ liệu thử nghiệm cho phương thức insert.
        // Bạn có thể tạo nhiều kịch bản kiểm tra với các thuộc tính khác nhau cho đối tượng SanPham.

        SanPham sanPham1 = new SanPham();
        sanPham1.setTenSP("Sản phẩm 1");
        sanPham1.setSoLuong(10);
        sanPham1.setGiaBan(100.0f);
        // Đặt các thuộc tính khác cần thiết.

        SanPham sanPham2 = new SanPham();
        sanPham2.setTenSP("Sản phẩm 2");
        sanPham2.setSoLuong(5);
        sanPham2.setGiaBan(50.0f);
        // Đặt các thuộc tính khác cần thiết.

        return new Object[][] { { sanPham1 }, { sanPham2 } };
    }
}

