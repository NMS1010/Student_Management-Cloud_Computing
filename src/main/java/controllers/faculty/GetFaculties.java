package controllers.faculty;

import models.services.faculty.FacultyService;
import models.view_models.faculty.FacultyViewModel;
import utils.ServletUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "GetFaculties", value = "/admin/faculties")
public class GetFaculties extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<FacultyViewModel> faculties = FacultyService.getInstance().retrieveAll();

        String error = request.getParameter("error");
        if(error != null && !error.equals("") || (faculties == null)){
            request.setAttribute("error",error);
            faculties = new ArrayList<>();
        }
        request.setAttribute("faculties",faculties);
        ServletUtils.forward(request,response,"/views/admin/faculty/faculty.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
