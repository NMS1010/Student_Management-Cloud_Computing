package controllers.subject;

import models.services.subject.SubjectService;
import models.view_models.subject.SubjectCreateRequest;
import utils.ServletUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddSubject", value = "/admin/subject/add")
public class AddSubject extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        SubjectCreateRequest createReq = new SubjectCreateRequest();

        createReq.setSubjectId(request.getParameter("subjectId"));
        createReq.setSubjectName(request.getParameter("subjectName"));
        createReq.setCreditsNo(Integer.parseInt(request.getParameter("creditsNo")));
        createReq.setPeriodsNo(Integer.parseInt(request.getParameter("periodsNo")));

        boolean success = SubjectService.getInstance().insert(createReq);
        String error = "";
        if(!success){
            error = "?error=true";
        }
        ServletUtils.redirect(response, request.getContextPath() + "/admin/subjects" + error);
    }
}
