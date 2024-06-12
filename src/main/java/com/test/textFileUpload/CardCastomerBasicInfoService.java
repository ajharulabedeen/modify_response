package com.test.textFileUpload;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service
@RequiredArgsConstructor
@Slf4j
public class CardCastomerBasicInfoService {

    private final CardAccountBasicInfoRepository cardAccountBasicInfoRepository;


    public void getTextFileData() {

        try {
            File file = new File("D:\\UnisoftFMSoftware\\usl_CRMS_ucb\\Documents\\20220630_83_Entire_Card_Details_Report.txt");

            FileInputStream fis = new FileInputStream(file);
            DataInputStream dis = new DataInputStream(fis);
            BufferedReader br = new BufferedReader(new InputStreamReader(dis));

            String read;
            int i = 0;
            boolean startProcessing = false;

            List<CardAccountBasicInfoEntity> entities = new ArrayList<>();
            int batchSize = 10000;
            int count = 0;

            while ((read = br.readLine()) != null) {
                read = read.trim();


                if (read.isEmpty() || read.contains("CLIENT_ID")){
                    continue;
                }


                if (read.contains("|")) {
                    startProcessing = true;

                } else {
                    continue;
                }

                if (startProcessing) {
                    String[] splicedLine = read.split("\\|");
                    String[] trimmedArray = Arrays.stream(splicedLine).map(String::trim).toArray(String[]::new);

                    i++;
//                    System.out.println("---------------- " + i + ": :");

                    CardAccountBasicInfoEntity cardAccountBasicInfoEntity = new CardAccountBasicInfoEntity();
                    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");


                     textToEntity(read, trimmedArray, cardAccountBasicInfoEntity, formatter);

                    try {

                        entities.add(cardAccountBasicInfoEntity);
                        count++;


                        if (count == batchSize) {
                            System.out.println("Saving: " + count);
                            cardAccountBasicInfoRepository.saveAll(entities);
                            entities.clear();
                            count = 0;
                        }
//                        else {
////                            log.error("Warning: Line does not have enough columns. Length: " + " | Line: " + read);
//                        }


                    } catch (Exception e) {

                        e.printStackTrace();
                    }
                }
            }

            // Save batch when count reaches batchSize
            if (!entities.isEmpty()) {
                System.out.println("Saving remaining: " + entities.size());
                cardAccountBasicInfoRepository.saveAll(entities);
            }


            br.close();
            dis.close();
            fis.close();

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void textToEntity(String read, String[] trimmedArray, CardAccountBasicInfoEntity cardAccountBasicInfoEntity, SimpleDateFormat formatter) {
        try {


                if (trimmedArray[2].equals("UCB33-000000009186")) {
                    int x = 9;
                    if (x == 9) {
                        System.out.println(x);
                    }
                }

            cardAccountBasicInfoEntity.setClientId(!trimmedArray[1].isEmpty() ? trimmedArray[1] : null);
            cardAccountBasicInfoEntity.setContractId(!trimmedArray[2].isEmpty() ? trimmedArray[2] : null);
            cardAccountBasicInfoEntity.setAccountNo(!trimmedArray[2].isEmpty() ? trimmedArray[2] : null);
            cardAccountBasicInfoEntity.setFileNo(!trimmedArray[3].isEmpty() ? trimmedArray[3] : null);
            cardAccountBasicInfoEntity.setCardNo(!trimmedArray[4].isEmpty() ? trimmedArray[4] : null);
            cardAccountBasicInfoEntity.setCardType(!trimmedArray[5].isEmpty() ? trimmedArray[5] : null);
            cardAccountBasicInfoEntity.setCardProfile(!trimmedArray[6].isEmpty() ? trimmedArray[6] : null);
            cardAccountBasicInfoEntity.setTitle(!trimmedArray[7].isEmpty() ? trimmedArray[7] : null);
            cardAccountBasicInfoEntity.setCustomerName(!trimmedArray[8].isEmpty() ? trimmedArray[8] : null);
            cardAccountBasicInfoEntity.setNameOnCard(!trimmedArray[9].isEmpty() ? trimmedArray[9] : null);
            cardAccountBasicInfoEntity.setSpouseName(!trimmedArray[10].isEmpty() ? trimmedArray[10] : null);
            cardAccountBasicInfoEntity.setMotherName(!trimmedArray[11].isEmpty() ? trimmedArray[11] : null);
            cardAccountBasicInfoEntity.setFatherName(!trimmedArray[12].isEmpty() ? trimmedArray[12] : null);
            cardAccountBasicInfoEntity.setDesignation(!trimmedArray[13].isEmpty() ? trimmedArray[13] : null);
            cardAccountBasicInfoEntity.setDateOfBirth(trimmedArray[14].isEmpty() ? null : formatter.parse(trimmedArray[14]));
            cardAccountBasicInfoEntity.setGender(!trimmedArray[15].isEmpty() ? trimmedArray[15] : null);
            cardAccountBasicInfoEntity.setPassportNo(!trimmedArray[16].isEmpty() ? trimmedArray[16] : null);
            cardAccountBasicInfoEntity.setNid(!trimmedArray[17].isEmpty() ? trimmedArray[17] : null);
            cardAccountBasicInfoEntity.setMarketBy(!trimmedArray[18].isEmpty() ? trimmedArray[18] : null);
            cardAccountBasicInfoEntity.setDeliveryInstr(!trimmedArray[19].isEmpty() ? trimmedArray[19] : null);
            cardAccountBasicInfoEntity.setResAddress(!trimmedArray[20].isEmpty() ? trimmedArray[20] : null);
            cardAccountBasicInfoEntity.setResCity(!trimmedArray[21].isEmpty() ? trimmedArray[21] : null);
            cardAccountBasicInfoEntity.setResRegion(!trimmedArray[22].isEmpty() ? trimmedArray[22] : null);
            cardAccountBasicInfoEntity.setCAddress(!trimmedArray[23].isEmpty() ? trimmedArray[23] : null);
            cardAccountBasicInfoEntity.setCCity(!trimmedArray[24].isEmpty() ? trimmedArray[24] : null);
            cardAccountBasicInfoEntity.setCRegion(!trimmedArray[25].isEmpty() ? trimmedArray[25] : null);
            cardAccountBasicInfoEntity.setRegAddress(!trimmedArray[26].isEmpty() ? trimmedArray[26] : null);
            cardAccountBasicInfoEntity.setRegCity(!trimmedArray[27].isEmpty() ? trimmedArray[27] : null);
            cardAccountBasicInfoEntity.setResRegion(!trimmedArray[28].isEmpty() ? trimmedArray[28] : null);
            cardAccountBasicInfoEntity.setCompanyName(!trimmedArray[29].isEmpty() ? trimmedArray[29] : null);
            cardAccountBasicInfoEntity.setCompanyAddress(!trimmedArray[30].isEmpty() ? trimmedArray[30] : null);
            cardAccountBasicInfoEntity.setBillAddress(!trimmedArray[31].isEmpty() ? trimmedArray[31] : null);
            cardAccountBasicInfoEntity.setHomeAddress(!trimmedArray[32].isEmpty() ? trimmedArray[32] : null);
            cardAccountBasicInfoEntity.setTelephone(!trimmedArray[33].isEmpty() ? trimmedArray[33] : null);
            cardAccountBasicInfoEntity.setFax(!trimmedArray[34].isEmpty() ? trimmedArray[34] : null);
            cardAccountBasicInfoEntity.setMobileNo(!trimmedArray[35].isEmpty() ? trimmedArray[35] : null);
            cardAccountBasicInfoEntity.setEmail(!trimmedArray[36].isEmpty() ? trimmedArray[36] : null);
            cardAccountBasicInfoEntity.setTin(!trimmedArray[37].isEmpty() ? trimmedArray[37] : null);
            cardAccountBasicInfoEntity.setPppass(!trimmedArray[38].isEmpty() ? trimmedArray[38] : null);
            cardAccountBasicInfoEntity.setCardProductName(!trimmedArray[39].isEmpty() ? trimmedArray[39] : null);

            cardAccountBasicInfoEntity.setCreatedDate(trimmedArray[40].isEmpty() ?  null : formatter.parse(trimmedArray[40]));
            cardAccountBasicInfoEntity.setGivenDate(trimmedArray[41].isEmpty() ? null : formatter.parse(trimmedArray[41]));
            cardAccountBasicInfoEntity.setClosingDate(trimmedArray[42].isEmpty() ? null : formatter.parse(trimmedArray[42]));
            cardAccountBasicInfoEntity.setAnnivDate(trimmedArray[43].isEmpty() ? null : formatter.parse(trimmedArray[43]));
            cardAccountBasicInfoEntity.setExpDate(trimmedArray[44].isEmpty() ? null : formatter.parse(trimmedArray[44]));

            cardAccountBasicInfoEntity.setCardStatus(!trimmedArray[45].isEmpty() ? trimmedArray[45] : null);
            cardAccountBasicInfoEntity.setCardState(!trimmedArray[46].isEmpty() ? trimmedArray[46] : null);
            cardAccountBasicInfoEntity.setContState(!trimmedArray[47].isEmpty() ? trimmedArray[47] : null);
            cardAccountBasicInfoEntity.setDomAccountNo(!trimmedArray[48].isEmpty() ? trimmedArray[48] : null);
            cardAccountBasicInfoEntity.setLimitAmt(!trimmedArray[49].isEmpty() ? trimmedArray[49] : null);
            cardAccountBasicInfoEntity.setOsAmt(!trimmedArray[50].isEmpty() ? trimmedArray[50] : null);
            cardAccountBasicInfoEntity.setMinDueAmt(!trimmedArray[51].isEmpty() ? trimmedArray[51] : null);
            cardAccountBasicInfoEntity.setAutoPayBdt(!trimmedArray[52].isEmpty() ? trimmedArray[52] : null);
            cardAccountBasicInfoEntity.setAutoPayAc(!trimmedArray[53].isEmpty() ? trimmedArray[53] : null);
            cardAccountBasicInfoEntity.setIntAccountNo(!trimmedArray[54].isEmpty() ? trimmedArray[54] : null);
            cardAccountBasicInfoEntity.setIntLimitAmt(!trimmedArray[55].isEmpty() ? trimmedArray[55] : null);
            cardAccountBasicInfoEntity.setIntOsAmt(!trimmedArray[56].isEmpty() ? trimmedArray[56] : null);
            cardAccountBasicInfoEntity.setIntminDueAmt(!trimmedArray[57].isEmpty() ? trimmedArray[57] : null);
            cardAccountBasicInfoEntity.setAutoPayUsd(!trimmedArray[58].isEmpty() ? trimmedArray[58] : null);
            cardAccountBasicInfoEntity.setAutoPayAcUsd(!trimmedArray[59].isEmpty() ? trimmedArray[59] : null);
            cardAccountBasicInfoEntity.setRiskGroup(!trimmedArray[60].isEmpty() ? trimmedArray[60] : null);
            cardAccountBasicInfoEntity.setState(!trimmedArray[61].isEmpty() ? trimmedArray[61] : null);
            cardAccountBasicInfoEntity.setNoOfdays(!trimmedArray[62].isEmpty() ? trimmedArray[62] : null);
            cardAccountBasicInfoEntity.setAge(!trimmedArray[63].isEmpty() ? trimmedArray[63] : null);

            cardAccountBasicInfoEntity.setStatementDate(trimmedArray[64].isEmpty() ? null : formatter.parse(trimmedArray[64]));
            cardAccountBasicInfoEntity.setDueDate(trimmedArray[65].isEmpty() ? null : formatter.parse(trimmedArray[65]));
        }catch (Exception e){
            log.error("Exception : {} \n  {}",e.getMessage(), String.join(" ", trimmedArray));
        }
    }
}
