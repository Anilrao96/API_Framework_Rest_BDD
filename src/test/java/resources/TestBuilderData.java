package resources;

import io.restassured.specification.RequestSpecification;
import pojo.AddPet;

public class TestBuilderData {
    public AddPet addPlacePayLoad(String name, String status){
        //RequestSpecification req;
        AddPet p = new AddPet();
        p.setId(108);
        p.setName(name);//
        p.setStatus(status);//

        return p;

}
public String deletePet(){
        return "100";

}
}



