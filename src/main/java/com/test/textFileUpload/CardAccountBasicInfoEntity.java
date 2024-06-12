package com.test.textFileUpload;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "CRAD_ACCOUNT_BASIC_INFO")
public class CardAccountBasicInfoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String clientId;
    private String contractId;
    private String accountNo;
    private String fileNo;
    private String cardNo;
    private String cardType;
    private String cardProfile;
    private String title;
    private String customerName;
    private String nameOnCard;
    private String spouseName;
    private String motherName;
    private String fatherName;
    private String designation;
    private Date dateOfBirth;
    private String gender;
    private String passportNo;
    private String nid;
    private String marketBy;
    private String deliveryInstr;
    private String resAddress;
    private String resCity;
    private String resRegion;
    private String cAddress;
    private String cCity;
    private String cRegion;
    private String regAddress;
    private String regCity;
    private String regRegion;
    private String companyName;
    private String companyAddress;
    private String billAddress;
    private String homeAddress;
    private String telephone;
    private String fax;
    private String mobileNo;
    private String email;
    private String tin;
    private String pppass;
    private String cardProductName;
    private Date createdDate;
    private Date givenDate;
    private Date closingDate;
    private Date annivDate;
    private Date expDate;
    private String cardState;
    private String cardStatus;
    private String contState;
    private String domAccountNo;
    private String limitAmt;
    private String osAmt;
    private String minDueAmt;
    private String autoPayBdt;
    private String autoPayAc;
    private String intAccountNo;
    private String intLimitAmt;
    private String intOsAmt;
    private String intminDueAmt;
    private String autoPayUsd;
    private String autoPayAcUsd;
    private String riskGroup;
    private String state;
    private String noOfdays;
    private String age;
    private Date statementDate;
    private Date dueDate;


}
