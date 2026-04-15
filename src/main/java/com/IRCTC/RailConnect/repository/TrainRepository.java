package com.IRCTC.RailConnect.repository;

import com.IRCTC.RailConnect.entity.Train;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface TrainRepository extends JpaRepository<Train, String> {

}
