import lombok.SneakyThrows;
import org.example.ConsolidatedPets;
import org.example.model.Pet;
import org.example.model.Status;
import org.example.model.User;
import org.example.service.PetStoreClient;
import org.javatuples.Pair;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;


public class Main {
    static PetStoreClient apiClient = new PetStoreClient();

    public static void main(String[] args) throws IOException {

        //Collect, through an HTTP request, the JSON returned by the endpoint /pet/findByStatus
        //System.out.println(apiClient.findPetsByStatus(Status.SOLD));

        //Class with constructor consuming output if /findByStatus response
        ConsolidatedPets consolidatedPets = new ConsolidatedPets(findPetsAndStoreAsTuples(Status.AVAILABLE));
        System.out.println(consolidatedPets.getConsolidatedPets().entrySet()
                .stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).toList());
    }

    static void createUser(User user) {
        apiClient.createUser(user);
    }

    static void getUser(String username) {
        System.out.println("User: " + apiClient.getUser(username));
    }

    @SneakyThrows
    static List<Pair<Long, String>> findPetsAndStoreAsTuples(Status status) {
        List<Pet> pets = apiClient.findPetsByStatus(status);
        List<Pair<Long, String>> petsTuples = new ArrayList<>();
        for (Pet pet : pets
        ) {
            petsTuples.add(new Pair<>(pet.getId(), pet.getName()));
        }
        return petsTuples;
    }
}
