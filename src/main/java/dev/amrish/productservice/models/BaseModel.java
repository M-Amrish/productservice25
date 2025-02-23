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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateedAt() {
        return createedAt;
    }

    public void setCreateedAt(Date createedAt) {
        this.createedAt = createedAt;
    }

    public Date getUpdateddAt() {
        return updateddAt;
    }

    public void setUpdateddAt(Date updateddAt) {
        this.updateddAt = updateddAt;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }
}
