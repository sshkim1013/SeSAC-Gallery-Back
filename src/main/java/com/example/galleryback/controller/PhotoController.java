package com.example.galleryback.controller;

import com.example.galleryback.dto.request.PhotoRequest;
import com.example.galleryback.dto.response.PhotoResponse;
import com.example.galleryback.service.PhotoService;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/photos")
@RequiredArgsConstructor
public class PhotoController {

    private final PhotoService photoService;

    @GetMapping
    public List<PhotoResponse> list() {
        return photoService.findAll();
    }

    @GetMapping("/{id}")
    public PhotoResponse detail(
        @PathVariable Long id
    ) {
        return photoService.findById(id);
    }

    @PostMapping
    public PhotoResponse upload(
        @Valid @ModelAttribute PhotoRequest request,
        @RequestParam MultipartFile file
    ) {
        return photoService.save(request, file);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        photoService.delete(id);
    }

}
