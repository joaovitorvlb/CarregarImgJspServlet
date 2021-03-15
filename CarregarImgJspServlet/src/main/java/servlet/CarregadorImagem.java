package servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CarregadorImagem
 */
public class CarregadorImagem extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CarregadorImagem() {
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
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("Get ");

		String imageId = "/home/joaovitor/uploads/java.png";// request.getParameter("imageId");

		byte[] imageData = carregarImagem(imageId);

		response.setContentType("image/png");
		response.getOutputStream().write(imageData);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		System.out.println("Post ");
	}

	private static byte[] carregarImagem(String path) throws FileNotFoundException, IOException {

		byte[] image;
		File file = new File(path);
		image = new byte[(int) file.length()];

		FileInputStream fileInputStream = new FileInputStream(file);
		fileInputStream.read(image);

		return image;
	}
}
