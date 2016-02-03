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
import co.edu.uniandes.csw.mpfreelancer.api.ICategoryLogic;
import co.edu.uniandes.csw.mpfreelancer.dtos.CategoryDTO;
import co.edu.uniandes.csw.mpfreelancer.entities.CategoryEntity;
import co.edu.uniandes.csw.mpfreelancer.converters.CategoryConverter;
import co.edu.uniandes.csw.mpfreelancer.dtos.ProjectDTO;
import co.edu.uniandes.csw.mpfreelancer.converters.ProjectConverter;

/**
 * @generated
 */
@Path("/categorys")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CategoryService {

    @Inject private ICategoryLogic categoryLogic;
    @Context private HttpServletResponse response;
    @QueryParam("page") private Integer page;
    @QueryParam("maxRecords") private Integer maxRecords;

    /**
     * Obtiene la lista de los registros de Book.
     *
     * @return Colección de objetos de CategoryDTO cada uno con sus respectivos Review
     * @generated
     */
    @GET
    public List<CategoryDTO> getCategorys() {
        if (page != null && maxRecords != null) {
            this.response.setIntHeader("X-Total-Count", categoryLogic.countCategorys());
            return CategoryConverter.listEntity2DTO(categoryLogic.getCategorys(page, maxRecords));
        }
        return CategoryConverter.listEntity2DTO(categoryLogic.getCategorys());
    }

    /**
     * Obtiene los datos de una instancia de Book a partir de su ID.
     *
     * @param id Identificador de la instancia a consultar
     * @return Instancia de CategoryDTO con los datos del Book consultado y sus Review
     * @generated
     */
    @GET
    @Path("{id: \\d+}")
    public CategoryDTO getCategory(@PathParam("id") Long id) {
        return CategoryConverter.fullEntity2DTO(categoryLogic.getCategory(id));
    }

    /**
     * Se encarga de crear un book en la base de datos.
     *
     * @param dto Objeto de CategoryDTO con los datos nuevos
     * @return Objeto de CategoryDTO con los datos nuevos y su ID.
     * @generated
     */
    @POST
    @StatusCreated
    public CategoryDTO createCategory(CategoryDTO dto) {
        CategoryEntity entity = CategoryConverter.fullDTO2Entity(dto);
        return CategoryConverter.fullEntity2DTO(categoryLogic.createCategory(entity));
    }

    /**
     * Actualiza la información de una instancia de Book.
     *
     * @param id Identificador de la instancia de Book a modificar
     * @param dto Instancia de CategoryDTO con los nuevos datos.
     * @return Instancia de CategoryDTO con los datos actualizados.
     * @generated
     */
    @PUT
    @Path("{id: \\d+}")
    public CategoryDTO updateCategory(@PathParam("id") Long id, CategoryDTO dto) {
        CategoryEntity entity = CategoryConverter.fullDTO2Entity(dto);
        entity.setId(id);
        return CategoryConverter.fullEntity2DTO(categoryLogic.updateCategory(entity));
    }

    /**
     * Elimina una instancia de Book de la base de datos.
     *
     * @param id Identificador de la instancia a eliminar.
     * @generated
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteCategory(@PathParam("id") Long id) {
        categoryLogic.deleteCategory(id);
    }

    /**
     * Obtiene una colección de instancias de ProjectDTO asociadas a una
     * instancia de Category
     *
     * @param categoryId Identificador de la instancia de Category
     * @return Colección de instancias de ProjectDTO asociadas a la instancia de Category
     * @generated
     */
    @GET
    @Path("{categoryId: \\d+}/projects")
    public List<ProjectDTO> listProjects(@PathParam("categoryId") Long categoryId) {
        return ProjectConverter.listEntity2DTO(categoryLogic.listProjects(categoryId));
    }

    /**
     * Obtiene una instancia de Project asociada a una instancia de Category
     *
     * @param categoryId Identificador de la instancia de Category
     * @param projectId Identificador de la instancia de Project
     * @generated
     */
    @GET
    @Path("{categoryId: \\d+}/projects/{projectId: \\d+}")
    public ProjectDTO getProjects(@PathParam("categoryId") Long categoryId, @PathParam("projectId") Long projectId) {
        return ProjectConverter.fullEntity2DTO(categoryLogic.getProjects(categoryId, projectId));
    }

    /**
     * Asocia un Project existente a un Category
     *
     * @param categoryId Identificador de la instancia de Category
     * @param projectId Identificador de la instancia de Project
     * @return Instancia de ProjectDTO que fue asociada a Category
     * @generated
     */
    @POST
    @Path("{categoryId: \\d+}/projects/{projectId: \\d+}")
    public ProjectDTO addProjects(@PathParam("categoryId") Long categoryId, @PathParam("projectId") Long projectId) {
        return ProjectConverter.fullEntity2DTO(categoryLogic.addProjects(categoryId, projectId));
    }

    /**
     * Remplaza las instancias de Project asociadas a una instancia de Category
     *
     * @param categoryId Identificador de la instancia de Category
     * @param projects Colección de instancias de ProjectDTO a asociar a instancia de Category
     * @return Nueva colección de ProjectDTO asociada a la instancia de Category
     * @generated
     */
    @PUT
    @Path("{categoryId: \\d+}/projects")
    public List<ProjectDTO> replaceProjects(@PathParam("categoryId") Long categoryId, List<ProjectDTO> projects) {
        return ProjectConverter.listEntity2DTO(categoryLogic.replaceProjects(categoryId, ProjectConverter.listDTO2Entity(projects)));
    }

    /**
     * Desasocia un Project existente de un Category existente
     *
     * @param categoryId Identificador de la instancia de Category
     * @param projectId Identificador de la instancia de Project
     * @generated
     */
    @DELETE
    @Path("{categoryId: \\d+}/projects/{projectId: \\d+}")
    public void removeProjects(@PathParam("categoryId") Long categoryId, @PathParam("projectId") Long projectId) {
        categoryLogic.removeProjects(categoryId, projectId);
    }
}
