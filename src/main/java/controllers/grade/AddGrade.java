package controllers.grade;

import models.services.grade.GradeService;
import models.view_models.grade.GradeCreateRequest;
import utils.ServletUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddGrade", value = "/admin/grade/add")
public class AddGrade extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String studentId = request.getParameter("studentId");
        String subjectGroupId = request.getParameter("subjectGroupId");
        String middleGrade = request.getParameter("middleGrade");
        String finalGrade = request.getParameter("finalGrade");

        GradeCreateRequest createReq = new GradeCreateRequest();
        createReq.setStudentId(studentId);
        createReq.setSubjectGroupId(subjectGroupId);
        createReq.setMiddleGrade(Double.parseDouble(middleGrade));
        createReq.setFinalGrade(Double.parseDouble(finalGrade));

        createReq.setTotalGrade(0.5 * (createReq.getMiddleGrade() + createReq.getFinalGrade()));

        boolean success = GradeService.getInstance().insert(createReq);
        String error = "";
        if(!success){
            error = "?error=true";
        }
        ServletUtils.redirect(response, request.getContextPath() + "/admin/grades" + error);
    }
}
