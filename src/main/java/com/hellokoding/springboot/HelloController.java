package com.hellokoding.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {
/*    @GetMapping("/")
    public String index() {
        return "index";
    }*/

    private static String UPLOADED_FOLDER ="./";

    @GetMapping("/hello")
    public String hello(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
        model.addAttribute("name", name);
        return "hello";
    }

    @PostMapping("/upload")
    public String singleFileUpload(@RequestParam("file")MultipartFile file,
                                   RedirectAttributes redirectAttributes){
        if(file.isEmpty()){
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:uploadStatus";
        }
        try {
            byte[] bytes = file.getBytes();
            String name = file.getOriginalFilename();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);

            redirectAttributes.addFlashAttribute("message", "You successfully uploaded '" + file.getOriginalFilename() + "'");
        }catch (IOException e){
            e.printStackTrace();
        }
        return "redirect:/";
    }


    @GetMapping("/unko")
    public String unko(Model model, @RequestParam(value="name", required=false, defaultValue="うんち") String name) {
        model.addAttribute("name", name);
        return "unko";
        //返り値の文字列＝templates/*.ftlの名前
    }
    @GetMapping("/unko/{name}")
    public ModelAndView name(ModelAndView mav, @PathVariable("name") String name) {
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        for (String str : list){
            System.out.println(str);
        }
        mav.addObject("name",name);
        mav.addObject("lists",list);
        mav.setViewName("hoge");
        return mav;
        //返り値の文字列＝templates/*.ftlの名前
    }
}
