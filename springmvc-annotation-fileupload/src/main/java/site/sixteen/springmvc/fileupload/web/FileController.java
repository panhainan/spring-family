package site.sixteen.springmvc.fileupload.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;

@Slf4j
@Controller
public class FileController {

    @GetMapping({"/", "/upload"})
    public String upload() {
        return "upload";
    }

    @PostMapping("/upload")
    public String upload(@RequestPart MultipartFile file, RedirectAttributes redirectAttributes) throws IOException {
        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Error，Please select a file to upload");
            return "redirect:/upload";
        }
        file.transferTo(new File(file.getOriginalFilename()));
        redirectAttributes.addFlashAttribute("message", "You successfully uploaded '" + file.getOriginalFilename() + "'");
        return "redirect:/upload";
    }

    @PostMapping("/uploadMulti")
    public String multiFileUpload(@RequestPart MultipartFile[] files, RedirectAttributes redirectAttributes) throws IOException {
        int i=1;
        for (MultipartFile file : files) {
            if (file.isEmpty()) {
                redirectAttributes.addFlashAttribute("messages"+i, "Error，Please select a file to upload");
            }else{
                file.transferTo(new File(file.getOriginalFilename()));
                redirectAttributes.addFlashAttribute("messages"+i,"You successfully uploaded '" + file.getOriginalFilename() + "'");
            }
            i++;
        }
        return "redirect:/upload";

    }
}
