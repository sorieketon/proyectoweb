
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dni.Dni;

/**
 * Servlet implementation class CalculaDni
 */
@WebServlet("/CalculaDni")
public class CalculaDni extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CalculaDni() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String ndni = request.getParameter("dni");
		int dni = Integer.parseInt(ndni);
		char letra = Dni.calculaLetra(dni);

		DniBean dnibean = new DniBean();
		dnibean.setDni(ndni);
		dnibean.setLetra(letra);
		
		request.setAttribute("dnibean", dnibean);
		request.getRequestDispatcher("resultado.jsp").forward(request , response);

		// System.out.println("DNI = " + ndni);
		response.getWriter().print("<h1>HOLA dni " + ndni);
		response.getWriter().print("<h2>Tu DNI completo es " + ndni + "-" + letra);
		response.setStatus(202);
		// response.setContentType("");
		// http://localhost:8080/MiAppWeb/CalculaDni?dni=11900144
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
