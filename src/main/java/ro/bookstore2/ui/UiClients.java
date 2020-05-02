//package ro.bookstore2.ui;
//
//import api.models.Client;
//import org.springframework.beans.factory.annotation.Autowired;
//import ro.bookstore2.services.ClientClientService;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//public class UiClients {
//
//    @Autowired
//    private ClientClientService clientClientService;
//
//    public void addClient() {
//        String firstname, lastname;
//
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        try {
//            System.out.println("First Name:");
//            firstname = reader.readLine();
//            System.out.println("Last Name:");
//            lastname = reader.readLine();
//            this.clientClientService.addClient(firstname, lastname, 0);
//            System.out.println("Client added successfully!");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void printClients() {
//        Iterable<Client> clients = this.clientClientService.getAllClients();
//        clients.forEach(System.out::println);
//    }
//
//    public void updateClient() {
//        String ID, firstname, lastname, spendings;
//
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        try {
//            System.out.println("Client ID:");
//            ID = reader.readLine();
//            System.out.println("New First Name (Blank if unchanged):");
//            firstname = reader.readLine();
//            System.out.println("New Last Name (Blank if unchanged):");
//            lastname = reader.readLine();
//            System.out.println("New Spendings (Blank if unchanged):");
//            spendings = reader.readLine();
//            this.clientClientService.updateClient(Long.parseLong(ID), firstname, lastname, Long.parseLong(spendings));
//            System.out.println("Client updated successfully!");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void deleteClient() {
//        String ID;
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        try {
//            System.out.println("Client ID:");
//            ID = reader.readLine();
//            this.clientClientService.removeClient(Long.parseLong(ID));
//            System.out.println("Client deleted successfully!");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void filterClientsName() {
//        String name;
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        try {
//            System.out.println("Client Name:");
//            name = reader.readLine();
//            Iterable<Client> clients = this.clientClientService.filterClientsByName(name);
//            clients.forEach(System.out::println);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void filterTopClients() {
//        Iterable<Client> clients = this.clientClientService.topNClientsOnMoneySpent(10);
//        clients.forEach(System.out::println);
//    }
//
//}
