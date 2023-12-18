package main.java.magicvet.component;

import main.java.magicvet.model.Client;
import main.java.magicvet.model.Pet;
import main.java.magicvet.service.ClientService;
import main.java.magicvet.service.PetService;

public class ApplicationRunner {

    private final ClientService clientService = new ClientService();
    private final PetService petService = new PetService();

    public void run() {
        if (Authenticator.auth()) {
            Client client = clientService.resiterNewClient();

            if (client != null) {
                System.out.println("Adding a new pet.");

                Pet pet = petService.registerNewPet();
                client.setPet(pet);
                pet.setOwnerName(client.getFirstName() + " " + client.getLastName());
                System.out.println("Pet has been added.");

                System.out.println(client);
            }
        }
    }
}
