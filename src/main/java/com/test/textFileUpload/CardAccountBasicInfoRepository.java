package com.test.textFileUpload;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface CardAccountBasicInfoRepository extends JpaRepository<CardAccountBasicInfoEntity, Long> {


}
