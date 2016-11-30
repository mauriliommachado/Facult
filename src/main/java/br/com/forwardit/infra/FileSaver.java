/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.forwardit.infra;

import java.io.File;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author mauri
 */
@Component
public class FileSaver {
    
    @Autowired
    private HttpServletRequest request;
    
    public String write(MultipartFile file){
        String realPath = "C:\\Users\\mauri\\OneDrive\\Documentos\\Arquivos\\uploaded-images";
        try{
            String path = realPath+"/"+file.getOriginalFilename();
            File destino = new File(path);
            file.transferTo(destino);
            return "C:\\Users\\mauri\\OneDrive\\Documentos\\Arquivos\\uploaded-images"+file.getOriginalFilename();
        }catch(IOException ex){
            throw new RuntimeException(ex);
        }
    }
}
