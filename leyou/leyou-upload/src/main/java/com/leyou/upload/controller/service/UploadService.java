package com.leyou.upload.controller.service;

import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @author dongren
 * @create 2019-07-31 9:15
 */
@Service
//@Slfj
public class UploadService {

    @Autowired
    private FastFileStorageClient storageClient;

    private static final List<String> CONTENT_TYPES = Arrays.asList("image/gif","image/jpeg","image/png");

    private static final Logger LOG = LoggerFactory.getLogger(UploadService.class);

    public String uploadImage(MultipartFile file) {
        String originalFilename = file.getOriginalFilename();
//        StringUtils.substringAfterLast(originalFilename,".");
        //校验文件类型
        String contentType = file.getContentType();
        if(!CONTENT_TYPES.contains(contentType)){
//            LOG.info("文件类型不合法：" + originalFilename);
            LOG.info("文件类型不合法：{}",originalFilename);
            return null;
        }

        try {
            //校验文件内容
            BufferedImage bufferedImage = ImageIO.read(file.getInputStream());
            if(bufferedImage == null){
                LOG.info("文件内容不合法：{}",originalFilename);
                return null;
            }

            /*//保存到文件的服务器
            file.transferTo(new File("D:\\july-leyou\\image\\"+originalFilename));

            //返回url，进行回显
            return "http://image.leyou.com/"+originalFilename;*/

            String ext = StringUtils.substringAfterLast(originalFilename, ".");
            StorePath storePath = this.storageClient.uploadFile(file.getInputStream(), file.getSize(), ext, null);

            // 生成url地址，返回
            return "http://image.leyou.com/" + storePath.getFullPath();
        } catch (IOException e) {
            LOG.info("服务器内部错误："+originalFilename);
            e.printStackTrace();
        }
        return null;
    }
}
