package org.apache.jsp.WEB_002dINF;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <label for=\"usuario\"></label>\n");
      out.write("        <input type=\"text\" id=\"usuario\">\n");
      out.write("        \n");
      out.write("        <label for=\"password\"></label>\n");
      out.write("        <input type=\"text\" id=\"password\">\n");
      out.write("        <button id=\"buttonIngresar\" >Ingrese Usuario</button>\n");
      out.write("        \n");
      out.write("        <label for=\"dni\"></label>\n");
      out.write("        <input type=\"text\" id=\"dni\">\n");
      out.write("        \n");
      out.write("        <button id=\"buttonIngresoVotar\" > Votar </button>\n");
      out.write("        \n");
      out.write("        <script src=\"https://code.jquery.com/jquery-3.3.1.min.js\" ></script>\n");
      out.write("        \n");
      out.write("        <script>   \n");
      out.write("            \n");
      out.write("            //AJAX con JSON\n");
      out.write("            $(\"#buttonIngresar\" ).click(function() {\n");
      out.write("                var user = new Object();\n");
      out.write("                user.userName = $('#usuario').val(); //valor que tenga el id_usuario se guarda\n");
      out.write("                user.userPass = $('#password').val();\n");
      out.write("                console.log(user);\n");
      out.write("                $.ajax({\n");
      out.write("                        url: \"Administrador_Servlet\",\n");
      out.write("                        type: 'POST',   \n");
      out.write("                        dataType: 'json',\n");
      out.write("                        data: {\n");
      out.write("                            accion: $(\"#accion\").val(),\n");
      out.write("                            text_json: JSON.stringify(user) //convertirlo el user que es un objeto en una extructura json\n");
      out.write("                        },\n");
      out.write("                          \n");
      out.write("                        success : function(response) {\n");
      out.write("                                console.log(response);\n");
      out.write("                                if(response == \"noPass\"){\n");
      out.write("                                    $('#ajaxResponseUsuario').html(\"Contraseña equivocada\");\n");
      out.write("                                }else if(response == \"noUsu\"){\n");
      out.write("                                    $('#ajaxResponseUsuario').html(\"Usuario equivocado\");\n");
      out.write("                                }else{\n");
      out.write("                                    window.location.href = \"admi_menu.jsp\"; //localizar ventana en el navegador .\n");
      out.write("                                }\n");
      out.write("                        },\n");
      out.write("                        error:function(data,status,er) {\n");
      out.write("                            $('#ajaxResponseUsuario').html(\"No registrado \" );\n");
      out.write("                        }\n");
      out.write("                });\n");
      out.write("            });\n");
      out.write("            \n");
      out.write("            //AJAX con JSON\n");
      out.write("            $(\"#buttonIngresoVotar\" ).click(function() {\n");
      out.write("                var user = new Object();\n");
      out.write("                user.userdni = $('#dni').val();\n");
      out.write("                console.log(user);\n");
      out.write("                $.ajax({\n");
      out.write("                        url: \"Servlet_Persona\",\n");
      out.write("                        type: 'POST',   \n");
      out.write("                        dataType: 'json',\n");
      out.write("                        data: {\n");
      out.write("                            accion: $(\"#accion\").val(),\n");
      out.write("                            text_json: JSON.stringify(user)\n");
      out.write("                        },\n");
      out.write("                          \n");
      out.write("                        success : function(response) {\n");
      out.write("                                console.log(response);\n");
      out.write("                                if(response == \"noPass\"){\n");
      out.write("                                    $('#ajaxResponseDNI').html(\"Este DNI no existe\");\n");
      out.write("                                }else if(response == \"noUsu\"){\n");
      out.write("                                    $('#ajaxResponseDNI').html(\"Usuario equivocado\");\n");
      out.write("                                }else{\n");
      out.write("                                    window.location.href = \"votar.jsp\";\n");
      out.write("                                }\n");
      out.write("                        },\n");
      out.write("                        error:function(data,status,er) {\n");
      out.write("                            $('#ajaxResponseDNI').html(\"No registrado \" );\n");
      out.write("                        }\n");
      out.write("                });\n");
      out.write("            });\n");
      out.write("        </script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
