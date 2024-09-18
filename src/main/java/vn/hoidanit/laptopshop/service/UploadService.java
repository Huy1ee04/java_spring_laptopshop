package vn.hoidanit.laptopshop.service;

import jakarta.servlet.ServletContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import vn.hoidanit.laptopshop.repository.RoleRepository;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Service
public class UploadService {
    private final ServletContext servletContext;
    public UploadService(ServletContext servletContext) {
        this.servletContext = servletContext;
    }
    public String handleUPloadFile(MultipartFile file, String targetFolder) throws IOException {
        if (file.isEmpty()) return "";  //Nếu không up avatar thì trả về rỗng
        String rootPath = this.servletContext.getRealPath("/resources/images");
        String finalName = "";
        byte[] bytes = file.getBytes();
        File dir = new File(rootPath + File.separator + targetFolder);
        if (!dir.exists())
            dir.mkdirs();  //mkdirs: viết tắt của make directories
        // Create the file on server
        finalName = System.currentTimeMillis() + "-" + file.getOriginalFilename();
        File serverFile = new File(dir.getAbsolutePath() + File.separator +finalName);
        BufferedOutputStream stream = new BufferedOutputStream(
                new FileOutputStream(serverFile));
        stream.write(bytes);
        stream.close();
        return serverFile.getAbsolutePath();
    }
}
