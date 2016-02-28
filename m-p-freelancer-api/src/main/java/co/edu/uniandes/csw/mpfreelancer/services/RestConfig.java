package co.edu.uniandes.csw.mpfreelancer.services;

import org.glassfish.jersey.server.ResourceConfig;
import javax.ws.rs.ApplicationPath;

@ApplicationPath("api")
public class RestConfig extends ResourceConfig {

    public RestConfig() {
        packages("co.edu.uniandes.csw.mpfreelancer.services");
        packages("co.edu.uniandes.csw.auth.service");
        packages("co.edu.uniandes.csw.auth.provider");
    }
}
