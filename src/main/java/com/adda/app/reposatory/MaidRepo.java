package com.adda.app.reposatory;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adda.app.Entity.Maid;

public interface MaidRepo extends JpaRepository<Maid, Long> {

}
