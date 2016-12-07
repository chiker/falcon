package io.falcon.pipeline.service;

import io.falcon.pipeline.domain.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Message, Long>{
}
