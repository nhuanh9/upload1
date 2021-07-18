package com.codegym.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
public class ProductController {

    @GetMapping("/upload")
    public ModelAndView showCreateIMG() {
        ModelAndView modelAndView = new ModelAndView("/createIMG");
        return modelAndView;
    }


    @PostMapping("/show")
    public ModelAndView saveIMG(@RequestParam MultipartFile image) {
        String fileName = image.getOriginalFilename();
        try {
            FileCopyUtils.copy(image.getBytes(),
                    new File("/Users/daonhuanh/Downloads/Codegym/nal/" + fileName)); // coppy ảnh từ ảnh nhận được vào thư mục quy định
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        ModelAndView modelAndView = new ModelAndView("/index2");
        modelAndView.addObject("src", fileName);
        return modelAndView;
    }
}
