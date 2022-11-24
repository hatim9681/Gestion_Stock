package services;

import java.util.ArrayList;
import java.util.List;

import dao.IDao;
import entities.Client;

public class ClientService implements IDao<Client> {

	private List<Client> clients;

	public ClientService() {
		clients = new ArrayList<Client>();
	}

	@Override
	public boolean create(Client o) {
		return clients.add(o);
	}

	@Override
	public boolean delete(Client o) {
		// TODO Auto-generated method stub
		return clients.remove(o);
	}

	@Override
	public boolean update(Client newClient) {

		return true;
	}

	@Override
	public Client findById(int id) {
		for (Client s : clients)
			if (s.getId() == id)
				return s;
		return null;
	}

	@Override
	public List<Client> findAll() {
		return clients;
	}

}
