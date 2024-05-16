package resources;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.*;
import java.util.Properties;

public class Utils {
   public static RequestSpecification req;
    public RequestSpecification requestSpecification() throws IOException {

        if(req==null){
        PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
        //RestAssured.baseURI = "https://petstore.swagger.io";
        req = new RequestSpecBuilder().setBaseUri(getGlobalValue("baseUrl")).addFilter(RequestLoggingFilter.logRequestTo(log)).addFilter(ResponseLoggingFilter.logResponseTo(log))
                .setContentType(ContentType.JSON).build();
        //System.out.println(req);
        //.addFilter(ResponseLoggingFilter.logResponseTo(log))
        return req;}
        return req;
    }

    public static String getGlobalValue(String key) throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("C:\\Users\\ramad\\eclipse-workspace\\API_Frameword_Udemy_BDD\\src\\test\\java\\resources\\global.properties");
        prop.load(fis);
        return prop.getProperty(key);
        //return prop;
    }
    public String getJsonPath(Response response, String key){
        String resp = response.asString();
        JsonPath js = new JsonPath(resp);
        return js.get(key).toString();


    }
}
