package com.school.repository;

import com.school.models.dao.School;
import com.school.models.dao.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolRepository extends JpaRepository<School,String> {
}