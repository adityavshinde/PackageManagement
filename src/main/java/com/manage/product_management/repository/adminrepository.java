package com.manage.product_management.repository;

import com.manage.product_management.model.LoginTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.RepositoryDefinition;

//@Repository
public interface adminrepository extends JpaRepository<LoginTable, Long> {
    LoginTable findByUsernameAndPassword(String username, String password);

}
