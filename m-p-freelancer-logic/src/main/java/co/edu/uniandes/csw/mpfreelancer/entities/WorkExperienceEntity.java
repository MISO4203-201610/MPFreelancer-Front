package co.edu.uniandes.csw.mpfreelancer.entities;

import co.edu.uniandes.csw.crud.api.podam.strategy.DateStrategy;
import java.io.Serializable;
import javax.persistence.Entity;
import co.edu.uniandes.csw.crud.spi.entity.BaseEntity;
import uk.co.jemos.podam.common.PodamExclude;
import java.util.Date;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import uk.co.jemos.podam.common.PodamStrategyValue;

/**
 * @generated
 */
@Entity
public class WorkExperienceEntity extends BaseEntity implements Serializable {

    private String projectName;
    
    private String projectDescription;
    
    @Temporal(TemporalType.DATE)
    @PodamStrategyValue(DateStrategy.class)
    private Date startDate;

    @Temporal(TemporalType.DATE)
    @PodamStrategyValue(DateStrategy.class)
    private Date endDate;
    
    private String sponsorCompany;

    @PodamExclude
    @ManyToOne
    private FreelancerEntity freelancer;

    /**
     * @generated
     */
    public FreelancerEntity getFreelancer(){
        return freelancer;
    }
    
     /**
     * @generated
     */
    public void setFreelancer(FreelancerEntity freelancer){
        this.freelancer = freelancer;
    }
    
    /**
     * @generated
     */
    public Date getStartDate(){
        return startDate;
    }

    /**
     * @generated
     */
    public void setStartDate(Date startDate){
        this.startDate = startDate;
    }
    
    /**
     * @generated
     */
    public Date getEndDate(){
        return endDate;
    }

    /**
     * @generated
     */
    public void setEndDate(Date endDate){
        this.endDate = endDate;
    }
    
    /**
     * @generated
     */
    public String getProjectDescription(){
        return projectDescription;
    }

    /**
     * @generated
     */
    public void setProjectDescription(String projectDescription){
        this.projectDescription = projectDescription;
    }
    
    /**
     * @generated
     */
    public String getSponsorCompany(){
        return sponsorCompany;
    }

    /**
     * @generated
     */
    public void setSponsorCompany(String sponsorCompany){
        this.sponsorCompany = sponsorCompany;
    }
    
    /**
     * @generated
     */
    public String getProjectName(){
        return projectName;
    }

    /**
     * @generated
     */
    public void setProjectName(String projectName){
        this.projectName = projectName;
    }
}
