package org.example.model;

import lombok.Getter;
import org.javatuples.Pair;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class ConsolidatedPets {
    public ConsolidatedPets(List<Pair<Long, String>> pets) {
        this.consolidatedPets = new HashMap<>();
        String name;
        for (Pair<Long, String> pet : pets
        ) {
            name = pet.getValue1();
            consolidatedPets.put(name, consolidatedPets.getOrDefault(name, 0) + 1);
        }
    }

    private final Map<String, Integer> consolidatedPets;

    @Override
    public String toString() {
        return String.format(consolidatedPets.toString());
    }
}
