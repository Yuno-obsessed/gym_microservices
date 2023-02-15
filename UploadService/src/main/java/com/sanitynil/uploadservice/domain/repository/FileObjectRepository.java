package com.sanitynil.uploadservice.domain.repository;

import com.sanitynil.uploadservice.domain.entity.FileObject;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FileObjectRepository extends JpaRepository<FileObject, Integer> {
    Optional<FileObject> findFileObjectByObjectId(Integer id);


}
