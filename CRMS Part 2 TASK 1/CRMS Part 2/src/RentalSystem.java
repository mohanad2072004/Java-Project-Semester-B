import java.util.ArrayList;
public class RentalSystem {
    private ArrayList<Agent> agents;
    private ArrayList<Client> clients;
    private ArrayList<Car> cars;

    public RentalSystem(ArrayList<Agent> agents, ArrayList<Client> clients, ArrayList<Car> cars) {
        this.agents = agents;
        this.clients = clients;
        this.cars = cars;
    }

    public ArrayList<Agent> getAgents() {
        return agents;
    }

    public void setAgents(ArrayList<Agent> agents) {
        this.agents = agents;
    }

    public ArrayList<Client> getClients() {
        return clients;
    }

    public void setClients(ArrayList<Client> clients) {
        this.clients = clients;
    }

    public ArrayList<Car> getCars() {
        return cars;
    }

    public void setCars(ArrayList<Car> cars) {
        this.cars = cars;
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
