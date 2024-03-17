import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class showall extends HttpServlet
{
public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
{
PrintWriter out=response.getWriter();
out.println("<html>");
out.println("<head>");
out.println("<link rel='stylesheet' href='abcd.css'>");
out.println("</head>");
out.println("<body>");
out.println("<div id='mydata'>");
try
{
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql:///SWTdb2","root","root");
Statement st=con.createStatement();
String q="select * from mytable2";
ResultSet rs=st.executeQuery(q);
out.println("<center>");
out.println("<form action='showall'>");
out.println("<table cellpadding='12'>");
out.println("<tr>");
out.println("<td>RNO</td>");
out.println("<td>Name</td>");
out.println("<td>C.N.</td>");
out.println("<td>Pass</td>");
out.println("</tr>");
while(rs.next())
{
out.println("<tr>");
out.println("<td>"+rs.getString(1)+"</td>");
out.println("<td>"+rs.getString(2)+"</td>");
out.println("<td>"+rs.getString(3)+"</td>");
out.println("<td>"+rs.getString(4)+"</td>");
out.println("</tr>");
}
out.println("</table>");
out.println("</form>");
out.println("</center>");
}
catch(Exception e)
{
out.println(e);
}
out.println("</div>");
out.println("</body>");
out.println("</html>");
out.close();
}
}