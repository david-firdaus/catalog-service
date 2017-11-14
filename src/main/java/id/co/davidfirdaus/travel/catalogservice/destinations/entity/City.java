package id.co.davidfirdaus.travel.catalogservice.destinations.entity;

public enum City {
    BALI("BALI", "Bali"),
    BANDUNG("BANDUNG", "Bandung"),
    BWI("BWI", "Banyuwangi"),
    DIENG("DIENG", "Dieng"),
    JAKARTA("JAKARTA", "Jakarta"),
    JOGJA("JOGJAKARTA", "Yogyakarta"),
    LOMBOK("LOMBOK", "Lombok"),
    MALANG("MALANG", "Malang"),
    MALUKU("MALUKU", "Maluku"),
    SEMARANG("SEMARANG", "Semarang"),
    SOLO("SOLO", "Solo"),
    SURABAYA("SURABAYA", "Surabaya"),
    WAMENA("WAMENA", "Wamena");

    private final String code;
    private final String description;

    City(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
