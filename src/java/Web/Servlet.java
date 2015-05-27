/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Web;

import Control.DataBean;
import Model.Worktime;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mike
 */
public class Servlet extends HttpServlet {
    @EJB
    private DataBean dataHandler;
 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
 @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        dataHandler = new DataBean();
        String method = request.getParameter("method");
        String success = "";
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            
            
            if(method != null){
                
                success = "YAY SUCCESS";
                
            }
            else{
                success = "BOO FAIL";
            }



            
                    SimpleDateFormat  date = new SimpleDateFormat("yyyy-MM-dd");
                    SimpleDateFormat  time = new SimpleDateFormat("HH:mm:ss"); 
            

       
            switch(method){
                 
                case "checkUser":
                    
                    response.addHeader("backEnd", success);
                    out.println("<p>Method " + method + "</p>");
                    int id = Integer.parseInt(request.getParameter("id"));
                   List<Worktime> list = dataHandler.getWorkersTime(id);

                    response.addHeader("size", Integer.toString(list.size()));
                  
                 out.println("<p>size " + Integer.toString(list.size()) + "</p>");
                  for(int i = 0; i < list.size(); i++){
                         
                       String numerator = Integer.toString(i);
                      Worktime item = list.get(i);
                        out.println("<p>Numerator" + numerator + "</p>");
                            
                      
                      response.addHeader("id"+numerator, (list.get(i).getId().toString()));
                      response.addHeader("start"+numerator,String.valueOf(list.get(i).getStarttime()));                  
                      response.addHeader("end"+numerator,String.valueOf(list.get(i).getEndtime()));
                      response.addHeader("trackingType"+numerator, Integer.toString(list.get(i).getTrackingtype().getId()));
                      
                     
                   
                 
                        }
         
          
         
                    break;
                    
                case "checkIn":
                  int eId = Integer.parseInt(request.getParameter("empId"));
                  dataHandler.setEmployeeToAdd(dataHandler.findEmployee(eId));   
                    dataHandler.setTracker(dataHandler.findTrackingType(Integer.parseInt(request.getParameter("tracker"))));                    
                    
                   dataHandler.setStartTime(Long.parseLong(request.getParameter("sTime")));
//                    
                    dataHandler.checkIn();
               
                      response.addHeader("backEnd", success);
                      response.addHeader("wId", Integer.toString(dataHandler.getwId()));
                     
                    break;
                    
                    
                case "checkOut":
                    dataHandler.setEndTime(Long.parseLong(request.getParameter("eTime")));
                    dataHandler.checkOut(Integer.parseInt(request.getParameter("wId")));
                    
                   response.addHeader("backEnd", success);
                   
                 
                    break;
                    
                    
                case "login":
                    response.addHeader("backEnd", success);
                    
                    int empId = dataHandler.fetchUserId((request.getParameter("code"))).getEmployee().getId();
                    String wifi = dataHandler.fetchUserId((request.getParameter("code"))).getWifi();
                    
                    response.addHeader("empId", Integer.toString(empId));
                    response.addHeader("wifi", wifi);
                   
                    
                    
                    break;
            }  
   

            
          
           
       

    }


    
 
    
    
}
    
}
