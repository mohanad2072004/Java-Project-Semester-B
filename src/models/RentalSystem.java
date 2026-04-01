package models;

import java.util.ArrayList;

public class RentalSystem {

    private ArrayList<Agent> agents;
    private ArrayList<Client> clients;
    private ArrayList<Car> cars;

    public RentalSystem(ArrayList<Agent> agents, ArrayList<Client> clients, ArrayList<Car> cars) {
        this.agents = (agents != null) ? agents : new ArrayList<>();
        this.clients = (clients != null) ? clients : new ArrayList<>();
        this.cars = (cars != null) ? cars : new ArrayList<>();
    }

    public ArrayList<Agent> getAgents() {
        return agents;
    }

    public void setAgents(ArrayList<Agent> agents) {
        this.agents = (agents != null) ? agents : new ArrayList<>();
    }

    public ArrayList<Client> getClients() {
        return clients;
    }

    public void setClients(ArrayList<Client> clients) {
        this.clients = (clients != null) ? clients : new ArrayList<>();
    }

    public ArrayList<Car> getCars() {
        return cars;
    }

    public void setCars(ArrayList<Car> cars) {
        this.cars = (cars != null) ? cars : new ArrayList<>();
    }

    public void addAgent(Agent agent) {
        if (agent != null) {
            agents.add(agent);
        }
    }

    public void removeAgent(Agent agent) {
        agents.remove(agent);
    }

    public void addClient(Client client) {
        if (client != null) {
            clients.add(client);
        }
    }

    public void removeClient(Client client) {
        clients.remove(client);
    }

    public void addCar(Car car) {
        if (car != null) {
            cars.add(car);
        }
    }

    public void removeCar(Car car) {
        cars.remove(car);
    }

    @Override
    public String toString() {
        return "RentalSystem{" +
                "agents=" + agents +
                ", clients=" + clients +
                ", cars=" + cars +
                '}';
    }
}