package com.sellcontrol.sellcontrolapi.domain.site_users.repository;


import com.sellcontrol.sellcontrolapi.domain.site_users.model.Site_Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<Site_Users, Long> {


    UserDetails findByLogin(String login);
}
