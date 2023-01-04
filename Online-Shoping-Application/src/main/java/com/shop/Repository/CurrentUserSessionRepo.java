package com.shop.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shop.Model.CurrentUserSession;

@Repository
public interface CurrentUserSessionRepo extends JpaRepository<CurrentUserSession, Integer>{

	public CurrentUserSession findByUuid(String key);
}
