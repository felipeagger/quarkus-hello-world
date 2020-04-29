package org.acme;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public class ExampleResource {

    InetAddress ip;
    String hostname;
    Integer counter = 0;

    public ExampleResource() {
        try {
            ip = InetAddress.getLocalHost();
            hostname = ip.getHostName();
            System.out.println("Your current IP address : " + ip);
            System.out.println("Your current Hostname : " + hostname);
    
        } catch (UnknownHostException e) {
    
            e.printStackTrace();
        }
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        counter += 1;
        return "Hello World - by Java Quarkus!\nCount: "+this.counter.toString()+
        "\nHostname: "+this.hostname;
    }
}