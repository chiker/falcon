package io.falcon.pipeline.dao;

import io.falcon.pipeline.domain.Request;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestRepository extends JpaRepository<Request, Long> {
}
