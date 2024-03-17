import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class InsertDemo extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
{
PrintWriter out=response.getWriter();
String s1=request.getParameter("n1");
String s2=request.getParameter("n2");
String s3=request.getParameter("n3");
String s4=request.getParameter("n4");
out.println("<html>");
out.println("<body>");
try
{
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql:///SWTdb2","root","root");
Statement st=con.createStatement();
String q="insert into mytable2 values('"+s1+"','"+s2+"','"+s3+"','"+s4+"')";
st.executeUpdate(q);
response.sendRedirect("showall");
con.close();
}
catch(Exception e)
{
out.println(e);
}
out.println("</body>");
out.println("</html>");
out.close();
}
}