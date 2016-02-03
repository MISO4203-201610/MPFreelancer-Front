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
public class StatusEntity extends BaseEntity implements Serializable {

    @PodamExclude
    @OneToMany(mappedBy = "status")
    private List<ProjectEntity> project = new ArrayList<>();

    /**
     * @generated
     */
    public List<ProjectEntity> getProject() {
        return project;
    }

    /**
     * @generated
     */
    public void setProject(List<ProjectEntity> project) {
        this.project = project;
    }
}
