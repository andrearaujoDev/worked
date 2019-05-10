package controllers;

import java.io.IOException;
import java.util.Scanner;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.xml.parsers.ParserConfigurationException;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;
import org.xml.sax.SAXException;

@ManagedBean
public class UparArquivos {

   private UploadedFile file;
   private String textoArquivo;
   
    public UploadedFile getFile() {
        return file;
    }
 
    public void setFile(UploadedFile file) {
        this.file = file;
    }
     
    public void upload() throws SAXException, ParserConfigurationException {
        if(file != null) {
            FacesMessage msg = new FacesMessage("Succesful", file.getFileName() + " is uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }
     
    public void handleFileUpload(FileUploadEvent event) throws SAXException, ParserConfigurationException, IOException {
        FacesMessage msg = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        textoArquivo = new Scanner(event.getFile().getInputstream(),"UTF-8").useDelimiter("\\A").next();
         
    }

    public String getTextoArquivo() {
        return textoArquivo;
    }

    public void setTextoArquivo(String textoArquivo) {
        this.textoArquivo = textoArquivo;
    }
    
}
