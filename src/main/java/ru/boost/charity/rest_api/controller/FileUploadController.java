package ru.boost.charity.rest_api.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.boost.charity.rest_api.service.FileUploadService;

@Slf4j
@Controller
@RequestMapping("/rest/file")
@RequiredArgsConstructor
public class FileUploadController {

    private final FileUploadService fileUploadService;

    @GetMapping("/{id}")
    public ResponseEntity<byte[]> getFile(@PathVariable Long id) {
        return new ResponseEntity<>(fileUploadService.getFileById(id).getValue(), HttpStatus.OK);
    }

    //public ResponseEntity<> getFilesByUserId
}
