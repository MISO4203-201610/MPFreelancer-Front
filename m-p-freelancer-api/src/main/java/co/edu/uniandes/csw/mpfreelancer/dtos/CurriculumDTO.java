/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.mpfreelancer.dtos;

import javax.xml.bind.annotation.XmlRootElement;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author Fernando
 */
@XmlRootElement
public class CurriculumDTO {
    
    private Long id;
    private String profile;
    private String identification;
    private String email;
    private String mobile;
    @PodamExclude
    private FreelancerDTO freelancer;

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
    public String getProfile() {
        return profile;
    }

    /**
     * @generated
     */
    public void setProfile(String profile) {
        this.profile = profile;
    }

    /**
     * @generated
     */
    public String getIdentification() {
        return identification;
    }

    /**
     * @generated
     */
    public void setIdentification(String identification) {
        this.identification = identification;
    }

    /**
     * @generated
     */
    public String getEmail() {
        return email;
    }

    /**
     * @generated
     */
    public void setEmail(String email) {
        this.email = email;
    }
    
    /**
     * @generated
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * @generated
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * @generated
     */
    public FreelancerDTO getFreelancer() {
        return freelancer;
    }

    /**
     * @generated
     */
    public void setFreelancer(FreelancerDTO freelancer) {
        this.freelancer = freelancer;
    }
}
