package Spells;

public record Components(boolean verbal, boolean somatic, boolean material) {
    public String toJSON(){
        String json = new String("{\n");
        json += "\"verbal\": "+verbal+",\n";
        json += "\"somatic\": "+somatic+",\n";
        json += "\"material\": "+material+"\n";
        json += "}";
        return json;
    }
}
