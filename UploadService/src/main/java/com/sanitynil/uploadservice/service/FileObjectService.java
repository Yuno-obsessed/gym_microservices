package com.sanitynil.uploadservice.service;

import com.sanitynil.uploadservice.domain.entity.FileObject;
import com.sanitynil.uploadservice.domain.repository.FileObjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FileObjectService {

    @Autowired
    private FileObjectRepository fileObjectRepository;

    public Optional<FileObject> findByObjectId(Integer id){
        return fileObjectRepository.findFileObjectByObjectId(id);
    }

    public void save(FileObject fileObject){
        fileObjectRepository.save(fileObject);
    }

    public void deleteFileObject(FileObject fileObject){
        fileObjectRepository.delete(fileObject);
    }

    public Optional<List<FileObject>> getAllbyEntity(String entity){
        return fileObjectRepository.findAllByEntity(entity);
    }
}
