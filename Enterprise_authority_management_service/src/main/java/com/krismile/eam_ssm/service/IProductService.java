package com.krismile.eam_ssm.service;

import com.krismile.eam_ssm.domain.Product;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author krismile
 * @Create 2020-07-23 21:07
 */
public interface IProductService {
//    List<Product> findAll() throws Exception;

    void save(Product product) throws Exception;

    List<Product> findAll(int page, int pageSize) throws Exception;
}
