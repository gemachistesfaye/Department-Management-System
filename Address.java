package project1;

public class Address {

    private String city;
    private String region;
    private String country;

    // ─── Constructor ────────────────────────────────────────────────────────────

    public Address(String city, String region, String country) {
        this.city    = isValid(city)    ? city.trim()    : "Unknown City";
        this.region  = isValid(region)  ? region.trim()  : "Unknown Region";
        this.country = isValid(country) ? country.trim() : "Unknown Country";
    }

    // Convenience constructor for backward-compatible single-city usage
    public Address(String city) {
        this(city, "N/A", "N/A");
    }

    // ─── Validation Helper ───────────────────────────────────────────────────────

    private boolean isValid(String value) {
        return value != null && !value.trim().isEmpty();
    }

    // ─── Getters ─────────────────────────────────────────────────────────────────

    public String getCity()    { return city; }
    public String getRegion()  { return region; }
    public String getCountry() { return country; }

    // ─── Setters ─────────────────────────────────────────────────────────────────

    public void setCity(String city) {
        if (isValid(city)) this.city = city.trim();
    }

    public void setRegion(String region) {
        if (isValid(region)) this.region = region.trim();
    }

    public void setCountry(String country) {
        if (isValid(country)) this.country = country.trim();
    }

    // ─── toString ────────────────────────────────────────────────────────────────

   
    @Override
    public String toString() {
        return city + ", " + region + ", " + country;
    }
}
