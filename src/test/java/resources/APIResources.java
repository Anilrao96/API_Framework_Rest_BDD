package resources;

//enum is special class in java which has collection of constants and methods
public enum APIResources {
    AddpetAPI("v2/pet");

    public String deletePetAPI() {
        return "v2/pet";
    }

    private String resource;

    APIResources(String resource) {
        this.resource = resource;
        System.out.println(resource);
    }
    public String getResource(){
        System.out.println(resource);
        return resource;

    }
}
