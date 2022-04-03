package model.repository;

import model.bean.ContractDetail;

import java.util.List;

public interface ContractDetailRepository {
    List<ContractDetail> findAll();

    boolean save(ContractDetail contractDetail);

    ContractDetail findById(int id);

    boolean update(ContractDetail contract, int contract_detail_id);

    boolean delete(int contract_detail_id);

    List<ContractDetail> search(String attachService, String quantity);
}
