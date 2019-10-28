package com.edu.system.demo.repository;

import com.edu.system.demo.entity.Administer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author lucas
 * @site
 * @company
 * @create 2019-10-24 20:57
 */
@Repository
public interface AdminRepository extends JpaRepository<Administer, Integer> {

    @Query(value="SELECT * FROM administer where usr_name =:usr_name",nativeQuery = true)
    Administer findAdminByUsr_name(String usr_name);

}
