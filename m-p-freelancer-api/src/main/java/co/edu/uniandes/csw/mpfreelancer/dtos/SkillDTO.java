package co.edu.uniandes.csw.mpfreelancer.dtos;

import javax.xml.bind.annotation.XmlRootElement;
import uk.co.jemos.podam.common.PodamExclude;
import java.util.List;
import java.util.ArrayList;

/**
 * @generated
 */
@XmlRootElement
public class SkillDTO {

    private Long id;
    private String name;
    private String description;
    @PodamExclude
    private List<FreelancerDTO> freelancers = new ArrayList<>();
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
    public String getDescription() {
        return description;
    }

    /**
     * @generated
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @generated
     */
    public List<FreelancerDTO> getFreelancers() {
        return freelancers;
    }

    /**
     * @generated
     */
    public void setFreelancers(List<FreelancerDTO> freelancers) {
        this.freelancers = freelancers;
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
