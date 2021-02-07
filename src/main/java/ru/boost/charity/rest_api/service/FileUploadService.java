package ru.boost.charity.rest_api.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.boost.charity.rest_api.entity.UploadedFile;
import ru.boost.charity.rest_api.repository.UploadFileRepository;

import javax.persistence.EntityExistsException;

@Service
@RequiredArgsConstructor
public class FileUploadService {

    private final UploadFileRepository fileRepository;

    public UploadedFile getFileById(Long id) {
        return fileRepository.findById(id).orElseThrow(EntityExistsException::new);
    }

}
