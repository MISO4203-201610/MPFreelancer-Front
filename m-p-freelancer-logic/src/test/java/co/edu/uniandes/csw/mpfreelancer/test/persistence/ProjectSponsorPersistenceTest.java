package co.edu.uniandes.csw.mpfreelancer.test.persistence;

import co.edu.uniandes.csw.mpfreelancer.entities.ProjectSponsorEntity;
import co.edu.uniandes.csw.mpfreelancer.persistence.ProjectSponsorPersistence;
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
public class ProjectSponsorPersistenceTest {

    /**
     * @generated
     */
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(ProjectSponsorEntity.class.getPackage())
                .addPackage(ProjectSponsorPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * @generated
     */
    @Inject
    private ProjectSponsorPersistence projectSponsorPersistence;

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
        em.createQuery("delete from ProjectSponsorEntity").executeUpdate();
    }

    /**
     * @generated
     */
    private List<ProjectSponsorEntity> data = new ArrayList<ProjectSponsorEntity>();

    /**
     * @generated
     */
    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            ProjectSponsorEntity entity = factory.manufacturePojo(ProjectSponsorEntity.class);
            em.persist(entity);
            data.add(entity);
        }
    }

    /**
     * @generated
     */
    @Test
    public void createProjectSponsorTest() {
		PodamFactory factory = new PodamFactoryImpl();
        ProjectSponsorEntity newEntity = factory.manufacturePojo(ProjectSponsorEntity.class);
        ProjectSponsorEntity result = projectSponsorPersistence.create(newEntity);

        Assert.assertNotNull(result);

        ProjectSponsorEntity entity = em.find(ProjectSponsorEntity.class, result.getId());

        Assert.assertEquals(newEntity.getName(), entity.getName());
        Assert.assertEquals(newEntity.getCompany(), entity.getCompany());
        Assert.assertEquals(newEntity.getPicture(), entity.getPicture());
    }

    /**
     * @generated
     */
    @Test
    public void getProjectSponsorsTest() {
        List<ProjectSponsorEntity> list = projectSponsorPersistence.findAll();
        Assert.assertEquals(data.size(), list.size());
        for (ProjectSponsorEntity ent : list) {
            boolean found = false;
            for (ProjectSponsorEntity entity : data) {
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
    public void getProjectSponsorTest() {
        ProjectSponsorEntity entity = data.get(0);
        ProjectSponsorEntity newEntity = projectSponsorPersistence.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getName(), newEntity.getName());
        Assert.assertEquals(entity.getCompany(), newEntity.getCompany());
        Assert.assertEquals(entity.getPicture(), newEntity.getPicture());
    }

    /**
     * @generated
     */
    @Test
    public void deleteProjectSponsorTest() {
        ProjectSponsorEntity entity = data.get(0);
        projectSponsorPersistence.delete(entity.getId());
        ProjectSponsorEntity deleted = em.find(ProjectSponsorEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * @generated
     */
    @Test
    public void updateProjectSponsorTest() {
        ProjectSponsorEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        ProjectSponsorEntity newEntity = factory.manufacturePojo(ProjectSponsorEntity.class);

        newEntity.setId(entity.getId());

        projectSponsorPersistence.update(newEntity);

        ProjectSponsorEntity resp = em.find(ProjectSponsorEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getName(), resp.getName());
        Assert.assertEquals(newEntity.getCompany(), resp.getCompany());
        Assert.assertEquals(newEntity.getPicture(), resp.getPicture());
    }
}
