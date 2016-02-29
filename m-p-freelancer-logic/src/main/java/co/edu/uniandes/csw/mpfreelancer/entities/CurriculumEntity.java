package co.edu.uniandes.csw.mpfreelancer.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import co.edu.uniandes.csw.crud.spi.entity.BaseEntity;
import uk.co.jemos.podam.common.PodamExclude;
import javax.persistence.OneToOne;

/**
 * @generated
 */
@Entity
public class CurriculumEntity extends BaseEntity implements Serializable {

    private String profile;
    
    private String identification;
    
    private String email;
    
    private String mobile;

    @PodamExclude
    @OneToOne
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
    public String getMobile(){
        return mobile;
    }

    /**
     * @generated
     */
    public void setMobile(String mobile){
        this.mobile = mobile;
    }
    
    /**
     * @generated
     */
    public String getIdentification(){
        return identification;
    }

    /**
     * @generated
     */
    public void setIdentification(String identification){
        this.identification = identification;
    }
    
    /**
     * @generated
     */
    public String getEmail(){
        return email;
    }

    /**
     * @generated
     */
    public void setEmail(String email){
        this.email = email;
    }
    
    /**
     * @generated
     */
    public String getProfile(){
        return profile;
    }

    /**
     * @generated
     */
    public void setProfile(String profile){
        this.profile = profile;
    }
}