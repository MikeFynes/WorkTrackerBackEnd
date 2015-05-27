/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Web;

import Control.DataBean;
import Control.WebBean;
import Model.Worktime;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author mike
 */
public class WebApp extends HttpServlet {
    @EJB
    private DataBean dataBean;
    private WebBean webBean;

    



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
      dataBean = new DataBean();
        webBean = new WebBean();
  
    
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        try (PrintWriter out = response.getWriter()) {
         
      
                     
            
             
      
                      try{
                      webBean.setCodeEntered(request.getSession().getAttribute("code").toString());
                      Boolean status = false;
                             status = webBean.checkLogin();
                      
                            if(status != false){
                                
                              String index = "<!DOCTYPE HTML>\n" +
"<html>\n" +
"<head>\n" +
"      	<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\n" +
"        <title> WorkTracker </title>\n" +
"        <link rel=stylesheet href=\"./style.css\" type=\"text/css\">\n" +
"		\n" +
"</head>\n" +
"<body>\n" +
"\n" +
"<div id=\"main_container\">\n" +
"\n" +
"        <div id=\"container\">\n" +
"                <div id=\"content\">\n" +
"				     <small>Logged in as "+webBean.getLoggedUser().getFname()+" "+webBean.getLoggedUser().getLname()+" </small> 	\n" +
"					 <h2>Welcome to WorkTracker</h2>\n" +
"					 <h2>Select an option below to continue</h2>\n" +
"				<div id=\"work\"> \n" +
"				<h3>My Work</h3>\n" +
"				<form action=\"WebApp\" method=\"post\"><input type=\"hidden\" name=\"method\" value=\"lastSeven\" /><input type=\"submit\" class=\"button\" value=\"Last Seven Days\" ></input></form>\n" +
"				<form action=\"WebApp\" method=\"post\"><input type=\"hidden\" name=\"method\" value=\"fullMonth\" /><input type=\"submit\" class=\"button\" value=\"Full Month\" ></input></form>\n" +
"                <form action=\"WebApp\" method=\"post\"><input type=\"hidden\" name=\"method\" value=\"all\" /><input type=\"submit\" class=\"button\" value=\"All\" ></input></form>\n" +
"				  \n" +
"      \n" +
"                </div>\n" +
"				<div id=\"team\">\n" +
"					<h3>My Team</h3>\n" +
"					<form action=\"WebApp\" method=\"post\"><input type=\"hidden\" name=\"method\" value=\"fullTeam\" /><input type=\"submit\" class=\"button\" value=\"Full Team\" ></input></form>\n" +
"					  <form action=\"WebApp\" method=\"post\"><input type=\"hidden\" name=\"method\" value=\"addUser\" /><input type=\"submit\" class=\"button\" value=\"Add User\" ></input></form>\n" +
" \n" +
"				\n" +
"				\n" +
"				</div>\n" +
"				\n" +
"				 </div>\n" +
"				 <br />\n" +
"			\n" +
"						\n" +
"        </div>\n" +
"\n" +
"       \n" +
"</div>\n" +
"</body>\n" +
"</html>";
            
             out.println(index);       
             
             session.setAttribute("code", webBean.getCodeEntered());
                                
                                
                 System.out.println(session.getAttribute("code"));
                                
                                
                            } 
                            else{
                                
                                String page = "<html>\n" +
"    <head>\n" +
"        <title>WorkTracker</title>\n" +
"    </head>\n" +
"    <body>\n" +
"        <p>Oops!  It appears you do not have permission to do that!</p>\n" +
"                     <a href=\"../Servlet\"><Button class=\"button\" id=\"back\" onclick=\"goBack()\">Back</Button></a>\n" +

"    </body>\n" +
"</html>\n" +
"";
                 out.println(page);                  
                            }
                             
                             
                             
                      
                      }
                  catch(NullPointerException e){
                                                      String page = "<html>\n" +
"    <head>\n" +
"        <title>WorkTracker</title>\n" +
"    </head>\n" +
"    <body>\n" +
"        <p>Oops!  It appears you do not have permission to do that!</p>\n" +
"                     <a href=\"../Servlet\"><Button class=\"button\" id=\"back\" onclick=\"goBack()\">Back</Button></a>\n" +

"    </body>\n" +
"    </body>\n" +
"</html>\n" +
"";
                 out.println(page);   
                  }
    }
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
        
