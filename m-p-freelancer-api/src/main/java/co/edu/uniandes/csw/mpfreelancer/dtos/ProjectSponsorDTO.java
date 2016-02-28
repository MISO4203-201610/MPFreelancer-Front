package co.edu.uniandes.csw.mpfreelancer.dtos;

import javax.xml.bind.annotation.XmlRootElement;
import uk.co.jemos.podam.common.PodamExclude;
import java.util.List;
import java.util.ArrayList;

/**
 * @generated
 */
@XmlRootElement
public class ProjectSponsorDTO {

    private Long id;
    private String name;
    private String company;
    private String picture;
    @PodamExclude
    private List<ProjectDTO> projects = new ArrayList<>();

    /**
     * @generated
     */
    public Long getId() {
        return id;
    }

    /**
     * @generated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @generated
     */
    public String getName() {
        return name;
    }

    /**
     * @generated
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @generated
     */
    public String getCompany() {
        return company;
    }

    /**
     * @generated
     */
    public void setCompany(String company) {
        this.company = company;
    }

    /**
     * @generated
     */
    public String getPicture() {
        return picture;
    }

    /**
     * @generated
     */
    public void setPicture(String picture) {
        this.picture = picture;
    }

    /**
     * @generated
     */
    public List<ProjectDTO> getProjects() {
        return projects;
    }

    /**
     * @generated
     */
    public void setProjects(List<ProjectDTO> projects) {
        this.projects = projects;
    }

}
