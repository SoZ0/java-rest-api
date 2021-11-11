import java.util.HashMap;
import java.util.Map;

import Spells.CastingTime;
import Spells.Components;
import Spells.Distance;
import Spells.Durration;
import Spells.Radius;
import Spells.Range;
import Spells.School;
import Spells.Spell;
import Spells.Time;

public class DataStore {
    
    private Map<Integer, Spell> spellMap = new HashMap<>();

    private static DataStore instance = new DataStore();

    public DataStore(){
        spellMap.put(0, new Spell("Fire Bolt", School.Evocation, new CastingTime(Time.Action, 1), new Range(Distance.Feet, 120, new Radius(Distance.Feet, 0)), new Durration(Time.Instantaneous, 0), new Components(true, true, false)));
        spellMap.put(1, new Spell("Thunderclap", School.Evocation, new CastingTime(Time.Action, 1), new Range(Distance.Self, 0, new Radius(Distance.Feet, 5)), new Durration(Time.Instantaneous, 0), new Components(false, true, false)));
        spellMap.put(2, new Spell("Chill Touch", School.Necromancy, new CastingTime(Time.Action, 1), new Range(Distance.Feet, 120, new Radius(Distance.Feet, 0)), new Durration(Time.Round, 1), new Components(true, true, false)));
    }

    public static DataStore getInstance() {
        return instance == null ? new DataStore() : instance;
    }

    public Spell getSpell(Integer id){
        return spellMap.get(id);
    }

    public Spell putSpell(Integer id, Spell spell){
        return spellMap.put(id, spell);
    }
}
