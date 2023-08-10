package view;

import controllers.UsuarioController;

public class UsuarioView {
	
	public static void main(String[] args) {
		
		// String usuario = new UsuarioController().createUsuario("Prueba", "", "kevz_gg@outlook.com", "+52 55 3965 0500", "2023-08-10 00:00:00");
		String usuario = new UsuarioController().deleteUsuario(2);
			
	}
}
