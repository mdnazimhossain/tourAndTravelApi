package com.saiful.restApi.repository;

import com.saiful.restApi.entity.Cancellation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CancellationRepo extends JpaRepository<Cancellation, Long> {


}
