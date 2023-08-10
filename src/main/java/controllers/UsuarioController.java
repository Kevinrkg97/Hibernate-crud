package controllers;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import models.Usuario;

public class UsuarioController {

	public String createUsuario(String nombre, String apellido, String email, String telefono, String fecha_registro) {

		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Usuario.class).buildSessionFactory();

		Session session = sessionFactory.openSession();

		try {

			Usuario usuario = new Usuario(nombre, apellido, email, telefono, fecha_registro);
			session.beginTransaction();
			session.save(usuario);
			session.getTransaction().commit();

			sessionFactory.close();
			return "Se ha registrado el usuario";

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error: " + e.getMessage());
		}

		return "Se ha completado la solicitud";
	}

	public String deleteUsuario(int id) {
		SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Usuario.class).buildSessionFactory();

		Session session = sessionFactory.openSession();

		try {

			session.beginTransaction();
			Usuario usuario = session.get(Usuario.class, id);
			session.delete(usuario);
			session.getTransaction().commit();

			sessionFactory.close();
			return "Usuario eliminado correctamente";

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Error: " + e.getMessage());
		}

		return "Se ha completado la solicitud";
	}
}
