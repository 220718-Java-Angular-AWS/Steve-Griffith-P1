package com.steve360.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.steve360.Objects.Reimbursements;
import com.steve360.Services.ReimbursementService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@WebServlet("/reimbursement")
public class ReimbursementServlet extends HttpServlet {
    ReimbursementService service;
    ObjectMapper mapper;

    public void init(){
        this.service = new ReimbursementService();
        this.mapper = new ObjectMapper();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String param = req.getParameter("user-id");
        if (param == null){
            List<Reimbursements> reimbursementsList = service.getAllReimbursements();
            String json = mapper.writeValueAsString(reimbursementsList);
            resp.getWriter().println(json);
        }
        resp.setContentType("Json");
        resp.setStatus(200);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        StringBuilder builder = new StringBuilder();

        BufferedReader buffer = req.getReader();

        while(buffer.ready()){
            builder.append(buffer.readLine());
        }
        String json = builder.toString();

        Reimbursements newReimbursement = mapper.readValue(json, Reimbursements.class);
        service.save(newReimbursement);
        resp.setStatus(200);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPut(req, resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doDelete(req, resp);
    }

    @Override
    public void destroy() {
    }
}
