package com.pb.challangeThree.msNotify.kafkaConsumer.repository;

import com.pb.challangeThree.msNotify.kafkaConsumer.entitie.Notify;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotifyRepository extends MongoRepository<Notify, String> {
}
