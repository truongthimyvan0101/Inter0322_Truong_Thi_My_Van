package controller;

import model.bean.AttachService;
import model.bean.ContractDetail;
import model.service.AttachServiceService;
import model.service.ContractDetailService;
import model.service.impl.AttachServiceServiceImpl;
import model.service.impl.ContractDetailServiceImpl;
import model.service.impl.ContractServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "ContractDetailServlet", urlPatterns = {"/contractDetail"})
public class ContractDetailServlet extends HttpServlet {
    ContractDetailService contractDetailService = new ContractDetailServiceImpl();
    AttachServiceService attachServiceService = new AttachServiceServiceImpl();
    ContractService contractService = new ContractServiceImpl();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createContractDetail(request, response);
                break;
            case "update":
                updateContractDetail(request, response);
                break;
            case "delete":
                deleteContractDetail(request, response);
                break;
            case "search":
                searchContractDetail(request, response);
                break;
        }
    }

    private void searchContractDetail(HttpServletRequest request, HttpServletResponse response) {
        String attachService = request.getParameter("attachService");
        String quantity = request.getParameter("quantity");

        List<ContractDetail> contractDetailList = contractDetailService.search(attachService, quantity);
        request.setAttribute("contractDetailList", contractDetailList);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/contractDetail/list.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteContractDetail(HttpServletRequest request, HttpServletResponse response) {
        int contract_detail_id = Integer.parseInt(request.getParameter("contract_detail_id"));
        ContractDetail contractDetail = contractDetailService.findById(contract_detail_id);
        contractDetailService.delete(contract_detail_id);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/contractDetail/list.jsp");
        request.setAttribute("contractDetailList", contractDetailService.findAll());
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void updateContractDetail(HttpServletRequest request, HttpServletResponse response) {
        int contract_detail_id = Integer.parseInt(request.getParameter("contract_detail_id"));
        int contract_id = Integer.parseInt(request.getParameter("contract_id"));
        int attach_service_id = Integer.parseInt(request.getParameter("attach_service_id"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        ContractDetail contractDetail = new ContractDetail(contract_detail_id, contract_id, attach_service_id, quantity);
        contractDetailService.update(contractDetail, contract_detail_id);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/contractDetail/list.jsp");
        request.setAttribute("contractDetailList", contractDetailService.findAll());
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createContractDetail(HttpServletRequest request, HttpServletResponse response) {
        int contract_detail_id = (int) Math.random() * 1000;
        int contract_id = Integer.parseInt(request.getParameter("contract_id"));
        int attach_service_id = Integer.parseInt(request.getParameter("attach_service_id"));
        int quantity = 0;
        try {
            quantity = Integer.parseInt(request.getParameter("quantity"));
            if (quantity == -1) {
                quantity = -2;
            }
            if (quantity == -3) {
                quantity = -4;
            }
        } catch (NumberFormatException e) {
            if (request.getParameter("quantity").equals("")) {
                quantity = -1;
            } else {
                quantity = -3;
            }
        }


        ContractDetail contractDetail = new ContractDetail(contract_detail_id, contract_id, attach_service_id, quantity);
        Map<String, String> contractDetailMap = contractDetailService.save(contractDetail);

        List<AttachService> attachServiceList = attachServiceService.findAll();
        List<Contract> contractList = contractService.findAll();

        RequestDispatcher requestDispatcherSuccess = request.getRequestDispatcher("views/contractDetail/list.jsp");
        RequestDispatcher requestDispatcherFail = request.getRequestDispatcher("views/contractDetail/create.jsp");

        if (contractDetailMap.isEmpty()) {
            request.setAttribute("contractDetailList", contractDetailService.findAll());
            try {
                requestDispatcherSuccess.forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            request.setAttribute("attachServiceList", attachServiceList);
            request.setAttribute("contractList", contractList);
            request.setAttribute("quantityMessage", contractDetailMap.get("quantityMessage"));
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
        if (action == null) {
            action = "";
        }
        switch (action) {
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

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/contractDetail/create.jsp");
        List<AttachService> attachServiceList = attachServiceService.findAll();
        List<Contract> contractList = contractService.findAll();
        request.setAttribute("attachServiceList", attachServiceList);
        request.setAttribute("contractList", contractList);
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
        ContractDetail contractDetail = contractDetailService.findById(id);
        List<AttachService> attachServiceList = attachServiceService.findAll();
        List<Contract> contractList = contractService.findAll();
        RequestDispatcher requestDispatcher;
        request.setAttribute("attachServiceList", attachServiceList);
        request.setAttribute("contractList", contractList);
        request.setAttribute("contractDetail", contractDetail);
        requestDispatcher = request.getRequestDispatcher("views/contractDetail/update.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        ContractDetail contractDetail = contractDetailService.findById(id);
        request.setAttribute("contractDetail", contractDetail);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/contractDetail/delete.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showListForm(HttpServletRequest request, HttpServletResponse response) {
        request.setAttribute("contractDetailList", contractDetailService.findAll());
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/contractDetail/list.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
