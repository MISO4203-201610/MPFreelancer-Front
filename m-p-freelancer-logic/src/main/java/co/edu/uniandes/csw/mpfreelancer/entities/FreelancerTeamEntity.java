package co.edu.uniandes.csw.mpfreelancer.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import co.edu.uniandes.csw.crud.spi.entity.BaseEntity;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import uk.co.jemos.podam.common.PodamStrategyValue;
import co.edu.uniandes.csw.crud.api.podam.strategy.DateStrategy;
import uk.co.jemos.podam.common.PodamExclude;
import javax.persistence.ManyToMany;
import java.util.List;
import java.util.ArrayList;

/**
 * @generated
 */
@Entity
public class FreelancerTeamEntity extends BaseEntity implements Serializable {

    private Integer rate;

    @Temporal(TemporalType.DATE)
    @PodamStrategyValue(DateStrategy.class)
    private Date creation;

    private String picture;

    @PodamExclude
    @ManyToMany(mappedBy = "freelancerTeams")
    private List<FreelancerEntity> freelancers = new ArrayList<>();

    /**
     * @generated
     */
    public Integer getRate(){
        return rate;
    }

    /**
     * @generated
     */
    public void setRate(Integer rate){
        this.rate = rate;
    }

    /**
     * @generated
     */
    public Date getCreation(){
        return creation;
    }

    /**
     * @generated
     */
    public void setCreation(Date creation){
        this.creation = creation;
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
    public List<FreelancerEntity> getFreelancers() {
        return freelancers;
    }

    /**
     * @generated
     */
    public void setFreelancers(List<FreelancerEntity> freelancers) {
        this.freelancers = freelancers;
    }
}
