package com.poly.testlogin;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import store.app.dao.NhanVienDao;
import store.app.entity.NhanVien;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNull;

import java.util.Date;

public class logintest {
    private NhanVienDao nhanVienDao = new NhanVienDao();
    
    @DataProvider(name = "validMaNV")
    public Object[][] validMaNV() {
        return new Object[][] {
            {"NV001", "newpassword123"},
            // Thêm các cặp mã nhân viên và mật khẩu hợp lệ khác ở đây
        };
    }

    @DataProvider(name = "invalidMaNV")
    public Object[][] invalidMaNV() {
        return new Object[][] {
            {"InvalidID"},
            // Thêm các mã nhân viên không tồn tại ở đây
        };
    }
    @DataProvider(name = "DoiMatKhauDung")
    public Object[][] DoiMatKhauDung() {
        return new Object[][] {
            {"NV001", "newPassword123"},
            // Thêm các cặp mã nhân viên và mật khẩu hợp lệ khác ở đây
        };
    }
    
    @Test(dataProvider = "validMaNV", priority = 0)
    public void testdangnhapthanhcong(String maNV, String passWord) {
        NhanVien nhanVien = nhanVienDao.selectById(maNV);
        assertEquals(nhanVien.getMaNV(), maNV);
        assertEquals(nhanVien.getMatKhau(), passWord);
        System.out.println("test nhan vien dung");
    }
    
    @Test(dataProvider = "invalidMaNV" , priority = 1)
    public void testdangnhapsaimanv(String maNV) {
        NhanVien nhanVien = nhanVienDao.selectById(maNV);
        assertNull(nhanVien);
        System.out.println("test nhan vien sai ma nv");
    }
    @Test( priority = 2)
    public void testThemNhanVienThanhCong() {
        NhanVien newNhanVien = new NhanVien();
        newNhanVien.setMaNV("NV111");
        newNhanVien.setTenNV("New Employee");
        newNhanVien.setGioiTinh(true);
        newNhanVien.setDiaChi("Hậu Giang");
        newNhanVien.setSdt("0123456789");
        newNhanVien.setNgaySinh(new Date(2003-12-27)); // Thay bằng ngày sinh hợp lệ
        newNhanVien.setMatKhau("123");
        newNhanVien.setVaiTro(false);
        
        nhanVienDao.insert(newNhanVien);
     
        NhanVien addedNhanVien = nhanVienDao.selectById(newNhanVien.getMaNV());
        assertNotNull(addedNhanVien);
        System.out.println("test thêm nhân viên thành công");
    }
    
    @Test(dataProvider = "DoiMatKhauDung", priority = 3)
    public void testDoiMatKhauDungManv(String maNV, String passWord) {
        NhanVien nhanVien = nhanVienDao.selectById(maNV);
        String newPassword = "newpassword123";
        nhanVien.setMatKhau(newPassword);
        nhanVienDao.qmk(nhanVien);
        NhanVien updatedNhanVien = nhanVienDao.selectById(maNV);
        assertEquals(updatedNhanVien.getMatKhau(), newPassword);
        System.out.println("test doi mat khau thanh cong");
    }
    
    @Test(dataProvider = "invalidMaNV", priority = 4)
    public void testDoiMatKhauSaiManv(String maNV) {
        NhanVien nhanVien = new NhanVien();
        nhanVien.setMaNV(maNV);
        nhanVien.setMatKhau("newPassword123");
        nhanVienDao.qmk(nhanVien);
        // Kiểm tra xem mật khẩu đã được cập nhật hay không (không nên cập nhật)
        NhanVien updatedNhanVien = nhanVienDao.selectById(maNV);
        assertNull(updatedNhanVien);
        System.out.println("test doi mat khau sai ma nhan vien");
    }
}
