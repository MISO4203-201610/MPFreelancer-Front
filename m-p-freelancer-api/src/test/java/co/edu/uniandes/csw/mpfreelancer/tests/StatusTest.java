package co.edu.uniandes.csw.mpfreelancer.tests;

import co.edu.uniandes.csw.auth.model.UserDTO;
import co.edu.uniandes.csw.auth.security.JWT;
import co.edu.uniandes.csw.mpfreelancer.dtos.StatusDTO;
import co.edu.uniandes.csw.mpfreelancer.dtos.ProjectDTO;
import co.edu.uniandes.csw.mpfreelancer.services.StatusService;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import org.codehaus.jackson.map.ObjectMapper;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.filter.LoggingFilter;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.junit.InSequence;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.jboss.shrinkwrap.resolver.api.maven.Maven;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

@RunWith(Arquillian.class)
public class StatusTest {

    private final int Ok = Status.OK.getStatusCode();
    private final int Created = Status.CREATED.getStatusCode();
    private final int OkWithoutContent = Status.NO_CONTENT.getStatusCode();
    private final String statusPath = "statuss";
    private final static List<StatusDTO> oraculo = new ArrayList<>();
    private final String projectPath = "projects";
    private final static List<ProjectDTO> oraculoProject = new ArrayList<>();
    private WebTarget target;
    private final String apiPath = "api";
    private final String username = System.getenv("USERNAME_USER");
    private final String password = System.getenv("PASSWORD_USER");

    @ArquillianResource
    private URL deploymentURL;

    @Deployment(testable = false)
    public static WebArchive createDeployment() {
        return ShrinkWrap.create(WebArchive.class)
                // Se agrega la dependencia a la logica con el nombre groupid:artefactid:version (GAV)
                .addAsLibraries(Maven.resolver()
                        .resolve("co.edu.uniandes.csw.mpfreelancer:m-p-freelancer-logic:0.1.0")
                        .withTransitivity().asFile())
                .addAsLibraries(Maven.resolver()
                        .resolve("co.edu.uniandes.csw:auth-utils:0.1.0")
                        .withTransitivity().asFile())
                // Se agregan los compilados de los paquetes de servicios
                .addPackage(StatusService.class.getPackage())
                // El archivo que contiene la configuracion a la base de datos.
                .addAsResource("META-INF/persistence.xml", "META-INF/persistence.xml")
                // El archivo beans.xml es necesario para injeccion de dependencias.
                .addAsWebInfResource(new File("src/main/webapp/WEB-INF/beans.xml"))
                // El archivo shiro.ini es necesario para injeccion de dependencias
                .addAsWebInfResource(new File("src/main/webapp/WEB-INF/shiro.ini"))
                // El archivo web.xml es necesario para el despliegue de los servlets
                .setWebXML(new File("src/main/webapp/WEB-INF/web.xml"));
    }

    private WebTarget createWebTarget() {
        ClientConfig config = new ClientConfig();
        config.register(LoggingFilter.class);
        return ClientBuilder.newClient(config).target(deploymentURL.toString()).path(apiPath);
    }

    @BeforeClass
    public static void setUp() {
        insertData();
    }

    public static void insertData() {
        for (int i = 0; i < 5; i++) {
            PodamFactory factory = new PodamFactoryImpl();
            StatusDTO status = factory.manufacturePojo(StatusDTO.class);
            status.setId(i + 1L);

            oraculo.add(status);

            ProjectDTO project = factory.manufacturePojo(ProjectDTO.class);
            project.setId(i + 1L);
            oraculoProject.add(project);
        }
    }

    public Cookie login(String username, String password) {
        UserDTO user = new UserDTO();
        user.setUserName(username);
        user.setPassword(password);
        user.setRememberMe(true);
        Response response = target.path("users").path("login").request()
                .post(Entity.entity(user, MediaType.APPLICATION_JSON));
        if (response.getStatus() == Ok) {
            return response.getCookies().get(JWT.cookieName);
        } else {
            return null;
        }
    }

    @Before
    public void setUpTest() {
        target = createWebTarget();
    }

    @Test
    @InSequence(1)
    public void createStatusTest() throws IOException {
        StatusDTO status = oraculo.get(0);
        Cookie cookieSessionId = login(username, password);
        Response response = target.path(statusPath)
                .request().cookie(cookieSessionId)
                .post(Entity.entity(status, MediaType.APPLICATION_JSON));
        StatusDTO  statusTest = (StatusDTO) response.readEntity(StatusDTO.class);
        Assert.assertEquals(status.getId(), statusTest.getId());
        Assert.assertEquals(status.getName(), statusTest.getName());
        Assert.assertEquals(Created, response.getStatus());
    }

    @Test
    @InSequence(2)
    public void getStatusById() {
        Cookie cookieSessionId = login(username, password);
        StatusDTO statusTest = target.path(statusPath)
                .path(oraculo.get(0).getId().toString())
                .request().cookie(cookieSessionId).get(StatusDTO.class);
        Assert.assertEquals(statusTest.getId(), oraculo.get(0).getId());
        Assert.assertEquals(statusTest.getName(), oraculo.get(0).getName());
    }

