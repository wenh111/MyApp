package com.wenh.myapp.service;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import com.wenh.myapp.entity.UploadSuccessfulMessage;
import com.wenh.myapp.entity.UserPhotoBean;
import com.wenh.myapp.mapper.UserPhotoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

@Service
public class FileUploadAndDownLoadService {

    @Value("${files.upload.path}")
    private String fileUploadPath;
    @Value("${String.urls}")
    private String urls;
    @Autowired
    private UserPhotoMapper userPhotoMapper;

    public UploadSuccessfulMessage photo(MultipartFile file, String account) throws IOException {
        String originalFilename = file.getOriginalFilename();
        String type = FileUtil.extName(originalFilename);
        long size = file.getSize();

        // 定义一个文件唯一的标识码
        String uuid = IdUtil.fastSimpleUUID();
        String fileUUID = uuid + StrUtil.DOT + type;

        File uploadFile = new File(fileUploadPath + fileUUID);
        // 判断配置的文件目录是否存在，若不存在则创建一个新的文件目录
        File parentFile = uploadFile.getParentFile();
        if(!parentFile.exists()) {
            parentFile.mkdirs();
        }

        String url;
        // 获取文件的md5
        String md5 = SecureUtil.md5(file.getInputStream());
        System.out.println("md5 =======>" + md5);
        System.out.println("uploadFile =======>" + uploadFile);
        //url = "http://localhost:9090/file/" + fileUUID;
        // 从数据库查询是否存在相同的记录
        UserPhotoBean dbFiles = getFileByMd5(md5);
        if (dbFiles != null) { // 文件已存在
            url = dbFiles.getUrl();
        } else {
            // 上传文件到磁盘
            file.transferTo(uploadFile);
            // 数据库若不存在重复文件，则不删除刚才上传的文件
            //url = "http://localhost:9090/photo/" + fileUUID;
            url = urls + fileUUID;
        }

        // 存储数据库
        UserPhotoBean userPhotoBean = new UserPhotoBean();
        userPhotoBean.setName(originalFilename);
        userPhotoBean.setType(type);
        userPhotoBean.setSize(size/1024);
        userPhotoBean.setUrl(url);
        userPhotoBean.setMd5(md5);
        userPhotoBean.setAccount(account);
        List<UserPhotoBean> userPhotoBeans = userPhotoMapper.selectUserPhoto(account);
        if(userPhotoBeans.size() != 0 && userPhotoBeans != null){
            userPhotoMapper.updatePhoto(userPhotoBean);
        }else{
            userPhotoMapper.insertPhoto(userPhotoBean);
        }
        //userPhotoMapper.insertPhoto(userPhotoBean);
        UploadSuccessfulMessage uploadSuccessfulMessage = new UploadSuccessfulMessage(account,type,url);
        return uploadSuccessfulMessage;
    }

    private UserPhotoBean getFileByMd5(String md5) {
        List<UserPhotoBean> userPhotoBeans = userPhotoMapper.selectPhoto(md5);
        return userPhotoBeans.size() == 0 ? null : userPhotoBeans.get(0);
    }

    public void downloadPhoto(String fileUUID, HttpServletResponse response) throws IOException {
        // 根据文件的唯一标识码获取文件
        File uploadFile = new File(fileUploadPath + fileUUID);
        // 设置输出流的格式
        ServletOutputStream os = response.getOutputStream();
        response.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileUUID, "UTF-8"));
        response.setContentType("application/octet-stream");

        // 读取文件的字节流
        os.write(FileUtil.readBytes(uploadFile));
        os.flush();
        os.close();

    }

    public String getAccountFileUUID(String account) {
        List<UserPhotoBean> accountPhotoName = userPhotoMapper.getAccountPhotoName(account);
        String fileUUID = accountPhotoName.get(0).getUrl();
        fileUUID = fileUUID.substring(fileUUID.lastIndexOf("/")+1);
        System.out.println("getAccountFileUUID ==============>" + fileUUID);
        return fileUUID;
    }
    public UserPhotoBean getAccountPhotoUrl(String account) {
        List<UserPhotoBean> accountPhotoName = userPhotoMapper.getAccountPhotoName(account);
        UserPhotoBean userPhotoBean = accountPhotoName.get(0);
        return userPhotoBean;
    }
}
