/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package store.app.utils;

//import DuAn.entity.NhanVien;

import store.app.entity.KhachHang;
import store.app.entity.NhanVien;


/**
 *
 * @author asus
 */
public class Auth {
    /*
     * Đối tượng này chứa thông tin người sử dụng sau khi đăng nhập
     */
    public static NhanVien user = null; //người dùng chưa login
    
    public static KhachHang khachHang = null;
    
    /*Xóa thông tin của người dùng khi có yêu cầu đăng xuất
     * 
     */
    public static void clear(){//log out
        Auth.user = null;
    }
    
    /*
     * Kiểm tra đăng nhập hay chưa
     */
    public static boolean isLogin(){
        return Auth.user != null;
    }
    
    /*
     * Kiểm tra có phải trường phòng hay không
     */
    public static boolean isManager(){
        return Auth.isLogin() && user.isVaiTro();
    }
    
    
    /*
     * Kiểm tra có phải trường phòng hay không
     */
    public static boolean isThanhVien(){
        return khachHang.isThanhVien();
    }
}
