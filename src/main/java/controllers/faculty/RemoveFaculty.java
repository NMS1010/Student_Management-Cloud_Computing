package controllers.faculty;

import models.services.faculty.FacultyService;
import utils.ServletUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RemoveFaculty", value = "/admin/faculty/delete")
public class RemoveFaculty extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String facultyId = request.getParameter("facultyId");

        boolean isSuccess = FacultyService.getInstance().delete(facultyId, "");
        String error = "";
        if(!isSuccess){
            error = "?error=true";
        }
        ServletUtils.redirect(response, request.getContextPath() + "/admin/faculties" +error);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
