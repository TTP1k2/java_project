package iotstar.vn.Controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import iotstar.vn.model.Category;
import iotstar.vn.service.CategoryService;
import iotstar.vn.service.impl.CatogeryServiceImpl;
import iotstar.vn.ulti.Constant;
@WebServlet(urlPatterns = { "/admin/category/edit"})
	
public class CategoryEditController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	CategoryService cateService = new CatogeryServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		Category category = cateService.get(Integer.parseInt(id));
		req.setAttribute("category", category);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/admin/edit category.jsp");
		dispatcher.forward(req, resp);
	}

	@Override protected void doPost
	HttpServletRequest req, HttpServletResponse resp)throws ServletException,IOException
	{
	Category category = new Category();
	DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
	ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
	servletFileUpload.setHeaderEncoding("UTF-8");
	try {
	resp.setContentType("text/html");
	resp.setCharacterEncoding("UTF-8");
	req.setCharacterEncoding("UTF-8");
	List<FileItem> items = servletFileUpload.parseRequest(req);
	for (FileItem item : items) {
		if (item.getFieldName().equals("id")) {
		category.setCateid(Integer.parseInt(item .getString()));
		}
		else if (item.getFieldName().equals("name")) {
		category.setCatename(item.getString("UTF-8"));
		}
		else if (item.getFieldName().equals("icon")) {
		if (item.getSize() > 0) {// neu co file d
		String originalFileName = item.getName();
		int index = originalFileName.lastIndexOf(".");
		String ext = originalFileName.substring(index + 1);
		String fileName = System.currentTimeMillis() + "." + ext;
		File file = new File(Constant.DIR + "/category/"+ fileName);
		item.write(file);
		category.setIcon("category"+ fileName);
		}
		else {
		category.setIcon(null);}}}
		cateService.edit(category);
		resp.sendRedirect(req.getContextPath() + "/admin/category/list");
		}
		catch (FileUploadException e) {
		e.printStackTrace();
		}
		catch (Exception e) { e.printStackTrace();}
		
}
