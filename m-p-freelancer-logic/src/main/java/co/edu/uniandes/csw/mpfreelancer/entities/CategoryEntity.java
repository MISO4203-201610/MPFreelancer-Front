package co.edu.uniandes.csw.mpfreelancer.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import co.edu.uniandes.csw.crud.spi.entity.BaseEntity;
import uk.co.jemos.podam.common.PodamExclude;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.ArrayList;

/**
 * @generated
 */
@Entity
public class CategoryEntity extends BaseEntity implements Serializable {

    private String description;

    @PodamExclude
    @OneToMany(mappedBy = "category")
    private List<ProjectEntity> projects = new ArrayList<>();

    /**
     * @generated
     */
    public String getDescription(){
        return description;
    }

    /**
     * @generated
     */
    public void setDescription(String description){
        this.description = description;
    }

    /**
     * @generated
     */
    public List<ProjectEntity> getProjects() {
        return projects;
    }

    /**
     * @generated
     */
    public void setProjects(List<ProjectEntity> projects) {
        this.projects = projects;
    }
}
