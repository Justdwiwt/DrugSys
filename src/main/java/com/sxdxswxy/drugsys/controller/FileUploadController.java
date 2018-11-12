package com.sxdxswxy.drugsys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 文件上传
 *
 * @author Justdwiwt
 */
@Controller
public class FileUploadController {

    /**
     * 单例上传
     *
     * @return /upload/upload
     */
    @GetMapping("/")
    public String index() {
        return "/upload/upload";
    }

    /**
     * 多例上传
     *
     * @return /upload/uploadMore
     */
    @GetMapping("/more")
    public String uploadMore() {
        return "/upload/uploadMore";
    }

    /**
     * 单例上传逻辑
     *
     * @param file               MultipartFile 读取文件信息
     * @param redirectAttributes message
     * @return /upload/uploadStatus
     */
    @PostMapping("/upload")
    public String singleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) {
        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message",
                    "Please select a file to upload");
            return "/upload/uploadStatus";
        }
        try {
            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            // UPLOADED_FOLDER 文件本地存储地址
            Path path = Paths.get("D:\\BIG\\DrugSys\\src\\main\\resources\\file\\upload\\"
                    + file.getOriginalFilename());
            Files.write(path, bytes);

            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded '" + file.getOriginalFilename() + "'");

        } catch (IOException e) {
            e.printStackTrace();
        }
        return "/upload/uploadStatus";
    }

    /**
     * 多例上传逻辑
     *
     * @param files              MultipartFile 读取文件信息
     * @param redirectAttributes message
     * @return /upload/uploadStatus
     */
    @PostMapping("/uploadMore")
    public String moreFileUpload(@RequestParam("file") MultipartFile[] files,
                                 RedirectAttributes redirectAttributes) {
        if (files.length == 0) {
            redirectAttributes.addFlashAttribute("message",
                    "Please select a file to upload");
            return "/upload/uploadStatus";
        }
        for (MultipartFile file : files) {
            try {
                byte[] bytes = file.getBytes();
                Path path = Paths.get("D:\\BIG\\DrugSys\\src\\main\\resources\\file\\upload\\"
                        + file.getOriginalFilename());
                Files.write(path, bytes);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        redirectAttributes.addFlashAttribute("message",
                "You successfully uploaded all");
        return "/upload/uploadStatus";
    }

    /**
     * MultipartException 的异常处理
     */
    @ControllerAdvice
    public class GlobalExceptionHandler {
        @ExceptionHandler(MultipartException.class)
        public String handleError1(MultipartException e, RedirectAttributes redirectAttributes) {
            redirectAttributes.addFlashAttribute("message", e.getCause().getMessage());
            return "/upload/uploadStatus";
        }
    }

}
