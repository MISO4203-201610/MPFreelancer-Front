package co.edu.uniandes.csw.mpfreelancer.test.persistence;

import co.edu.uniandes.csw.mpfreelancer.entities.ProjectEntity;
import co.edu.uniandes.csw.mpfreelancer.persistence.ProjectPersistence;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
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
public class ProjectPersistenceTest {

    /**
     * @generated
     */
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(ProjectEntity.class.getPackage())
                .addPackage(ProjectPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * @generated
     */
    @Inject
    private ProjectPersistence projectPersistence;

    /**
     * @generated
     */
    @PersistenceContext
    private EntityManager em;

    /**
     * @generated
     */
    @Inject
    UserTransaction utx;

    /**
     * @generated
     */
    @Before
    public void configTest() {
        try {
            utx.begin();
            em.joinTransaction();
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
    }

    /**
     * @generated
     */
    private List<ProjectEntity> data = new ArrayList<ProjectEntity>();

    /**
     * @generated
     */
    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            ProjectEntity entity = factory.manufacturePojo(ProjectEntity.class);
            em.persist(entity);
            data.add(entity);
        }
    }

    /**
     * @generated
     */
    @Test
    public void createProjectTest() {
		PodamFactory factory = new PodamFactoryImpl();
        ProjectEntity newEntity = factory.manufacturePojo(ProjectEntity.class);
        ProjectEntity result = projectPersistence.create(newEntity);

        Assert.assertNotNull(result);

        ProjectEntity entity = em.find(ProjectEntity.class, result.getId());

        Assert.assertEquals(newEntity.getName(), entity.getName());
        Assert.assertEquals(newEntity.getDescription(), entity.getDescription());
        Assert.assertEquals(newEntity.getPrice(), entity.getPrice());
    }

    /**
     * @generated
     */
    @Test
    public void getProjectsTest() {
        List<ProjectEntity> list = projectPersistence.findAll();
        Assert.assertEquals(data.size(), list.size());
        for (ProjectEntity ent : list) {
            boolean found = false;
            for (ProjectEntity entity : data) {
                if (ent.getId().equals(entity.getId())) {
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
    public void getProjectTest() {
        ProjectEntity entity = data.get(0);
        ProjectEntity newEntity = projectPersistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getName(), newEntity.getName());
        Assert.assertEquals(entity.getDescription(), newEntity.getDescription());
        Assert.assertEquals(entity.getPrice(), newEntity.getPrice());
        Assert.assertEquals(entity.getDeadLine(), newEntity.getDeadLine());
        Assert.assertEquals(entity.getPublicationDate(), newEntity.getPublicationDate());
        Assert.assertEquals(entity.getStartDate(), newEntity.getStartDate());
    }

    /**
     * @generated
     */
    @Test
    public void deleteProjectTest() {
        ProjectEntity entity = data.get(0);
        projectPersistence.delete(entity.getId());
        ProjectEntity deleted = em.find(ProjectEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * @generated
     */
    @Test
    public void updateProjectTest() {
        ProjectEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        ProjectEntity newEntity = factory.manufacturePojo(ProjectEntity.class);

        newEntity.setId(entity.getId());

        projectPersistence.update(newEntity);

        ProjectEntity resp = em.find(ProjectEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getName(), resp.getName());
        Assert.assertEquals(newEntity.getDescription(), resp.getDescription());
        Assert.assertEquals(newEntity.getPrice(), resp.getPrice());
    }
}
