package project1;

public class Address {

    private String city;

    // Constructor
    public Address(String city) {
        // Basic validation: default to "N/A" if input is empty or null
        if (city == null || city.trim().isEmpty()) {
            this.city = "Unknown City";
        } else {
            this.city = city;
        }
    }

    // Getter method
    public String getCity() {
        return city;
    }

    // Setter method
    public void setCity(String city) {
        if (city != null && !city.trim().isEmpty()) {
            this.city = city;
        }
    }
}
