package project1;

public class Address {

    private String city;   

    
    public Address(String city) {
       
        if (city == null || city.trim().isEmpty()) {
            this.city = "Unknown City";
        } else {
            this.city = city;   
        }
    }


    public String getCity() {
        return city;
    }

    
    public void setCity(String city) {
        if (city != null && !city.trim().isEmpty()) {
            this.city = city;
        }
    }
}
