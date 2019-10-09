<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.List"%>
<%@page import="org.solent.com504.factoryandfacade.model.Animal"%>
<%@page import="org.solent.com504.factoryandfacade.model.FarmFacade"%>
<%@page import="org.solent.com504.factoryandfacade.model.FarmObjectFactory"%>
<%@page import="org.solent.com504.factoryandfacade.impl.FarmObjectFactoryImpl"%>

<%

    FarmFacade farmFacade = (FarmFacade) session.getAttribute("farmFacade");

    // synchronised block to prevent multiple creations of factory
    if (farmFacade == null) {
        synchronized (this) {
            if (farmFacade == null) {
                FarmObjectFactory farmobjectFactory = new FarmObjectFactoryImpl();
                farmFacade = farmobjectFactory.createFarmFacade();
                session.setAttribute("farmFacade", farmFacade);

                List<String> supportedAnimalTypes = farmobjectFactory.getSupportedAnimalTypes();
                session.setAttribute("supportedAnimalTypes", supportedAnimalTypes);
            }
        }
    }

    List<String> supportedAnimalTypes = (List<String>) session.getAttribute("supportedAnimalTypes");
    
    if (request.getParameter("button1") != null && request.getParameter("animalName") != "") {
       farmFacade.addAnimal(request.getParameter("button1"), request.getParameter("animalName"));
    } else if (request.getParameter("button2") != null && request.getParameter("animalName") != "") {
        farmFacade.addAnimal(request.getParameter("button2"), request.getParameter("animalName"));
    } else if (request.getParameter("button3") != null && request.getParameter("animalName") != "") {
        farmFacade.addAnimal(request.getParameter("button3"), request.getParameter("animalName"));
    }

%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page Farm</title>
    </head>
    <body>
        <p>Page for Farm</p>
        
        <caption>Supported Animal Types:</caption>
        <table>
            <% for (String animalType : supportedAnimalTypes) {%>
            <tr>
                <td><%=animalType%></td>
            </tr>
            <%
                }
            %>
        </table> 
        
        <div style="background-color:lightgrey;width:220px;">
            <p>Add Animal to Farm</p>
            <form action="#" method="post">
                Animal Name:<br>
                <input type="text" name="animalName" value=""><br>
                <br>
                <button type="submit" name="button1" value="Cat">Add Cat</button>
                <button type="submit" name="button2" value="Cow">Add Cow</button>
                <button type="submit" name="button3" value="Dog">Add Dog</button>
            </form>
        </div>
        <br>

        <caption>Animals on Farm</caption>
        <table>
            <tr>
                <th>Type</th>
                <th>Name</th>
                <th>Sound</th>
            </tr>
            <% for (Animal animal : farmFacade.getAllAnimals()) {%>
            <tr>
                <td><%=animal.getAnimalType()%></td>
                <td><%=animal.getName()%></td>
                <td><%=animal.getSound()%></td>
            </tr>
            <%
                }
            %>
        </table> 

    </body>
</html>
