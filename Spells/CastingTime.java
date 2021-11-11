package Spells;
public record CastingTime(Time time, int ammount){
    public String toJSON(){
        String json = new String("{\n");
        json += "\"time\": \""+time+"\",\n";
        json += "\"ammount\": "+ammount+"\n";
        json += "}";
        return json;
    }
}