    @Test
    @InSequence(3)
    public void listStatusTest() throws IOException {
        Cookie cookieSessionId = login(username, password);
        Response response = target.path(statusPath)
                .request().cookie(cookieSessionId).get();
        String listStatus = response.readEntity(String.class);
        List<StatusDTO> listStatusTest = new ObjectMapper().readValue(listStatus, List.class);
        Assert.assertEquals(Ok, response.getStatus());
        Assert.assertEquals(1, listStatusTest.size());
    }

    @Test
    @InSequence(4)
    public void updateStatusTest() throws IOException {
        Cookie cookieSessionId = login(username, password);
        StatusDTO status = oraculo.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        StatusDTO statusChanged = factory.manufacturePojo(StatusDTO.class);
        status.setName(statusChanged.getName());
        Response response = target.path(statusPath).path(status.getId().toString())
                .request().cookie(cookieSessionId).put(Entity.entity(status, MediaType.APPLICATION_JSON));
        StatusDTO statusTest = (StatusDTO) response.readEntity(StatusDTO.class);
        Assert.assertEquals(Ok, response.getStatus());
        Assert.assertEquals(status.getName(), statusTest.getName());
    }

    @Test
    @InSequence(9)
    public void deleteStatusTest() {
        Cookie cookieSessionId = login(username, password);
        StatusDTO status = oraculo.get(0);
        Response response = target.path(statusPath).path(status.getId().toString())
                .request().cookie(cookieSessionId).delete();
        Assert.assertEquals(OkWithoutContent, response.getStatus());
    }

    @Test
    @InSequence(5)
    public void addProjectTest() {
        Cookie cookieSessionId = login(username, password);

        ProjectDTO project = oraculoProject.get(0);
        StatusDTO status = oraculo.get(0);


        Response response = target.path("projects")
                .request().cookie(cookieSessionId)
                .post(Entity.entity(project, MediaType.APPLICATION_JSON));

        ProjectDTO projectTest = (ProjectDTO) response.readEntity(ProjectDTO.class);
        Assert.assertEquals(project.getId(), projectTest.getId());
        Assert.assertEquals(project.getName(), projectTest.getName());
        Assert.assertEquals(project.getDescription(), projectTest.getDescription());
        Assert.assertEquals(project.getPrice(), projectTest.getPrice());
        Assert.assertEquals(project.getDeadLine(), projectTest.getDeadLine());
        Assert.assertEquals(project.getPublicationDate(), projectTest.getPublicationDate());
        Assert.assertEquals(project.getStartDate(), projectTest.getStartDate());
        Assert.assertEquals(Created, response.getStatus());

        response = target.path(statusPath).path(status.getId().toString())
                .path(projectPath).path(project.getId().toString())
                .request().cookie(cookieSessionId)
                .post(Entity.entity(project, MediaType.APPLICATION_JSON));

        projectTest = (ProjectDTO) response.readEntity(ProjectDTO.class);
        Assert.assertEquals(Ok, response.getStatus());
        Assert.assertEquals(project.getId(), projectTest.getId());
    }

    @Test
    @InSequence(6)
    public void listProjectTest() throws IOException {
        Cookie cookieSessionId = login(username, password);
        StatusDTO status = oraculo.get(0);

        Response response = target.path(statusPath)
                .path(status.getId().toString())
                .path(projectPath)
                .request().cookie(cookieSessionId).get();

        String projectList = response.readEntity(String.class);
        List<ProjectDTO> projectListTest = new ObjectMapper().readValue(projectList, List.class);
        Assert.assertEquals(Ok, response.getStatus());
        Assert.assertEquals(1, projectListTest.size());
    }

    @Test
    @InSequence(7)
    public void getProjectTest() throws IOException {
        Cookie cookieSessionId = login(username, password);
        ProjectDTO project = oraculoProject.get(0);
        StatusDTO status = oraculo.get(0);

        ProjectDTO projectTest = target.path(statusPath)
                .path(status.getId().toString()).path(projectPath)
                .path(project.getId().toString())
                .request().cookie(cookieSessionId).get(ProjectDTO.class);

        Assert.assertEquals(project.getId(), projectTest.getId());
        Assert.assertEquals(project.getName(), projectTest.getName());
        Assert.assertEquals(project.getDescription(), projectTest.getDescription());
        Assert.assertEquals(project.getPrice(), projectTest.getPrice());
        Assert.assertEquals(project.getDeadLine(), projectTest.getDeadLine());
        Assert.assertEquals(project.getPublicationDate(), projectTest.getPublicationDate());
        Assert.assertEquals(project.getStartDate(), projectTest.getStartDate());
    }

    @Test
    @InSequence(8)
    public void removeProjectTest() {
        Cookie cookieSessionId = login(username, password);

        ProjectDTO project = oraculoProject.get(0);
        StatusDTO status = oraculo.get(0);

        Response response = target.path(statusPath).path(status.getId().toString())
                .path(projectPath).path(project.getId().toString())
                .request().cookie(cookieSessionId).delete();
        Assert.assertEquals(OkWithoutContent, response.getStatus());
    }
}
