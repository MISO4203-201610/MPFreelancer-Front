package co.edu.uniandes.csw.mpfreelancer.api;

import co.edu.uniandes.csw.mpfreelancer.entities.ProjectSponsorEntity;
import co.edu.uniandes.csw.mpfreelancer.entities.ProjectEntity;
import java.util.List;

public interface IProjectSponsorLogic {
    public int countProjectSponsors();
    public List<ProjectSponsorEntity> getProjectSponsors();
    public List<ProjectSponsorEntity> getProjectSponsors(Integer page, Integer maxRecords);
    public ProjectSponsorEntity getProjectSponsor(Long id);
    public ProjectSponsorEntity createProjectSponsor(ProjectSponsorEntity entity);
    public ProjectSponsorEntity updateProjectSponsor(ProjectSponsorEntity entity);
    public void deleteProjectSponsor(Long id);
    public List<ProjectEntity> listProjects(Long projectSponsorId);
    public ProjectEntity getProjects(Long projectSponsorId, Long projectsId);
    public ProjectEntity addProjects(Long projectSponsorId, Long projectsId);
    public List<ProjectEntity> replaceProjects(Long projectSponsorId, List<ProjectEntity> list);
    public void removeProjects(Long projectSponsorId, Long projectsId);
}
