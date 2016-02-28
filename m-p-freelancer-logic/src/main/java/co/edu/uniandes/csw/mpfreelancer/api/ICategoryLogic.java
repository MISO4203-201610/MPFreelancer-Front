package co.edu.uniandes.csw.mpfreelancer.api;

import co.edu.uniandes.csw.mpfreelancer.entities.CategoryEntity;
import co.edu.uniandes.csw.mpfreelancer.entities.ProjectEntity;
import java.util.List;

public interface ICategoryLogic {
    public int countCategorys();
    public List<CategoryEntity> getCategorys();
    public List<CategoryEntity> getCategorys(Integer page, Integer maxRecords);
    public CategoryEntity getCategory(Long id);
    public CategoryEntity createCategory(CategoryEntity entity);
    public CategoryEntity updateCategory(CategoryEntity entity);
    public void deleteCategory(Long id);
    public List<ProjectEntity> listProjects(Long categoryId);
    public ProjectEntity getProjects(Long categoryId, Long projectsId);
    public ProjectEntity addProjects(Long categoryId, Long projectsId);
    public List<ProjectEntity> replaceProjects(Long categoryId, List<ProjectEntity> list);
    public void removeProjects(Long categoryId, Long projectsId);
}
