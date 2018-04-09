package site.sixteen.springmvc.fileupload.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.FileNotFoundException;
import java.io.IOException;

@ControllerAdvice
public class WebExceptionHandler{

    @ExceptionHandler({MultipartException.class,FileNotFoundException.class,IOException.class})
    public String handleFileUploadException(Exception e, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("message", e.getLocalizedMessage());
        return "redirect:/upload";
    }
}

