package controllers.faculty;

import models.services.faculty.FacultyService;
import models.view_models.faculty.FacultyUpdateRequest;
import models.view_models.faculty.FacultyViewModel;
import utils.ServletUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;

@WebServlet(name = "EditFaculty", value = "/admin/faculty/edit")
@MultipartConfig(
        fileSizeThreshold = 1024*1024*2, // 2MB
        maxFileSize = 1024*1024*10, // 10MB
        maxRequestSize = 1024*1024*11   // 11MB
)
public class EditFaculty extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String facultyId = request.getParameter("facultyId");

        FacultyViewModel faculty = FacultyService.getInstance().retrieveById(facultyId,"");

        request.setAttribute("faculty", faculty);

        ServletUtils.forward(request,response,"/admin/faculties");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        FacultyUpdateRequest updateReq = new FacultyUpdateRequest();
        Part logo = request.getPart("faculty-logo");
        String facultyId = request.getParameter("facultyId");
        String facultyName = request.getParameter("facultyName");
        updateReq.setFacultyId(facultyId);
        updateReq.setFile(logo);
        updateReq.setFacultyName(facultyName);

        boolean isSuccess = FacultyService.getInstance().update(updateReq);
        String error = "";
        if(!isSuccess){
            error = "?error=true";
        }
        ServletUtils.redirect(response, request.getContextPath() + "/admin/faculties" + error);
    }
}
