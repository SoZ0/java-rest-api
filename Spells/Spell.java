package Spells;
public record Spell(String name, School school, CastingTime castingTime, Range range, Durration durration, Components components) {
    public String toJSON(){
        String json = new String("{\n");
        json += "\"name\": \"" + name + "\",\n";
        json += "\"school\": \"" + school + "\",\n";
        json += "\"castingTime\": " + castingTime.toJSON() + ",\n";
        json += "\"range\": " + range.toJSON() + ",\n";
        json += "\"durration\": " + durration.toJSON() + ",\n";
        json += "\"components\": " + components.toJSON() + "\n";
        json += "}";
        return json;
    }
}
