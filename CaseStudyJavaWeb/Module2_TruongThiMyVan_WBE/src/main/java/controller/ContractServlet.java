package controller;

import model.bean.Customer;
import model.bean.Employee;
import model.bean.Service;
import model.service.CustomerService;
import model.service.EmployeeService;
import model.service.ServiceService;
import model.service.impl.ContractServiceImpl;
import model.service.impl.CustomerServiceImpl;
import model.service.impl.EmployeeServiceImpl;
import model.service.impl.ServiceServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "ContractServlet", urlPatterns = {"/contract"})
public class ContractServlet extends HttpServlet {
    ContractService contractService = new ContractServiceImpl();
    CustomerService customerService = new CustomerServiceImpl();
    EmployeeService employeeService = new EmployeeServiceImpl();
    ServiceService serviceService = new ServiceServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "create":
                createContract(request, response);
                break;
            case "update":
                updateContract(request, response);
                break;
            case "delete":
                deleteContract(request, response);
                break;
            case "search":
                searchContract(request, response);
                break;
        }
    }

    private void searchContract(HttpServletRequest request, HttpServletResponse response) {
        String employee = request.getParameter("employee");
        String customer = request.getParameter("customer");
        String service = request.getParameter("service");
        List<Contract> contractList = contractService.search(employee, customer, service);
        request.setAttribute("contractList", contractList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/contract/list.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void deleteContract(HttpServletRequest request, HttpServletResponse response) {
        int contract_id = Integer.parseInt(request.getParameter("contract_id"));
        Contract contract = contractService.findById(contract_id);
        contractService.delete(contract_id);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/contract/list.jsp");
        request.setAttribute("contractList", contractService.findAll());
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateContract(HttpServletRequest request, HttpServletResponse response) {
        int contract_id = Integer.parseInt(request.getParameter("contract_id"));
        String contract_start_date = request.getParameter("contract_start_date");
        String contract_end_date = request.getParameter("contract_end_date");
        double contract_deposit = Double.parseDouble(request.getParameter("contract_deposit"));
        double contract_total_money = Double.parseDouble(request.getParameter("contract_total_money"));
        int employee_id = Integer.parseInt(request.getParameter("employee_id"));
        int customer_id = Integer.parseInt(request.getParameter("customer_id"));
        int service_id = Integer.parseInt(request.getParameter("service_id"));
        Contract contract = new Contract(contract_id, contract_start_date, contract_end_date, contract_deposit, contract_total_money, employee_id, customer_id, service_id);
        contractService.update(contract, service_id);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/contract/list.jsp");
        request.setAttribute("contractList", contractService.findAll());
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createContract(HttpServletRequest request, HttpServletResponse response) {
        int contract_id = (int)Math.random()*1000;
        String contract_start_date = request.getParameter("contract_start_date");
        String contract_end_date = request.getParameter("contract_end_date");
        double contract_deposit = 0;
        try {
            contract_deposit = Double.parseDouble(request.getParameter("contract_deposit"));
        }catch (NumberFormatException e){
            if (request.getParameter("contract_deposit").equals("")){
                contract_deposit = 0.001;
            }else {
                contract_deposit = 0.002;
            }
        }

        double contract_total_money = 0;
        try {
            contract_total_money = Double.parseDouble(request.getParameter("contract_total_money"));
        }catch (NumberFormatException e){
            if (request.getParameter("contract_total_money").equals("")){
                contract_total_money = 0.001;
            }else {
                contract_total_money = 0.002;
            }
        }
        int employee_id = Integer.parseInt(request.getParameter("employee_id"));
        int customer_id = Integer.parseInt(request.getParameter("customer_id"));
        int service_id = Integer.parseInt(request.getParameter("service_id"));
        Contract contract = new Contract(contract_id, contract_start_date, contract_end_date, contract_deposit, contract_total_money, employee_id, customer_id, service_id);
        Map<String, String> messageMap =  contractService.save(contract);
        RequestDispatcher requestDispatcherFail = request.getRequestDispatcher("views/contract/create.jsp");
        RequestDispatcher requestDispatcherSuccess = request.getRequestDispatcher("views/contract/list.jsp");

        if (messageMap.isEmpty()){
            request.setAttribute("contractList", contractService.findAll());
            try {
                requestDispatcherSuccess.forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            List<Customer> customerList = customerService.findAll();
            List<Employee> employeeList = employeeService.findAll();
            List<Service> serviceList = serviceService.findAll();
            request.setAttribute("customerList", customerList);
            request.setAttribute("employeeList", employeeList);
            request.setAttribute("serviceList", serviceList);
            request.setAttribute("depositMessage", messageMap.get("depositMessage"));
            request.setAttribute("totalMoneyMessage", messageMap.get("totalMoneyMessage"));
            request.setAttribute("startDateMessage", messageMap.get("startDateMessage"));
            request.setAttribute("endDateMessage", messageMap.get("endDateMessage"));
            request.setAttribute("oldContract", contract);
            try {
                requestDispatcherFail.forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null){
            action = "";
        }
        switch (action){
            case "create":
                showCreateForm(request, response);
                break;
            case "update":
                showUpdateForm(request, response);
                break;
            case "delete":
                showDeleteForm(request, response);
                break;
            default:
                showListForm(request, response);
                break;
        }
    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Contract contract = contractService.findById(id);
        request.setAttribute("contract", contract);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/contract/delete.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showUpdateForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Contract contract = contractService.findById(id);
        List<Customer> customerList = customerService.findAll();
        List<Employee> employeeList = employeeService.findAll();
        List<Service> serviceList = serviceService.findAll();
        RequestDispatcher requestDispatcher;
        request.setAttribute("customerList", customerList);
        request.setAttribute("employeeList", employeeList);
        request.setAttribute("serviceList", serviceList);
        request.setAttribute("contract", contract);
        requestDispatcher = request.getRequestDispatcher("views/contract/update.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        List<Customer> customerList = customerService.findAll();
        List<Employee> employeeList = employeeService.findAll();
        List<Service> serviceList = serviceService.findAll();
        request.setAttribute("customerList", customerList);
        request.setAttribute("employeeList", employeeList);
        request.setAttribute("serviceList", serviceList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/contract/create.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showListForm(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("contractList", contractService.findAll());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/contract/list.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
