package ru.boost.charity.rest_api.repository;

import org.springframework.data.repository.CrudRepository;
import ru.boost.charity.rest_api.entity.UploadedFile;

public interface UploadFileRepository extends CrudRepository<UploadedFile, Long> {
}
