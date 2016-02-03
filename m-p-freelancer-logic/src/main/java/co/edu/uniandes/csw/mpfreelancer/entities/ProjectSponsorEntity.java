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
public class ProjectSponsorEntity extends BaseEntity implements Serializable {

    private String company;

    private String picture;

    @PodamExclude
    @OneToMany(mappedBy = "sponsor")
    private List<ProjectEntity> projects = new ArrayList<>();

    /**
     * @generated
     */
    public String getCompany(){
        return company;
    }

    /**
     * @generated
     */
    public void setCompany(String company){
        this.company = company;
    }

    /**
     * @generated
     */
    public String getPicture(){
        return picture;
    }

    /**
     * @generated
     */
    public void setPicture(String picture){
        this.picture = picture;
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
