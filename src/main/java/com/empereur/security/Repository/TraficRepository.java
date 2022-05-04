package com.empereur.security.Repository;

import com.empereur.security.Models.Sites;
import com.empereur.security.Models.Trafic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TraficRepository extends JpaRepository<Trafic, Long> {
    List<Trafic> findAllByTraficSite(Sites traficSite);
}
