package controllers.student;

import models.services.student.StudentService;
import models.view_models.student.StudentUpdateRequest;
import models.view_models.student.StudentViewModel;
import utils.ServletUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EditStudent", value = "/admin/student/edit")
@MultipartConfig(
        fileSizeThreshold = 1024*1024*2, // 2MB
        maxFileSize = 1024*1024*10, // 10MB
        maxRequestSize = 1024*1024*11   // 11MB
)
public class EditStudent extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String studentId = req.getParameter("studentId");

        StudentViewModel student = StudentService.getInstance().retrieveById(studentId,"");

        req.setAttribute("student", student);

        ServletUtils.forward(req,resp,"/admin/students");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        StudentUpdateRequest updateReq = new StudentUpdateRequest();

        String studentId = req.getParameter("studentId");
        String studentName = req.getParameter("studentName");
        String studentClassId = req.getParameter("studentClassId");
        String address = req.getParameter("address");
        String phone = req.getParameter("phone");
        String gender = req.getParameter("gender");
        String dob = req.getParameter("dob");

        updateReq.setStudentId(studentId);
        updateReq.setStudentName(studentName);
        updateReq.setStudentClassId(studentClassId);
        updateReq.setAddress(address);
        updateReq.setDob(dob);
        updateReq.setPhone(phone);
        updateReq.setGender(gender);
        updateReq.setFile(req.getPart("student-image"));

        boolean isSuccess = StudentService.getInstance().update(updateReq);
        String error = "";
        if(!isSuccess){
            error = "?error=true";
        }
        ServletUtils.redirect(resp, req.getContextPath() + "/admin/students" + error);
    }
}
