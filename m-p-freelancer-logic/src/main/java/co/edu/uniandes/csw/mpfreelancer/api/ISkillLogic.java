package co.edu.uniandes.csw.mpfreelancer.api;

import co.edu.uniandes.csw.mpfreelancer.entities.SkillEntity;
import co.edu.uniandes.csw.mpfreelancer.entities.FreelancerEntity;
import co.edu.uniandes.csw.mpfreelancer.entities.ProjectEntity;
import java.util.List;

public interface ISkillLogic {
    public int countSkills();
    public List<SkillEntity> getSkills();
    public List<SkillEntity> getSkills(Integer page, Integer maxRecords);
    public SkillEntity getSkill(Long id);
    public SkillEntity createSkill(SkillEntity entity);
    public SkillEntity updateSkill(SkillEntity entity);
    public void deleteSkill(Long id);
    public List<FreelancerEntity> listFreelancers(Long skillId);
    public FreelancerEntity getFreelancers(Long skillId, Long freelancersId);
    public FreelancerEntity addFreelancers(Long skillId, Long freelancersId);
    public List<FreelancerEntity> replaceFreelancers(Long skillId, List<FreelancerEntity> list);
    public void removeFreelancers(Long skillId, Long freelancersId);
    public List<ProjectEntity> listProjects(Long skillId);
    public ProjectEntity getProjects(Long skillId, Long projectsId);
    public ProjectEntity addProjects(Long skillId, Long projectsId);
    public List<ProjectEntity> replaceProjects(Long skillId, List<ProjectEntity> list);
    public void removeProjects(Long skillId, Long projectsId);
}
