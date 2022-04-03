package model.service;

import model.bean.ContractDetail;

import java.util.List;
import java.util.Map;

public interface ContractDetailService {
    List<ContractDetail> findAll();

    Map<String, String> save(ContractDetail contractDetail);

    ContractDetail findById(int id);

    boolean update(ContractDetail contract, int contract_detail_id);

    boolean delete(int contract_detail_id);

    List<ContractDetail> search(String attachService, String quantity);
}