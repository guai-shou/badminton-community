package com.cloud.badminton.project.utils.controller;

import com.cloud.badminton.framework.common.exception.APIException;
import com.cloud.badminton.framework.common.exception.AppCode;
import com.cloud.badminton.framework.common.result.ResultVo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author cloud
 * @version 1.0
 * Create by 2023/3/3 16:27
 */
@RequestMapping("/file")
@RestController
public class UploadController {
    @Value("${upload.file.path}")
    private String filePath;

    private DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss-Sss");

    @PostMapping("/upload")
    public ResultVo upload(@RequestParam("file") MultipartFile file) {

        String fileName = saveFile(file);
        return new ResultVo(fileName);
    }

    @PostMapping("/multiUpload")
    public ResultVo multiUpload(@RequestParam("file")MultipartFile[] multipartFile) {
        for (MultipartFile file : multipartFile) {
            saveFile(file);
        }
        return ResultVo.success();
    }

    private String saveFile(MultipartFile file) {
        if (file.isEmpty()) {
            throw new APIException(AppCode.APP_ERROR, "文件未选择");
        }
        String fileName = LocalDateTime.now().format(df);

        File temp = new File(filePath);
        if (!temp.exists()) {
            temp.mkdir();
        }

        File localFile = new File(filePath + "\\" + fileName + ".jpg");
        try {
            file.transferTo(localFile); // 把上传的文件保存至本地
        }catch (Exception e) {
            e.printStackTrace();
            throw new APIException(AppCode.APP_ERROR, "上传失败");
        }
        return fileName + ".jpg";
    }

}