        dataBean = new DataBean();
        webBean = new WebBean();
        String method = request.getParameter("method");
    
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        try (PrintWriter out = response.getWriter()) {
            if(method != null){
                System.out.println(method);
                       SimpleDateFormat  date = new SimpleDateFormat("dd-MM-yyyy");
                    SimpleDateFormat  time = new SimpleDateFormat("HH:mm");         
            
              switch(method){
                  case "login":
                      try{
                      webBean.setCodeEntered(request.getParameter("code"));
                      Boolean status = false;
                             status = webBean.checkLogin();
                      
                            if(status != false){
                                
                              String index = "<!DOCTYPE HTML>\n" +
"<html>\n" +
"<head>\n" +
"      	<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\n" +
"        <title> WorkTracker </title>\n" +
"        <link rel=stylesheet href=\"./style.css\" type=\"text/css\">\n" +
"		\n" +
"</head>\n" +
"<body>\n" +
"\n" +
"<div id=\"main_container\">\n" +
"\n" +
"        <div id=\"container\">\n" +
"                <div id=\"content\">\n" +
"				     <small>Logged in as "+webBean.getLoggedUser().getFname()+" "+webBean.getLoggedUser().getLname()+" </small> 	\n" +
"					 <h2>Welcome to WorkTracker</h2>\n" +
"					 <h2>Select an option below to continue</h2>\n" +
"				<div id=\"work\"> \n" +
"				<h3>My Work</h3>\n" +
"				<form action=\"WebApp\" method=\"post\"><input type=\"hidden\" name=\"method\" value=\"lastSeven\" /><input type=\"submit\" class=\"button\" value=\"Last Seven Days\" ></input></form>\n" +
"				<form action=\"WebApp\" method=\"post\"><input type=\"hidden\" name=\"method\" value=\"fullMonth\" /><input type=\"submit\" class=\"button\" value=\"Full Month\" ></input></form>\n" +
"                <form action=\"WebApp\" method=\"post\"><input type=\"hidden\" name=\"method\" value=\"all\" /><input type=\"submit\" class=\"button\" value=\"All\" ></input></form>\n" +
"				  \n" +
"      \n" +
"                </div>\n" +
"				<div id=\"team\">\n" +
"					<h3>My Team</h3>\n" +
"					<form action=\"WebApp\" method=\"post\"><input type=\"hidden\" name=\"method\" value=\"fullTeam\" /><input type=\"submit\" class=\"button\" value=\"Full Team\" ></input></form>\n" +
"					  <form action=\"WebApp\" method=\"post\"><input type=\"hidden\" name=\"method\" value=\"addUser\" /><input type=\"submit\" class=\"button\" value=\"Add User\" ></input></form>\n" +
" \n" +
"				\n" +
"				\n" +
"				</div>\n" +
"				\n" +
"				 </div>\n" +
"				 <br />\n" +
"			\n" +
"						\n" +
"        </div>\n" +
"\n" +
"       \n" +
"</div>\n" +
"</body>\n" +
"</html>";
            
             out.println(index);       
             
             session.setAttribute("code", webBean.getCodeEntered());
                                
                                
                 System.out.println(session.getAttribute("code"));
                                
                                
                            } 
                             
                             
                             
                      
                      }
                  catch(NullPointerException e){
                      System.out.println("Error: "+e.toString());
                  }
                  
                  break;
                      
                  case "lastSeven":
                                            webBean.setCodeEntered(request.getSession().getAttribute("code").toString());
                      Boolean status = false;
                             status = webBean.checkLogin();
                      
                            if(status != false){
                                
                            
                      
                      
                        try{
                            
                           String lastSevenStart = "<!DOCTYPE html>\n" +
"<html style=\"background:white;\">\n" +
"<head>\n" +
"      	<meta http-equiv=\"content-type\" content=\"text/html; charset=utf-8\" />\n" +
"        <title> WorkTracker </title>\n" +
"        <link rel=\"stylesheet\" href=\"./style.css\" type=\"text/css\" />\n" +
"        	\n" +
"\n" +
"\n" +
"</head>\n" +
"    <body>\n" +
"            <div id=\"main_container\">\n" +
"\n" +
"        <div id=\"container\">\n" +
"                <div id=\"content\">\n" +
"                 <Button class=\"button\" id=\"back\" onclick=\"goBack()\">Back</Button><script>\n" +
"function goBack() {\n" +
"    window.history.back()\n" +
"}\n" +
"</script>\n" +
"        <small>Logged in as "+webBean.getLoggedUser().getFname()+" "+webBean.getLoggedUser().getLname()+" </small> 	\n" +
"          <h2>Your last seven completed days</h2>    <table class=\"time_table\">\n" +
"	<tr class=\"header_row\">\n" +
"	<td class=\"time_cell\">\n" +
"	<h3>ID</h3>\n" +
"	</td>\n" +
"	<td class=\"time_cell\">\n" +
"	<h3>Date</h3>\n" +
"	</td>\n" +
"\n" +
"	<td class=\"time_cell\">\n" +
"	<h3>Start</h3>\n" +
"	</td>\n" +
"	<td class=\"time_cell\">\n" +
"		<h3>End</h3>\n" +
"	</td>\n" +
"	\n" +
"	</tr>\n" +
"      ";
                           
                   String lastSevenTable = "";
                   String codeEntered = session.getAttribute("code").toString();
           List<Worktime> grabbedList = new ArrayList<Worktime>();
           grabbedList = grabbedList(7, codeEntered);
          for(int i=0; i<grabbedList.size(); i++){
              
              lastSevenTable += "	<tr class=\"time_row\">\n" +
"	<td class=\"time_cell\">\n" +
"	<p>"+grabbedList.get(i).getId().toString()+"</p>\n" +
"	</td>\n" +
"	<td class=\"time_cell\">\n" +
"	<p>"+date.format(grabbedList.get(i).getStarttime())+"</p>\n" +
"	</td>\n" +
"\n" +
"	<td class=\"time_cell\">\n" +
"	<p>"+time.format(grabbedList.get(i).getStarttime())+"</p>\n" +
"	</td>\n" +
"	<td class=\"time_cell\">\n" +
"		<p>"+time.format(grabbedList.get(i).getEndtime())+"</p>\n" +
"	</td>\n" +
"	\n" +
"	</tr>";
              
              
          }         
                   
                   
                   
                   
                   
                   
                   
                   String lastSevenEnd = "  </table></div>\n" +
"				\n" +
"			\n" +
"						\n" +
"        </div>\n" +
"\n" +
"       \n" +
"</div>\n" +
"        \n" +
"        \n" +
"    <body>\n" +
"</html>";
                   
                   out.println(lastSevenStart);
                   out.println(lastSevenTable);
                   out.println(lastSevenEnd);
                              
                        }
                        catch(NullPointerException e){
                                        System.out.println("Error: "+e.toString());
                        }
                      
                         
                      
                      
                      }
                      
                      
                      break;
                      
                      
                  case "fullMonth":
                                                         webBean.setCodeEntered(request.getSession().getAttribute("code").toString());
                       status = false;
                             status = webBean.checkLogin();
                      
                            if(status != false){
                                 
                      
                       try{
                            
                           String fullMonthStart = "<!DOCTYPE html>\n" +
"<html style=\"background:white;\">\n" +
"<head>\n" +
"      	<meta http-equiv=\"content-type\" content=\"text/html; charset=utf-8\" />\n" +
"        <title> WorkTracker </title>\n" +
"        <link rel=\"stylesheet\" href=\"./style.css\" type=\"text/css\" />\n" +
"        	\n" +
"\n" +
"\n" +
"</head>\n" +
"    <body>\n" +
"            <div id=\"main_container\">\n" +
"\n" +
"        <div id=\"container\">\n" +
"                <div id=\"content\">\n" +
"                 <Button class=\"button\" id=\"back\" onclick=\"goBack()\">Back</Button><script>\n" +
"function goBack() {\n" +
"    window.history.back()\n" +
"}\n" +
"</script>\n" +
"        <small>Logged in as "+webBean.getLoggedUser().getFname()+" "+webBean.getLoggedUser().getLname()+" </small> 	\n" +
"          <h2>Your last months work history</h2>    <table class=\"time_table\">\n" +
"	<tr class=\"header_row\">\n" +
"	<td class=\"time_cell\">\n" +
"	<h3>ID</h3>\n" +
"	</td>\n" +
"	<td class=\"time_cell\">\n" +
"	<h3>Date</h3>\n" +
"	</td>\n" +
"\n" +
"	<td class=\"time_cell\">\n" +
"	<h3>Start</h3>\n" +
"	</td>\n" +
"	<td class=\"time_cell\">\n" +
"		<h3>End</h3>\n" +
"	</td>\n" +
"	\n" +
"	</tr>\n" +
"      ";
                           
                   String fullMonthTable = "";
                   String codeEntered = session.getAttribute("code").toString();
           List<Worktime> grabbedList = new ArrayList<Worktime>();
           grabbedList = grabbedList(30, codeEntered);
          for(int i=0; i<grabbedList.size(); i++){
              
              fullMonthTable += "	<tr class=\"time_row\">\n" +
"	<td class=\"time_cell\">\n" +
"	<p>"+grabbedList.get(i).getId().toString()+"</p>\n" +
"	</td>\n" +
"	<td class=\"time_cell\">\n" +
"	<p>"+date.format(grabbedList.get(i).getStarttime())+"</p>\n" +
"	</td>\n" +
"\n" +
"	<td class=\"time_cell\">\n" +
"	<p>"+time.format(grabbedList.get(i).getStarttime())+"</p>\n" +
"	</td>\n" +
"	<td class=\"time_cell\">\n" +
"		<p>"+time.format(grabbedList.get(i).getEndtime())+"</p>\n" +
"	</td>\n" +
"	\n" +
"	</tr>";
              
              
          }         
                   
                   
                   
                   
                   
                   
                   
                   String fullMonthEnd = "  </table></div>\n" +
"				\n" +
"			\n" +
"						\n" +
"        </div>\n" +
"\n" +
"       \n" +
"</div>\n" +
"        \n" +
"        \n" +
"    <body>\n" +
"</html>";
                   
                   out.println(fullMonthStart);
                   out.println(fullMonthTable);
                   out.println(fullMonthEnd);
                              
                        }
                        catch(NullPointerException e){
                                        System.out.println("Error: "+e.toString());
                        }
                      
                      
                            }
                      
                      
                      
                      break;
                      
                      
                      
                  case "all":
                                                          webBean.setCodeEntered(request.getSession().getAttribute("code").toString());
                      status = false;
                             status = webBean.checkLogin();
                      
                            if(status != false){
                                
                      
                      
                         try{
                            
                           String allStart = "<!DOCTYPE html>\n" +
"<html style=\"background:white;\">\n" +
"<head>\n" +
"      	<meta http-equiv=\"content-type\" content=\"text/html; charset=utf-8\" />\n" +
"        <title> WorkTracker </title>\n" +
"        <link rel=\"stylesheet\" href=\"./style.css\" type=\"text/css\" />\n" +
"        	\n" +
"\n" +
"\n" +
"</head>\n" +
"    <body>\n" +
"            <div id=\"main_container\">\n" +
"\n" +
"        <div id=\"container\">\n" +
"                <div id=\"content\">\n" +
"                 <Button class=\"button\" id=\"back\" onclick=\"goBack()\">Back</Button><script>\n" +
"function goBack() {\n" +
"    window.history.back()\n" +
"}\n" +
"</script>\n" +
"          <small>Logged in as "+webBean.getLoggedUser().getFname()+" "+webBean.getLoggedUser().getLname()+" </small> 	\n" +
"          <h2>Full work history</h2>    <table class=\"time_table\">\n" +
"	<tr class=\"header_row\">\n" +
"	<td class=\"time_cell\">\n" +
"	<h3>ID</h3>\n" +
"	</td>\n" +
"	<td class=\"time_cell\">\n" +
"	<h3>Date</h3>\n" +
"	</td>\n" +
"\n" +
"	<td class=\"time_cell\">\n" +
"	<h3>Start</h3>\n" +
"	</td>\n" +
"	<td class=\"time_cell\">\n" +
"		<h3>End</h3>\n" +
"	</td>\n" +
"	\n" +
"	</tr>\n" +
"      ";
                           
                   String allTable = "";
                   String codeEntered = session.getAttribute("code").toString();
           List<Worktime> grabbedList = new ArrayList<Worktime>();
           grabbedList = grabbedList(30, codeEntered);
          for(int i=0; i<grabbedList.size(); i++){
              
              allTable += "	<tr class=\"time_row\">\n" +
"	<td class=\"time_cell\">\n" +
"	<p>"+grabbedList.get(i).getId().toString()+"</p>\n" +
"	</td>\n" +
"	<td class=\"time_cell\">\n" +
"	<p>"+date.format(grabbedList.get(i).getStarttime())+"</p>\n" +
"	</td>\n" +
"\n" +
"	<td class=\"time_cell\">\n" +
"	<p>"+time.format(grabbedList.get(i).getStarttime())+"</p>\n" +
"	</td>\n" +
"	<td class=\"time_cell\">\n" +
"		<p>"+time.format(grabbedList.get(i).getEndtime())+"</p>\n" +
"	</td>\n" +
"	\n" +
"	</tr>";
              
              
          }         
                   
                   
                   
                   
                   
                   
                   
                   String allEnd = "  </table></div>\n" +
"				\n" +
"			\n" +
"						\n" +
"        </div>\n" +
"\n" +
"       \n" +
"</div>\n" +
"        \n" +
"        \n" +
"    <body>\n" +
"</html>";
                   
                   out.println(allStart);
                   out.println(allTable);
                   out.println(allEnd);
                              
                        }
                        catch(NullPointerException e){
                                        System.out.println("Error: "+e.toString());
                        }
                         
                            }
                      
                      break;
                      
                      
                      
                  case "fullTeam":
                                                          webBean.setCodeEntered(request.getSession().getAttribute("code").toString());
                      status = false;
                             status = webBean.checkLogin();
                      
                            if(status != false){
                                
                      
                      
                      try{
                            
                           String fullTeamStart = "<!DOCTYPE html>\n" +
"<html style=\"background:white;\">\n" +
"<head>\n" +
"      	<meta http-equiv=\"content-type\" content=\"text/html; charset=utf-8\" />\n" +
"        <title> WorkTracker </title>\n" +
"        <link rel=\"stylesheet\" href=\"./style.css\" type=\"text/css\" />\n" +
"        	\n" +
"\n" +
"\n" +
"</head>\n" +
"    <body>\n" +
"            <div id=\"main_container\">\n" +
"\n" +
"        <div id=\"container\">\n" +
"                <div id=\"content\">\n" +
"                 <Button class=\"button\" id=\"back\" onclick=\"goBack()\">Back</Button><script>\n" +
"function goBack() {\n" +
"    window.history.back()\n" +
"}\n" +
"</script>\n" +
"          <small>Logged in as "+webBean.getLoggedUser().getFname()+" "+webBean.getLoggedUser().getLname()+" </small> 	\n" +
"          <h2>Full Team history</h2>    <table class=\"time_table\">\n" +
"	<tr class=\"header_row\">\n" +
"	<td class=\"time_cell\">\n" +
"	<h3>ID</h3>\n" +
"	</td>\n" +
"	<td class=\"time_cell\">\n" +
"	<h3>Name</h3>\n" +
"	</td>\n" +
"	<td class=\"time_cell\">\n" +
"	<h3>Date</h3>\n" +
"	</td>\n" +
"\n" +
"	<td class=\"time_cell\">\n" +
"	<h3>Start</h3>\n" +
"	</td>\n" +
"	<td class=\"time_cell\">\n" +
"		<h3>End</h3>\n" +
"	</td>\n" +
"	\n" +
"	</tr>\n" +
"      ";
                           
                   String fullTeamTable = "";
                   String codeEntered = session.getAttribute("code").toString();
           List<Worktime> grabbedList = new ArrayList<Worktime>();
           grabbedList = fullTeamList(codeEntered);
          for(int i=0; i<grabbedList.size(); i++){
              
              fullTeamTable += "	<tr class=\"time_row\">\n" +
"	<td class=\"time_cell\">\n" +
"	<p>"+grabbedList.get(i).getId().toString()+"</p>\n" +
"	</td>\n" +
"	<td class=\"time_cell\">\n" +
"	<p>"+grabbedList.get(i).getEmployee().getFname()+" "+grabbedList.get(i).getEmployee().getLname()+"</p>\n" +
"	</td>\n" +
"	<td class=\"time_cell\">\n" +
"	<p>"+date.format(grabbedList.get(i).getStarttime())+"</p>\n" +
"	</td>\n" +
"\n" +
"	<td class=\"time_cell\">\n" +
"	<p>"+time.format(grabbedList.get(i).getStarttime())+"</p>\n" +
"	</td>\n" +
"	<td class=\"time_cell\">\n" +
"		<p>"+time.format(grabbedList.get(i).getEndtime())+"</p>\n" +
"	</td>\n" +
"	\n" +
"	</tr>";
              
              
          }         
                   
                   
                   
                   
                   
                   
                   
                   String fullTeamEnd = "  </table></div>\n" +
"				\n" +
"			\n" +
"						\n" +
"        </div>\n" +
"\n" +
"       \n" +
"</div>\n" +
"        \n" +
"        \n" +
"    <body>\n" +
"</html>";
                   
                   out.println(fullTeamStart);
                   out.println(fullTeamTable);
                   out.println(fullTeamEnd);
                              
                        }
                        catch(NullPointerException e){
                                        System.out.println("Error: "+e.toString());
                        }      
                      
                            }
                      break;
                      
                      
                  case "addUser":
                                                          webBean.setCodeEntered(request.getSession().getAttribute("code").toString());
                      status = false;
                             status = webBean.checkLogin();
                      
                            if(status != false){
                                
                      
                                           try{
                    
                                
                              String addUser = "<html      style=\"background:white;\">\n" +
"    <head>\n" +
"        <title>WorkTracker</title>\n" +
"           <link rel=\"stylesheet\" href=\"./style.css\" type=\"text/css\" />\n" +
"    <head>\n" +
"    <body>\n" +
"        <div id=\"main_container\">\n" +
"\n" +
"        <div id=\"container\">\n" +
"                <div id=\"content\">\n" +
"                 <Button class=\"button\" id=\"back\" onclick=\"goBack()\">Back</Button><script>\n" +
"function goBack() {\n" +
"    window.history.back()\n" +
"}\n" +
"</script>\n" +
"          <small>Logged in as "+webBean.getLoggedUser().getFname()+" "+webBean.getLoggedUser().getLname()+" </small> 	\n" +
"                    \n" +
"					 <h2>Add User</h2>\n" +
"					 <h2>Fill the form below to continue</h2>\n" +
"                                         \n" +
"                                         \n" +
"    <table class=\"new_user_form\">\n" +
"        \n" +
"                      <form action=\"WebApp\" method=\"post\">\n" +
"                         \n" +
"                              <input type=\"hidden\" name=\"method\" value=\"newUserInput\"></input>\n" +
"							  \n" +
"							  	<tr>\n" +
"				<td class=\"add_cell\">First Name</td></tr>\n" +
"				<tr>\n" +
"				<td class=\"add_second_cell\"><input name=\"fname\" type=\"text\" required/></td>\n" +
"			</tr>\n" +
"			\n" +
"								  	<tr>\n" +
"				<td class=\"add_cell\">Last Name</td></tr>\n" +
"					<tr><td class=\"add_second_cell\"><input name=\"lname\" type=\"text\" required/></td>\n" +
"			</tr>\n" +
"										  	<tr>\n" +
"				<td class=\"add_cell\">Role Id</td></tr>\n" +
"			<tr>	<td ><select name=\"role\" required>\n" +
"  <option value=\"1\">Office Employee</option>\n" +
"  <option value=\"2\">Field Employee</option>\n" +
"  <option value=\"3\">Manager / Director</option>\n" +
"  <option value=\"4\">HR Employee</option>\n" +
"</select></td>\n" +
"			</tr>\n" +
"											  	<tr>\n" +
"				<td class=\"add_cell\">Supervisor Id</td></tr>\n" +
"		<tr>		<td class=\"add_second_cell\"><input name=\"super\" type=\"text\" required/></td>\n" +
"			</tr>\n" +
"			\n" +
"                      \n" +
"                              <tr>\n" +
"							  <td>\n" +
"                                  <input type=\"submit\" class=\"button\" value=\"Add User\">\n" +
"								  </td>\n" +
"								  </tr>\n" +
"        </form>\n" +
"                                             \n" +
"                                             \n" +
"         </table>                                                       \n" +
"      </div>\n" +
"			\n" +
"			\n" +
"						\n" +
"        </div>\n" +
"\n" +
"       \n" +
"</div>\n" +
"          \n" +
"    </body>\n" +
"</html>\n" +
"";
            
             out.println(addUser);       
             
             session.setAttribute("code", webBean.getCodeEntered());
                                
                                
                 System.out.println(session.getAttribute("code"));
                                
                                
                            } 
                             
                             
                             
                      
                     
                  catch(NullPointerException e){
                      System.out.println("Error: "+e.toString());
                  }
                                           
                                            }
                      break;
                    
                      
                  case "newUserInput":
                      
                      webBean.setCodeEntered(request.getSession().getAttribute("code").toString());
                      status = false;
                             status = webBean.checkLogin();
                      
                            if(status != false){
                                
                       Boolean addUserState = false;
                      
                      try{
                          String code = request.getSession().getAttribute("code").toString();
                          addUserState = addNewUser(code, request.getParameter("fname"), request.getParameter("lname"), Integer.parseInt(request.getParameter("role")));
                          
                          
                      }
                           catch(NullPointerException e){
                      System.out.println("Error: "+e.toString());
                  }
                      
                      String addedUser = "";
                      
                      if(addUserState != false){
                          addedUser += "<html>\n" +
"    <head>\n" +
"        <title>WorkTracker</title>\n" +
"    </head>\n" +
"    <body>\n" +
"        <p>New user added successfully!</p>\n" +
"                       <a href=\"../Servlet/WebApp\" <Button class=\"button\" id=\"back\" onclick=\"index()\">Back</Button></a>\n" +

"    </body>\n" +
"</html>\n" +
"";
                      }
                      else{
                          addedUser += "<html>\n" +
"    <head>\n" +
"        <title>WorkTracker</title>\n" +
"    </head>\n" +
"    <body>\n" +
"        <p>Oops!  It appears you do not have permission to do that!</p>\n" +
"                        <Button class=\"button\" id=\"back\" onclick=\"goBack()\">Back</Button><script>\n" +
"function goBack() {\n" +
"    window.history.back()\n" +
"   \n" +
"}\n" +
"</script>\n" +
"    </body>\n" +
"</html>\n" +
"";
                      }
                      
                      
                      
                      out.println(addedUser);
                      
                      
                            }
                      
                      
                      
                      
                      
              }


    }
            else{
                   System.out.println("Method is null");
            }
        
    }
        
         }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

 
    
    
    public List<Worktime> grabbedList(int size, String code){
       List<Worktime> selectedList = new ArrayList<Worktime>();
        
        webBean.setCodeEntered(code);
        webBean.checkLogin();
        selectedList = webBean.loadList(size);
        
    
       return selectedList;
    }
    
        public List<Worktime> fullTeamList(String code){
       List<Worktime> selectedList = new ArrayList<Worktime>();
        
        webBean.setCodeEntered(code);
        webBean.checkLogin();
        selectedList = webBean.getFullTeamWorkingHours();
        
    
       return selectedList;
    }
    
    public Boolean addNewUser(String code, String fName, String lName, int role){
        Boolean status = false;
        
        if(dataBean.fetchUserId(code).getEmployee().getRole().getId()>2){
            
        
        
        try{
            
        
        int superId = dataBean.fetchUserId(code).getEmployee().getId();
        dataBean.setFirstName(fName);
        dataBean.setLastName(lName);
        dataBean.setRoleId(role);
        dataBean.setSuperId(superId);
        
        dataBean.addEmployee();
        status = true;
        
        }
        catch(Error e){
          status = false;  
        }
        }
        
        else{
            status = false;
        }
        
        
        return status;
        
    }
}
