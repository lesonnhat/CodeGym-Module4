package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @GetMapping("/")
    public ModelAndView index() {
        return new ModelAndView("index");
    }

    @GetMapping("/user")
    public ModelAndView userPage() {
        return new ModelAndView("user");
    }

    @GetMapping("/admin")
    public ModelAndView adminPage() {
        return new ModelAndView("admin");
    }

    @GetMapping("/login")
    public ModelAndView loginPage(@RequestParam(value = "error", required = false) String error) {
        ModelAndView modelAndView = new ModelAndView("login");
        if (error != null) {
            modelAndView.addObject("error", "Tên đăng nhập hoặc mật khẩu không đúng.");
        }
        return modelAndView;
    }

    @GetMapping("/posts/create")
    public ModelAndView createPostPage() {
        return new ModelAndView("create_post");
    }

    // Giả sử bạn có một form để tạo bài viết và xử lý nó ở đây
    @PostMapping("/posts/create")
    public String createPost(/* Dữ liệu bài viết */) {
        // Xử lý tạo bài viết ở đây
        return "redirect:/"; // Chuyển hướng về trang chủ sau khi tạo
    }
}