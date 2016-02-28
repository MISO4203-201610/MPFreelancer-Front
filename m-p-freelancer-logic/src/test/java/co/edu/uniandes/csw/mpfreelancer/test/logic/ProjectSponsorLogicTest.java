package co.edu.uniandes.csw.mpfreelancer.test.logic;

import co.edu.uniandes.csw.mpfreelancer.ejbs.ProjectSponsorLogic;
import co.edu.uniandes.csw.mpfreelancer.api.IProjectSponsorLogic;
import co.edu.uniandes.csw.mpfreelancer.entities.ProjectSponsorEntity;
import co.edu.uniandes.csw.mpfreelancer.persistence.ProjectSponsorPersistence;
import co.edu.uniandes.csw.mpfreelancer.entities.ProjectEntity;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import org.junit.Assert;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class ProjectSponsorLogicTest {

    /**
     * @generated
     */
    private PodamFactory factory = new PodamFactoryImpl();

    /**
     * @generated
     */
    @Inject
    private IProjectSponsorLogic projectSponsorLogic;

    /**
     * @generated
     */
    @PersistenceContext
    private EntityManager em;

    /**
     * @generated
     */
    @Inject
    private UserTransaction utx;

    /**
     * @generated
     */
    private List<ProjectSponsorEntity> data = new ArrayList<ProjectSponsorEntity>();

    /**
     * @generated
     */
    private List<ProjectEntity> projectsData = new ArrayList<>();

    /**
     * @generated
     */
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(ProjectSponsorEntity.class.getPackage())
                .addPackage(ProjectSponsorLogic.class.getPackage())
                .addPackage(IProjectSponsorLogic.class.getPackage())
                .addPackage(ProjectSponsorPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * @generated
     */
    @Before
    public void configTest() {
        try {
            utx.begin();
            clearData();
            insertData();
            utx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                utx.rollback();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }

    /**
     * @generated
     */
    private void clearData() {
        em.createQuery("delete from ProjectEntity").executeUpdate();
        em.createQuery("delete from ProjectSponsorEntity").executeUpdate();
    }

    /**
     * @generated
     */
    private void insertData() {
        for (int i = 0; i < 3; i++) {
            ProjectEntity projects = factory.manufacturePojo(ProjectEntity.class);
            em.persist(projects);
            projectsData.add(projects);
        }

        for (int i = 0; i < 3; i++) {
            ProjectSponsorEntity entity = factory.manufacturePojo(ProjectSponsorEntity.class);

            em.persist(entity);
            data.add(entity);

            if (i == 0) {
                projectsData.get(i).setSponsor(entity);
            }
        }
    }

    /**
     * @generated
     */
    @Test
    public void createProjectSponsorTest() {
        ProjectSponsorEntity entity = factory.manufacturePojo(ProjectSponsorEntity.class);
        ProjectSponsorEntity result = projectSponsorLogic.createProjectSponsor(entity);
        Assert.assertNotNull(result);
        Assert.assertEquals(result.getId(), entity.getId());
        Assert.assertEquals(result.getName(), entity.getName());
        Assert.assertEquals(result.getCompany(), entity.getCompany());
        Assert.assertEquals(result.getPicture(), entity.getPicture());
    }

    /**
     * @generated
     */
    @Test
    public void getProjectSponsorsTest() {
        List<ProjectSponsorEntity> list = projectSponsorLogic.getProjectSponsors();
        Assert.assertEquals(data.size(), list.size());
        for (ProjectSponsorEntity entity : list) {
            boolean found = false;
            for (ProjectSponsorEntity storedEntity : data) {
                if (entity.getId().equals(storedEntity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    /**
     * @generated
     */
    @Test
    public void getProjectSponsorTest() {
        ProjectSponsorEntity entity = data.get(0);
        ProjectSponsorEntity resultEntity = projectSponsorLogic.getProjectSponsor(entity.getId());
        Assert.assertNotNull(resultEntity);
        Assert.assertEquals(entity.getId(), resultEntity.getId());
        Assert.assertEquals(entity.getName(), resultEntity.getName());
        Assert.assertEquals(entity.getCompany(), resultEntity.getCompany());
        Assert.assertEquals(entity.getPicture(), resultEntity.getPicture());
    }

    /**
     * @generated
     */
    @Test
    public void deleteProjectSponsorTest() {
        ProjectSponsorEntity entity = data.get(1);
        projectSponsorLogic.deleteProjectSponsor(entity.getId());
        ProjectSponsorEntity deleted = em.find(ProjectSponsorEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * @generated
     */
    @Test
    public void updateProjectSponsorTest() {
        ProjectSponsorEntity entity = data.get(0);
        ProjectSponsorEntity pojoEntity = factory.manufacturePojo(ProjectSponsorEntity.class);

        pojoEntity.setId(entity.getId());

        projectSponsorLogic.updateProjectSponsor(pojoEntity);

        ProjectSponsorEntity resp = em.find(ProjectSponsorEntity.class, entity.getId());

        Assert.assertEquals(pojoEntity.getId(), resp.getId());
        Assert.assertEquals(pojoEntity.getName(), resp.getName());
        Assert.assertEquals(pojoEntity.getCompany(), resp.getCompany());
        Assert.assertEquals(pojoEntity.getPicture(), resp.getPicture());
    }

    /**
     * @generated
     */
    @Test
    public void getProjectsTest() {
        ProjectSponsorEntity entity = data.get(0);
        ProjectEntity projectEntity = projectsData.get(0);
        ProjectEntity response = projectSponsorLogic.getProjects(entity.getId(), projectEntity.getId());

        Assert.assertEquals(projectEntity.getId(), response.getId());
        Assert.assertEquals(projectEntity.getName(), response.getName());
        Assert.assertEquals(projectEntity.getDescription(), response.getDescription());
        Assert.assertEquals(projectEntity.getPrice(), response.getPrice());
        Assert.assertEquals(projectEntity.getDeadLine(), response.getDeadLine());
        Assert.assertEquals(projectEntity.getPublicationDate(), response.getPublicationDate());
        Assert.assertEquals(projectEntity.getStartDate(), response.getStartDate());
    }

    /**
     * @generated
     */
    @Test
    public void listProjectsTest() {
        List<ProjectEntity> list = projectSponsorLogic.listProjects(data.get(0).getId());
        Assert.assertEquals(1, list.size());
    }

    /**
     * @generated
     */
    @Test
    public void addProjectsTest() {
        ProjectSponsorEntity entity = data.get(0);
        ProjectEntity projectEntity = projectsData.get(1);
        ProjectEntity response = projectSponsorLogic.addProjects(entity.getId(), projectEntity.getId());

        Assert.assertNotNull(response);
        Assert.assertEquals(projectEntity.getId(), response.getId());
    }

    /**
     * @generated
     */
    @Test
    public void replaceProjectsTest() {
        ProjectSponsorEntity entity = data.get(0);
        List<ProjectEntity> list = projectsData.subList(1, 3);
        projectSponsorLogic.replaceProjects(entity.getId(), list);

        entity = projectSponsorLogic.getProjectSponsor(entity.getId());
        Assert.assertFalse(entity.getProjects().contains(projectsData.get(0)));
        Assert.assertTrue(entity.getProjects().contains(projectsData.get(1)));
        Assert.assertTrue(entity.getProjects().contains(projectsData.get(2)));
    }

    /**
     * @generated
     */
    @Test
    public void removeProjectsTest() {
        projectSponsorLogic.removeProjects(data.get(0).getId(), projectsData.get(0).getId());
        ProjectEntity response = projectSponsorLogic.getProjects(data.get(0).getId(), projectsData.get(0).getId());
        Assert.assertNull(response);
    }
}
