package co.edu.uniandes.csw.mpfreelancer.converters;

import co.edu.uniandes.csw.mpfreelancer.dtos.ProjectSponsorDTO;
import co.edu.uniandes.csw.mpfreelancer.entities.ProjectSponsorEntity;
import java.util.ArrayList;
import java.util.List;

/**
 * @generated
 */
public abstract class ProjectSponsorConverter {

    /**
     * Constructor privado para evitar la creación del constructor implícito de Java
     * @generated
     */
    private ProjectSponsorConverter() {
    }

    /**
     * Realiza la conversión de ProjectSponsorEntity a ProjectSponsorDTO.
     * Se invoca cuando otra entidad tiene una referencia a ProjectSponsorEntity.
     * Entrega únicamente los atributos proprios de la entidad.
     *
     * @param entity instancia de ProjectSponsorEntity a convertir
     * @return instancia de ProjectSponsorDTO con los datos recibidos por parámetro
     * @generated
     */
    public static ProjectSponsorDTO refEntity2DTO(ProjectSponsorEntity entity) {
        if (entity != null) {
            ProjectSponsorDTO dto = new ProjectSponsorDTO();
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            dto.setCompany(entity.getCompany());
            dto.setPicture(entity.getPicture());

            return dto;
        } else {
            return null;
        }
    }

    /**
     * Realiza la conversión de ProjectSponsorDTO a ProjectSponsorEntity Se invoca cuando otro DTO
     * tiene una referencia a ProjectSponsorDTO Convierte únicamente el ID ya que es el
     * único atributo necesario para guardar la relación en la base de datos
     *
     * @param dto instancia de ProjectSponsorDTO a convertir
     * @return instancia de ProjectSponsorEntity con los datos recibidos por parámetro
     * @generated
     */
    public static ProjectSponsorEntity refDTO2Entity(ProjectSponsorDTO dto) {
        if (dto != null) {
            ProjectSponsorEntity entity = new ProjectSponsorEntity();
            entity.setId(dto.getId());

            return entity;
        } else {
            return null;
        }
    }

    /**
     * Convierte una instancia de ProjectSponsorEntity a ProjectSponsorDTO Se invoca cuando se desea
     * consultar la entidad y sus relaciones muchos a uno o uno a uno
     *
     * @param entity instancia de ProjectSponsorEntity a convertir
     * @return Instancia de ProjectSponsorDTO con los datos recibidos por parámetro
     * @generated
     */
    private static ProjectSponsorDTO basicEntity2DTO(ProjectSponsorEntity entity) {
        if (entity != null) {
            ProjectSponsorDTO dto = new ProjectSponsorDTO();
            dto.setId(entity.getId());
            dto.setName(entity.getName());
            dto.setCompany(entity.getCompany());
            dto.setPicture(entity.getPicture());

            return dto;
        } else {
            return null;
        }
    }

    /**
     * Convierte una instancia de ProjectSponsorDTO a ProjectSponsorEntity Se invoca cuando se
     * necesita convertir una instancia de ProjectSponsorDTO con los atributos propios de
     * la entidad y con las relaciones uno a uno o muchos a uno
     *
     * @param dto instancia de ProjectSponsorDTO a convertir
     * @return Instancia de ProjectSponsorEntity creada a partir de los datos de dto
     * @generated
     */
    private static ProjectSponsorEntity basicDTO2Entity(ProjectSponsorDTO dto) {
        if (dto != null) {
            ProjectSponsorEntity entity = new ProjectSponsorEntity();
            entity.setId(dto.getId());
            entity.setName(dto.getName());
            entity.setCompany(dto.getCompany());
            entity.setPicture(dto.getPicture());

            return entity;
        } else {
            return null;
        }
    }

    /**
     * Convierte instancias de ProjectSponsorEntity a ProjectSponsorDTO incluyendo sus relaciones
     * Uno a muchos y Muchos a muchos
     *
     * @param entity Instancia de ProjectSponsorEntity a convertir
     * @return Instancia de ProjectSponsorDTO con los datos recibidos por parámetro
     * @generated
     */
    public static ProjectSponsorDTO fullEntity2DTO(ProjectSponsorEntity entity) {
        if (entity != null) {
            ProjectSponsorDTO dto = basicEntity2DTO(entity);
            dto.setProjects(ProjectConverter.listEntity2DTO(entity.getProjects()));
            return dto;
        } else {
            return null;
        }
    }

    /**
     * Convierte una instancia de ProjectSponsorDTO a ProjectSponsorEntity.
     * Incluye todos los atributos de ProjectSponsorEntity.
     *
     * @param dto Instancia de ProjectSponsorDTO a convertir
     * @return Instancia de ProjectSponsorEntity con los datos recibidos por parámetro
     * @generated
     */
    public static ProjectSponsorEntity fullDTO2Entity(ProjectSponsorDTO dto) {
        if (dto != null) {
            ProjectSponsorEntity entity = basicDTO2Entity(dto);
            entity.setProjects(ProjectConverter.listDTO2Entity(dto.getProjects()));
            return entity;
        } else {
            return null;
        }
    }

    /**
     * Convierte una colección de instancias de ProjectSponsorEntity a ProjectSponsorDTO. Para cada
     * instancia de ProjectSponsorEntity en la lista, invoca basicEntity2DTO y añade el
     * nuevo ProjectSponsorDTO a una nueva lista
     *
     * @param entities Colección de entidades a convertir
     * @return Collección de instancias de ProjectSponsorDTO
     * @generated
     */
    public static List<ProjectSponsorDTO> listEntity2DTO(List<ProjectSponsorEntity> entities) {
        List<ProjectSponsorDTO> dtos = new ArrayList<ProjectSponsorDTO>();
        if (entities != null) {
            for (ProjectSponsorEntity entity : entities) {
                dtos.add(basicEntity2DTO(entity));
            }
        }
        return dtos;
    }

    /**
     * Convierte una colección de instancias de ProjectSponsorDTO a instancias de
     * ProjectSponsorEntity Para cada instancia se invoca el método basicDTO2Entity
     *
     * @param dtos entities Colección de ProjectSponsorDTO a convertir
     * @return Collección de instancias de ProjectSponsorEntity
     * @generated
     */
    public static List<ProjectSponsorEntity> listDTO2Entity(List<ProjectSponsorDTO> dtos) {
        List<ProjectSponsorEntity> entities = new ArrayList<ProjectSponsorEntity>();
        if (dtos != null) {
            for (ProjectSponsorDTO dto : dtos) {
                entities.add(basicDTO2Entity(dto));
            }
        }
        return entities;
    }
}
