package com.SpringbootRestApi.RestApiBank.serviceRepo;


import com.SpringbootRestApi.RestApiBank.Entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepo extends JpaRepository<Account,Integer> {
}
