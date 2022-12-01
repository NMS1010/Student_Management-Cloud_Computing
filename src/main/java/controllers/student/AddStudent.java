package controllers.student;

import models.services.student.StudentService;
import models.view_models.student.StudentCreateRequest;
import utils.ServletUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddStudent", value = "/admin/student/add")
@MultipartConfig(
        fileSizeThreshold = 1024*1024*2, // 2MB
        maxFileSize = 1024*1024*10, // 10MB
        maxRequestSize = 1024*1024*11   // 11MB
)
public class AddStudent extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        StudentCreateRequest createReq = new StudentCreateRequest();

        String studentId = req.getParameter("studentId");
        String studentName = req.getParameter("studentName");
        String studentClassId = req.getParameter("studentClassId");
        String address = req.getParameter("address");
        String phone = req.getParameter("phone");
        String gender = req.getParameter("gender");
        String dob = req.getParameter("dob");

        createReq.setStudentId(studentId);
        createReq.setStudentName(studentName);
        createReq.setStudentClassId(studentClassId);
        createReq.setAddress(address);
        createReq.setDob(dob);
        createReq.setPhone(phone);
        createReq.setGender(gender);
        createReq.setFile(req.getPart("student-image"));

        boolean success = StudentService.getInstance().insert(createReq);
        String error = "";
        if(!success){
            error = "?error=true";
        }
        ServletUtils.redirect(resp, req.getContextPath() + "/admin/students" + error);
    }
}
