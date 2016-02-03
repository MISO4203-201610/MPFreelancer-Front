package co.edu.uniandes.csw.mpfreelancer.api;

import co.edu.uniandes.csw.mpfreelancer.entities.StatusEntity;
import co.edu.uniandes.csw.mpfreelancer.entities.ProjectEntity;
import java.util.List;

public interface IStatusLogic {
    public int countStatuss();
    public List<StatusEntity> getStatuss();
    public List<StatusEntity> getStatuss(Integer page, Integer maxRecords);
    public StatusEntity getStatus(Long id);
    public StatusEntity createStatus(StatusEntity entity);
    public StatusEntity updateStatus(StatusEntity entity);
    public void deleteStatus(Long id);
    public List<ProjectEntity> listProject(Long statusId);
    public ProjectEntity getProject(Long statusId, Long projectId);
    public ProjectEntity addProject(Long statusId, Long projectId);
    public List<ProjectEntity> replaceProject(Long statusId, List<ProjectEntity> list);
    public void removeProject(Long statusId, Long projectId);
}
