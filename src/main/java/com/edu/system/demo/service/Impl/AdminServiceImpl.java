package com.edu.system.demo.service.Impl;

import com.edu.system.demo.entity.Administer;
import com.edu.system.demo.repository.AdminRepository;
import com.edu.system.demo.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author lucas
 * @site
 * @company
 * @create 2019-10-22 22:58
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;


    @Override
    public String adminSignIn(String usr_name, String password) {
        try {
            Administer admin = adminRepository.findAdminByUsr_name(usr_name);
            System.out.println("ad_pass: " + admin.getPassword());
            System.out.println("pass: "+ password);
            if(!admin.getPassword().equals(password)){
                return "密码错误";
            }else {
                return "登陆成功";
            }
        }catch (Exception e){
            return "账号不存在";
        }

    }
}
