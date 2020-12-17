package hibernate;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import POJOS.Clientes;

public class HotelManager {
	public static SessionFactory getSessionFactory() {
		SessionFactory sessionFactory = new Configuration().addAnnotatedClass(Clientes.class).configure().buildSessionFactory();
		return sessionFactory;
	}
	public static void create (Clientes cliente) {
		Session sessionObj = getSessionFactory().openSession();
		Transaction transObj = sessionObj.beginTransaction();
		sessionObj.save(cliente);
		transObj.commit();
		sessionObj.close();
		System.out.println("Cliente " + cliente.getIdClientes() + " ha sido insertado correctamente");
	}
	public static List<?> readClientes(){
		String c = "FROM Clientes";
		Session sessionObj = getSessionFactory().openSession();
		List<?> resultado = sessionObj.createQuery(c).list();
		Iterator<?>clientesIterator=resultado.iterator();
		while (clientesIterator.hasNext()) {
			Clientes c1 = (Clientes) clientesIterator.next();
			System.out.println(" - " + c1.getNombre() + " - " +
					c1.getApellidos() + " - " + c1.getDni() + " - " + c1.getEmail()+ " - " +c1.getClave());
		}
		sessionObj.close();
		return resultado;
	}
	public static void updateClientes (Clientes cliente) {
		Session sessionObj = getSessionFactory().openSession();
		Transaction transObj = sessionObj.beginTransaction();
		Clientes BDClientes = (Clientes)
				sessionObj.load(Clientes.class, cliente.getIdClientes());
		BDClientes.setNombre(cliente.getNombre());
		BDClientes.setApellidos(cliente.getApellidos());
		BDClientes.setDni(cliente.getDni());
		BDClientes.setEmail(cliente.getEmail());
		BDClientes.setClave(cliente.getClave());
		transObj.commit();
		sessionObj.close();
		System.out.println("El cliente se ha actualizado correctamente");
	}
	public static void deleteClientes(Clientes cliente) {
		Session sessionObj = getSessionFactory().openSession();
		Transaction transObj = sessionObj.beginTransaction();
		Clientes BDClientes=(Clientes) sessionObj.load(Clientes.class, cliente.getIdClientes());
		sessionObj.delete(BDClientes);
		transObj.commit();
		sessionObj.close();
		System.out.println("El cliente ha sido eliminado correctamente");
		
	}
}