package com.dashboard.ontopresenter.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dashboard.ontopresenter.model.User;

public interface Users extends JpaRepository<User, Long>{

}
