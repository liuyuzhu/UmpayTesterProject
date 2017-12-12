package com.yuzhuliu.study.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import java.lang.reflect.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet {
 public static final Class[] NO_PARAMS = new Class[0];

 public void doGet(HttpServletRequest request, HttpServletResponse response)
   throws ServletException, IOException {
  doPost(request,response);
 }
 
 public void doPost(HttpServletRequest request, HttpServletResponse response)
   throws ServletException, IOException 
 {
  String tableOptions = request.getParameter("tableOptions");
  if(tableOptions == null)
  {
   tableOptions = "";
  }
  String trOptions = request.getParameter("trOptions");
  if(trOptions == null)
  {
   trOptions = "";
  }
  String tdOptions = request.getParameter("tdOptions");
  if(tdOptions == null)
  {
   tdOptions = "";
  }
  String thOptions = request.getParameter("thOptions");
  if(thOptions == null)
  {
   thOptions = "";
   
  }
  String data = request.getParameter("data");
  if(data == null)
  {
   getServletContext().log("No data available");
   throw new ServletException("No data parameter available");
  }
  Object dataOb = request.getAttribute(data);
  if(dataOb == null)
  {
   getServletContext().log("No data object found");
   throw new ServletException("Can' t locate the data object named"+data);
  }
  String[] columns = request.getParameterValues("column");
  String[] columnType = request.getParameterValues("columnType");
  String[] columnHeaders = request.getParameterValues("columnHeader");
  
  Hashtable columnAccessors = getAccessors(dataOb,columns);
  PrintWriter out = response.getWriter();
  out.println("<table  "+tableOptions+">");
  //out.println("<table border='1'>");
  if(columnHeaders != null)
  {
   out.println("<tr  "+trOptions+">");
   //out.println("<tr>");
   for(int i=0; i<columnHeaders.length;i++)
   {
    out.print("<th  "+thOptions+">");
    //out.println("<th>");
    out.println(columnHeaders[i]);
    out.println("</th>");
   }
   out.println("</tr>");
  }
  if(dataOb instanceof Vector)
  {
   Vector v=(Vector)dataOb;
   Enumeration e = v.elements();
   while (e.hasMoreElements())
   {
    out.println("<tr  "+trOptions+">");
    //out.println("<tr>");
    printRow(out,e.nextElement(),columns,columnType,
      columnAccessors,tdOptions);
    out.println("</tr>");
    
   }
  }
  else if(dataOb instanceof Object[])
  {
   Object[] obs = (Object[])dataOb;
   for(int i=0;i<obs.length;i++)
   {
    out.println("<tr  "+trOptions+">");
    out.println("<tr>");
    printRow(out,obs[i],columns,columnType,columnAccessors,tdOptions);
    out.println("</tr>");
   }
   
  }
  out.println("</table>");
  
  
  
 }
 protected void printRow(PrintWriter out,Object ob,String[] columns,
   String[] columnTypes,Hashtable columnAccessors,String tdOptions)
         throws ServletException
   {
         for(int i=0;i<columns.length;i++)
         {
          Object value = getColumnValue(ob,columns[i],columnAccessors);
          out.print("<td  "+tdOptions+">");
          if(columnTypes[i].equalsIgnoreCase("data"))
          {
           out.print(value);
          }
          else if(columnTypes[i].equalsIgnoreCase("image"))
          {
//           out.print("img src/"  "+value+"/">");
          }
          out.print("</td>");
         }
   }
 protected Object getColumnValue(Object ob,String columnName,Hashtable columnAccessors)
 throws ServletException
 {
  Object accessor = columnAccessors.get(columnName);
  if(accessor instanceof Field)
  {
   try {
    Field f = (Field)accessor;
    return f.get(ob);
   } catch (IllegalAccessException e) {
                  getServletContext().log(
                  "Error getting column"+columnName,e  
                  );
                  throw new ServletException(
                  "Illegal access exception for column"+columnName);  
                  
      
   }
   
  }
  else if(accessor instanceof Method)
  {
   try {
    Method m=(Method)accessor;
    return m.invoke(ob,NO_PARAMS);
    
   } catch (IllegalAccessException e) {
               getServletContext().log(
                "Error getting column"+columnName,e
               );
      throw new ServletException(
      "Illegal access exception for column"+columnName  
      );
      
   }
   catch(InvocationTargetException ee)
   {
    getServletContext().log(
    "Error getting column"+columnName,ee  
    
    );
    throw new ServletException(
      "Invocation target exception"+"for column"+columnName  
    );
    
    
   }
  }
  return null;
 }
 
 protected Hashtable getAccessors(Object ob,String[] columns)
 throws ServletException
 {
  Hashtable result = new Hashtable();
  Class obClass = null;
  if(ob instanceof Object[])
  {
   Object[] obs=(Object[])ob;
   if(obs.length==0)
    return result;
   obClass = obs[0].getClass();
  }
  else if(ob instanceof Vector)
  {
   Vector v =(Vector)ob;
   if(v.size()==0)
    return result;
   obClass = v.elementAt(0).getClass();
  }
  for(int i=0;i<columns.length;i++)
  {
   try {
    Field f=obClass.getField(columns[i]);
    result.put(columns[i],f);
    continue;
   } catch (Exception e) {
    // TODO: handle exception
   }
   try {
    Method m=obClass.getMethod(columns[i],NO_PARAMS);
    result.put(columns[i],m);
    
   } catch (Exception ex) {
                 getServletContext().log("Exception location field"+
                 columns[i],ex);
                 throw new ServletException(
                 "Can' t location field/method for"+columns[i]  
                 );
   }
  }
  return result;
  
 }
  
}
 
