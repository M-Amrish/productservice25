package dev.amrish.productservice.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Setter
@Getter
@MappedSuperclass
public class BaseModel {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long id;
    private Date createedAt;
    private Date updateddAt;
    private boolean isDeleted;

}
