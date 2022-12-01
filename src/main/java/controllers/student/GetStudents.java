package controllers.student;

import models.services.student.StudentService;
import models.services.student_class.StudentClassService;
import models.view_models.student.StudentViewModel;
import models.view_models.student_class.StudentClassViewModel;
import utils.ServletUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "GetStudents", value = "/admin/students")
public class GetStudents extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<StudentViewModel> students = StudentService.getInstance().retrieveAll();
        ArrayList<StudentClassViewModel> studentClasses = StudentClassService.getInstance().retrieveAll();

        String error = req.getParameter("error");
        if((error != null && !error.equals("")) || (studentClasses == null || students == null)){
            req.setAttribute("error",error);
            if(studentClasses == null)
                studentClasses = new ArrayList<>();
            if(students == null)
                students = new ArrayList<>();
        }
        studentClasses.removeIf(c -> c.getDeleted() == 1);
        req.setAttribute("studentClasses",studentClasses);
        req.setAttribute("students",students);
        ServletUtils.forward(req,resp,"/views/admin/student/student.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
