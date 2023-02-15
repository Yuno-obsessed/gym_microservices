package com.sanitynil.uploadservice.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "objects")
public class FileObject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "object_id")
    private Integer objectId;
    @Column(name = "name", nullable = false, length = 250)
    private String name;
    @Column(name = "entity", nullable = false, length = 60)
    private String entity;
    // TODO: Add timestamp when file was uploaded

    public FileObject(String name, String entity){
        this.name = name;
        this.entity = entity;
    }
}
