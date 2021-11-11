package Spells;

public record Range(Distance distance, int ammount, Radius radius) {
    public String toJSON(){
        String json = new String("{\n");
        json += "\"distance\": \""+distance+"\",\n";
        json += "\"distanceAmmount\": "+ammount+",\n";
        json += "\"radius\": \""+radius.distance()+"\",\n";
        json += "\"radiusAmmount\": "+radius.ammount()+"\n";
        json += "}";
        return json;
    }
}