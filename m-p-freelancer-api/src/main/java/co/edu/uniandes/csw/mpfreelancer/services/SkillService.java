package co.edu.uniandes.csw.mpfreelancer.services;

import co.edu.uniandes.csw.auth.provider.StatusCreated;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import co.edu.uniandes.csw.mpfreelancer.api.ISkillLogic;
import co.edu.uniandes.csw.mpfreelancer.dtos.SkillDTO;
import co.edu.uniandes.csw.mpfreelancer.entities.SkillEntity;
import co.edu.uniandes.csw.mpfreelancer.converters.SkillConverter;
import co.edu.uniandes.csw.mpfreelancer.dtos.ProjectDTO;
import co.edu.uniandes.csw.mpfreelancer.converters.ProjectConverter;
import co.edu.uniandes.csw.mpfreelancer.dtos.FreelancerDTO;
import co.edu.uniandes.csw.mpfreelancer.converters.FreelancerConverter;

/**
 * @generated
 */
@Path("/skills")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SkillService {

    @Inject private ISkillLogic skillLogic;
    @Context private HttpServletResponse response;
    @QueryParam("page") private Integer page;
    @QueryParam("maxRecords") private Integer maxRecords;

    /**
     * Obtiene la lista de los registros de Book.
     *
     * @return Colección de objetos de SkillDTO cada uno con sus respectivos Review
     * @generated
     */
    @GET
    public List<SkillDTO> getSkills() {
        if (page != null && maxRecords != null) {
            this.response.setIntHeader("X-Total-Count", skillLogic.countSkills());
            return SkillConverter.listEntity2DTO(skillLogic.getSkills(page, maxRecords));
        }
        return SkillConverter.listEntity2DTO(skillLogic.getSkills());
    }

    /**
     * Obtiene los datos de una instancia de Book a partir de su ID.
     *
     * @param id Identificador de la instancia a consultar
     * @return Instancia de SkillDTO con los datos del Book consultado y sus Review
     * @generated
     */
    @GET
    @Path("{id: \\d+}")
    public SkillDTO getSkill(@PathParam("id") Long id) {
        return SkillConverter.fullEntity2DTO(skillLogic.getSkill(id));
    }

    /**
     * Se encarga de crear un book en la base de datos.
     *
     * @param dto Objeto de SkillDTO con los datos nuevos
     * @return Objeto de SkillDTO con los datos nuevos y su ID.
     * @generated
     */
    @POST
    @StatusCreated
    public SkillDTO createSkill(SkillDTO dto) {
        SkillEntity entity = SkillConverter.fullDTO2Entity(dto);
        return SkillConverter.fullEntity2DTO(skillLogic.createSkill(entity));
    }

    /**
     * Actualiza la información de una instancia de Book.
     *
     * @param id Identificador de la instancia de Book a modificar
     * @param dto Instancia de SkillDTO con los nuevos datos.
     * @return Instancia de SkillDTO con los datos actualizados.
     * @generated
     */
    @PUT
    @Path("{id: \\d+}")
    public SkillDTO updateSkill(@PathParam("id") Long id, SkillDTO dto) {
        SkillEntity entity = SkillConverter.fullDTO2Entity(dto);
        entity.setId(id);
        return SkillConverter.fullEntity2DTO(skillLogic.updateSkill(entity));
    }

    /**
     * Elimina una instancia de Book de la base de datos.
     *
     * @param id Identificador de la instancia a eliminar.
     * @generated
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteSkill(@PathParam("id") Long id) {
        skillLogic.deleteSkill(id);
    }

    /**
     * Obtiene una colección de instancias de ProjectDTO asociadas a una
     * instancia de Skill
     *
     * @param skillId Identificador de la instancia de Skill
     * @return Colección de instancias de ProjectDTO asociadas a la instancia de Skill
     * @generated
     */
    @GET
    @Path("{skillId: \\d+}/projects")
    public List<ProjectDTO> listProjects(@PathParam("skillId") Long skillId) {
        return ProjectConverter.listEntity2DTO(skillLogic.listProjects(skillId));
    }

    /**
     * Obtiene una instancia de Project asociada a una instancia de Skill
     *
     * @param skillId Identificador de la instancia de Skill
     * @param projectId Identificador de la instancia de Project
     * @generated
     */
    @GET
    @Path("{skillId: \\d+}/projects/{projectId: \\d+}")
    public ProjectDTO getProjects(@PathParam("skillId") Long skillId, @PathParam("projectId") Long projectId) {
        return ProjectConverter.fullEntity2DTO(skillLogic.getProjects(skillId, projectId));
    }

    /**
     * Asocia un Project existente a un Skill
     *
     * @param skillId Identificador de la instancia de Skill
     * @param projectId Identificador de la instancia de Project
     * @return Instancia de ProjectDTO que fue asociada a Skill
     * @generated
     */
    @POST
    @Path("{skillId: \\d+}/projects/{projectId: \\d+}")
    public ProjectDTO addProjects(@PathParam("skillId") Long skillId, @PathParam("projectId") Long projectId) {
        return ProjectConverter.fullEntity2DTO(skillLogic.addProjects(skillId, projectId));
    }

    /**
     * Remplaza las instancias de Project asociadas a una instancia de Skill
     *
     * @param skillId Identificador de la instancia de Skill
     * @param projects Colección de instancias de ProjectDTO a asociar a instancia de Skill
     * @return Nueva colección de ProjectDTO asociada a la instancia de Skill
     * @generated
     */
    @PUT
    @Path("{skillId: \\d+}/projects")
    public List<ProjectDTO> replaceProjects(@PathParam("skillId") Long skillId, List<ProjectDTO> projects) {
        return ProjectConverter.listEntity2DTO(skillLogic.replaceProjects(skillId, ProjectConverter.listDTO2Entity(projects)));
    }

    /**
     * Desasocia un Project existente de un Skill existente
     *
     * @param skillId Identificador de la instancia de Skill
     * @param projectId Identificador de la instancia de Project
     * @generated
     */
    @DELETE
    @Path("{skillId: \\d+}/projects/{projectId: \\d+}")
    public void removeProjects(@PathParam("skillId") Long skillId, @PathParam("projectId") Long projectId) {
        skillLogic.removeProjects(skillId, projectId);
    }

    /**
     * Obtiene una colección de instancias de FreelancerDTO asociadas a una
     * instancia de Skill
     *
     * @param skillId Identificador de la instancia de Skill
     * @return Colección de instancias de FreelancerDTO asociadas a la instancia de Skill
     * @generated
     */
    @GET
    @Path("{skillId: \\d+}/freelancers")
    public List<FreelancerDTO> listFreelancers(@PathParam("skillId") Long skillId) {
        return FreelancerConverter.listEntity2DTO(skillLogic.listFreelancers(skillId));
    }

    /**
     * Obtiene una instancia de Freelancer asociada a una instancia de Skill
     *
     * @param skillId Identificador de la instancia de Skill
     * @param freelancerId Identificador de la instancia de Freelancer
     * @generated
     */
    @GET
    @Path("{skillId: \\d+}/freelancers/{freelancerId: \\d+}")
    public FreelancerDTO getFreelancers(@PathParam("skillId") Long skillId, @PathParam("freelancerId") Long freelancerId) {
        return FreelancerConverter.fullEntity2DTO(skillLogic.getFreelancers(skillId, freelancerId));
    }

    /**
     * Asocia un Freelancer existente a un Skill
     *
     * @param skillId Identificador de la instancia de Skill
     * @param freelancerId Identificador de la instancia de Freelancer
     * @return Instancia de FreelancerDTO que fue asociada a Skill
     * @generated
     */
    @POST
    @Path("{skillId: \\d+}/freelancers/{freelancerId: \\d+}")
    public FreelancerDTO addFreelancers(@PathParam("skillId") Long skillId, @PathParam("freelancerId") Long freelancerId) {
        return FreelancerConverter.fullEntity2DTO(skillLogic.addFreelancers(skillId, freelancerId));
    }

    /**
     * Remplaza las instancias de Freelancer asociadas a una instancia de Skill
     *
     * @param skillId Identificador de la instancia de Skill
     * @param freelancers Colección de instancias de FreelancerDTO a asociar a instancia de Skill
     * @return Nueva colección de FreelancerDTO asociada a la instancia de Skill
     * @generated
     */
    @PUT
    @Path("{skillId: \\d+}/freelancers")
    public List<FreelancerDTO> replaceFreelancers(@PathParam("skillId") Long skillId, List<FreelancerDTO> freelancers) {
        return FreelancerConverter.listEntity2DTO(skillLogic.replaceFreelancers(skillId, FreelancerConverter.listDTO2Entity(freelancers)));
    }

    /**
     * Desasocia un Freelancer existente de un Skill existente
     *
     * @param skillId Identificador de la instancia de Skill
     * @param freelancerId Identificador de la instancia de Freelancer
     * @generated
     */
    @DELETE
    @Path("{skillId: \\d+}/freelancers/{freelancerId: \\d+}")
    public void removeFreelancers(@PathParam("skillId") Long skillId, @PathParam("freelancerId") Long freelancerId) {
        skillLogic.removeFreelancers(skillId, freelancerId);
    }
}
