package Controller;

import DAO.*;
import Model.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(value = "/sellMill")
public class SellMill extends HttpServlet {
    private final UserDAO userDAO;
    MillDAO millDAO;
    MillingExpenseDAO millingExpenseDAO;

    MillingProductDAO millingProductDAO;
    HarvestDAO harvestDAO;
    private RequestDispatcher dispatcher;

    public SellMill() {
        millDAO = new MillDAOImpl();
        userDAO = new UserDAOImpl();
        millingExpenseDAO = new MillingExpenseDAOImpl();
        harvestDAO = new HarvestDAOImpl();
        millingProductDAO = new MillingProductDAOImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        User logger = userDAO.getLogger((String) request.getSession().getAttribute("email"));
        String name =  request.getParameter("product");
        String productUnit = request.getParameter("productUnit");
        String unitPrice = request.getParameter("unitParameter");
        Integer unitsSold = Integer.valueOf(request.getParameter("unitsSold"));
        String receivedFrom = request.getParameter("receivedFrom");
        Date date = Date.valueOf(request.getParameter("date"));
        String remark = request.getParameter("remark");

        MillingProduct millingProduct = new MillingProduct();


            if( name.equals("CRUDE_PALM_OIL")  &&  productUnit.equals("CANS")){
                millingProduct.setPalmOilCan(unitsSold);
            }
            if (name.equals("CRUDE_PALM_OIL")  && productUnit.equals("DRUMS")) {
                millingProduct.setPalmOilDrum(unitsSold);

            }
            if ( name.equals("FIBRE_PALM_OIL") && productUnit.equals("CANS") ) {
                millingProduct.setFibreOilCan(unitsSold);
            }
            if(millingProductDAO.update(millingProduct)){
                request.setAttribute("message", "Saved!!!!");

        }




        listMills(request, response);


    }

    public void listMills(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        try {
            List<Mill> list = millDAO.get();
            request.setAttribute("list", list);
            request.setAttribute("title", "Mill List");
            dispatcher = request.getRequestDispatcher("/Views/Admin/Mills.jsp");
            dispatcher.forward(request, response);
            return;
        } catch (IOException ex) {
            Logger.getLogger(SellMill.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void newMill(HttpServletRequest request, HttpServletResponse response) {

        try {
            User user = userDAO.getLogger((String) request.getSession().getAttribute("email"));
            user.setFullName();
            request.setAttribute("user", user);
            request.setAttribute("title", "Create new Mill");
            dispatcher = request.getRequestDispatcher("/Views/Admin/AddMill.jsp");

            dispatcher.forward(request, response);
            return;
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }

    }
    public void sellMill(HttpServletRequest request, HttpServletResponse response) {

        try {
            User user = userDAO.getLogger((String) request.getSession().getAttribute("email"));
            user.setFullName();
            request.setAttribute("user", user);
            request.setAttribute("title", "Create new Mill");
            dispatcher = request.getRequestDispatcher("/Views/Admin/SellMill.jsp");

            dispatcher.forward(request, response);
            return;
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }

    }

    public void deleteMill(HttpServletRequest request, HttpServletResponse response) throws ServletException {


        String id = request.getParameter("id");


        if (millDAO.delete(Integer.parseInt(id))) {

            request.setAttribute("title", "Delete Mill");
            request.setAttribute("message", "Mill Deleted!");

        }
        listMills(request, response);

    }

    public void editMill(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Mill mill = millDAO.get(Integer.parseInt(id));
        MillingExpense millingExpense = millingExpenseDAO.get(mill);
        mill.setMillingExpense(millingExpense);
        request.setAttribute("title", "Edit Mill");
        request.setAttribute("mill", mill);
        dispatcher = request.getRequestDispatcher("/Views/Admin/EditMill.jsp");
        dispatcher.forward(request, response);


    }

}
